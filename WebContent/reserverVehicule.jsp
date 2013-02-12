<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.util.*"
import = "modele.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK title="Res Form css" href="/GreenLocation/WebContent/CSS/Formulaire.css" type="text/css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserver Vehicule</title>
</head>
<body>
<h2>Reservation d'un vehicule:</h2>
<form action=".\Reservation" Method="post">
<table>	
	<tr>
   	<td>
   	<%
   	Vehicule v = (Vehicule)request.getAttribute("Vehicule");
   	List<Client> clients = (List<Client>)request.getAttribute("Clients");
   	List<Employe> employes = (List<Employe>)request.getAttribute("Employes");
   	%>
	   	<label>Vehicule: </label>
	   	</td>
	   	<td>
	   	<input type=hidden name="vehicule_id" value = "<% out.println(v.getId()); %>" >
	    <input type="text" name="Vehicule" readonly="readonly" value="<% out.println( v.getMarque() ); %>">
	</td>
	</tr>
	<tr>
	<td>   
	    <label>Client: </label>
	</td>
	<td> <% out.println(clients.get(0).getNom() ); %> </td>
	<td>   
	    <input type=hidden name="client_id" value = "<% out.println(clients.get(0).getId()); %>" >
   	</td>
   	</tr>
   	<tr>
   	<td>
   	<label>Employe:  </label>
   	</td>
	<td>
	    <select name="employe_id">
		<option value="<% out.println(employes.get(0).getId()); %>"><% out.println( employes.get(0).getLogin() ); %></option>
		<option value="<% out.println(employes.get(1).getId()); %>"><% out.println( employes.get(1).getLogin() ); %></option>
		<option value="<% out.println(employes.get(2).getId()); %>"><% out.println( employes.get(2).getLogin() ); %></option>
		</select>	   
   	</td>
   	</tr>
   	<tr>
   	<td>
   	<label>Date Debut: </label>
   	</td>
	<td>
	    <input type="text" name="dateDebut" value="24/01/2012">	   
   	</td>
   	</tr>
   	<tr>
   	<td>
   	<label>Date Fin: </label>
   	</td>
	<td>
	    <input type="text" name="dateFin" value="26/01/2012">	   
   	</td>
   	</tr>
   	</table>
 	<input type="submit" Value="Reserver" />
</form>

</body>
</html>