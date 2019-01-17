package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Sponsor;
import com.virtualpairprogrammers.service.SponsorService;

public class SponsorServlet extends HttpServlet{  
	
	private SponsorService sponsorService;
	private List<Sponsor> listaSponsor;
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        sponsorService = new SponsorService();
        
        switch (scelta) {
        
    	   case "view":
    		    listaSponsor = sponsorService.getAllSponsor();
                request.setAttribute("allSponsor", listaSponsor);
                getServletContext().getRequestDispatcher("/sponsorView.jsp").forward(request,response);           
                break; 
                
    	   case "insert":
    		    response.sendRedirect("sponsorInsert.jsp");
    		    break;  
    		    
    	   case "insertSponsor":
    		   if (request != null) {
    			   int idSponsor = 0;
    			   //int idpoi = Integer.parseInt(request.getParameter("idPoi").toString());
    			   String nome = request.getParameter("nome").toString();
    			   String descr = request.getParameter("descr").toString();
    			   
    			   if (sponsorService.insertSponsor(new Sponsor(idSponsor, nome, descr))){
    				  this.listaSponsor = this.sponsorService.getAllSponsor();
    				  request.setAttribute("allSponsor", this.listaSponsor);
    				  getServletContext().getRequestDispatcher("/sponsorView.jsp").forward(request, response);
    				  
    	       	   }
    			   else {
    				   response.sendRedirect("sponsorInsert.jsp");

    			   }
    		     }
    		   break;    
 
   			case "update":
   				int id= Integer.parseInt(request.getParameter("id"));
   				this.listaSponsor = this.sponsorService.getSponsor(id);
   				request.setAttribute("allSponsor", this.listaSponsor);
   				getServletContext().getRequestDispatcher("/sponsorUpdate.jsp").forward(request, response);
     		   break;
   			case "updateSponsor":
   				this.sponsorService.updateSponsor(request);
   				this.listaSponsor= this.sponsorService.getAllSponsor();
   				request.setAttribute("allSponsor",this.listaSponsor);
   				getServletContext().getRequestDispatcher("/sponsorView.jsp").forward(request, response);
   				break; 
   				
   			case "delete":
   				this.sponsorService.deleteSponsor(Integer.parseInt(request.getParameter("id")));
   				this.listaSponsor = this.sponsorService.getAllSponsor();
   				request.setAttribute("allSponsor",this.listaSponsor);
   				getServletContext().getRequestDispatcher("/sponsorView.jsp").forward(request, response);
   				break; 
                
            case "Indietro":
     		   response.sendRedirect("homeSponsor.jsp");
     		   break;
            case "Indietro2":
               listaSponsor = sponsorService.getAllSponsor();
               request.setAttribute("allSponsor", listaSponsor);
               getServletContext().getRequestDispatcher("/sponsorView.jsp").forward(request,response);
      		   break;   
            case "Return":
      		   response.sendRedirect("homeGamer.jsp");
      		   break;
    	  
        }
		
	}
	
}