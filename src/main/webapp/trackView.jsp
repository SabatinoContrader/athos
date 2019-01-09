<%@ page import="com.virtualpairprogrammers.model.Track" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Track> allTrack = (List<Track>) request.getAttribute("allTrack");%>
 </head>
 <body>
 
     <h2>-------Elenco percorsi disponibili-------</h2><br/>
      
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
       
		 <td> <a href="TrackServlet?richiesta=update&id=<%= track.getId() %>">Modifica</a></td>
		 <td> <a href="TrackServlet?richiesta=delete&id=<%= track.getId() %>">Elimina</a></td>
		 
     </tr>
     <% }%>
 </table>

</form>
 <h2></h2>
 <h2></h2>
 <form action="TrackServlet" method="post">
 <input type="submit" value="Indietro" name="richiesta">
 <h3></h3>

 </form>
 </body>
</html>