package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePlayerServlet extends HttpServlet {
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {  
		
		String scelta = request.getParameter("richiesta");
	    HttpSession session = request.getSession(true);
	    
	    switch (scelta) {
	    
		   case "solo":
	            getServletContext().getRequestDispatcher("/homeSolo.jsp").forward(request,response);
	            break;
		   case "gruppo":
			   getServletContext().getRequestDispatcher("/homeGruppo.jsp").forward(request,response);
	            break;
		         
	       default: 
	    	   getServletContext().getRequestDispatcher("/homePlayer.jsp").forward(request,response);  // return al login
	    	   
	    }
	        
	}
	
}
