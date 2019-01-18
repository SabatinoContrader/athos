<%@ page import="com.virtualpairprogrammers.model.Poi" %>
<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Poi> allPoi = (List<Poi>) request.getAttribute("allPoi");%>
  <% List<String> allSpot = (List<String>) request.getAttribute("allSponsor");%> 
  <% int i = 0; %>
 </head>
 <body>
 
     <h2>-------Elenco Punti di Interesse-------</h2><br/>
      
<form action="GameServlet" method="post">
 <table border="2">

     <tr>   
         <th> ID POI</th>
         <th> LATITUDINE </th>
         <th> LONGITUDINE </th>
         <th> INDIZIO </th>
         <th> NOME SPONSOR </th>
     </tr>
     
        <%for (Poi poi : allPoi) { %>
         
     <tr>
         <td> <%= poi.getId()%> </td>
         <td> <%= poi.getLatitudine()%> </td>
         <td> <%= poi.getLongitudine()%> </td>
         <td> <%= poi.getIndizio()%> </td>  
         <td> <%= allSpot.get(i) %> </td>   
         <% i++; %>
         <% }%> 
     </tr>
    
   
 </table>

</form>
 <h2></h2>
 <h2></h2>
 <form action="GameServlet" method="post">
 <input type="submit" value="Indietro" name="richiesta">
 <h3></h3>

 </form>
 </body>
</html>