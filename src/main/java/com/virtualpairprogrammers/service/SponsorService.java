package com.virtualpairprogrammers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.dao.SponsorDAO;
import com.virtualpairprogrammers.model.Sponsor;

public class SponsorService {

	private SponsorDAO sponsorDAO;

	public SponsorService() {
		sponsorDAO = new SponsorDAO();
	}
	public List<Sponsor> getAllSponsor() {
		return this.sponsorDAO.getAllSponsor();
	}
	public boolean insertSponsor(Sponsor sponsor) {
		return this.sponsorDAO.insertSponsor(sponsor);
	}
	public boolean updateSponsor(HttpServletRequest request) {
		return this.sponsorDAO.updateSponsor(request);
	}
	public boolean deleteSponsor(int idSponsor) {
		return this.sponsorDAO.deleteSponsor(idSponsor);
	}
	public List<Sponsor> getSponsor(int id) {
		return this.sponsorDAO.getSponsor(id);
	}
	public String returnNome(int id) {
		return this.sponsorDAO.getNome(id);
	}
	
}
