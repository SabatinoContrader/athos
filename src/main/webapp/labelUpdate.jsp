<%@ page import="com.virtualpairprogrammers.model.Label"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<Label> allLabel = (List<Label>) request.getAttribute("allLabel");
%>

</head>
<body>
	<%
		int scelta = Integer.parseInt(request.getParameter("id"));
	%>
	<h1>------Modifica Indizi------</h1>
	<form action="LabelServlet" method="post">

		<table border="2">

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
		</table>
		<table>
			<input type="hidden" name="id" value="<%=scelta%>">
			<tr>
				<td>
					<h2>Seleziona il campo che vuoi modificare:</h2>
				</td>
			</tr>
			<tr>
				<td><input type="radio" name="campo" value="orders">Numero di ordine dell'indizio
				<input type="radio" name="campo" value="description">Descrizione
				<input type="radio" name="campo" value="idGame">Id Game associato</td>
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
				<button type="submit" value="updateLabel" name="richiesta">Invio</button>
			</tr>
			
		</table>
	</form>
	<form action="LabelServlet" method=post>
		<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
	</form>
</body>
</html>