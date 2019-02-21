package com.example.Athos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.converter.GameConverter;
import com.example.Athos.converter.UserConverter;
import com.example.Athos.dao.GameRepository;
import com.example.Athos.dto.GameDTO;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.model.Game;
import com.example.Athos.model.RelUserGame;
import com.example.Athos.model.User;

@Service
public class GameService {

	private GameRepository gameRepository;
	private UserConverter userConverter;
	private GameConverter gameConverter;
	
	@Autowired 
	public GameService(GameRepository gameRepository, UserConverter userConverter, GameConverter gameConverter) {
		this.gameRepository = gameRepository;
		this.userConverter = userConverter;
		this.gameConverter = gameConverter;
	}
	
	
	public List<GameDTO> findByCreatore(UserDTO userDTO) {
		
		User user=userConverter.converToEntity(userDTO);
		List<Game> game =  gameRepository.findByIdcreatore(user);
		List<GameDTO> gameDTO= new ArrayList<>();	
		game.forEach(i->gameDTO.add(gameConverter.convertToDTO(i)));	
		return gameDTO;
		
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
	
	public List<Game> findAttivi() {
		return gameRepository.findAttivi();	
	}
	
}
