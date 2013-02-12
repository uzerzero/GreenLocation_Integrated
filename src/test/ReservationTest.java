package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modele.Categorie;
import modele.Client;
import modele.ConnectionDB;
import modele.Employe;
import modele.Reservation;

import org.junit.Before;
import org.junit.Test;

import com.sun.net.httpserver.Authenticator.Success;

public class ReservationTest {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	ConnectionDB cb = new ConnectionDB(PERSISTENCE_UNIT_NAME);

	@Before
	public void setUp() throws Exception {
	   List<Categorie> categories = cb.get("select c from Categorie c ");
	   Employe emp = new Employe();
	   emp.setLogin("user02");
	   Client client = new Client();
	   client.setLogin("user01");
	   Date debut = new Date(2012, 1, 15);
	   Date fin =new Date(2012, 1, 20);
	  
	   boolean creatNewEntries = (categories.size()>=0);
	   if(creatNewEntries){
		   assertTrue(categories.size()>=0);		  			   
		    Reservation res = new Reservation();
		    res.setDateDebut(debut);
		    res.setDateFin(fin);
		    res.setEmploye(emp);
		    res.setClient(client);
		    				
		    cb.add(res);	  
	   }
	   
	}

	@Test
	public void test() {	
	
	    List<Categorie> categories = cb.get("select c from Categorie c ");
	    System.out.println("Count: "+categories.size());
	    cb.close();
	}


}
