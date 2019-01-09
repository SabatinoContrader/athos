<%@ page import="com.virtualpairprogrammers.model.Label" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<Label> allLabel = (List<Label>) request.getAttribute("allLabel");%>
 </head>
 <body>
 
     <h2>-------Elenco indizi disponibili-------</h2><br/>
      
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
       
		 <td> <a href="LabelServlet?richiesta=update&id=<%= label.getId() %>">Modifica</a></td>
		 <td> <a href="LabelServlet?richiesta=delete&id=<%= label.getId() %>">Elimina</a></td>
		 
     </tr>
     <% }%>
 </table>

</form>
 <h2></h2>
 <h2></h2>
 <form action="LabelServlet" method="post">
 <input type="submit" value="Indietro" name="richiesta">
 <h3></h3>

 </form>
 </body>
</html>