package com.example.Athos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Athos.model.Evento;
import java.util.List;

import javax.transaction.Transactional;
@Repository
@Transactional
public interface EventoRepository extends CrudRepository<Evento, Long> {
	
	Evento save(Evento evento);
	Evento findById(int id);
	List<Evento> findAll();
	//List<Evento> findByIdGame(int id_game);
	
}
