package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Track;
import com.virtualpairprogrammers.service.TrackService;

public class TrackServlet extends HttpServlet{  
	
	private TrackService trackService;
	private List<Track> listaTrack;
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        trackService = new TrackService();
        
        switch (scelta) {
        
    	   case "view":
    		    listaTrack = trackService.getAllTrack();
                request.setAttribute("allTrack", listaTrack);
                getServletContext().getRequestDispatcher("/trackView.jsp").forward(request,response);           
                break; 
                
    	   case "insert":
    		    response.sendRedirect("trackInsert.jsp");
    		    break;  
    		    
    	   case "insertTrack":
    		   if (request != null) {
    			   int idTrack = 0; 
    			   String name = request.getParameter("name").toString();
    			   int startId = Integer.parseInt(request.getParameter("startId").toString());
    			   int endId = Integer.parseInt(request.getParameter("endId").toString());
    			   
    			   if (trackService.insertTrack(new Track(idTrack, name, startId, endId))){
    				  this.listaTrack = this.trackService.getAllTrack();
    				  request.setAttribute("allTrack", this.listaTrack);
    				  getServletContext().getRequestDispatcher("/trackView.jsp").forward(request, response);
    				  
    	       	   }
    			   else {
    				   response.sendRedirect("/trackInsert.jsp");

    			   }
    		     }
    		   break;    
 
    		case "update":
   				int id= Integer.parseInt(request.getParameter("id"));
   				this.listaTrack = this.trackService.getTrack(id);
   				request.setAttribute("allTrack", this.listaTrack);
   				getServletContext().getRequestDispatcher("/trackUpdate.jsp").forward(request, response);
     		   break;
   			case "updateTrack":
   				this.trackService.updateTrack(request);
   				this.listaTrack= this.trackService.getAllTrack();
   				request.setAttribute("allTrack",this.listaTrack);
   				getServletContext().getRequestDispatcher("/trackView.jsp").forward(request, response);
   				break; 
   				
   			case "delete":
   				this.trackService.deleteTrack(Integer.parseInt(request.getParameter("id")));
   				this.listaTrack = this.trackService.getAllTrack();
   				request.setAttribute("allTrack",this.listaTrack);
   				getServletContext().getRequestDispatcher("/trackView.jsp").forward(request, response);
   				break; 
               
            case "Indietro":
     		   response.sendRedirect("homeTrack.jsp");
     		   break;
            case "Indietro2":
               listaTrack = trackService.getAllTrack();
               request.setAttribute("allTrack", listaTrack);
               getServletContext().getRequestDispatcher("/trackView.jsp").forward(request,response);
      		   break;   
            case "Return":
      		   response.sendRedirect("homeGamer.jsp");
      		   break;
    	  
        }
		
	}
	
}