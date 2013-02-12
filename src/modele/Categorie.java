package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import modele.Vehicule;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@Entity
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String nom;
	private int prix;
	private int caution;
	private int nbPortes;
	private int nbPlaces;
	private int coffreContenanceEnM3;
	private int CO2;
	
	@OneToMany(mappedBy = "categorie")
	private final List<Vehicule> vehicules = new ArrayList<Vehicule>();

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}

	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}

	public int getPrix() {return prix;}
	public void setPrix(int prix) {this.prix = prix;}

	public int getCaution() {return caution;}
	public void setCaution(int caution) {this.caution = caution;}

	public int getNbPortes() {return nbPortes;}
	public void setNbPortes(int nbPortes) {this.nbPortes = nbPortes;}

	public int getNbPlaces() {return nbPlaces;}
	public void setNbPlaces(int nbPlaces) {this.nbPlaces = nbPlaces;}

	public int getCoffreContenanceEnM3() {return coffreContenanceEnM3;}
	public void setCoffreContenanceEnM3(int coffreContenanceEnM3) {this.coffreContenanceEnM3 = coffreContenanceEnM3;}

	public int getCO2() {return CO2;}
	public void setCO2(int cO2) {CO2 = cO2;}
	
	public List<Vehicule> getVehicules() {
	    return vehicules;
	  }

	public Categorie() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

   
}
