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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/relUserGame")
public class RelUserGameController {

	private RelUserGameService relUserGameService;
	//private GameDTO gameDTO;
	private HttpSession session;


	@Autowired
	public RelUserGameController( RelUserGameService relUserGameService) {
	
		this.relUserGameService = relUserGameService;
	}

	
	
	@RequestMapping(value = "/insertRelUserGiochi", method = RequestMethod.POST)
	public boolean insertRelUserGiochi(@RequestBody RelUserGame rug, HttpServletRequest request) {
		
		this.session = request.getSession();
		relUserGameService.saveRelUserGame(rug);
		
		return true;
	}
	
	
	@RequestMapping(value = "/chiGiocatoGioco", method = RequestMethod.POST)
	public List<RelUserGame> chiGiocatoGioco(@RequestParam("idGioco") int idGioco, HttpServletRequest request) {
		
		this.session = request.getSession();
		
		List<RelUserGame> poi=relUserGameService.chiGiocatoGioco(idGioco);
		return poi;
	}
	
	@RequestMapping(value = "/diverso", method = RequestMethod.POST)
	public List<RelUserGame> diverso(@RequestParam("idGioco") int idGioco, HttpServletRequest request) {
		
		this.session = request.getSession();
		
		List<RelUserGame> poi=relUserGameService.diverso(idGioco);
		return poi;
	}
	
	public HttpSession getSession() {
		return this.session;
	}
	
	
}

