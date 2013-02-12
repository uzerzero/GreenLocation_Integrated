package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Client;
import modele.ConnectionDB;
import modele.Contrat;
import modele.Employe;
import modele.Reservation;
import modele.Vehicule;

/**
 * Servlet implementation class ContratController
 */
@WebServlet("/ContratController")
public class ContratController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static ConnectionDB db = new ConnectionDB(PERSISTENCE_UNIT_NAME);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContratController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vehiculeID = request.getParameter("vehicule_id");
		String clientID = request.getParameter("client_id");
		String employeID = request.getParameter("employe_id");
		String strDateSaisie = request.getParameter("dateSaisie");
		
		Vehicule vehicule = (Vehicule)db.getByID("Vehicule", "id", vehiculeID);	
		Client client = (Client)db.getByID("Client", "id", clientID);
		Employe employe = (Employe)db.getByID("Employe", "id", employeID);
		  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy"); 
	    try {
			Date dateSaisie = dateFormat.parse(strDateSaisie);
			
			Contrat cont = new Contrat();
			cont.setClient(client);
			cont.setEmploye(employe);
			cont.setVehicule(vehicule);
			cont.setDateSaisie(dateSaisie);
			db.add(cont);
		} 
	    catch (ParseException e) {			
			e.printStackTrace();
		}
		
		List<Contrat> myContrat = db.getAll("Contrat");
		
		request.setAttribute("Contrats", myContrat);
		//Dispatch to jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Contrat.jsp"); 
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
