package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Client;
import modele.ConnectionDB;
import modele.Employe;
import modele.Reservation;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static final long serialVersionUID = 1L;
	private static ConnectionDB db = new ConnectionDB(PERSISTENCE_UNIT_NAME);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employe emp = new Employe();
		
		emp.setNom(request.getParameter("nomEmp"));
		emp.setPrenom(request.getParameter("preCli"));
		emp.setFonction(request.getParameter("fonctCli"));
		emp.setAdmin(false);
		//cli.setCodePostal(request.getParameter("cpCli"));
		db.add(emp);
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client cli = new Client();
	
		cli.setNom(request.getParameter("nomCli"));
		cli.setPrenom(request.getParameter("preCli"));
		cli.setAdresse(request.getParameter("adCli"));
		cli.setVille(request.getParameter("villeCli"));
		cli.setCodePostal(request.getParameter("cpCli"));
		db.add(cli);
		response.sendRedirect("index.jsp");
	}

}
