package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Game;
import com.virtualpairprogrammers.service.GameService;
import com.virtualpairprogrammers.model.Poi;
import com.virtualpairprogrammers.service.PoiService;
import com.virtualpairprogrammers.model.Sponsor;
import com.virtualpairprogrammers.service.SponsorService;

public class GameServlet extends HttpServlet{  
	
	private GameService gameService;
	private List<Game> listaGame;
	private PoiService poiService;
	private List<Poi> listaPoi;
	private SponsorService sponsorService;
	private List<Sponsor> listaSponsor;
	private Sponsor spot;
	private String prova; 
	private List<String> listaStringa;
	
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        gameService = new GameService();
        poiService = new PoiService();
        sponsorService = new SponsorService();

        int idGamer=Integer.parseInt(session.getAttribute("idUser").toString());
        
        
        switch (scelta) {
      
        
    	   case "view":   		    
    		    listaGame= gameService.getAllGame(idGamer);
                request.setAttribute("allGame", listaGame);
                getServletContext().getRequestDispatcher("/gameView.jsp").forward(request,response);           
                break; 
                
    	   case "insert":
    		   listaSponsor=new ArrayList<Sponsor>();
    		   listaPoi = poiService.getAllPoi();
    		   for (Poi poi : listaPoi) {
    			   int idSponsor=poi.getIdSponsor();
    			   if(idSponsor!=0) {
    				   List<Sponsor> singleSponsor=sponsorService.getSponsor(idSponsor);
        			   listaSponsor.add(singleSponsor.get(0));
    			   }else {
    				   listaSponsor.add(null);
    			   }
    			   
    		   }
    		   
               request.setAttribute("allPoi", listaPoi);
               request.setAttribute("allSponsor", listaSponsor);
               getServletContext().getRequestDispatcher("/gameInsert.jsp").forward(request,response);    
    		   break;  
    		    
    	   case "insertGame":
    		   if (request != null) {
    			   int id = 0; 
    			   int idCreatore=Integer.parseInt(session.getAttribute("idUser").toString());
    			   String nome = request.getParameter("nome").toString();
    			   String descrPercorso = request.getParameter("descrPercorso").toString();
    			   String [] idPoi =request.getParameterValues("poi[]");
    			   String [] ordine =request.getParameterValues("ordine[]");
    			   
    			   if (gameService.insertGame(new Game(id,idCreatore, nome, descrPercorso))){
    				  
    				  this.listaGame = this.gameService.getAllGame(idGamer);
    				  int idLastGame=listaGame.get(listaGame.size()-1).getId();
    				  gameService.insertRelGiochiPoi(idLastGame, idPoi, ordine);
    				  request.setAttribute("allGame", this.listaGame);
    				  getServletContext().getRequestDispatcher("/gameView.jsp").forward(request, response);
    				  
    	       	   }
    			   else {
    				   response.sendRedirect("gameInsert.jsp");

    			   }
    		     }
    		   break;    
 
    		case "update":
   				int id= Integer.parseInt(request.getParameter("id"));
   				this.listaGame = this.gameService.getGame(id);
   				request.setAttribute("allGame", this.listaGame);
   				getServletContext().getRequestDispatcher("/gameUpdate.jsp").forward(request, response);
     		   break;
   			case "updateGame":
   				this.gameService.updateGame(request);
   				this.listaGame= this.gameService.getAllGame(idGamer);
   				request.setAttribute("allGame",this.listaGame);
   				getServletContext().getRequestDispatcher("/gameView.jsp").forward(request, response);
   				break; 
   				
   			case "delete":
   				this.gameService.deleteGame(Integer.parseInt(request.getParameter("id")));
   				this.listaGame = this.gameService.getAllGame(idGamer);
   				request.setAttribute("allGame",this.listaGame);
   				getServletContext().getRequestDispatcher("/gameView.jsp").forward(request, response);
   				break; 
              
            case "Indietro":
     		   response.sendRedirect("homeGame.jsp");
     		   break;
            case "Indietro2":
               listaGame = gameService.getAllGame(idGamer);
               request.setAttribute("allGame", listaGame);
               getServletContext().getRequestDispatcher("/gameView.jsp").forward(request,response);
      		   break;   
            case "control":       
            	List<String> listaStringa = new ArrayList<>();
            	int idg= Integer.parseInt(request.getParameter("id"));
   				listaPoi = gameService.getAllPoi(idg);
   		    	request.setAttribute("allPoi", listaPoi);   
  
   		    	for (Poi poi : listaPoi) {
   		    		this.prova = this.sponsorService.returnNome(poi.getIdSponsor());
   		    		if (prova == "") {
   		    			listaStringa.add("");	
   		    		}
   		    		else
   		    		{
   		    			listaStringa.add(prova);
   		    		}
				}
   		    	
   		        request.setAttribute("allSponsor", listaStringa);  
                getServletContext().getRequestDispatcher("/poiOfGame.jsp").forward(request,response);    
   		        break;  
   				         
            case "Return":
      		   response.sendRedirect("homeGamer.jsp");
      		   break;
    	  
        }
		
	}
	
}