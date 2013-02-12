import java.util.List;

import javax.persistence.*;

import modele.Vehicule;

public class Main {
	  private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	  private static EntityManagerFactory factory;

	  public static void main(String[] args) {
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();
	    Query q = em.createQuery("select v from Vehicule v");
	    List<Vehicule> vehiculeList = q.getResultList();
	    for (Vehicule vehicule : vehiculeList) {
	      System.out.println("Vehicule: "+vehicule.getMarque()+" : "+vehicule.getModele()+" : " +vehicule.getCouleur());
	    }
	    viewVehiculeByID();
	    System.out.println("No de vehicule dans le DB: " + vehiculeList.size());	    
	  }
	  
	  public static void viewVehiculeByID(){
		  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		  EntityManager em = factory.createEntityManager();		  
		  Query q = em.createQuery( "SELECT v FROM Vehicule v WHERE v.id = '3'");
		  Vehicule v = (Vehicule)q.getSingleResult();		 
		  System.out.println("Vehicule: " + v.getMarque()+" : "+v.getModele()+" : "+v.getCouleur());
		  
	  }
	} 
