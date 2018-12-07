package fr.naf.hbjpa.hbjpaheritage.joined;

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
public class Testhbjpajoined {

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
		 Voiture voiture = new Voiture();
		 voiture.setNbrPortes(3);  
		 voiture.setNom("Dasia");
		 Moto moto = new Moto();
		 moto.setTypeMoteur(4);
		 moto.setNom("Lari");
         ts.begin();
         em.persist(voiture);
         em.persist(moto); 
         ts.commit();                           
         assertNotNull(voiture.getId());
         assertNotNull(moto.getId());
	}
	
	@Test
	public void test2ListerAnnimaux() {	
		
		//requete
		//select vehicule0_.id as id1_5_, vehicule0_.nom as nom2_5_, vehicule0_1_.nbrPortes as nbrPorte1_6_, vehicule0_2_.typeMoteur as typeMote1_4_, case when vehicule0_1_.id is not null then 1 when vehicule0_2_.id is not null then 2 when vehicule0_.id is not null then 0 end as clazz_ from Vehicule vehicule0_ left outer join Voiture vehicule0_1_ on vehicule0_.id=vehicule0_1_.id
		//left outer join Moto vehicule0_2_ on vehicule0_.id=vehicule0_2_.id
		
		Query animalQuery = em.createQuery("select veh from Vehicule veh");
		List<Vehicule> resultList = animalQuery.getResultList();	 
		for(Vehicule veh:resultList)
		{
			System.out.println(veh.getClass());
		}
		
		assertTrue(resultList.size()>0);
	}
	
	@Test
	public void test3Listerchiens() {
		
		//requete
		//select moto0_.id as id1_5_, moto0_1_.nom as nom2_5_, moto0_.typeMoteur as typeMote1_4_ from Moto moto0_ inner join Vehicule moto0_1_ on moto0_.id=moto0_1_.id
		
		
		Query chienQuery = em.createQuery("select moto from Moto moto");
		List<Moto> resultList = chienQuery.getResultList();	 
		for(Moto moto:resultList)
		{
			System.out.println(moto.getNom());
		}
		
		assertTrue(resultList.size()>0);
	}
	
	
}
