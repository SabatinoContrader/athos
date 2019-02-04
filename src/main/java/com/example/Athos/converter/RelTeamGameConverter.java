package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.RelTeamGameDTO;
import com.example.Athos.model.RelTeamGame;

@Component
public class RelTeamGameConverter implements Converter<RelTeamGame , RelTeamGameDTO> {
	@Override
	public  RelTeamGame converToEntity(RelTeamGameDTO relteamgameDTO) {
		RelTeamGame relteamgame=new RelTeamGame();
		relteamgame.setId(relteamgameDTO.getId());
		relteamgame.setId_poi(relteamgameDTO.getId_poi());
		relteamgame.setId_game(relteamgameDTO.getId_game());
		relteamgame.setId_team(relteamgameDTO.getId_team());
		
		return relteamgame;
	}

	@Override
	public  RelTeamGameDTO convertToDTO(RelTeamGame relteamgame) {
		RelTeamGameDTO relteamgameDTO=new RelTeamGameDTO();
		relteamgameDTO.setId(relteamgame.getId());
		relteamgameDTO.setId_game(relteamgame.getId_game());
		relteamgameDTO.setId_poi(relteamgame.getId_poi());
		relteamgameDTO.setId_team(relteamgame.getId_team());
		
		return relteamgameDTO;
		}
}
