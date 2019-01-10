package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.UserService;

public class HomeSuperServlet extends HttpServlet {
 
		
		private UserService userService;
		private List<User> listaGamer;
		
		public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
			
			String scelta = request.getParameter("richiesta");
	        HttpSession session = request.getSession(true);
	        userService = new UserService();
	        
	        switch (scelta) {
	        
	    	   case "view":
	    		    listaGamer= userService.getAllGamer();
	                request.setAttribute("allGamer", listaGamer);
	                getServletContext().getRequestDispatcher("/gamerView.jsp").forward(request,response);           
	                break; 
	                
	    	   case "insert":
	    		    response.sendRedirect("gamerInsert.jsp");
	    		    break;  
	    		    
	    	   case "insertGamer":
	    		   if (request != null) {
	    			   int idGamer = 0; 
	    			   String username = request.getParameter("username").toString();
	    			   String password = request.getParameter("password").toString();
	    			   
	    			   if (userService.insertGamer(new User(idGamer, username, password, 1))){
	    				  this.listaGamer = this.userService.getAllGamer();
	    				  request.setAttribute("allGamer", this.listaGamer);
	    				  getServletContext().getRequestDispatcher("/gamerView.jsp").forward(request, response);
	    				  
	    	       	   }
	    			   else {
	    				   response.sendRedirect("gamerInsert.jsp");

	    			   }
	    		     }
	    		   break;    
	    		   
	    		case "update":
	   				int id= Integer.parseInt(request.getParameter("id"));
	   				this.listaGamer = this.userService.getGamer(id);
	   				request.setAttribute("allGamer", this.listaGamer);
	   				getServletContext().getRequestDispatcher("/gamerUpdate.jsp").forward(request, response);
	     		   break;
	     		   
	   			case "updateGamer":
	   				this.userService.updateGamer(request);
	   				this.listaGamer= this.userService.getAllGamer();
	   				request.setAttribute("allGamer",this.listaGamer);
	   				getServletContext().getRequestDispatcher("/gamerView.jsp").forward(request, response);
	   				break; 
	   					
	   			case "delete":
	   				this.userService.deleteGamer(Integer.parseInt(request.getParameter("id")));
	   				this.listaGamer = this.userService.getAllGamer();
	   				request.setAttribute("allGamer",this.listaGamer);
	   				getServletContext().getRequestDispatcher("/gamerView.jsp").forward(request, response);
	   				break; 
	            
	            case "Indietro":
	     		   response.sendRedirect("homeSuper.jsp");
	     		   break;
	            case "Indietro2":
	               listaGamer = userService.getAllGamer();
	               request.setAttribute("allGamer", listaGamer);
	               getServletContext().getRequestDispatcher("/gamerView.jsp").forward(request,response);
	      		   break;  
	    	  
	        }
			
		}
	
}
