<html>
<head>
<title>Menu Principale D.I.M.</title>
</head>
<body>
     
     <h2>------- Benvenuto Player -------</h2>
     <h2>------- Seleziona un' operazione -------</h2>
     <h2>    <h2>

     <h3>1. Gioca da solo</h3>
     <form action="HomePlayerServlet" method="post">
     <button type="submit" value="solo" name="richiesta">Vai</button>
     </form>
     
     <h3>2. Gioca in gruppo</h3>
     <form action="HomePlayerServlet" method="post">
     <button type="submit" value="gruppo" name="richiesta">Vai</button>
     </form>
     
     <h3>3. Logout<h3>
     <form action="LogoutServlet" method="post">
     <input type="submit" value="Logout" name="Logout">
     </form>

</body>
</html>