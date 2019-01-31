package com.example.Athos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.dao.GameRepository;
import com.example.Athos.model.Game;
import com.example.Athos.model.User;

@Service
public class GameService {

	private GameRepository gameRepository;
	
	@Autowired 
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public List<Game> findByCreatore(User user) {
		List<Game> game = gameRepository.findByCreatore(user);
		
			return game;
		
	}
	
	public Game findById(int id) {
		Game game = gameRepository.findById(id);
		
			return game;
		
	}
	
	public List<Game> findByVersione(String nome) {
		List<Game> game = gameRepository.findByVersione(nome);
		
			return game;
		
	}
	
	public List<Game> findByAttivo(int id_creatore) {
		List<Game> game = gameRepository.findByAttivo(id_creatore);
		
			return game;
		
	}
	
	public List<Game> findByNonAttivo(int id_creatore) {
		List<Game> game = gameRepository.findByNonAttivo(id_creatore);
		
			return game;
		
	}

	public boolean saveGame(Game game) {
		gameRepository.save(game);
		
		return true;
		
	}
	
	//public boolean deleteGame(int id) {
	//	gameRepository.delete(id);		
	//	return true;
	//}
	
}
