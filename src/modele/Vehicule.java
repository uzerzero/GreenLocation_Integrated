package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import modele.Categorie;

/**
 * Entity implementation class for Entity: Vehicle
 *
 */
@Entity
public class Vehicule implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String modele;
	private String immatriculation;
	private String marque;
	private String couleur;
	private String disponibilite;
	
	private Categorie categorie;
	
	@OneToMany(mappedBy = "vehicule")
	private final List<Reservation> reservations = new ArrayList<Reservation>();
	
	public List<Reservation> getReservations() {
	    return reservations;
	  }
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getModele() {	return modele;}
	public void setModele(String modele) {this.modele = modele;	}

	public String getImmatriculation() {return immatriculation;	}
	public void setImmatriculation(String immatriculation) {this.immatriculation = immatriculation;	}

	public String getMarque() {return marque;}
	public void setMarque(String marque) {this.marque = marque;}
	
	public String getCouleur() {return couleur;}
	public void setCouleur(String couleur) {this.couleur = couleur;}

	public String getDisponibilite() {return disponibilite;}
	public void setDisponibilite(String disponibilite) {this.disponibilite = disponibilite;	}

	@ManyToOne
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Vehicule() {	super();}
	
	@Override
	public String toString() { return super.toString();	} 
	
   
}
