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

import com.virtualpairprogrammers.model.CategorieStandard; //////////////
import com.virtualpairprogrammers.service.CrudCategorieStandardService;  ////////////

/**
 * Servlet implementation class categorie standard
 */
public class CategorieStandarServlet extends HttpServlet {
	
	private String message;
	
	//////////////////////////////////////////////////////////////////////////////////////////
	private CrudCategorieStandardService CrudCategorieStandardService;
	private List<CategorieStandard> allCategorieStandard;
	/////////////////////////////////////////////////////////////////////////////////////////
	@Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
    	
    	this.CrudCategorieStandardService= new CrudCategorieStandardService();
    	this.message = "";
    	String choice = request.getParameter("richiesta");
        if (choice != null) {
        	switch (choice) {
        	
            case "VisualizzaCat":
            	this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();
                request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);
            	getServletContext().getRequestDispatcher("/CategorieStandardSelect.jsp").forward(request,response);
            	break;
            	
            case "vprincipi":

        		getServletContext().getRequestDispatcher("/homePrincipi.jsp").forward(request,response);

        		break;
            	
            	
            case "inserisciCategoria":

            	getServletContext().getRequestDispatcher("/insertCategoria.jsp").forward(request,response);

                break;
      

            case "insert":
             if (request != null) {

                    int id = 0;

                    String nome = request.getParameter("nome").toString();

                    String nomeIng = request.getParameter("nomeIng").toString();

                    if (CrudCategorieStandardService.insertCategorieStandard(new CategorieStandard( id,nome, nomeIng))) {

                   	 this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();

                   	 request.setAttribute("visualizzaCategorieStandard", this.allCategorieStandard);

                   	 getServletContext().getRequestDispatcher("/inserisciCat.jsp").forward(request,response);

                    } 

                    else {

                        response.sendRedirect("insertBadgeReader.jsp");

                    }

           	}

               break;
                
            case "Indietro":
            	//getServletContext().getRequestDispatcher("/homeAsset.jsp").forward(request,response);
                
            	response.sendRedirect("homeCustomers.jsp");
            	//getServletContext().getRequestDispatcher("/inserBadgereader.jsp").forward(request,response);
                break;    
                
           
                
                /////////////////////////////		////////////
            case "delete":
            	this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();
                request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);
            	getServletContext().getRequestDispatcher("/deliteCategoria.jsp").forward(request,response);
            break;
            
            	
           
            case "deleteID":
            	if(this.CrudCategorieStandardService.deleteCategorieStandard(Integer.parseInt(request.getParameter("id")))){
            		this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();
                    request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);
                	getServletContext().getRequestDispatcher ("/deliteCategoria.jsp").forward(request,response);}
            	else {
            		response.sendRedirect("home.jsp");
            	}
            	
             break;
           	
            	
            	
            	
            
               /////////////////////////				/////////////
           
            case "aggiornaID":

    	    	if (request != null) {

    	    		int id = Integer.parseInt(request.getParameter("id").toString());

                    String nome = request.getParameter("nome").toString();

                    String nomeIng = request.getParameter("nomeIng").toString();

                    if (CrudCategorieStandardService.updateCategorieStandard(new CategorieStandard( id,nome,nomeIng ))) {

                   	 this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();

                   	 request.setAttribute("visualizzaCategorieStandard", this.allCategorieStandard);

                   	 getServletContext().getRequestDispatcher("/inserisciCat.jsp").forward(request,response);

                    } 

                    else {

                        response.sendRedirect("insertBadgeReader.jsp");

                    }

           	}	

             break;

           	

    	    

    	    case "aggiornaCat": //da implementare

    	    	this.allCategorieStandard = this.CrudCategorieStandardService.getAllCategorieStandard();

                request.setAttribute("visualizzaCategorieStandard", allCategorieStandard);

            	getServletContext().getRequestDispatcher("/AggiornaCategoria.jsp").forward(request,response);

            break;
        	
        	
        }
        	
        }
    
	}
	}
	 
	 
	 