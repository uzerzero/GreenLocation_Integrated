<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
<h1>Inscription</h1>
<form name="formInscription" action="verifInscription" method="post">
<table>
<tr><td>Login</td><td><input type="text" name="login"></td></tr>
<tr><td>Password</td><td><input type="password" name="password"></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name="cpassword"></td></tr>
<tr><td><input type="submit" name="Soumettre" value="Soumettre"/><input type="reset" name="reset" value="Rafraichir"/></td></tr>
</table>


</form>
</body>
</html>