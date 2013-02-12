package modele;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.*;

@Entity
public class Contrat implements Serializable{

		private static final long serialVersionUID = 1L;
		@Id 
		@GeneratedValue(strategy=GenerationType.TABLE)
		private long id;
		@Temporal(TemporalType.DATE)
		private Date dateSaisie;
		private int prix;
		public int getPrix() {
			return prix;
		}

		public void setPrix(int prix) {
			this.prix = prix;
		}

		public Date getDateSaisie() {
			return dateSaisie;
		}

		public void setDateSaisie(Date dateSaisie) {
			this.dateSaisie = dateSaisie;
		}
		private Employe employe;
		
		private Client client;
		
		private Vehicule vehicule;
		
	    private Reservation reservation;		
		
	    @OneToOne
		public Reservation getReservation() {
			return reservation;
		}
		
		@ManyToOne
		public Employe getEmploye() {
			return employe;
		}
		
		public void setEmploye(Employe employe) {
			this.employe = employe;
		}
		
		@ManyToOne
		public Client getClient() {
			return client;
		}
		
		public void setClient(Client client) {
			this.client = client;
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		@ManyToOne
		public Vehicule getVehicule() {
			return vehicule;
		}
		public void setVehicule(Vehicule vehicule) {
			this.vehicule = vehicule;
		}

	
}
