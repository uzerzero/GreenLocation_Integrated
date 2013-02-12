<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.util.*"
import = "modele.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<LINK title="Res css" href="/GreenLocation/WebContent/CSS/Formulaire.css" type="text/css" rel="stylesheet"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservation</title>
</head>
<body>
<h1>Reservations List</h1>

<table> 
<%
List<Reservation> resList = (List<Reservation>)request.getAttribute("Reservations");
if (resList.size()!=0)
{
	for (Iterator iter = resList.iterator(); iter.hasNext();) {
		Reservation element = (Reservation) iter.next();	
		%>	
		<tr>
			<td>
			<input type="hidden" name="vehicule_id" value="<%= element.getId() %>"/>	
			</td>
			<%
			out.println("<td>" + element.getClient().getNom() +" </td>");
			out.println("<td>" + element.getDateDebut() + " </td>");
			out.println("<td>" + element.getDateFin() + "</td>");
			out.println("<td>" + element.getVehicule().getModele() + "</td>");
			out.println("<td>" + element.getEmploye().getNom() + "</td>");
			%>
			
		</tr>		
		<%
	}
}
else
{
	out.println("No reservations found");
}
%>


</table>
<a href = "./">Back to search</a> 

</body>
</html>