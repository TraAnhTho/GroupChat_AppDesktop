package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.mapping.List;

import Model.UserModel;
import View.InterfaceMain;
import View.chatRoom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserDAO {
//	public static void main(String[] args) {
//		userChat u = new userChat("Name","pass",null,"tho123@",84090909);
//		loadData();
//	}

	public static UserDAO getInstance() {
		return new UserDAO();
	}
	public void create(UserModel u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			UserModel userchat = new UserModel(u.getUserName(), u.getPassword(), u.getBirthday(), u.getEmail(), u.getPhoneNumber());

			em.persist(userchat);
			em.getTransaction().commit();
			System.out.println("thêm thành công 1 userchat");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("thêm that bai userchat");
		}
		em.close();
	}

	public void delete(UserModel u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			UserModel userchat = new UserModel( u.getUserName(), u.getPassword(), u.getBirthday(), u.getEmail(), u.getPhoneNumber());

			em.remove(userchat);
			em.getTransaction().commit();
			System.out.println("xóa thành công 1 userchat");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("xóa that bai userchat");
		}
		em.close();
	}
	

	public void edit(UserModel u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            UserModel existingUserChat = em.find(UserModel.class, u.getUserName());
            if (existingUserChat != null) {
                existingUserChat.setUserName(u.getUserName());
                existingUserChat.setPassword(u.getPassword());
                existingUserChat.setBirthday(u.getBirthday());
                existingUserChat.setEmail(u.getEmail());
                existingUserChat.setPhoneNumber(u.getPhoneNumber());
                em.merge(existingUserChat);
                em.getTransaction().commit();
                System.out.println("Sửa thành công 1 userchat");
            } else {
                System.out.println("Không tìm thấy userchat với userId: " + u.getUserName());
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Sửa thất bại userchat");
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    public ArrayList<UserModel> loadData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
        EntityManager em = emf.createEntityManager();
        ArrayList<UserModel> list = new ArrayList<UserModel>();
        try {
            String jpql = "SELECT u FROM UserModel u";
            TypedQuery<UserModel> query = em.createQuery(jpql, UserModel.class);
            list = (ArrayList<UserModel>) query.getResultList();
            for (UserModel user : list) {
                System.out.println("UserId: " + user.getUserName());
                System.out.println("UserName: " + user.getUserName());
                System.out.println("Password: " + user.getPassword());
                System.out.println("Birthday: " + user.getBirthday());
                System.out.println("Email: " + user.getEmail());
                System.out.println("Phone Number: " + user.getPhoneNumber());
                System.out.println("---------------");
            }
        } catch (Exception e) {
            System.out.println("Lấy dữ liệu thất bại userchat");
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
		return list;
    }
    
    public ArrayList<UserModel> DangNhap(String id, String mk) {
		// lấy all user
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
        EntityManager em = emf.createEntityManager();
		ArrayList<UserModel> list = new ArrayList<UserModel>();
		try {
			String jpql = "SELECT u FROM UserModel u WHERE u.userName = :userName AND u.password = :password";
            TypedQuery<UserModel> query = em.createQuery(jpql, UserModel.class);
			query.setParameter("userName", id);
			query.setParameter("password", mk);
            list = (ArrayList<UserModel>) query.getResultList();
            
            if (!list.isEmpty()) {
				JOptionPane.showMessageDialog(new InterfaceMain(id), "Đăng nhập thành công!!!");
				System.out.println("success");
				em.close();

			} else {
				JOptionPane.showMessageDialog(null, "Tài khoản KHÔNG tồn tại!!!");
				System.out.println("Tài khoản chưa tồn tại!!!");
				em.close();
			}

			 } catch (Exception e) {
            System.out.println("Lấy dữ liệu thất bại userchat");
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
		return list;
    }
}







