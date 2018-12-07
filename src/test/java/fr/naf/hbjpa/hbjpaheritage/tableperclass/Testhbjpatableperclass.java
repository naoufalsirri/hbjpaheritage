package fr.naf.hbjpa.hbjpaheritage.tableperclass;


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
public class Testhbjpatableperclass {

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
		 Java java = new Java();
		 java.setNom("java");  
		 Csharp csharp = new Csharp();
		 csharp.setNom("C#");
         ts.begin();
         em.persist(java);
         em.persist(csharp); 
         ts.commit();                           
         assertNotNull(java.getId());
         assertNotNull(csharp.getId());
	}
	
	@Test
	public void test2ListerAnnimaux() {	
		
		//requete
		//select langage0_.id as id1_3_, langage0_.nom as nom2_3_, langage0_.clazz_ as clazz_ from 
		//( select id, nom, 1 as clazz_ from Java union select id, nom, 2 as clazz_ from Csharp ) langage0_
		
		Query animalQuery = em.createQuery("select lg from Langage lg");
		List<Langage> resultList = animalQuery.getResultList();	 
		for(Langage lg:resultList)
		{
			System.out.println(lg.getClass());
		}
		
		assertTrue(resultList.size()>0);
	}
	
	@Test
	public void test3Listerchiens() {
		
		//requete
		//select csharp0_.id as id1_3_, csharp0_.nom as nom2_3_ from Csharp csharp0_
		
		
		Query chienQuery = em.createQuery("select cs from Csharp cs");
		List<Csharp> resultList = chienQuery.getResultList();	 
		for(Csharp java:resultList)
		{
			System.out.println(java.getNom());
		}
		
		assertTrue(resultList.size()>0);
	}
	
	
}
