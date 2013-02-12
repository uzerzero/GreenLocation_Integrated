package test;

import static org.junit.Assert.*;

import java.util.List;
import modele.*;


import org.junit.Before;
import org.junit.Test;

public class vehiculeTest {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	
	ConnectionDB cb = new ConnectionDB(PERSISTENCE_UNIT_NAME);
	
	@Before
	public void setUp() throws Exception {    
	       	    
	    List<Categorie> categories = cb.get("select c from Categorie c where c.id=1");
	    Categorie categorie = categories.get(0);
	    System.out.println("Category: "+categorie.getNom());
	    List<Vehicule> vehicules = cb.getAll("Vehicule");
	    
	    boolean creatNewEntries = (vehicules.size()==0);
	    if(creatNewEntries){	
			assertTrue(vehicules.size()==0);
			
		    for(int i=0;i<15;i++){		   
			    Vehicule vehicule = new Vehicule();
			    vehicule.setImmatriculation("CAT31_"+i);
				vehicule.setMarque("BMW_"+i);
				vehicule.setModele("Serie_"+i);
				vehicule.setCouleur("Rouge_"+i);
				vehicule.setDisponibilite("dispo");
			    vehicule.setCategorie(categorie);
			    cb.add(vehicule);
			    Thread.sleep(1000);
		    }	
		    
	    }
	    System.out.println("Vehicules: "+vehicules.size());
	}

	@Test
	public void test() {	
		fail("Tah loora lorra li");		
		List<Vehicule> vehicules = cb.getAll("Vehicule");
		assertTrue(vehicules.size()==15);
		System.out.println("Count: "+vehicules.size());
		cb.close();
		
	}


}
