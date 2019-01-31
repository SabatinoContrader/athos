package com.example.Athos.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.Athos.model.RelTeamGame;

public interface RelTeamGameRepository extends CrudRepository<RelTeamGame, Long>{
	
	RelTeamGame save(RelTeamGame relteamgame);
	List<RelTeamGame> findAll();
	//List<RelTeamGame> findByIdTeam(int id_team);
	//List<RelTeamGame> findByIdGame(int id_game);
	RelTeamGame findById(int id);
	

}
