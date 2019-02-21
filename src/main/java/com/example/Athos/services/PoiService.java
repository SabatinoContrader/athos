package com.example.Athos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.converter.PoiConverter;
import com.example.Athos.dao.PoiRepository;

import com.example.Athos.model.Poi;

@Service
public class PoiService {
	
	private PoiRepository poiRepository;
	private PoiConverter poiConverter;
	
	public PoiService() {}

	@Autowired 
	public PoiService(PoiRepository poiRepository,PoiConverter poiConverter) {

		this.poiRepository = poiRepository;
		this.poiConverter = poiConverter;
	}
	
	    public PoiRepository getPoiRepository() {
	    	return this.poiRepository;
	    }
	
		public Poi findById(int id) {
			Poi poi = poiRepository.findById(id);	
				return poi;	
		}
		
		public List<Poi> findAttivi() {
			List<Poi> poi = poiRepository.findAttivi();	
				return poi;	
		}

		public boolean savePoi(Poi poi) {
			poiRepository.save(poi);	
			return true;
			
		}
		
		public int disattivaPoi(int id) {
			return poiRepository.disattivaPoi(id);
		}
		
}
