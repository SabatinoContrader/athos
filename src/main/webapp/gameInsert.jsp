<%@ page import="com.virtualpairprogrammers.model.Game" %>
<%@ page import="com.virtualpairprogrammers.model.Sponsor" %>
<%@ page import="com.virtualpairprogrammers.model.Poi" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	 <% List<Poi> allPoi = (List<Poi>) request.getAttribute("allPoi");%> 
	 <% List<Sponsor> allSponsor = (List<Sponsor>) request.getAttribute("allSponsor");%>  
	 <% Integer i=0;%> 
	 <% String a=" "; %>   
</head>
<body>

	 <h2>-------Inserisci i dati del nuovo gioco-------</h2><br/>
	 
  <form action="GameServlet?richiesta=insertGame" method="post">
    
    <h2>Nome del gioco: <input type="text" name="nome"></h2>
    <h2>Descrizione del percorso: <input type="text" name="descrPercorso"> </h2>
    <br>
    <h2>Seleziona i Poi nell'ordine desiderato</h2>
	
	 <table id="tab" border="2">

     <tr>   
         <th> Indizio</th>
         <th> Latitudine </th>
         <th> Longitudine </th>
         <th> Sponsor</th>
         <th> Scegli i Poi</th>
         <th> Inserisci l'ordine</th>
     </tr>
     
        <%for (Poi poi : allPoi) { %>
        
     <tr>
        
         <td> 
         	<%if(poi.getIndizio()!=null){
         		out.println(poi.getIndizio());
         		}else{
         		out.println(a);} %>
         </td>
         <td> <%= poi.getLatitudine()%> </td>
         <td> <%= poi.getLongitudine()%> </td>
         <td>
         	<%if(allSponsor.get(i)!=null){ 
	  				out.println(allSponsor.get(i).getName());
	  			}else{
	  				out.println(a);
	  			}
         		i=i+1;
	  		%>
	  	</td> 
	  	<td><input type="checkbox" name="poi[]" value="<%=poi.getId()%>" onclick="document.getElementById('check<%=i-1%>').disabled=this.checked == false"></td>
	  	<td><input type="text" name="ordine[]" id="check<%=i-1%>" disabled="disabled" onblur="myFunction(<%=i-1%>)"></td>
     </tr>
     <% }%>
 	</table>
 	
 	<script>
 		function myFunction(pos) {
 		  var x = document.getElementsByName("ordine[]");
 		  
 		  
 		  var ultimo=x[pos].value;
 		  
 		  for(var i=0; i<x.length;i++){
 		    if(x[i].value==ultimo && i!=pos)
 		    	alert("Errroreeeee!!!!");
 		  }

 		  
 		}
	 	  
	 	
	</script>
	
    <input type="submit" value="Inserisci" name="richiesta">
  </form>
  
  <form action="GameServlet" method="post">
    <input type="submit" value="Indietro" name="richiesta">
  </form>
 
</body>
</html>