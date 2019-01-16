<%@ page import="com.virtualpairprogrammers.model.Game" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>

	 <h2>-------Inserisci i dati del nuovo gioco-------</h2><br/>
	 
  <form action="GameServlet?richiesta=insertGame" method="post">
    
    <h2>Nome del gioco: <input type="text" name="nome"></h2>
    <h2>Descrizione del percorso: <input type="text" name="descrPercorso"> </h2>
   	
    <input type="submit" value="Inserisci" name="richiesta">
  </form>
  
  <form action="GameServlet" method="post">
    <input type="submit" value="Indietro" name="richiesta">
  </form>
 
</body>
</html>