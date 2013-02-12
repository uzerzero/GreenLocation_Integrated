package test;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modele.Categorie;
import modele.ConnectionDB;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;

public class categorieTest {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	ConnectionDB cb = new ConnectionDB(PERSISTENCE_UNIT_NAME);

	@Before
	public void setUp() throws Exception {
	   List<Categorie> categories = cb.get("select c from Categorie c ");
	  
	   boolean creatNewEntries = (categories.size()>=0);
	   if(creatNewEntries){
		   assertTrue(categories.size()>=0);		  			   
		    Categorie categorie = new Categorie();
		    categorie.setCaution(600);
		    categorie.setCO2(18);
		    categorie.setCoffreContenanceEnM3(6);
		    categorie.setNbPlaces(5);
		    categorie.setNbPortes(5);
		    categorie.setNom("grand");
		    categorie.setPrix(65);				
		    cb.add(categorie);	  
	   }
	   
	}

	@Test
	public void test() {	
	
	    List<Categorie> categories = cb.get("select c from Categorie c ");
	    System.out.println("Count: "+categories.size());
	    cb.close();
	}


}
