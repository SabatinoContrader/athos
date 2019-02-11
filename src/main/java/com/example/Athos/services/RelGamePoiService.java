package com.example.Athos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.dao.RelGamePoiRepository;
import com.example.Athos.model.RelGamePoi;


@Service
public class RelGamePoiService {
	
	private RelGamePoiService relGamePoiService;
	private RelGamePoiRepository relGamePoiRepository;
	
	@Autowired 
	public RelGamePoiService(RelGamePoiRepository relGamePoiRepository) {
		this.relGamePoiRepository = relGamePoiRepository;
	}
	
	public RelGamePoi findById(int id) {
		RelGamePoi relGamePoi = relGamePoiRepository.findById(id);	
			return relGamePoi;	
	}
	
	public List<RelGamePoi> findAll() {
		List<RelGamePoi> relGamePoi = relGamePoiRepository.findAll();	
			return relGamePoi;	
	}

	public boolean save(RelGamePoi relGamePoi) {
		relGamePoiRepository.save(relGamePoi);	
		return true;
		
	}
}
