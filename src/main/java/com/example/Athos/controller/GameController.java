package com.example.Athos.controller;

import com.example.Athos.model.Game;
import com.example.Athos.model.RelUserGame;
import com.example.Athos.model.User;
//import com.example.Athos.dto.GameDTO;
import com.example.Athos.services.GameService;
import com.example.Athos.services.RelUserGameService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Game")
public class GameController {

	private GameService gameService;
	private RelUserGameService relUserGameService;
	//private GameDTO gameDTO;
	private HttpSession session;


	@Autowired
	public GameController(GameService gameService, RelUserGameService relUserGameService) {
		this.gameService = gameService;
		this.relUserGameService = relUserGameService;
	}


	@RequestMapping(value = "/giochiPerCreatore", method = RequestMethod.POST)
	public List<Game> gameCreatore(@RequestBody User user , HttpServletRequest request) {
		
		this.session = request.getSession();
		List <Game> game=gameService.findByCreatore(user);
		return game;
	}
	
	@RequestMapping(value = "/giochiPerVersione", method = RequestMethod.POST)
	public List<Game> gameVersione(@RequestParam("nome") String nome , HttpServletRequest request) {
		
		this.session = request.getSession();
		List <Game> game=gameService.findByVersione(nome);
		return game;
	}

	@RequestMapping(value = "/insertGiochi", method = RequestMethod.POST)
	public boolean saveGame(@RequestBody Game game , HttpServletRequest request) {
		
		this.session = request.getSession();
		gameService.saveGame(game);
		return true;
	}
	
	@RequestMapping(value = "/insertNewVersione", method = RequestMethod.POST)
	public boolean saveNewVersione(@RequestBody Game game , HttpServletRequest request) {
		
		this.session = request.getSession();
		game.setVersione(game.getVersione()+1);
		gameService.saveGame(game);
		return true;
	}
	
	//@RequestMapping(value = "/deleteGiochi", method = RequestMethod.POST)
	//public boolean deleteGame(@RequestParam("idGame") int idGame, HttpServletRequest request) {	
	//	this.session = request.getSession();
	//////Game game1= gameService.findById(idGame);
	//	relUserGameService.deleteRelUserGame(idGame);
	//	gameService.deleteGame(idGame);
	//	return true;
	//}
	
	@RequestMapping(value = "/insertRelUserGiochi", method = RequestMethod.POST)
	public boolean insertRelUserGiochi(@RequestBody RelUserGame rug, HttpServletRequest request) {
		
		this.session = request.getSession();
		relUserGameService.saveRelUserGame(rug);
		
		return true;
	}
	
	@RequestMapping(value = "/giochiPerAttivoCreatore", method = RequestMethod.POST)
	public List<Game> gamePerAttivoCreatore(@RequestParam("id_creatore") int id_creatore , HttpServletRequest request) {
		
		this.session = request.getSession();
		List <Game> gameAttivi=gameService.findByAttivo(id_creatore);
		List <Game> gameNonAttivi=gameService.findByNonAttivo(id_creatore);
		return gameAttivi;
	}
	
	public HttpSession getSession() {
		return this.session;
	}
	
	
}

