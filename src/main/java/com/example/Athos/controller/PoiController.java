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
import com.example.Athos.model.Poi;
import com.example.Athos.services.PoiService;

@RestController
@RequestMapping("/Poi")
@CrossOrigin(value = "*")
public class PoiController {

	private PoiService poiService;
	private HttpSession session;

	@Autowired
	public PoiController(PoiService poiService) {
		this.poiService = poiService;	
	}
	public HttpSession getSession() {
		return this.session;
	}
	@RequestMapping(value = "/disattivaPoi", method = RequestMethod.GET)
	public int disattivaPoi(@RequestParam("idPoi") int idPoi, HttpServletRequest request) {
		return poiService.disattivaPoi(idPoi);
	}
	@RequestMapping(value = "/insertPoi", method = RequestMethod.POST)
	public boolean savePoi(@RequestBody Poi poi , HttpServletRequest request) {
		poiService.savePoi(poi);
		return true;
	}
	@RequestMapping(value = "/tuttiPoi", method = RequestMethod.GET)
	public List<Poi> tuttiPoi( HttpServletRequest request) {
		this.session = request.getSession();
		List<Poi> poi = poiService.findAttivi();
		return poi;
	}	
}
