package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.GameDTO;
import com.example.Athos.model.Game;

@Component
public class GameConverter implements Converter<Game , GameDTO> {
	
	@Override
	public  Game converToEntity(GameDTO gameDTO) {
		Game game=new Game();
		game.setId(gameDTO.getId());
		game.setIdcreatore(gameDTO.getId_creatore());
		game.setNome(gameDTO.getNome());
		game.setVersione(gameDTO.getVersione());
		game.setAttivo(gameDTO.isAttivo());
		return game;
	}

	@Override
	public  GameDTO convertToDTO(Game game) {
		GameDTO gameDTO=new GameDTO();
		gameDTO.setId(game.getId());
		gameDTO.setId_creatore(game.getIdcreatore());
		gameDTO.setNome(game.getNome());
		gameDTO.setVersione(game.getVersione());
		gameDTO.setAttivo(game.isAttivo());
		
		return gameDTO;
		}
}
