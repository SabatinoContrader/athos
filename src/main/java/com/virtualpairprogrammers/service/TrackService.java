package com.virtualpairprogrammers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.dao.TrackDAO;
import com.virtualpairprogrammers.model.Track;

public class TrackService {

	private TrackDAO trackDAO;

	public TrackService() {
		trackDAO = new TrackDAO();

	}

	public boolean deleteTrack(int id) {
		return this.trackDAO.deleteTrack(id);

	}

	public List<Track> getAllTrack() {
		return this.trackDAO.getAllTrack();

	}

	public boolean insertTrack(Track track) {
		return this.trackDAO.insertTrack(track);
	}

	public boolean updateTrack(HttpServletRequest request) {
		return this.trackDAO.updateTrack(request);
	}
	
	public List<Track> getTrack(long id) {
		return this.trackDAO.getTrack(id);

	}

}
