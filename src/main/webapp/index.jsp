<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Login Trader</title>
	<style>
		.center{
			margin: auto;
			width: 60%;
			text-align: center
		}
		/* The Modal (background) */
			.modal {
			  display: none; /* Hidden by default */
			  position: fixed; /* Stay in place */
			  z-index: 1; /* Sit on top */
			  padding-top: 100px; /* Location of the box */
			  left: 0;
			  top: 0;
			  width: 100%; /* Full width */
			  height: 100%; /* Full height */
			  overflow: auto; /* Enable scroll if needed */
			  background-color: rgb(0,0,0); /* Fallback color */
			  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
			}
			
			/* Modal Content */
			.modal-content {
			  background-color: #fefefe;
			  margin: auto;
			  padding: 20px;
			  border: 1px solid #888;
			  width: 80%;
			}
			
			/* The Close Button */
			.close {
			  color: #aaaaaa;
			  float: right;
			  font-size: 28px;
			  font-weight: bold;
			}
			
			.close:hover,
			.close:focus {
			  color: red;
			  text-decoration: none;
			  cursor: pointer
			}
	</style>
	<% String msg = (String) request.getAttribute("messaggio");
	   request.setAttribute("messaggio", " ");
	%>
</head>
<body>
   <div class="center">
   <img src="login.png" style="width:50px;height:50px;"/>
	
    <h2>LOGIN</h2>
    <div id="myModal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
		    <span class="close">&times;</span>
		    <p><%= msg%></p>
		  </div>
		
	</div>
 	 <% if (msg!=null){ %>
 			<script>
	 			var modal = document.getElementById('myModal');
	 			modal.style.display = "block";
	 		</script>  
 	 <% } %>
 
	
	<script>
			
			var span = document.getElementsByClassName("close")[0];
			span.onclick = function() {
				  modal.style.display = "none";
				}
	</script>
 	
     <form action = "LoginTraderServlet" method= "post">
     <h3>username: <input type = "text" id = "user" name ="username" placeholder = "inserisci username"></h3>
     <h3>password: <input type = "password" id = "pass" name ="password" placeholder = "inserisci password"></h3>
     <button type = "submit" value = "Login" name = "richiestaLogin">Login</button><br>
     </form>
     
      <form action = "RegisterServlet" method= "post">
      	<a href="register.jsp" name = "registrati"> Registrati </a>
      </form>
  
   </div>
</body>
</html>