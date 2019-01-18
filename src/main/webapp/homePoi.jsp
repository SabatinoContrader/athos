<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
<%@ page import="java.util.*" %>
<html>
<head>
 
<title>Menu Principale INDIZI</title>
</head>
<body>
     
     <h2>------- MENU PRINCIPALE GESTIONE PUNTI DI INTERESSE-------</h2>
     <h2>    <h2>

     <h3>1. Visualizza/Modifica/Elimina i POI</h3>
     <form action="PoiServlet" method="post">
     <button type="submit" value="view" name="richiesta">Vai</button>
     </form>
     
     <h3>2. Inserisci nuovo POI</h3>
     <form action="SponsorServlet" method="post">
     <button type="submit" value="view2" name="richiesta">Vai</button>
     <!-- <form action="PoiServlet" method="post"> -->
     <!--<button type="submit" value="insert" name="richiesta">Vai</button>-->
     </form>
 
     <h3>3. Return<h3>
     <form action="PoiServlet" method="post">
     <input type="submit" value="Return" name="richiesta">
     </form>

</body>
</html>