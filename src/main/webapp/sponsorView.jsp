<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
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
     <% List<Sponsor> allSponsor = (List<Sponsor>) request.getAttribute("allSponsor");
     	String msg = (String) request.getAttribute("messaggio");
	    request.setAttribute("messaggio", " ");    
     %>
 </head>
 <body>
 	<div class="center"> 
 		<% if (msg!=null){ %>
 			<h2 style="color:red"><%= msg%>	</h2>  
 	    <% } %>
		<h2>-------Elenco sponsor disponibili-------</h2><br/>
		      
		<form action="SponsorServlet" method="post">
		 <table >
		
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
		 <br>
		 <form action="SponsorServlet" method="post">
			 <input type="submit" value="Indietro" name="richiesta">
			 <br>
		 </form>
	 </div>
 </body>
</html>