package com.example.Athos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.dao.RelTeamGameRepository;
import com.example.Athos.model.RelTeamGame;

@Service
public class RelTeamGameService {
	
	private RelTeamGameRepository relTeamGameRepository;
	
	@Autowired 
	public RelTeamGameService(RelTeamGameRepository relTeamGameRepository) {
		this.relTeamGameRepository = relTeamGameRepository;
	}
	
	public boolean saveRelTeamGame(RelTeamGame relTeamGame) {
		relTeamGameRepository.save(relTeamGame);
		
		return true;
		
	}
	
	//public int deleteRelTeamGame(int id_game) {
	//	return relTeamGameRepository.deleteById_game(id_game);
		
	//}
	public RelTeamGame findById(int id) {
		RelTeamGame relTeamGame = relTeamGameRepository.findById(id);	
			return relTeamGame;	
	}
	
	public List<RelTeamGame> findAll() {
		List<RelTeamGame> relTeamGame = relTeamGameRepository.findAll();	
			return relTeamGame;	
	}


}
