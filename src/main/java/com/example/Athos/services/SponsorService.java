package com.example.Athos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.converter.SponsorConverter;
import com.example.Athos.dao.SponsorRepository;
import com.example.Athos.model.Sponsor;

@Service
public class SponsorService {
	
	private SponsorRepository sponsorRepository;
	private SponsorConverter sponsorConverter;
	
	public SponsorService() {}

	@Autowired 
	public SponsorService(SponsorRepository sponsorRepository,SponsorConverter sponsorConverter) {

		this.sponsorRepository = sponsorRepository;
		this.sponsorConverter = sponsorConverter;
	}
	
	    public SponsorRepository getSponsorRepository() {
	    	return this.sponsorRepository;
	    }
		public Sponsor findById(int id) {
			Sponsor sponsor = sponsorRepository.findById(id);	
				return sponsor;	
		}
		
		public List<Sponsor> findAll() {
			List<Sponsor> sponsor = sponsorRepository.findAll();	
				return sponsor;	
		}

		public boolean save(Sponsor sponsor) {
			sponsorRepository.save(sponsor);	
			return true;
			
		}
		
}
