package DAO;

import Model.groupChat;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GroupDAO {
	public static void main(String[] args) {
		groupChat g= new groupChat("English","Coputerm","máy tủ lạnh",null);
		create(g);
	}

	public static void create(groupChat g) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em =emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			groupChat groupchat = new groupChat( g.getGroupID(), g.getGroupName(),g.getMsgType(), g.getAttribute());
			
			em.persist(groupchat);
			em.getTransaction().commit();
			System.out.println("them thành công 1 groupchat");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("them that bai groupchat");
		}
		}
	
	public void delete() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chatroom");
		EntityManager em =emf.createEntityManager();
		
	}
}
