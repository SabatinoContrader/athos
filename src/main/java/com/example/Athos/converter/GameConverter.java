package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.GameDTO;
import com.example.Athos.model.Game;

@Component
public class GameConverter implements Converter<Game , GameDTO>{
	
	@Override
	public  Game converToEntity(GameDTO gameDTO) {
		
		Game game=new Game();
		
		game.setId(gameDTO.getId());
		game.setNome(gameDTO.getNome());
		game.setDescr_percorso(gameDTO.getDescr_percorso());
		game.setVersione(gameDTO.getVersione());
		game.setId_creatore(gameDTO.getId_creatore());
		game.setAttivo(gameDTO.isAttivo());
		
		return game;
	}

	@Override
	public  GameDTO convertToDTO(Game game) {
		
		GameDTO gameDTO=new GameDTO();
		
		gameDTO.setId(game.getId());
		gameDTO.setNome(game.getNome());
		gameDTO.setDescr_percorso(game.getDescr_percorso());
		gameDTO.setVersione(game.getVersione());
		gameDTO.setId_creatore(game.getId_creatore());
		gameDTO.setAttivo(game.isAttivo());
			
		return gameDTO;
		
		}
}
