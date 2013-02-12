<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
<h1>Connexion</h1>
<div>
ID:
<%Object id =session.getAttribute("id");%>
<%=id%>
</div>
<form name="formConnexion" action="connexion" method="get">
<table>

<tr><td>Login:</td><td><input type="text" name="login" value = <%Object nom =session.getAttribute("nom");%><%=nom%>></input></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></input></td></tr>
<tr><td><input type="submit" name="Soumettre" value="Soumettre"/><input type="reset" name="reset" value="Rafraichir"/></td></tr>   
</table>
</form>
<a href="Inscription.jsp">Inscription</a>
</body>
</html>