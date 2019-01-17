package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Poi;
import com.virtualpairprogrammers.service.PoiService;

public class PoiServlet extends HttpServlet{  
	
	private PoiService poiService;
	private List<Poi> listaPoi;
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        poiService = new PoiService();
        
        switch (scelta) {
        
    	   case "view":
    		    listaPoi = poiService.getAllPoi();
                request.setAttribute("allPoi", listaPoi);
                getServletContext().getRequestDispatcher("/poiView.jsp").forward(request,response);           
                break; 
                
    	   case "insert":
    		    response.sendRedirect("poiInsert.jsp");
    		    break;  
    		    
    	   case "insertPoi":
    		   if (request != null) {
    			   int idPoi = 0; 
    			   float latitudine = Float.parseFloat( request.getParameter("latitudine").toString());
    			   float longitudine = Float.parseFloat(request.getParameter("longitudine").toString());
    			   int idSponsor = Integer.parseInt(request.getParameter("idSponsor").toString());
    			   String indizio = request.getParameter("indizio").toString();
    			   
    			   if (poiService.insertPoi(new Poi(idPoi, latitudine,longitudine,idSponsor,indizio))){
    				  this.listaPoi = this.poiService.getAllPoi();
    				  request.setAttribute("allPoi", this.listaPoi);
    				  getServletContext().getRequestDispatcher("/poiView.jsp").forward(request, response);  				  
    	       	   }
    			   else {
    				   response.sendRedirect("poiInsert.jsp");
    			   }
    		     }
    		   break;    
 
    		case "update":
   				int id= Integer.parseInt(request.getParameter("id"));
   				this.listaPoi = this.poiService.getPoi(id);
   				request.setAttribute("allPoi", this.listaPoi);
   				getServletContext().getRequestDispatcher("/poiUpdate.jsp").forward(request, response);
     		   break; 		       		   
   			case "updatePoi":
   				this.poiService.updatePoi(request);
   				this.listaPoi= this.poiService.getAllPoi();
   				request.setAttribute("allPoi",this.listaPoi);
   				getServletContext().getRequestDispatcher("/poiView.jsp").forward(request, response);
   				break;  
   				
   			case "delete":
   				this.poiService.deletePoi(Integer.parseInt(request.getParameter("id")));
   				this.listaPoi = this.poiService.getAllPoi();
   				request.setAttribute("allPoi",this.listaPoi);
   				getServletContext().getRequestDispatcher("/poiView.jsp").forward(request, response);
   				break; 
              
            case "Indietro":
     		   response.sendRedirect("homePoi.jsp");
     		   break;
            case "Indietro2":
               listaPoi = poiService.getAllPoi();
               request.setAttribute("allPoi", listaPoi);
               getServletContext().getRequestDispatcher("/poiView.jsp").forward(request,response);
      		   break;   
            case "Return":
      		   response.sendRedirect("homeGamer.jsp");
      		   break;
    	  
        }
		
	}
	
}