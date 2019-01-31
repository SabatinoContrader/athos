package com.example.Athos.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.Athos.model.Evento;
import java.util.List;

public interface EventoRepository extends CrudRepository<Evento, Long> {
	
	Evento save(Evento evento);
	Evento findById(int id);
	List<Evento> findAll();
	//List<Evento> findByIdGame(int id_game);
	
}
