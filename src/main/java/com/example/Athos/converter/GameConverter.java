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
		game.setDescrpercorso(gameDTO.getDescr_percorso());
		game.setVersione(gameDTO.getVersione());
		game.setAttivo(gameDTO.isAttivo());
		game.setDescr_evento(gameDTO.getDescr_evento());
		game.setData_inizio(gameDTO.getData_inizio());
		game.setData_fine(gameDTO.getData_fine());
		return game;
	}

	@Override
	public  GameDTO convertToDTO(Game game) {
		GameDTO gameDTO=new GameDTO();
		gameDTO.setId(game.getId());
		gameDTO.setId_creatore(game.getIdcreatore());
		gameDTO.setNome(game.getNome());
		gameDTO.setDescr_percorso(game.getDescrpercorso());
		gameDTO.setVersione(game.getVersione());
		gameDTO.setAttivo(game.isAttivo());
		gameDTO.setDescr_evento(game.getDescr_evento());
		gameDTO.setData_inizio(game.getData_inizio());
		gameDTO.setData_fine(game.getData_fine());
		
		return gameDTO;
		}
}
