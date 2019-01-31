package com.example.Athos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.converter.PoiConverter;
import com.example.Athos.dao.PoiRepository;

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
	

}
