package com.example.Athos.dao;

import com.example.Athos.model.RelUserGame;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Repository
@Transactional
public interface RelUserGameRepository extends CrudRepository<RelUserGame, Long> {

	/*@Modifying
	@Query(value="delete from rel_user_giochi where id_game=?", nativeQuery = true)
	int deleteById_game(int id_game);*/
	
	
	@Query(value="select * from rel_user_giochi where id_game=?", nativeQuery = true)
	List<RelUserGame> chiGiocatoGioco(int id_game);

	
	@Query(value="select * from rel_user_giochi where id_game=?", nativeQuery = true)
	List<RelUserGame>findById_game(int id);
	
	RelUserGame save(RelUserGame relusergame);
	List<RelUserGame> findAll();
	//List<RelUserGame> findByIdTeam(int id_team);
	//List<RelUserGame> findByIdGame(int id_game);
	RelUserGame findById(int id);
	
}
