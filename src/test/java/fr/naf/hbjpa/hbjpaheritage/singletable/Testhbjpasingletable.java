package fr.naf.hbjpa.hbjpaheritage.singletable;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Testhbjpasingletable {

	private static EntityManager em;
	private static EntityTransaction ts;	
	
	@BeforeClass
	public static void initialisation() {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");    	          
		 em = emf.createEntityManager();
		 ts= em.getTransaction();
	}
	
	@Test
	public void test1Enregistrer() {
		 Chat chat = new Chat();
		 chat.setNom("LILI");  
		 Chien chien = new Chien();
		 chien.setNom("DIK");
         ts.begin();
         em.persist(chat);
         em.persist(chien); 
         ts.commit();                           
         assertNotNull(chat.getId());
	}
	
	@Test
	public void test2ListerAnnimaux() {	
		
		//requete
		//select animal0_.id as id2_0_, animal0_.nom as nom3_0_, animal0_.DTYPE as DTYPE1_0_ from Animal animal0_
		
		Query animalQuery = em.createQuery("select animal from Animal animal");
		List<Animal> resultList = animalQuery.getResultList();	 
		for(Animal animal:resultList)
		{
			System.out.println(animal.getClass());
		}
		
		assertTrue(resultList.size()>0);
	}
	
	@Test
	public void test3Listerchiens() {
		
		//requete
		//select chien0_.id as id2_0_, chien0_.nom as nom3_0_ from Animal chien0_ where chien0_.DTYPE='Chien'
		
		
		Query chienQuery = em.createQuery("select chien from Chien chien");
		List<Chien> resultList = chienQuery.getResultList();	 
		for(Chien chien:resultList)
		{
			System.out.println(chien.getNom());
		}
		
		assertTrue(resultList.size()>0);
	}
	
	
}
