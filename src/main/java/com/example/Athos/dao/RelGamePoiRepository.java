package com.example.Athos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.Athos.model.RelGamePoi;
@Repository
@Transactional
public interface RelGamePoiRepository extends CrudRepository<RelGamePoi, Long>{
	
	RelGamePoi save(RelGamePoi relgamepoi);
	List<RelGamePoi> findAll();
	//List<RelGamePoi> findByIdPoi(int id_poi);
	//List<RelGamePoi> findByIdGame(int id_game);
	RelGamePoi findById(int id);
	
	
}
