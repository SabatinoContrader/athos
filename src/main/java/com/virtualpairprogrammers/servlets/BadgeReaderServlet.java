package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Utente;
import com.virtualpairprogrammers.service.RegisterService;

import com.virtualpairprogrammers.model.Principio; //////////////
import com.virtualpairprogrammers.service.CrudPrincipiService;  ////////////

/**
 * Servlet implementation class PRINCIPI
 */
public class BadgeReaderServlet extends HttpServlet {
	
	private String message;
	//private BadgeReaderService badgeReaderService;
	
	//////////////////////////////////////////////////////////////////////////////////////////
	private CrudPrincipiService CrudPrincipiService;
	private List<Principio> allPrincipio;
	/////////////////////////////////////////////////////////////////////////////////////////
	
    @Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	
    	this.CrudPrincipiService= new CrudPrincipiService();
    	this.message = "";
    	String choice = request.getParameter("richiesta");
        if (choice != null) {
        	switch (choice) {
            case "badgesReaderManagement":
            	this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
                request.setAttribute("visualizzaBadgeReaders", allPrincipio);
            	getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
            	break;
            	
            	//inserimento principio			//////////////////////
            case "insert":
            	response.sendRedirect("insertBadgeReader.jsp");
            	//getServletContext().getRequestDispatcher("/inserBadgereader.jsp").forward(request,response);
                break;
                
                
            case "Indietro":
            	//getServletContext().getRequestDispatcher("/homeAsset.jsp").forward(request,response);
                
            	response.sendRedirect("homeAsset.jsp");
            	//getServletContext().getRequestDispatcher("/inserBadgereader.jsp").forward(request,response);
                break;    
                
                
                
                /////////////////////////////		////////////
            case "delete":
            	this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
                request.setAttribute("visualizzaBadgeReaders", allPrincipio);
            	getServletContext().getRequestDispatcher("/DeletePrincipio.jsp").forward(request,response);
            break;
            
            	
            	
            case "deleteID":
            	if(this.CrudPrincipiService.deletePrincipio(Integer.parseInt(request.getParameter("id")))){
            		this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
                    request.setAttribute("visualizzaBadgeReaders", allPrincipio);
                	getServletContext().getRequestDispatcher("/DeletePrincipio.jsp").forward(request,response);}
            	else {
            		response.sendRedirect("homeAsset.jsp");
            	}
            	
             break;
           	
            	
            	
            	
            //insert principio						////////////////////////    
            case "insertBadgeReader":
            	if (request != null) {
                    int id = 0;
                    String nomePrincipio = request.getParameter("nomePrincipio").toString();
                    String nomePrincipioIta = request.getParameter("nomePrincipioIta").toString();
                    String domande = request.getParameter("domande").toString();
                    String steps = request.getParameter("steps").toString();
                    String esempi = request.getParameter("esempi").toString();
                   
                    if (CrudPrincipiService.insertPrincipio(new Principio( id,nomePrincipio, nomePrincipioIta,domande,steps,esempi ))) {
                   	 this.allPrincipio = this.CrudPrincipiService.getAllPrincipio();
                   	 request.setAttribute("visualizzaBadgeReaders", this.allPrincipio);
                   	 getServletContext().getRequestDispatcher("/badgeReaderHome.jsp").forward(request,response);
                    } 
                    else {
                        response.sendRedirect("insertBadgeReader.jsp");
                    }
           	}
               break;
               /////////////////////////				/////////////
           
             }
        		
        }
        else {
        	response.sendRedirect("homeAsset.jsp");
        }
    }
	}
	 
	 
	 