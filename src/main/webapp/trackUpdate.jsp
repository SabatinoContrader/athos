<%@ page import="com.virtualpairprogrammers.model.Track"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<Track> allTrack = (List<Track>) request.getAttribute("allTrack");
%>

</head>
<body>
	<%
		int scelta = Integer.parseInt(request.getParameter("id"));
	%>
	<h1>------Modifica percorso------</h1>
	<form action="TrackServlet" method="post">

		<table border="2">

	<tr>   
		 <th> ID PERCORSO</th>
         <th> NOME </th>
         <th> ID POI PARTENZA </th>
         <th> ID POI ARRIVO </th>
     </tr>
     
        <%for (Track track : allTrack) { %>
        
     <tr>
        
         <td> <%= track.getId()%> </td>
         <td> <%= track.getName()%> </td>
         <td> <%= track.getStartPoiId()%> </td>
         <td> <%= track.getEndPoiId()%> </td>

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
				<td><input type="radio" name="campo" value="name">Nome del percorso
				<input type="radio" name="campo" value="start_poi_id">Id Punto di interesse partenza
				<input type="radio" name="campo" value="end_poi_id">Id Punto di interesse arrivo</td>
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
				<button type="submit" value="updateTrack" name="richiesta">Invio</button>
			</tr>
			
		</table>
	</form>
	<form action="TrackServlet" method=post>
		<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
	</form>
</body>
</html>