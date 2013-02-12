package modele;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ETAT database table.
 * 
 */
@Entity
public class Etat implements Serializable {


	private static final long serialVersionUID = 1L;

	
	private long id;

	private String portiere;
	
	private String roue;

	private String interieur;
	
	private String status;
	
	private String commentaire;
	

	

	public Etat() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInterieur() {
		return this.interieur;
	}

	public void setInterieur(String interieur) {
		this.interieur = interieur;
	}

	public String getPortiere() {
		return portiere;
	}

	public void setPortiere(String portiere) {
		this.portiere = portiere;
	}

	public String getRoue() {
		return roue;
	}

	public void setRoue(String roue) {
		this.roue = roue;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}