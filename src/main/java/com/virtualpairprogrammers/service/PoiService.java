package com.virtualpairprogrammers.service;

import java.util.List;
import com.virtualpairprogrammers.dao.PoiDAO;
import javax.servlet.http.HttpServletRequest;
import com.virtualpairprogrammers.model.Poi;

public class PoiService {

	private  PoiDAO poiDAO;

	public PoiService() {
		poiDAO = new PoiDAO();
	}

	public List<Poi> getAllPoi() {
		return this.poiDAO.getAllPoi();
	}

	public boolean insertPoi(Poi poi) {
		return this.poiDAO.insertPoi(poi);
	}

	public boolean updatePoi(HttpServletRequest request) {
		return this.poiDAO.updatePoi(request);
	}

	public boolean deletePoi(int id) {
		return this.poiDAO.deletePoi(id);

	}
	
	public List<Poi> getPoi(int id) {
		return this.poiDAO.getPoi(id);
	}

}
