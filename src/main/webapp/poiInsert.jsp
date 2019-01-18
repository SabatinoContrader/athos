<%@ page import="com.virtualpairprogrammers.model.Poi" %>
<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     <% List<Sponsor> allSponsor = (List<Sponsor>) request.getAttribute("allSponsor");%>
</head>
<body>

	 <h2>-------Inserisci i dati del nuovo Punto di Interesse-------</h2><br/>
	 
  <form action="PoiServlet?richiesta=insertPoi" method="post">
    
  
    <h2>Latitudine: <input type="text" name="latitudine"></h2>
    <h2>Longitudine: <input type="text" name="longitudine"> </h2>
   <h2>ID Sponsor: <input type="text" name="idSponsor"></h2>
   	   <h2>Indizio: <input type="text" name="indizio"> </h2>
  
    <h2>-------Elenco sponsor disponibili-------</h2><br/>
      
<!-- <form action="SponsorServlet" method="post">-->
 <table border="2">

     <tr>   
         <th> ID SPONSOR</th>
         <th> NOME </th>
         <th> DESCRIZIONE </th>
     </tr>
     
        <%for (Sponsor sponsor : allSponsor) { %>
        
     <tr>
        
         <td> <%= sponsor.getId()%> </td> 
         <td> <%= sponsor.getName()%> </td>
         <td> <%= sponsor.getDescription()%> </td>
		 
     </tr>
     <% }%>
 </table>
 <br>
    <input type="submit" value="Inserisci" name="richiesta">
  </form>
  
  <form action="PoiServlet" method="post">
    <input type="submit" value="Indietro" name="richiesta">
  </form>
 
</body>
</html>