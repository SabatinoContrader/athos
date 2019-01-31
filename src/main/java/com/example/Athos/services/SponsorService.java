package com.example.Athos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.converter.SponsorConverter;
import com.example.Athos.dao.SponsorRepository;

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
	

}
