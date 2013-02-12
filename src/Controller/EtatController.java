package Controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.concurrent.Executor;

import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import modele.*;

public class EtatController extends HttpServer {
	private static final String PERSISTENCE_UNIT_NAME = "LocationVoitureDB";
	private static final long serialVersionUID = 1L;
	private static ConnectionDB db = new ConnectionDB(PERSISTENCE_UNIT_NAME);
	
	//public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	//	response.getOutputStream().println("test");
//}

	@Override
	public void bind(InetSocketAddress arg0, int arg1) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HttpContext createContext(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpContext createContext(String arg0, HttpHandler arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InetSocketAddress getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executor getExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContext(String arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeContext(HttpContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExecutor(Executor arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(int arg0) {
		// TODO Auto-generated method stub
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
	 }

public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
ServletOutputStream out = response.getOutputStream();
	
Etat e = new Etat();
String idstr = request.getParameter("vehicule_id");
//Vehicule vehicule = getVehiculeByID(idstr);
e.setPortiere(request.getParameter("portiere"));
e.setRoue(request.getParameter("roue"));
e.setInterieur(request.getParameter("interieur"));
e.setCommentaire(request.getParameter("commentaire"));
e.setStatus(request.getParameter("status"));
db.add(e);

out.println("Etat: " + e.getId());

try
{
	EntityTransaction entr = db.getTransaction();
	entr.begin(); 
	
	 if (db.get("SELECT e FROM Etat e").size()!=0){
		 Iterator eIterator = db.get("SELECT e FROM Etat e").iterator();
		 out.println("Liste des enregistrements d'Etat: ");
		 while (eIterator.hasNext()) {
		      e = (Etat) eIterator.next();
		      
		     out.println("Id :"+ e.getId());
		     out.println("Portière :"+ e.getPortiere());
		     out.println("Roue :"+ e.getRoue());
		     out.println("Interieur :"+ e.getInterieur());
		     out.println("Status :"+ e.getStatus());    		
		     out.println("Commentaire:" +e.getCommentaire()+ "/n/n");
		     
		 }
	 }
	 else{
	 out.println("Record not found.");
	 }
	 entr.commit();
	 }
	 finally{
	 db.close();
	 }
}
}