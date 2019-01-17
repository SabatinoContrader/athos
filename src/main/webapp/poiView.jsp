<%@ page import="com.virtualpairprogrammers.model.Poi" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Poi> allPoi = (List<Poi>) request.getAttribute("allPoi");%>
 </head>
 <body>
 
     <h2>-------Elenco Punti di Interesse disponibili-------</h2><br/>
      
<form action="PoiServlet" method="post">
 <table border="2">

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
               
		 <td> <a href="PoiServlet?richiesta=update&id=<%= poi.getId() %>">Modifica</a></td>
		 <td> <a href="PoiServlet?richiesta=delete&id=<%= poi.getId() %>">Elimina</a></td>
		 
     </tr>
     <% }%>
 </table>

</form>
 <h2></h2>
 <h2></h2>
 <form action="PoiServlet" method="post">
 <input type="submit" value="Indietro" name="richiesta">
 <h3></h3>

 </form>
 </body>
</html>