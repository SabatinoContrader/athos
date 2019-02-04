package com.example.Athos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.dao.EventoRepository;
import com.example.Athos.model.Evento;

@Service
public class EventoService {

	private EventoRepository eventoRepository;
	
	@Autowired 
	public EventoService(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}
	
	public Evento findById(int id) {
		Evento evento = eventoRepository.findById(id);	
			return evento;	
	}
	
	public List<Evento> findAll() {
		List<Evento> evento = eventoRepository.findAll();	
			return evento;	
	}

	public boolean save(Evento evento) {
		eventoRepository.save(evento);	
		return true;
		
	}
}
