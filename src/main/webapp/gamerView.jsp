<%@ page import="com.virtualpairprogrammers.model.User" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
 <head>
     <% List<User> allGamer = (List<User>) request.getAttribute("allGamer");%>
 </head>
 <body>
 
     <h2>-------Elenco gamer disponibili-------</h2><br/>
      
<form action="HomeSuperServlet" method="post">
 <table border="2">

     <tr>   
         <th> ID GAMER</th>
         <th> USERNAME </th>
         <th> PASSWORD </th>
         <th> RUOLO </th>
     </tr>
     
        <%for (User gamer : allGamer) { %>
        
     <tr>
        
         <td> <%= gamer.getId()%> </td>
         <td> <%= gamer.getUsername()%> </td>
         <td> <%= gamer.getPassword()%> </td>
         <td> <%= gamer.getRole()%> </td>
       
		 <td> <a href="HomeSuperServlet?richiesta=update&id=<%= gamer.getId() %>">Modifica</a></td>
		 <td> <a href="HomeSuperServlet?richiesta=delete&id=<%= gamer.getId() %>">Elimina</a></td>
		 
     </tr>
     <% }%>
 </table>

</form>
 <h2></h2>
 <h2></h2>
 <form action="HomeSuperServlet" method="post">
 <input type="submit" value="Indietro" name="richiesta">
 <h3></h3>

 </form>
 </body>
</html>