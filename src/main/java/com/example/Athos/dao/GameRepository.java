package com.example.Athos.dao;

import com.example.Athos.model.Game;
import com.example.Athos.model.Poi;
import com.example.Athos.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.jca.cci.connection.*;

@Repository
@Transactional
public interface GameRepository extends CrudRepository<Game, Integer> {

	List<Game> findByIdcreatore(User user);
	
	@Modifying
	@Query(value="select * from game where nome=?", nativeQuery = true)
	List<Game> findByVersione(String nome);
	

	Game findById(int id);
	Game save(Game game);
	
	@Modifying
	@Query(value="select * from game where attivo=1 and id_creatore=?", nativeQuery = true)
	List<Game> findByAttivo(int idCreatore);
	
	@Modifying
	@Query(value="select * from game where attivo=0 and id_creatore=?", nativeQuery = true)
	List<Game> findByNonAttivo(int idCreatore);
	
	@Modifying
	@Query(value="update game set attivo=0 where id=?", nativeQuery = true)
	int disattivaGame(int id);
	
	
}
