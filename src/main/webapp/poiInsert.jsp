<%@ page import="com.virtualpairprogrammers.model.Poi" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>

	 <h2>-------Inserisci i dati del nuovo Punto di Interesse-------</h2><br/>
	 
  <form action="PoiServlet?richiesta=insertPoi" method="post">
    
  
    <h2>Latitudine: <input type="text" name="latitudine"></h2>
    <h2>Longitudine: <input type="text" name="longitudine"> </h2>
   <h2>ID Sponsor: <input type="text" name="idSponsor"></h2>
   	   <h2>Indizio: <input type="text" name="indizio"> </h2>
  
  
    <input type="submit" value="Inserisci" name="richiesta">
  </form>
  
  <form action="PoiServlet" method="post">
    <input type="submit" value="Indietro" name="richiesta">
  </form>
 
</body>
</html>