<%@ page import="com.virtualpairprogrammers.model.Poi"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	List<Poi> allPoi = (List<Poi>) request.getAttribute("allPoi");
%>

</head>
<body>
<div>
	<%
		int scelta = Integer.parseInt(request.getParameter("id"));
	%>
	<h1>------Modifica Punti di interesse------</h1>
	<form action="PoiServlet" method="post">

		<table  border="2">

			<tr>   
		        <th> ID POI</th>
         <th> LATITUDINE </th>
         <th> LONGITUDINE </th>
         <th> INDIZIO </th>
         <th> ID SPONSOR </th>
		        
		    </tr>
					
		  <%for (Poi poi : allPoi) { %>
        
     <tr>
        
          <td> <%= poi.getId()%> </td>
         <td> <%= poi.getLatitudine()%> </td>
         <td> <%= poi.getLongitudine()%> </td>
         <td> <%= poi.getIndizio()%> </td>
         <td> <%= poi.getIdSponsor()%> </td>

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
				
				<td><input type="radio" name="campo" value="latitudine">Latitudine
				<input type="radio" name="campo" value="longitudine">Longitudine
				<input type="radio" name="campo" value="indizio">Indizio
				<input type="radio" name="campo" value="idSponsor">ID Sponsor</td>
				
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
				<button type="submit" value="updatePoi" name="richiesta">Invio</button>
			</tr>
			
		</table>
	</form>
	<form action="PoiServlet" method=post>
		<button type="submit" value="Indietro2" name="richiesta">Annulla</button>
	</form>
	</div>
</body>
</html>