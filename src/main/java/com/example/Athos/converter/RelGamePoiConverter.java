package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.RelGamePoiDTO;
import com.example.Athos.model.RelGamePoi;

@Component
public class RelGamePoiConverter implements Converter<RelGamePoi , RelGamePoiDTO>{
	
	@Override
	public RelGamePoi converToEntity(RelGamePoiDTO relgamepoiDTO) {
		RelGamePoi relgamepoi=new RelGamePoi();
		relgamepoi.setId(relgamepoiDTO.getId());
		relgamepoi.setId_game(relgamepoi.getId_game());
		relgamepoi.setId_poi(relgamepoi.getId_poi());
		relgamepoi.setOrdine(relgamepoi.getOrdine());
		return relgamepoi;
	}

	@Override
	public  RelGamePoiDTO convertToDTO(RelGamePoi relgamepoi) {
		RelGamePoiDTO relgamepoiDTO=new RelGamePoiDTO();
		relgamepoiDTO.setId(relgamepoi.getId());
		relgamepoiDTO.setId_game(relgamepoi.getId_game());
		relgamepoiDTO.setId_poi(relgamepoi.getId_poi());
		relgamepoiDTO.setOrdine(relgamepoi.getOrdine());
		
		return relgamepoiDTO;
		}
}
