package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.service.RegisterService;

public class RegisterServlet extends HttpServlet {
	RegisterService registerService;


public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.registerService=new RegisterService();
    
    if (request != null) {
    
    	String username = request.getParameter("username").toString();
        String password = request.getParameter("password").toString();
    	
        User u=new User(0, username, password, 2);
        
    	if (registerService.register(u)) {
        	response.sendRedirect("index.jsp");	
        }
        else
        	//messaggio di registrazione fallita, ritenta.
            response.sendRedirect("register.jsp");
    }
}
}
