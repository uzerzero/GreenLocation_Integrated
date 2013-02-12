package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.*;

/**
 * Servlet implementation class ListeReservationController
 */

public class ReservationController extends HttpServlet {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static final long serialVersionUID = 1L;
	private static ConnectionDB db = new ConnectionDB(PERSISTENCE_UNIT_NAME);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * doGet => takes vehicule, sends client and employee info to jsp
	 * Here we want to get the vehicule object, the list of employees and the client
	 * to send to the reserveVehicule.jsp
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Vehicule
		String id = request.getParameter("vehicule_id");
		Vehicule v = (Vehicule)db.getByID("Vehicule", "id", id);	
		request.setAttribute("Vehicule", v);				   
		//List of employees
		List<Employe> employes = db.getAll("Employe");
		request.setAttribute("Employes", employes);
		//List of Clients - to be changed to session object
		List<Client> clients= db.getAll("Client");
		request.setAttribute("Clients", clients);		
		//Dispatch to jsp
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/reserverVehicule.jsp"); 
		dispatcher.forward(request, response);		
	}
	/**
	 * doPost => Adds a reservation then Lists Reservations with note of confirmation
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vehiculeID = request.getParameter("vehicule_id");
		String clientID = request.getParameter("client_id");
		String employeID = request.getParameter("employe_id");
		String strDateDebut = request.getParameter("dateDebut");
		String strDateFin = request.getParameter("dateFin");
		
		Vehicule vehicule = (Vehicule)db.getByID("Vehicule", "id", vehiculeID);	
		Client client = (Client)db.getByID("Client", "id", clientID);
		Employe employe = (Employe)db.getByID("Employe", "id", employeID);
		Categorie categorie = vehicule.getCategorie();
		int prix = categorie.getPrix();
	     
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
	    try {
			Date dateDebut = dateFormat.parse(strDateDebut);
			Date dateFin = dateFormat.parse(strDateFin);
			long interval = dateFin.getTime() - dateDebut.getTime();
			int days = (int)TimeUnit.MILLISECONDS.toDays(interval); 
			int devis = (days*prix);
			request.setAttribute("devis", devis);
			Reservation res = new Reservation();
			res.setClient(client);
			res.setEmploye(employe);
			res.setVehicule(vehicule);
			res.setDateDebut(dateDebut);
			res.setDateFin(dateFin);
			db.add(res);			
			vehicule.setDisponibilite("reserver");
			
		} 
	    catch (ParseException e) {			
			e.printStackTrace();
		}
		
		List<Reservation> myReservations = db.getAll("Reservation");	
		
		request.setAttribute("Reservations", myReservations);
		//Dispatch to jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listeReservation.jsp"); 
		dispatcher.forward(request, response);
	  }

	


}
