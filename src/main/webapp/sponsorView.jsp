<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Sponsor> allSponsor = (List<Sponsor>) request.getAttribute("allSponsor");%>
 </head>
 <body>
 
     <h2>-------Elenco sponsor disponibili-------</h2><br/>
      
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

		 <td> <a href="SponsorServlet?richiesta=update&id=<%= sponsor.getId() %>">Modifica</a></td>
		 <td> <a href="SponsorServlet?richiesta=delete&id=<%= sponsor.getId() %>">Elimina</a></td>
		 
     </tr>
     <% }%>
 </table>

</form>
 <h2></h2>
 <h2></h2>
 <form action="SponsorServlet" method="post">
 <input type="submit" value="Indietro" name="richiesta">
 <h3></h3>

 </form>
 </body>
</html>