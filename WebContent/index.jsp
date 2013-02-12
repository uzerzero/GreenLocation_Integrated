<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
  		<LINK title="index css" href="/GreenLocation/WebContent/CSS/Formulaire.css" type="text/css" rel="stylesheet"/>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>GlassFish JSP Page</title>
  </head>
  <body>
    <h1>Hello <%Object login =session.getAttribute("login");%> </h1>
    <form action="./Vehicules" method="post">
    <input type="submit" value="Admin"/>
    </form>
    <form action="./Vehicules" method="get">
    <input type="submit" value="Client Web"/>
    </form>
    <a href="ProfilClient.jsp">Profile Client</a>
    
       <form action="logout" method="get">
    <input type="submit" value="Logout"/>
    </form>
    
  </body>
</html> 
