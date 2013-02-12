package modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import modele.Utilisateur;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity
public class Employe extends Utilisateur implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fonction;
	private String nom;
	private String prenom;
	private boolean admin;
	
	@OneToMany(mappedBy = "employe")
	private final List<Reservation> reservations = new ArrayList<Reservation>();
	
	@OneToMany(mappedBy = "employe")
	private final List<Contrat> contrats = new ArrayList<Contrat>();
	
	public List<Reservation> getReservations() {
	    return reservations;
	  }

	public Employe(String fonction, String nom, String prenom, String admin) {
		super();
		this.fonction = fonction;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Employe() {
		super();
	}
   
}
