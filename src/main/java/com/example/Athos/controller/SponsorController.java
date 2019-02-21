package com.example.Athos.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Athos.model.Sponsor;
import com.example.Athos.services.SponsorService;

@RestController
@RequestMapping("/Sponsor")
@CrossOrigin(value = "*")
public class SponsorController {

	private SponsorService sponsorService;
	private HttpSession session;

	@Autowired
	public SponsorController(SponsorService sponsorService) {
		this.sponsorService = sponsorService;
	}
	public HttpSession getSession() {
		return this.session;
	}
	@RequestMapping(value = "/disattivaSponsor", method = RequestMethod.GET)
	public int disattivaSponsor(@RequestParam("idSponsor") int idSponsor, HttpServletRequest request) {
		return sponsorService.disattivaSponsor(idSponsor);
	}
	@RequestMapping(value = "/insertSponsor", method = RequestMethod.POST)
	public boolean saveSponsor(@RequestBody Sponsor sponsor , HttpServletRequest request) {
		sponsorService.saveSponsor(sponsor);
		return true;
	}
	@RequestMapping(value = "/tuttiSponsor", method = RequestMethod.GET)
	public List<Sponsor> tuttiSponsori( HttpServletRequest request) {
		this.session = request.getSession();
		List<Sponsor> poi = sponsorService.findAttivi();
		return poi;
	}
	
}
