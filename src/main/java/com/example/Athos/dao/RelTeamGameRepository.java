package com.example.Athos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.Athos.model.RelTeamGame;
@Repository
@Transactional
public interface RelTeamGameRepository extends CrudRepository<RelTeamGame, Long>{
	
	RelTeamGame save(RelTeamGame relteamgame);
	List<RelTeamGame> findAll();
	//List<RelTeamGame> findByIdTeam(int id_team);
	//List<RelTeamGame> findByIdGame(int id_game);
	RelTeamGame findById(int id);
	

}
