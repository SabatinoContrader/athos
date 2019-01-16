<%@ page import="com.virtualpairprogrammers.model.Label"%>
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
		List<Label> allLabel = (List<Label>) request.getAttribute("allLabel");
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
		<h1>------Modifica Indizi------</h1>
		<form action="LabelServlet" method="post">
	
			<table>
	
				<tr>   
			         <th> ID INDIZIO</th>
			         <th> NUMERO DI ORDINE </th>
			         <th> DESCRIZIONE </th>
			         <th> ID GAME ASSOCIATO </th>
			    </tr>
						
			  <%for (Label label : allLabel) { %>
	        
	     <tr>
	        
	         <td> <%= label.getId()%> </td>
	         <td> <%= label.getOrders()%> </td>
	         <td> <%= label.getDescription()%> </td>
	         <td> <%= label.getIdGame()%> </td>
	
	     </tr>
	     <% }%>
			</table> <br><br>

			<input type="hidden" name="id" value="<%=scelta%>">
			
			<h2>Seleziona il campo che vuoi modificare:</h2>
			<input type="radio" name="campo" value="orders">Numero di ordine dell'indizio
			<input type="radio" name="campo" value="description">Descrizione
			<input type="radio" name="campo" value="idGame">Id Game associato
			
			<br><br>
			
			<h2>Inserisci il nuovo valore del campo:</h2>
			<input type="text" name="newCampo" placeholder="Nuovo valore"><br>
			
			<br><br>
			
			<button type="submit" value="updateLabel" name="richiesta">Invio</button>
			
		</form>
		<form action="LabelServlet" method=post>
			<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
		</form>
	</div>
</body>
</html>