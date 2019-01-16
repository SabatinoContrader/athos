package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.model.Game;
import com.virtualpairprogrammers.service.GameService;

public class GameServlet extends HttpServlet{  
	
	private GameService gameService;
	private List<Game> listaGame;
	
	public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String scelta = request.getParameter("richiesta");
        HttpSession session = request.getSession(true);
        gameService = new GameService();
        
        switch (scelta) {
        
    	   case "view":
    		    listaGame= gameService.getAllGame();
                request.setAttribute("allGame", listaGame);
                getServletContext().getRequestDispatcher("/gameView.jsp").forward(request,response);           
                break; 
                
    	   case "insert":
    		    response.sendRedirect("gameInsert.jsp");
    		    break;  
    		    
    	   case "insertGame":
    		   if (request != null) {
    			   int id = 0; 
    			   int idCreatore=Integer.parseInt(session.getAttribute("idUser").toString());
    			   String nome = request.getParameter("nome").toString();
    			   String descrPercorso = request.getParameter("descrPercorso").toString();
    			   
    			   if (gameService.insertGame(new Game(id,idCreatore, nome, descrPercorso))){
    				  this.listaGame = this.gameService.getAllGame();
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
   				this.listaGame= this.gameService.getAllGame();
   				request.setAttribute("allGame",this.listaGame);
   				getServletContext().getRequestDispatcher("/gameView.jsp").forward(request, response);
   				break; 
   				
   			case "delete":
   				this.gameService.deleteGame(Integer.parseInt(request.getParameter("id")));
   				this.listaGame = this.gameService.getAllGame();
   				request.setAttribute("allGame",this.listaGame);
   				getServletContext().getRequestDispatcher("/gameView.jsp").forward(request, response);
   				break; 
              
            case "Indietro":
     		   response.sendRedirect("homeGame.jsp");
     		   break;
            case "Indietro2":
               listaGame = gameService.getAllGame();
               request.setAttribute("allGame", listaGame);
               getServletContext().getRequestDispatcher("/gameView.jsp").forward(request,response);
      		   break;   
            case "Return":
      		   response.sendRedirect("homeGamer.jsp");
      		   break;
    	  
        }
		
	}
	
}