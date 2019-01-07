package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeSuperServlet extends HttpServlet {
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {  
		
		String scelta = request.getParameter("richiesta");
	    HttpSession session = request.getSession(true);
	    
	    switch (scelta) {
	    
		   case "GestioneGamer":
	            getServletContext().getRequestDispatcher("/homeGestioneGamer.jsp").forward(request,response);
	            break;
	    }
	    
	    getServletContext().getRequestDispatcher("/homeSuper.jsp").forward(request,response);  // return al login
	    
	}
	
}
