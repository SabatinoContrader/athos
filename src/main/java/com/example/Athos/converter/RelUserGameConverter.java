package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.RelUserGameDTO;
import com.example.Athos.model.RelUserGame;

@Component
public class RelUserGameConverter implements Converter<RelUserGame , RelUserGameDTO> {
	
	@Override
	public  RelUserGame converToEntity(RelUserGameDTO relUserGameDTO) {
		
		RelUserGame relUserGame=new RelUserGame();
		relUserGame.setId(relUserGameDTO.getId());
		relUserGame.setId_user(relUserGameDTO.getId_user());
		relUserGame.setId_game(relUserGameDTO.getId_game());
		relUserGame.setId_poi(relUserGameDTO.getId_poi());
		relUserGame.setData_fine(relUserGameDTO.getData_fine());
		relUserGame.setData_inizio(relUserGameDTO.getData_inizio());
		relUserGame.setId_team(relUserGameDTO.getId_team());
		relUserGame.setAttivo(relUserGameDTO.isAttivo());
		
		return relUserGame;
	}
	@Override
	public  RelUserGameDTO convertToDTO(RelUserGame relUserGame) {
		RelUserGameDTO relUserGameDTO=new RelUserGameDTO();
		relUserGameDTO.setId(relUserGame.getId());
		relUserGameDTO.setId_user(relUserGame.getId_user());
		relUserGameDTO.setId_game(relUserGame.getId_game());
		relUserGameDTO.setId_poi(relUserGame.getId_poi());
		relUserGameDTO.setData_fine(relUserGame.getData_fine());
		relUserGameDTO.setData_inizio(relUserGame.getData_inizio());
		relUserGameDTO.setId_team(relUserGame.getId_team());
		relUserGameDTO.setAttivo(relUserGame.isAttivo());
		
		return relUserGameDTO;
		}
}
