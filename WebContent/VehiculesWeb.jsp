<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.util.*"
import = "modele.Vehicule"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicules</title>
</head>
<body>
<h1>Vehicules List Client</h1>
<form name="vehiculeSearch" action="./Vehicules" method="get">
<label>Marque :</label>
<input type="text" name="MarqueTxt" width="50">
<label>Modèle :</label>
<input type="text" name="ModeleTxt" width="50"/>
<label>Prix Max :</label>
<input type="text" name="PrixTxt" width="50"/>
<input type="submit" name="SearchV" value="Rechercher"/></form>

<table>
<tr><td><input type="hidden"  name="table"  value="Vehicule"></td></tr>
<%
int i = 1;
List<Vehicule> vehList = (List<Vehicule>)request.getAttribute("Vehicules");
if (vehList.size()!=0)
	{	
		out.println("<tr><td></td><td>Modèle</td>");
		out.println("<td>Marque</td>");
		out.println("<td>Couleur</td>");
		out.println("<td>Disponibilité</td></tr>");
		for (Iterator iter = vehList.iterator(); iter.hasNext();) 
		{	
			Vehicule element = (Vehicule) iter.next();
			%>
			<tr>
			<td>
			<input type="hidden" name="vehicule_id" value="<%= element.getId() %>"/>	
			</td>
			<%
			out.println("<td>" + element.getModele() +" </td>");
			out.println("<td>" + element.getMarque() + " </td>");
			out.println("<td>" + element.getCouleur() + "</td>");
			out.println("<td>" + element.getDisponibilite() + "</td>");
			%>
			<td><a href="./Reservation?vehicule_id=<%= element.getId() %>">Reserver</a></td>
			</tr>
			
			<%
		}
	}
else
	{
		System.out.println("Records no found");
	}
%>

</table>
</body>
</html>