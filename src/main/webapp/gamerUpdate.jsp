<%@ page import="com.virtualpairprogrammers.model.User"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<User> allGamer = (List<User>) request.getAttribute("allGamer");
%>

</head>
<body>
	<%
		int scelta = Integer.parseInt(request.getParameter("id"));
	%>
	<h1>------Modifica Gamer------</h1>
	<form action="HomeSuperServlet" method="post">

		<table border="2">

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
		</table>
		<table>
			<input type="hidden" name="id" value="<%=scelta%>">
			<tr>
				<td>
					<h2>Seleziona il campo che vuoi modificare:</h2>
				</td>
			</tr>
			<tr>
				<td><input type="radio" name="campo" value="username">Username
				<input type="radio" name="campo" value="password">Password </td>
			</tr>
		</table>
		<table>
			<tr>
				<td>
					<h2>Inserisci il nuovo valore del campo:</h2>
				</td>
			</tr>
			<tr>
				<td><input type="text" name="newCampo" placeholder="Nuovo valore"></td>
			</tr>
		
			
		</table>
		<br/>
		<table>

			<tr>
				<button type="submit" value="updateGamer" name="richiesta">Invio</button>
			</tr>
			
		</table>
	</form>
	<form action="HomeSuperServlet" method=post>
		<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
	</form>
</body>
</html>