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
			table,th, td{
				border: 1px solid black;
			}
	</style>
    <% List<User> allGamer = (List<User>) request.getAttribute("allGamer");
       String msg = (String) request.getAttribute("messaggio");
	   request.setAttribute("messaggio", " ");
	%>
 </head>
 <body>
 	<div class="center"> 
 		
 		<% if (msg!=null){ %>
 			<h2 style="color:red"><%= msg%>	</h2>  
 	    <% } %>
		<h2>-------Elenco gamer disponibili-------</h2><br/>
		      
		<form action="HomeSuperServlet" method="post">
			<table >
			
			    <tr>   
			        <th> ID GAMER</th>
			        <th> USERNAME </th>
			        <th> PASSWORD </th>
			        <th> RUOLO </th>
			    </tr>
			    
			       <%for (User gamer : allGamer) { %>
			   
			<tr>
			   
			    <td> <%= gamer.getId()%> </td>
			    <td> <%= gamer.getUsername()%> </td>
			    <td> <%= gamer.getPassword()%> </td>
			    <td> <%= gamer.getRole()%> </td>
			    
			<td> <a href="HomeSuperServlet?richiesta=update&id=<%= gamer.getId() %>">Modifica</a></td>
			<td> <a href="HomeSuperServlet?richiesta=delete&id=<%= gamer.getId() %>">Elimina</a></td>
			
			</tr>
			<% }%>
			</table>
		</form>
		
		 <br>
		 
		 <form action="HomeSuperServlet" method="post">
			 <input type="submit" value="Indietro" name="richiesta">
			 <br/>
		 </form>
	 </div>
 </body>
</html>