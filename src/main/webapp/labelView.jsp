<%@ page import="com.virtualpairprogrammers.model.Label" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
     <% List<Label> allLabel = (List<Label>) request.getAttribute("allLabel");
     	String msg = (String) request.getAttribute("messaggio");
	    request.setAttribute("messaggio", " ");     
     %>
 </head>
 <body>
 	<div class="center"> 
 		<% if (msg!=null){ %>
 			<h2 style="color:red"><%= msg%>	</h2>  
 	    <% } %>
 
     	<h2>-------Elenco indizi disponibili-------</h2><br/>
      
		<form action="LabelServlet" method="post">
		 <table >
		
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
		 <br>
		<form action="LabelServlet" method="post">
			 <input type="submit" value="Indietro" name="richiesta">
			 <br>
		</form>
 	</div>
 </body>
</html>