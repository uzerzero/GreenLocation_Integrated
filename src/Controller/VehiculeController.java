package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.ConnectionDB;
import modele.Vehicule;

public class VehiculeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static ConnectionDB db = new ConnectionDB(PERSISTENCE_UNIT_NAME);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehiculeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String modeleStr=request.getParameter("ModeleTxt");
		String marqueStr=request.getParameter("MarqueTxt");
		String prixStr=request.getParameter("PrixTxt");
		PrintWriter out = response.getWriter();
		try
		{ 
			int i = Integer.parseInt(prixStr); 
		} 
		catch (Exception e) { 
		prixStr="999999"; 
		}
		
		//String sql = "select v from Vehicule v where v.disponibilite = 'dispo'";
		String sql = "select v from Vehicule v left join v.categorie c where lower(v.modele) like lower('%"+modeleStr+"%') and lower(v.marque) like lower('%"+marqueStr+"%') and c.prix<="+prixStr+" and v.disponibilite = 'dispo'";
		   
		List<Vehicule> vehiculeList = db.get(sql);
	    //List<Vehicule> vehiculeList = db.getAll("Vehicule");		    
	    //viewVehiculeByID();
	    out.println("No de Vehicule dans le DB: " + vehiculeList.size());
	    request.setAttribute("Vehicules", vehiculeList);		
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/VehiculesWeb.jsp"); 
		dispatcher.forward(request, response);
	}	
	
	public static void viewVehiculeByID(){
		List<Vehicule> vehicule = db.get("Vehicule", "ID", "1");		  
		Vehicule v = vehicule.get(0);	 
		System.out.println("Vehicule: " + v.getMarque()+"</t> : "+v.getModele()+"</t> : "+v.getCouleur());		  
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String modeleStr=request.getParameter("ModeleTxt");
		String marqueStr=request.getParameter("MarqueTxt");
		String prixStr=request.getParameter("PrixTxt");
		PrintWriter out = response.getWriter();
		try
		{ 
			int i = Integer.parseInt(prixStr); 
		} 
		catch (Exception e) { 
		prixStr="999999"; 
		}
			    
	    String sql = "select v from Vehicule v left join v.categorie c where lower(v.modele) like lower('%"+modeleStr+"%') and lower(v.marque) like lower('%"+marqueStr+"%') and c.prix<="+prixStr;
	    List<Vehicule> vehiculeList = db.get(sql);
	    /*
	    for (Vehicule vehicule : vehiculeList) {
	      out.println("Vehicule: "+vehicule.getMarque()+"</t> : "+vehicule.getModele()+"</t> : " +vehicule.getCouleur());
	    }*/	    
	    //viewVehiculeByID();
	    out.println("No de vehicule dans le DB: " + vehiculeList.size());
	    request.setAttribute("Vehicules", vehiculeList);
		RequestDispatcher dispatcher = getServletContext().
		getRequestDispatcher("/VehiculesAdmin.jsp"); 
		dispatcher.forward(request, response);
	}

}
