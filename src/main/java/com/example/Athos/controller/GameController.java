package com.example.Athos.controller;

import com.example.Athos.dto.GameDTO;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.model.Game;
import com.example.Athos.model.RelUserGame;
import com.example.Athos.model.User;
import com.example.Athos.services.GameService;
import com.example.Athos.services.RelUserGameService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/Game")
public class GameController {

	private GameService gameService;
	private RelUserGameService relUserGameService;
	private HttpSession session;

	@Autowired
	public GameController(GameService gameService, RelUserGameService relUserGameService) {
		this.gameService = gameService;
		this.relUserGameService = relUserGameService;
	}

	
	

	@RequestMapping(value = "/giochiPerCreatore", method = RequestMethod.POST)
	public List <GameDTO> gameCreatore(HttpServletRequest request, Model model, @RequestBody UserDTO userDTO) {
		
		List <GameDTO> gameDTO=gameService.findByCreatore(userDTO);
		model.addAttribute("game", gameDTO);
		return gameDTO;
	}
	
	@RequestMapping(value = "/giochiPerVersione", method = RequestMethod.POST)
	public List<Game> gameVersione(@RequestParam("nome") String nome , HttpServletRequest request) {
		
		//this.session = request.getSession(true);
		List <Game> game=gameService.findByVersione(nome);
		return game;
	}

	@RequestMapping(value = "/insertGiochi", method = RequestMethod.POST)
	public boolean saveGame(@RequestBody Game game , HttpServletRequest request) {
		
		//this.session = request.getSession();
		gameService.saveGame(game);
		return true;
	}
	
	@RequestMapping(value = "/insertNewVersione", method = RequestMethod.POST)
	public boolean saveNewVersione(@RequestBody Game game , HttpServletRequest request) {
		
		//this.session = request.getSession();
		game.setVersione(game.getVersione()+1);
		gameService.saveGame(game);
		return true;
	}
	
	@RequestMapping(value = "/disattivaGiochi", method = RequestMethod.POST)
	public int disattivaGame(@RequestParam("idGame") int idGame, HttpServletRequest request) {
		
		//this.session = request.getSession();
		return gameService.disattivaGame(idGame);
	}
	
	
	@RequestMapping(value = "/giochiPerAttivoCreatore", method = RequestMethod.GET)
	public List<List<Game>> gamePerAttivoCreatore(@RequestParam("idCreatore") int idCreatore , HttpServletRequest request) {
		
		//this.session = request.getSession();
		List <Game> gameAttivi=gameService.findByAttivo(idCreatore);
		List <Game> gameNonAttivi=gameService.findByNonAttivo(idCreatore);
		List <List<Game>> games=new ArrayList<List<Game>>();
		games.add(gameAttivi);
		games.add(gameNonAttivi);
		return games;
	}
	
	
	@RequestMapping(value = "/giochiPerId", method = RequestMethod.POST)
	public Set<RelUserGame> gameID(@RequestParam("id") int id , HttpServletRequest request) {
		
		//this.session = request.getSession();
		Game game=gameService.findById(id);
		//game.getRelUserGame()
		return null;
	}
	
	
	
	
}

