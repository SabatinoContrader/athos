package com.example.Athos.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Athos.services.EventoService;

@RestController
@RequestMapping("/Evento")
@CrossOrigin(value = "*")
public class EventoController {

	private EventoService eventoService;
	private HttpSession session;

	@Autowired
	public EventoController(EventoService eventoService) {
		this.eventoService = eventoService;
		
	}
	public HttpSession getSession() {
		return this.session;
	}
}
