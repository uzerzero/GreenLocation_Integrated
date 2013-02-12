<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.util.*"
import = "modele.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<LINK title="Etat css" href="/GreenLocation/WebContent/CSS/Formulaire.css" type="text/css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire Etat Voiture</title>
</head>
<body>
<h1>Etat du véhicule</h1>
<form name="formContrat" action="contratDo" method="get">
<table>
<%
   	Vehicule v = (Vehicule)request.getAttribute("Vehicule");
   	List<Client> clients = (List<Client>)request.getAttribute("Clients");
   	List<Employe> employes = (List<Employe>)request.getAttribute("Employes");
   	%>
<% String nomMarque = request.getParameter("marque"); %>
<% String nomModele = request.getParameter("modele"); %>
<tr><td>Véhicule:</td><td><input type="text" name="ligne" readonly="readonly" value="<%= nomMarque +" "+nomModele %>"/></td></tr>


	    <label>Client: <% out.println(clients.get(0).getNom() ); %>  </label>
	    
	    <input type=hidden name="client_id" value = "<% out.println(clients.get(0).getId()); %>" >
   	

   	<p>
   	<label>Employe:  </label>
	    <select name="employe_id">
		<option value="<% out.println(employes.get(0).getId()); %>"><% out.println( employes.get(0).getLogin() ); %></option>
		<option value="<% out.println(employes.get(1).getId()); %>"><% out.println( employes.get(1).getLogin() ); %></option>
		<option value="<% out.println(employes.get(2).getId()); %>"><% out.println( employes.get(2).getLogin() ); %></option>
		</select>	   
   	</p>
<tr><td>Adresse Client:<% out.println(clients.get(0).getAdresse() ); %></td><td>

<tr><td>Permis:</td><td><select name="status">
<option value="Ok">Détenteur du Permis</option>
<option value="Pas en etat">Non détenteur du permis</option>
</select></td></tr>

<tr><td>Paiment<input type="text" name="paiement"></input></td></tr>

<tr><td><input type="submit" name="Soumettre" value="Soumettre"/><input type="reset" name="reset" value="Rafraichir"/></td></tr>     

</table>
</form>
</body>
</html>