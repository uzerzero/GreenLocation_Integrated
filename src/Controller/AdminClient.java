package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Client;
import modele.ConnectionDB;
import modele.Vehicule;

/**
 * Servlet implementation class AdminClient
 */
@WebServlet("/AdminClient")
public class AdminClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static ConnectionDB db = new ConnectionDB(PERSISTENCE_UNIT_NAME);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
	    List<Client> clientList = db.getAll("Client");		    
	
	    out.println("No de client dans le DB: " + clientList.size());
	    request.setAttribute("Clients", clientList);		
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/ListeClient.jsp"); 
		dispatcher.forward(request, response);
	}	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomCliStr=request.getParameter("client_nom");
		String prenomCliStr=request.getParameter("client_prenom");
		String adresseCliStr=request.getParameter("client_adresse");
		String villeCliStr=request.getParameter("client_ville");
		String cpCliStr=request.getParameter("client_cp");
		PrintWriter out = response.getWriter();
			    
	    String sql = "select c from Client c where c.nom = "+nomCliStr+" and c.prenom = "+prenomCliStr+" and c.adresse="+adresseCliStr+" and c.ville = "+villeCliStr+" and c.codePostal ="+cpCliStr+"";
	    List<Client> clientList = db.get(sql);
	    
	   
	    out.println("No de vehicule dans le DB: " + clientList.size());
	    request.setAttribute("Clients", clientList);
		
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/AdminClient.jsp"); 
		dispatcher.forward(request, response);
	}

}
