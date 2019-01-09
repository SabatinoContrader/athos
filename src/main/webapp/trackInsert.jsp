<%@ page import="com.virtualpairprogrammers.model.Track" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>

	 <h2>-------Inserisci i dati del nuovo Percorso-------</h2><br/>
	 
  <form action="TrackServlet?richiesta=insertTrack" method="post">
    
    <h2>Nome del percorso: <input type="text" name="name"></h2>
    <h2>Id punto di interesse di partenza: <input type="text" name="startId"></h2>
    <h2>Id punto di interesse di arrivo: <input type="text" name="endId"> </h2>
   	
    <input type="submit" value="Inserisci" name="richiesta">
  </form>
  
  <form action="TrackServlet" method="post">
    <input type="submit" value="Indietro" name="richiesta">
  </form>
 
</body>
</html>