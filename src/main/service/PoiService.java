package main.service;

import java.util.List;

import main.controller.Request;
import main.dao.PoiDAO;
import main.model.Poi;

public class PoiService {

	private  PoiDAO poiDAO = new PoiDAO();

	public PoiService() {
		

	}

	public List<Poi> getAllPoi() {
		return this.poiDAO.getAllPoi();

	}

	public boolean insertPoi(Poi poi) {
		return this.poiDAO.insertPoi(poi);
	}

	public boolean updatePoi(Request request) {
		return poiDAO.updatePoi(request);
	}

	public boolean deletePoi(int id) {
		return this.poiDAO.deletePoi(id);

	}

}
