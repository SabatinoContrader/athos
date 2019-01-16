<html>
<head>
	<title>Menu Principale Player</title>
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
	     <h2>------- Benvenuto Player -------</h2>
	     <h2>------- Seleziona un' operazione -------</h2>
	
	     <h3>1. Gioca da solo</h3>
	     <form action="HomeGamerServlet" method="post">
	     <button type="submit" value="solo" name="richiesta">Vai</button>
	     </form>
	     
	     <h3>2. Gioca in gruppo</h3>
	     <form action="HomeGamerServlet" method="post">
	     <button type="submit" value="gruppo" name="richiesta">Vai</button>
	     </form>
	     
	     <h3>3. Logout</h3>
	     <form action="LogoutServlet" method="post">
	     <input type="submit" value="Logout" name="Logout">
	     </form>
	</div>
</body>
</html>