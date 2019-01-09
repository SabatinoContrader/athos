<%@ page import="com.virtualpairprogrammers.model.Game"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<Game> allGame = (List<Game>) request.getAttribute("allGame");
%>

</head>
<body>
	<%
		int scelta = Integer.parseInt(request.getParameter("id"));
	%>
	<h1>------Modifica Gioco------</h1>
	<form action="GameServlet" method="post">

		<table border="2">

			<tr>   
		        <th> ID GIOCO</th>
		         <th> NOME GIOCO </th>
		         <th> ID GAMER CREATORE </th>
		         <th> LUOGO DEL GIOCO </th>
		         <th> AIUTO </th>
		     </tr>
		     
		        <%for (Game game : allGame) { %>
		        
		     <tr>
		        
		         <td> <%= game.getId()%> </td>
		         <td> <%= game.getName()%> </td>
		         <td> <%= game.getGamerId()%> </td>
		         <td> <%= game.getLocation()%> </td>
		         <td> <%= game.getHelp()%> </td>
		
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
				<td><input type="radio" name="campo" value="name">Nome del gioco
				<input type="radio" name="campo" value="gamer_id">Id del gamer creatore
				<input type="radio" name="campo" value="location">Luogo del gioco
				<input type="radio" name="campo" value="help">Aiuto </td>
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
				<button type="submit" value="updateGame" name="richiesta">Invio</button>
			</tr>
			
		</table>
	</form>
	<form action="GameServlet" method=post>
		<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
	</form>
</body>
</html>