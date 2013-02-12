package Controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele.Utilisateur;

/**
 * Servlet implementation class UtilisateurController
 */
@WebServlet("/UtilisateurController")
public class UtilisateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("LocationVoitureDB");
	EntityManager em = emf.createEntityManager();  
	Utilisateur e = new Utilisateur();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		
		HttpSession session = request.getSession (true); 
		String s=session.getId();
		session.setAttribute("id",s); 
		try {  
			 String password=request.getParameter("password");
				
				byte[] unencodedPassword = password.getBytes();
				MessageDigest md = null;
				try {
				md = MessageDigest.getInstance("MD5");
				} catch (Exception ex) {}
				md.reset();
				md.update(unencodedPassword);
				byte[] encodedPassword = md.digest();
				StringBuffer buf = new StringBuffer();
				for (int i = 0; i < encodedPassword.length; i++) {
				if (((int) encodedPassword[i] & 0xff) < 0x10) {
				buf.append("0");
				}
				buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
				}
				String passw=buf.toString();
				
				Query query= em.createQuery("SELECT i.login FROM Utilisateur i  WHERE i.login = :login");
				query.setParameter("login", request.getParameter("login"));
				Query querybis= em.createQuery("SELECT i.pwd FROM Utilisateur i  WHERE i.pwd = :pwd");
				querybis.setParameter("pwd", passw);
				
				List loginRes = query.getResultList();
				List pwdRes = querybis.getResultList();
		
			 if  ((loginRes.size()==0) || (pwdRes.size() == 0)){
				response.sendRedirect("LoginFailed.jsp"); 
				} 
			 else 
				 {
				 String nom = (String) session.getAttribute("nom");
				 session.setAttribute("nom", request.getParameter("login"));
				 String mdp= (String) session.getAttribute("mdp");
				 session.setAttribute("mdp", passw);
				 response.sendRedirect("./index.jsp"); //error page 
				 }
			 } catch (Throwable theException) 
			 { 
				 System.out.println(theException); 
				 }
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession (true); 
		String s=session.getId();
		session.setAttribute("id",s); 
		Query query= em.createQuery("SELECT i FROM Utilisateur i WHERE i.login = :login");
	query.setParameter("login", request.getParameter("login"));
	java.util.List results = query.getResultList();
	if (results.size() != 0){
		System.out.println("L'utilisateur existe déjà");
	}
	else if (!request.getParameter("password").equals(request.getParameter("cpassword"))){
		System.out.println("Mots de passes différent");
		
	}
	else{
		
String password=request.getParameter("password");
		
		byte[] unencodedPassword = password.getBytes();
		MessageDigest md = null;
		try {
		md = MessageDigest.getInstance("MD5");
		} catch (Exception ex) {}
		md.reset();
		md.update(unencodedPassword);
		byte[] encodedPassword = md.digest();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < encodedPassword.length; i++) {
		if (((int) encodedPassword[i] & 0xff) < 0x10) {
		buf.append("0");
		}
		buf.append(Long.toString((int) encodedPassword[i] & 0xff, 16));
		}
		String passw=buf.toString();
		em.getTransaction().begin();
		e.setLogin(request.getParameter("login"));
		e.setPwd(passw);
		em.persist(e);
		em.getTransaction().commit();
		String nom = (String) session.getAttribute("nom");
		session.setAttribute("nom", request.getParameter("login"));
		request.getRequestDispatcher("/Connexion.jsp").forward(request, response);
	}
	
	}
	}


