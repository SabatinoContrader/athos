<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>Menu Principale GIOCHI</title>
</head>
<body>
     
     <h2>------- MENU PRINCIPALE GESTIONE GIOCHI-------</h2>
     <h2>    <h2>

     <h3>1. Visualizza/Modifica/Elimina i giochi</h3>
     <form action="GameServlet" method="post">
     <button type="submit" value="view" name="richiesta">Vai</button>
     </form>
     
     <h3>2. Inserisci nuovo gioco</h3>
     <form action="GameServlet" method="post">
     <button type="submit" value="insert" name="richiesta">Vai</button>
     </form>
     
     
     <h3>3. Return<h3>
     <form action="GameServlet" method="post">
     <input type="submit" value="Return" name="richiesta">
     </form>

</body>
</html>