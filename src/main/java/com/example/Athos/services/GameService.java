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
		List<Game> game = gameRepository.findByIdcreatore(user);
		
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
	
	public List<Game> findByAttivo(int idCreatore) {
		List<Game> game = gameRepository.findByAttivo(idCreatore);
		
			return game;
		
	}
	
	public List<Game> findByNonAttivo(int idCreatore) {
		List<Game> game = gameRepository.findByNonAttivo(idCreatore);
		
			return game;
		
	}

	public boolean saveGame(Game game) {
		gameRepository.save(game);
		
		return true;
		
	}
	
	public int disattivaGame(int id) {

		return gameRepository.disattivaGame(id);
		
	}
	
}
