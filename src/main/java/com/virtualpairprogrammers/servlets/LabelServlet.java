package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Label;
import com.virtualpairprogrammers.service.LabelService;

public class LabelServlet extends HttpServlet{  
	
	private LabelService labelService;
	private List<Label> listaLabel;
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        labelService = new LabelService();
        
        switch (scelta) {
        
    	   case "view":
    		    listaLabel = labelService.getAllLabel();
                request.setAttribute("allLabel", listaLabel);
                getServletContext().getRequestDispatcher("/labelView.jsp").forward(request,response);           
                break; 
                
    	   case "insert":
    		    response.sendRedirect("labelInsert.jsp");
    		    break;  
    		    
    	   case "insertLabel":
    		   if (request != null) {
    			   int idLabel = 0; 
    			   long ordine= Long.parseLong(request.getParameter("ordine").toString());
    			   String descr = request.getParameter("descr").toString();
    			   long idGame = Long.parseLong(request.getParameter("idGame").toString());
    			   
    			   if (labelService.insertLabel(new Label(idLabel, ordine, descr, idGame))){
    				  this.listaLabel = this.labelService.getAllLabel();
    				  request.setAttribute("allLabel", this.listaLabel);
    				  request.setAttribute("messaggio", "Indizio inserito con successo.\n");
    				  getServletContext().getRequestDispatcher("/labelView.jsp").forward(request, response);
    				  
    	       	   }
    			   else {
    				   request.setAttribute("messaggio", "Problemi con l'inserimento del' indizio. Riprovare.\n");
    				   response.sendRedirect("labelInsert.jsp");

    			   }
    		     }
    		   break;    
 
    		case "update":
   				//int id= Integer.parseInt(request.getParameter("id"));
    			long id= Long.parseLong(request.getParameter("id"));
   				this.listaLabel = this.labelService.getLabel(id);
   				request.setAttribute("allLabel", this.listaLabel);
   				getServletContext().getRequestDispatcher("/labelUpdate.jsp").forward(request, response);
     		   break;
   			case "updateLabel":
   				this.labelService.updateLabel(request);
   				this.listaLabel= this.labelService.getAllLabel();
   				request.setAttribute("allLabel",this.listaLabel);
   				request.setAttribute("messaggio", "Indizio modificato con successo.\n");
   				getServletContext().getRequestDispatcher("/labelView.jsp").forward(request, response);
   				break; 
   				
   			case "delete":
   				this.labelService.deleteLabel(Integer.parseInt(request.getParameter("id")));
   				this.listaLabel = this.labelService.getAllLabel();
   				request.setAttribute("allLabel",this.listaLabel);
   				request.setAttribute("messaggio", "Indizio cancellato con successo.\n");
   				getServletContext().getRequestDispatcher("/labelView.jsp").forward(request, response);
   				break; 
                
            case "Indietro":
     		   response.sendRedirect("homeLabel.jsp");
     		   break;
            case "Indietro2":
               listaLabel = labelService.getAllLabel();
               request.setAttribute("allLabel", listaLabel);
               getServletContext().getRequestDispatcher("/labelView.jsp").forward(request,response);
      		   break;   
            case "Return":
      		   response.sendRedirect("homeGamer.jsp");
      		   break;
    	  
        }
		
	}
	
}