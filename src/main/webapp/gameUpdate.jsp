<%@ page import="com.virtualpairprogrammers.model.Game"%>
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
			table{
				border: 2px solid black;
			}
	</style>
	<%
		List<Game> allGame = (List<Game>) request.getAttribute("allGame");
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
		<h1>------Modifica Gioco------</h1>
		<form action="GameServlet" method="post">
	
			<table >
	
				<tr>   
			         <th> ID GIOCO</th>
			         <th> ID GAMER CREATORE </th>
			         <th> NOME GIOCO </th>
			         <th> DESCRIZIONE DEL PERCORSO CON PRIMO INDIZIO </th>
			    </tr>
			     
			        <%for (Game game : allGame) { %>
			        
			    <tr>
			        
			         <td> <%= game.getId()%> </td>
			         <td> <%= game.getIdCreatore()%> </td>
			         <td> <%= game.getNome()%> </td>
			         <td> <%= game.getDescrPercorso()%> </td>
			
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
					<td><input type="radio" name="campo" value="nome">Nome del gioco
					<input type="radio" name="campo" value="descrPercorso">Descrizione del percorso</td>
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
	</div>
</body>
</html>