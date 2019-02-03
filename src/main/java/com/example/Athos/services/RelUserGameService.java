package com.example.Athos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.dao.RelUserGameRepository;
import com.example.Athos.model.RelUserGame;

@Service
public class RelUserGameService {

	private RelUserGameRepository relUserGameRepository;

	@Autowired 
	public RelUserGameService(RelUserGameRepository relUserGameRepository) {
		this.relUserGameRepository = relUserGameRepository;
	}
	
	public boolean saveRelUserGame(RelUserGame relUserGame) {
		relUserGameRepository.save(relUserGame);
		
		return true;
		
	}
	
	public int deleteRelUserGame(int id_game) {
		return relUserGameRepository.deleteById_game(id_game);
		
	}
	public RelUserGame findById(int id) {
		RelUserGame relUserGame = relUserGameRepository.findById(id);	
			return relUserGame;	
	}
	
	public List<RelUserGame> findAll() {
		List<RelUserGame> relUserGame = relUserGameRepository.findAll();	
			return relUserGame;	
	}


}
