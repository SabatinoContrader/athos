<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
     
</head>
<body>

	 <h2>-------Inserisci i dati del nuovo sponsor-------</h2><br/>
	 
  <form action="SponsorServlet?richiesta=insertSponsor" method="post">
    
    <h2>Id Luogo di Interesse: <input type="text" name="idPoi"></h2>
    <h2>Nome Sponsor: <input type="text" name="nome"> </h2>
    <h2>Descrizione: <input type="text" name="descr"></h2>
   	
    <input type="submit" value="Inserisci" name="richiesta">
  </form>
  
  <form action="SponsorServlet" method="post">
    <input type="submit" value="Indietro" name="richiesta">
  </form>
 
</body>
</html>