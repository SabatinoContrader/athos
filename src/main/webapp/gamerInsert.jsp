<%@ page import="com.virtualpairprogrammers.model.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<style>
			.center{
				margin: auto;
				width: 80%;
				text-align: left
			}
	</style>
	<% String msg = (String) request.getAttribute("messaggio");
	   request.setAttribute("messaggio", " ");
	%> 
</head>
<body>
	<div class="center"> 

		<% if (msg!=null){ %>
 			<h2 style="color:red"><%= msg%>	</h2>  
 	 	 <% } %>
		<h2>-------Inserisci i dati del nuovo gamer-------</h2><br/>
		
		<form action="HomeSuperServlet?richiesta=insertGamer" method="post">
		  
		  <h2>Username: <input type="text" name="username"></h2>
		  <h2>Password: <input type="text" name="password"></h2>
		 	
		  <input type="submit" value="Inserisci" name="richiesta">
		</form>
		
		<form action="HomeSuperServlet" method="post">
		  <input type="submit" value="Indietro" name="richiesta">
		</form>
	</div> 
</body>
</html>