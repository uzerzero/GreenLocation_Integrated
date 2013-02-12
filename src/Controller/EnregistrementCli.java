package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Client;
import modele.ConnectionDB;

/**
 * Servlet implementation class EnregistrementCli
 */
@WebServlet("/EnregistrementCli")
public class EnregistrementCli extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnregistrementCli() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
		ConnectionDB db = new ConnectionDB(PERSISTENCE_UNIT_NAME);
		String nomCliStr=request.getParameter("client_nom");
		String prenomCliStr=request.getParameter("client_prenom");
		String adresseCliStr=request.getParameter("client_adresse");
		String villeCliStr=request.getParameter("client_ville");
		String cpCliStr=request.getParameter("client_cp");
		PrintWriter out = response.getWriter();
			    
	    String sql = "select c from Client c where c.nom = "+nomCliStr+" and c.prenom = "+prenomCliStr+" and c.adresse="+adresseCliStr+" and c.ville = "+villeCliStr+" and c.codePostal ="+cpCliStr+"";
	    Client clientResult = (Client) db.get(sql);
	    
				if (clientResult == null) {
				System.out.println("Client non trouvé");
				} else {	
				clientResult.setNom(nomCliStr);	
				clientResult.setPrenom(prenomCliStr);
				clientResult.setAdresse(adresseCliStr);
				clientResult.setVille(villeCliStr);
				clientResult.setCodePostal(cpCliStr);
				db.update(clientResult);
				RequestDispatcher dispatcher = getServletContext().
						getRequestDispatcher("/ListeClients.jsp"); 
						dispatcher.forward(request, response); 
				}
				db.close();
	}

}
