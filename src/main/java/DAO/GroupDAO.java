package DAO;

import java.util.ArrayList;

import Model.groupChat;
import Model.UserModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class GroupDAO {
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
//	    EntityManager em = emf.createEntityManager();
//		groupChat g = new groupChat("English", "Coputerm", "máy tủ lạnh", null);
//		create(g);
//		groupChat g1 = new groupChat("truyentranh", "truyentranh1", "truyentranh1", null);
////		System.out.println(g1.getGroupID());
//		loadData(g1);
////		testFind(em);
//	}
	public static GroupDAO getInstance() {
		return new GroupDAO();
	}

	public static void create(groupChat g) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			groupChat groupchat = new groupChat(g.getGroupID(), g.getGroupName(), g.getMsgType(), g.getAttribute());

			em.persist(groupchat);
			em.getTransaction().commit();
			System.out.println("thêm thành công 1 groupchat");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("thêm that bai groupchat");
		}
	}

	public void delete(groupChat g) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			groupChat groupchat = new groupChat(g.getGroupID(), g.getGroupName(), g.getMsgType(), g.getAttribute());

			em.remove(groupchat);
			em.getTransaction().commit();
			System.out.println("xóa thành công 1 groupchat");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("xóa that bai groupchat");
		}
	}
	
	
	public static void testFind(EntityManager em) {
	    try {
	        em.getTransaction().begin();
	        groupChat gc = em.find(groupChat.class, "someValidStringID");
	        System.out.println("Found groupChat: " + gc);
	        em.getTransaction().commit();
	    } catch (Exception e) {
	        em.getTransaction().rollback();
	        e.printStackTrace();
	    }
	}
	 // Edit dữ liệu từ bảng khi groupID bằng dữ liệu nhập
    public static void edit(groupChat g) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            System.out.println("Searching for groupChat with groupID: " + g.getGroupID() + " (type: " + g.getGroupID().getClass().getName() + ")");
            TypedQuery<groupChat> query = em.createQuery("SELECT gc FROM groupChat gc WHERE gc.groupID = :groupID", groupChat.class);
            query.setParameter("groupID", g.getGroupID());
            groupChat existingGroupChat = query.getSingleResult();
            System.out.println("Found groupChat: " + existingGroupChat);

            if (existingGroupChat != null) {
                existingGroupChat.setGroupName(g.getGroupName());
                existingGroupChat.setMsgType(g.getMsgType());
                existingGroupChat.setAttribute(g.getAttribute());
                em.merge(existingGroupChat);
                em.getTransaction().commit();
                System.out.println("Cập nhật groupchat thành công");
            } else {
                System.out.println("Không tìm thấy groupchat với groupID: " + g.getGroupID());
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Cập nhật groupchat thất bại");
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    // Lấy dữ liệu từ bảng khi groupID bằng dữ liệu nhập
    public ArrayList<groupChat> loadDataID(String id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
        EntityManager em = emf.createEntityManager();
        ArrayList<groupChat> list = new ArrayList<groupChat>();


        try {
        	String jpql = "SELECT gc FROM groupChat gc WHERE gc.groupID = :groupID";
            TypedQuery<groupChat> query = em.createQuery(jpql, groupChat.class);
            query.setParameter("groupID", id);
            list = (ArrayList<groupChat>) query.getResultList();

            for (groupChat chat : list) {
                System.out.println("Group ID: " + chat.getGroupID());
                System.out.println("Group Name: " + chat.getGroupName());
                System.out.println("Message Type: " + chat.getMsgType());
                System.out.println("Attribute: " + chat.getAttribute());
            }
        } catch (Exception e) {
            System.out.println("Lấy dữ liệu thất bại groupchat");
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        return list;
    }
    
public ArrayList<groupChat> loadData() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
    EntityManager em = emf.createEntityManager();
    ArrayList<groupChat> list = new ArrayList<groupChat>();


    try {
    	String jpql = "SELECT gc FROM groupChat gc";
        TypedQuery<groupChat> query = em.createQuery(jpql, groupChat.class);
        list = (ArrayList<groupChat>) query.getResultList();

        for (groupChat chat : list) {
            System.out.println("Group ID: " + chat.getGroupID());
            System.out.println("Group Name: " + chat.getGroupName());
            System.out.println("Message Type: " + chat.getMsgType());
            System.out.println("Attribute: " + chat.getAttribute());
        }
    } catch (Exception e) {
        System.out.println("Lấy dữ liệu thất bại groupchat");
        e.printStackTrace();
    } finally {
        em.close();
        emf.close();
    }
    return list;
}
}
