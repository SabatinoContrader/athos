<%@ page import="com.virtualpairprogrammers.model.User"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
	<%
	List<User> allGamer = (List<User>) request.getAttribute("allGamer");
	String msg = (String) request.getAttribute("messaggio");
	request.setAttribute("messaggio", " ");
	%>
</head>

<body>
	<div class="center">
		<%
			int scelta = Integer.parseInt(request.getParameter("id"));
		%>
		<% if (msg!=null){ %>
	 			<h2 style="color:red"><%= msg%>	</h2>  
	 	<% } %>
		<h1>------Modifica Gamer------</h1>
		<form action="HomeSuperServlet" method="post">
	
			<table>
	
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
			
			     </tr>
	     <% }%>
			</table><br><br>
			<input type="hidden" name="id" value="<%=scelta%>">
			
						<h2>Seleziona il campo che vuoi modificare:</h2>
					    <input type="radio" name="campo" value="username">Username
					<input type="radio" name="campo" value="password">Password 
			 <br><br>
			
					<h2>Inserisci il nuovo valore del campo:</h2> 
					<input type="text" name="newCampo" placeholder="Nuovo valore"> <br>
			<br><br>
	
			<button type="submit" value="updateGamer" name="richiesta">Invio</button>

		</form>
		<form action="HomeSuperServlet" method=post>
			<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
		</form>
	</div>
</body>
</html>