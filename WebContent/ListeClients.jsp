<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import = "java.util.*"
import = "modele.Client"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration des clients</title>
</head>
<body>
<h1>Clients List</h1>
<form action="AdministrationClient" method="post">
<table>
<tr><td><input type="hidden"  name="NumeroPage"  value="1"></td></tr>
<tr><td><input type="hidden"  name="table"  value="Client"></td></tr>

<%
int i = 1;
List<Client> cliList = (List<Client>)request.getAttribute("Clients");
if (cliList.size()!=0)
	{	
		for (Iterator iter = cliList.iterator(); iter.hasNext();) 
		{	
			Client element = (Client) iter.next();
			%>
			<tr>
			<td>
			<input type="hidden" name="client" value="<%= element.getId() %>"/>	
			</td>
			<td><input type="hidden" name="client_nom" value="<%= element.getNom() %>"/></td>
			<td><input type="hidden" name="client_prenom" value="<%= element.getPrenom() %>"/></td>
			<td><input type="hidden" name="client_adresse" value="<%= element.getAdresse() %>"/></td>
			<td><input type="hidden" name="client_ville" value="<%= element.getVille() %>"/></td>
			<td><input type="hidden" name="client_cp" value="<%= element.getCodePostal() %>"/></td>
			<%
			out.println("<td>" + element.getNom() +" </td>");
			out.println("<td>" + element.getPrenom() + " </td>");
			out.println("<td>" + element.getAdresse() + "</td>");
			out.println("<td>" + element.getVille() + "</td>");
			out.println("<td>" + element.getCodePostal() + "</td>");
			%>
			<td><input type="submit" Value="Administrer Client" /></td>
			<!-- <td>
			<input type="submit" Value="Remplir le formulaire d'état" />		
			</td> -->
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
</form>
</body>
</html>