package com.virtualpairprogrammers.servlets;

import com.virtualpairprogrammers.service.LoginService;
import com.virtualpairprogrammers.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginTraderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginService loginService;

    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
    
        loginService =  new LoginService();
        HttpSession session = request.getSession(true);
        
	    if (request != null) {
	        String nomeUtente = request.getParameter("username").toString(); 
	        String password = request.getParameter("password").toString();
	        User u = loginService.ruolo(nomeUtente, password);
	        if (u != null) {
	        	request.setAttribute("messaggio", "Login corretto\n");
	        	if (u.getRole() == 0) {
					getServletContext().getRequestDispatcher("/homeSuper.jsp").forward(request,response);
				} else if (u.getRole() == 1) {
					getServletContext().getRequestDispatcher("/homeGamer.jsp").forward(request,response);
				} else if (u.getRole() == 2) {
					getServletContext().getRequestDispatcher("/homePlayer.jsp").forward(request,response);
				} else {
					request.setAttribute("messaggio", "Login corretto ma ruolo non riconosciuto.\n");
					getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
				}
	        	
	        }
	        else {
	        	request.setAttribute("messaggio", "Username o Password sbagiati.\n");
	            getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
	        }
	    }
}
}