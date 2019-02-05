package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.PoiDTO;
import com.example.Athos.model.Poi;

@Component
public class PoiConverter implements Converter<Poi , PoiDTO>{
	
	@Override
	public  Poi converToEntity(PoiDTO poiDTO) {
		
		Poi poi=new Poi();
		
		poi.setId(poiDTO.getId());
		poi.setIndizio(poiDTO.getIndizio());
		poi.setLatitudine(poiDTO.getLatitudine());
		poi.setLongitudine(poiDTO.getLongitudine());
		
		return poi;
	}

	@Override
	public  PoiDTO convertToDTO(Poi poi) {
		
		PoiDTO poiDTO=new PoiDTO();
		
		poiDTO.setId(poi.getId());
		poiDTO.setIndizio(poi.getIndizio());
		poiDTO.setLatitudine(poi.getLatitudine());
		poiDTO.setLongitudine(poi.getLongitudine());
		
		return poiDTO;
		}
}
