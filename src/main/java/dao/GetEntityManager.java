package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetEntityManager {
	
	private static final String JPA = "projeto-jpa";
	private static EntityManagerFactory emf;
	
	public static EntityManager getJpaConnection() {
		
		emf = Persistence.createEntityManagerFactory(JPA);
		EntityManager em = emf.createEntityManager();
		
		return em;
		
	}
	

}
