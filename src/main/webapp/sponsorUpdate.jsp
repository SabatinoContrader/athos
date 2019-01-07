<%@ page import="com.virtualpairprogrammers.model.Sponsor"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<Sponsor> allSponsor = (List<Sponsor>) request.getAttribute("allSponsor");
%>
<h1>------Modifica Sponsor------</h1>
</head>
<body>
	<%
		int scelta = Integer.parseInt(request.getParameter("id"));
	%>

	<form action="SponsorServlet" method="post">

		<table border="2">

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
		</table>
		<table>
			<input type="hidden" name="id" value="<%=scelta%>">
			<tr>
				<td>
					<h2>Seleziona il campo che vuoi modificare:</h2>
				</td>
			</tr>
			<tr>
				<td><input type="radio" name="campo" value="poi_id">Id Punto di Interesse
				<input type="radio" name="campo" value="name">Nome
				<input type="radio" name="campo" value="description">Descrizione</td>
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
				<button type="submit" value="updateSponsor" name="richiesta">Invio</button>
			</tr>
			
		</table>
	</form>
	<form action="SponsorServlet" method=post>
		<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
	</form>
</body>
</html>