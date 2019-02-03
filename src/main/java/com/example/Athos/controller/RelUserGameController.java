package com.example.Athos.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Athos.services.RelUserGameService;

@RestController
@RequestMapping("/RelUserGame")
@CrossOrigin(value = "*")
public class RelUserGameController {

	private RelUserGameService relusergameService;
	private HttpSession session;

	@Autowired
	public RelUserGameController(RelUserGameService relusergameService) {
		this.relusergameService = relusergameService;
		
	}
	public HttpSession getSession() {
		return this.session;
	}
	
}

	