package com.example.Athos.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Athos.services.RelGamePoiService;

@RestController
@RequestMapping("/RelGamePoi")
@CrossOrigin(value = "*")
public class RelGamePoiController {

	private RelGamePoiService relgamepoiService;
	private HttpSession session;

	@Autowired
	public RelGamePoiController(RelGamePoiService relgamepoiService) {
		this.relgamepoiService = relgamepoiService;
		
	}
	public HttpSession getSession() {
		return this.session;
	}
}
