<html>
<head>
<title>Menu Principale D.I.M.</title>
</head>
<body>
     
     <h2>------- Benvenuto Gamer -------</h2>
     <h2>------- Seleziona un' operazione -------</h2>
     <h2>    <h2>

     <h3>1. Gestione Punti di Interesse</h3>
     <form action="HomeGamerServlet" method="post">
     <button type="submit" value="poi" name="richiesta">Vai</button>
     </form>
     
     <h3>2. Gestione Indizi</h3>
     <form action="HomeGamerServlet" method="post">
     <button type="submit" value="label" name="richiesta">Vai</button>
     </form>
     
     <h3>3. Gestione Sponsor</h3>
     <form action="HomeGamerServlet" method="post">
     <button type="submit" value="sponsor" name="richiesta">Vai</button>
     </form>
     
     <h3>4. Gestione Percorsi</h3>
     <form action="HomeGamerServlet" method="post">
     <button type="submit" value="track" name="richiesta">Vai</button>
     </form>
     
     <h3>5. Gestione Game</h3>
     <form action="HomeGamerServlet" method="post">
     <button type="submit" value="game" name="richiesta">Vai</button>
     </form>
     
     <h3>6. Logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>