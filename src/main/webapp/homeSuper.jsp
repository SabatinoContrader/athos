<html>
<head>
	<title>Menu Principale Super User</title>
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
 	 	 
	     <h2>------- Benvenuto Super User -------</h2>
	     <h2>------- Seleziona un' operazione -------</h2>
	
	     <h3>1. Visualizza/Modifica/Elimina Gamer</h3>
	     <form action="HomeSuperServlet" method="post">
	     <button type="submit" value="view" name="richiesta">Vai</button>
	     </form>
	     
	     <h3>2. Inserisci nuovo Gamer</h3>
	     <form action="HomeSuperServlet" method="post">
	     <button type="submit" value="insert" name="richiesta">Vai</button>
	     </form>
	     
	     <h3>3. Logout</h3>
	     <form action="LogoutServlet" method="post">
	     <input type="submit" value="Logout" name="Logout">
	     </form>
	</div>
</body>
</html>