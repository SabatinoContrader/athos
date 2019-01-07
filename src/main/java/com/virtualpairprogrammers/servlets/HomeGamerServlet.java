package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeGamerServlet extends HttpServlet {
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {  
		
		String scelta = request.getParameter("richiesta");
	    HttpSession session = request.getSession(true);
	    
	    switch (scelta) {
	    
		   case "poi":
	            getServletContext().getRequestDispatcher("/homePoi.jsp").forward(request,response);
	            break;
		   case "label":
			   getServletContext().getRequestDispatcher("/homeLabel.jsp").forward(request,response);
	            break;
		   case "sponsor":
			    getServletContext().getRequestDispatcher("/homeSponsor.jsp").forward(request,response);
	            break;
		   case "track":
			    getServletContext().getRequestDispatcher("/homeTrack.jsp").forward(request,response);
	            break;		
		   case "game":
			    getServletContext().getRequestDispatcher("/homeGame.jsp").forward(request,response);
	            break;
	            
	       default: 
	    	   getServletContext().getRequestDispatcher("/homeGamer.jsp").forward(request,response);  // return al login
	    	   
	    }
	        
	}
	
}
