<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>

	 <h2>-------Inserisci i dati del nuovo indovinello-------</h2><br/>
	 
  <form action="LabelServlet?richiesta=insertLabel" method="post">
    
    <h2>Numero di ordine dell'indovinello: <input type="text" name="ordine"></h2>
    <h2>Descrizione: <input type="text" name="descr"></h2>
    <h2>Id Game Associato: <input type="text" name="idGame"> </h2>
   	
    <input type="submit" value="Inserisci" name="richiesta">
  </form>
  
  <form action="LabelServlet" method="post">
    <input type="submit" value="Indietro" name="richiesta">
  </form>
 
</body>
</html>