<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Menu Principale SPONSOR</title>
</head>
<body>
     
     <h2>------- MENU PRINCIPALE GESTIONE SPONSOR -------</h2>
     <h2>    <h2>

     <h3>1. Visualizza/Modifica/Elimina gli Sponsor</h3>
     <form action="SponsorServlet" method="post">
     <%--  <input type="hidden" name="modalita" value="visualizza">  --%>
     <button type="submit" value="view" name="richiesta">Vai</button>
     </form>
     
     <h3>2. Inserisci nuovo Sponsor</h3>
     <form action="SponsorServlet" method="post">
     <button type="submit" value="insert" name="richiesta">Vai</button>
     </form>
     
     
     <h3>5. Return<h3>
     <form action="SponsorServlet" method="post">
     <input type="submit" value="Return" name="richiesta">
     </form>

</body>
</html>