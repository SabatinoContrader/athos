package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.RelUserGameDTO;
import com.example.Athos.dto.TeamDTO;
import com.example.Athos.model.RelUserGame;
import com.example.Athos.model.Team;

@Component
public class RelUserGameConverter implements Converter<RelUserGame , RelUserGameDTO>{
	@Override
	public  RelUserGame converToEntity(RelUserGameDTO relusergameDTO) {
		RelUserGame relusergame=new RelUserGame();
		relusergame.setId(relusergameDTO.getId());
		relusergame.setId_poi(relusergameDTO.getId_poi());
		relusergame.setId_user(relusergameDTO.getId_user());
		relusergame.setId_game(relusergameDTO.getId_game());
		
		return relusergame;
	}

	@Override
	public  RelUserGameDTO convertToDTO(RelUserGame relusergame) {
		RelUserGameDTO relusergameDTO=new RelUserGameDTO();
		relusergameDTO.setId(relusergame.getId());
		relusergameDTO.setId_game(relusergame.getId_game());
		relusergameDTO.setId_poi(relusergame.getId_poi());
		relusergameDTO.setId_user(relusergame.getId_user());
		
		return relusergameDTO;
		}
}
