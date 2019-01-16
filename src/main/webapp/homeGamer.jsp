<html>
<head>
	<title>Menu Principale Gamer</title>
	<style>
			.center{
				margin: auto;
				width: 80%;
				text-align: left
			}
	</style>
	<% String msg = (String) request.getAttribute("messaggio");
	   request.setAttribute("messaggio", " ");
	%>
</head>

<body>
     <div class="center"> 
			 
		 <% if (msg!=null){ %>
 			<h2 style="color:red"><%= msg%>	</h2>  
 	 	 <% } %> 
	     <h2>------- Benvenuto Gamer -------</h2>
	     <h2>------- Seleziona un' operazione -------</h2>
	
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
	     
	     <h3>6. Logout</h3>
	     <form action="LogoutServlet" method="post">
	     <input type="submit" value="Logout" name="Logout">
	     </form>
	</div>
</body>
</html>