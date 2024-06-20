package DAO;

import java.util.ArrayList;

import org.hibernate.mapping.List;

import Model.userChat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserDAO {
//	public static void main(String[] args) {
//		userChat u = new userChat("Name","pass",null,"tho123@",84090909);
//		loadData();
//	}

	public void create(userChat u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			userChat userchat = new userChat(u.getUserName(), u.getPassword(), u.getBirthday(), u.getEmail(), u.getPhoneNumber());

			em.persist(userchat);
			em.getTransaction().commit();
			System.out.println("thêm thành công 1 userchat");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("thêm that bai userchat");
		}
		em.close();
	}

	public void delete(userChat u) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			userChat userchat = new userChat( u.getUserName(), u.getPassword(), u.getBirthday(), u.getEmail(), u.getPhoneNumber());

			em.remove(userchat);
			em.getTransaction().commit();
			System.out.println("xóa thành công 1 userchat");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("xóa that bai userchat");
		}
		em.close();
	}
	

	public void edit(userChat u) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            userChat existingUserChat = em.find(userChat.class, u.getUserName());
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

    public ArrayList<userChat> loadData() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
        EntityManager em = emf.createEntityManager();
        ArrayList<userChat> list = new ArrayList<userChat>();
        try {
            String jpql = "SELECT u FROM userChat u";
            TypedQuery<userChat> query = em.createQuery(jpql, userChat.class);
            list = (ArrayList<userChat>) query.getResultList();
            for (userChat user : list) {
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
}







