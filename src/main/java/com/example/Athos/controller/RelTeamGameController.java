package com.example.Athos.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Athos.services.RelTeamGameService;

@RestController
@RequestMapping("/RelTeamGame")
@CrossOrigin(value = "*")
public class RelTeamGameController {

	private RelTeamGameService relteamgameService;
	private HttpSession session;

	@Autowired
	public RelTeamGameController(RelTeamGameService relteamgameService) {
		this.relteamgameService = relteamgameService;
		
	}
	public HttpSession getSession() {
		return this.session;
	}
}

