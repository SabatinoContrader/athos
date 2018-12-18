package main.service;

import java.util.List;

import main.controller.Request;
import main.dao.SponsorDAO;
import main.model.Sponsor;

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

	public boolean updateSponsor(Request request) {
		return this.sponsorDAO.updateSponsor(request);
	}

}
