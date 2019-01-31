package com.example.Athos.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
