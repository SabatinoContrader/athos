package com.virtualpairprogrammers.service;

import java.util.List;

import com.virtualpairprogrammers.servlets.Request;
import com.virtualpairprogrammers.dao.SponsorDAO;
import com.virtualpairprogrammers.model.Sponsor;
import javax.servlet.http.HttpServletRequest;

public class SponsorService {

	private SponsorDAO sponsorDAO;

	public SponsorService() {
		sponsorDAO = new SponsorDAO();

	}

	public boolean deleteSponsor(int idSponsor) {
		return this.sponsorDAO.deleteSponsor(idSponsor);

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

	public List<Sponsor> getSponsor(int id) {
		return this.sponsorDAO.getSponsor(id);

	}
}
