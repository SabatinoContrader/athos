package com.example.Athos.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Athos.services.PoiService;

@RestController
@RequestMapping("/Poi")
@CrossOrigin(value = "*")
public class PoiController {

	private PoiService poiService;
	private HttpSession session;


	@Autowired
	public PoiController(PoiService poiService) {
		this.poiService = poiService;
		
	}
	public HttpSession getSession() {
		return this.session;
	}
}
