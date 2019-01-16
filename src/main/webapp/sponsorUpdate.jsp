<%@ page import="com.virtualpairprogrammers.model.Sponsor"%>
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
		List<Sponsor> allSponsor = (List<Sponsor>) request.getAttribute("allSponsor");
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
		<h1>------Modifica Sponsor------</h1>
		<form action="SponsorServlet" method="post">
	
			<table>
	
				<tr>   
			         <th> ID SPONSOR</th>
			         <th> ID LUOGO DI INTERESSE </th>
			         <th> NOME </th>
			         <th> DESCRIZIONE </th>
	     		</tr>
				
			 <%for (Sponsor sponsor : allSponsor) { %>
	        
	     <tr>
	        
	         <td> <%= sponsor.getId()%> </td>
	         <td> <%= sponsor.getPoiID()%> </td>
	         <td> <%= sponsor.getName()%> </td>
	         <td> <%= sponsor.getDescription()%> </td>
	
	     </tr>
	     <% }%>
			</table><br><br>
			
			<input type="hidden" name="id" value="<%=scelta%>">
				
			<h2>Seleziona il campo che vuoi modificare:</h2>
			<input type="radio" name="campo" value="poi_id">Id Punto di Interesse
			<input type="radio" name="campo" value="name">Nome
			<input type="radio" name="campo" value="description">Descrizione
			
			<br><br>
				
			<h2>Inserisci il nuovo valore del campo:</h2>
			<input type="text" name="newCampo" placeholder="Nuovo valore"><br>
			
			<br><br>
			
			<button type="submit" value="updateSponsor" name="richiesta">Invio</button>
				
		</form>
		<form action="SponsorServlet" method=post>
			<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
		</form>
	</div>
</body>
</html>