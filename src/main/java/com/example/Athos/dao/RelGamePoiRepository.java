package com.example.Athos.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.Athos.model.RelGamePoi;

public interface RelGamePoiRepository extends CrudRepository<RelGamePoi, Long>{
	
	RelGamePoi save(RelGamePoi relgamepoi);
	List<RelGamePoi> findAll();
	//List<RelGamePoi> findByIdPoi(int id_poi);
	//List<RelGamePoi> findByIdGame(int id_game);
	RelGamePoi findById(int id);
	
	
}
