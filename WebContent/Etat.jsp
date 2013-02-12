<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
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
<form name="formEtat" action="verif" method="get">
<table>

<% String nomMarque = request.getParameter("marque"); %>
<% String nomModele = request.getParameter("modele"); %>
<tr><td>Véhicule:</td><td><input type="text" name="ligne" readonly="readonly" value="<%= nomMarque +" "+nomModele %>"/></td></tr>

<tr><td>Portières:</td><td><input type="text" name="portiere"></input></td></tr>

<tr><td>Roues:</td><td><input type="text" name="roue"></input></td></tr>

<tr><td>Intérieur:</td><td><input type="text" name="interieur"></input></td></tr>

<tr><td>Status:</td><td><select name="status">
<option value="Ok">Ok</option>
<option value="Pas en etat">Pas en etat</option>
</select></td></tr>

<tr><td>Commentaire (détails roues, portières):</td><td><textarea name="commentaire" cols="50" rows="3"></textarea></td></tr>

<tr><td><input type="submit" name="Soumettre" value="Soumettre"/><input type="reset" name="reset" value="Rafraichir"/></td></tr>     

</table>
</form>
</body>
</html>