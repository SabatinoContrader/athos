package com.virtualpairprogrammers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.dao.GameDAO;
import com.virtualpairprogrammers.model.Game;
import com.virtualpairprogrammers.model.Poi;

public class GameService {

	private GameDAO gameDAO;

	public GameService() {
		gameDAO = new GameDAO();

	}

	public boolean deleteGame(int id) {
		return this.gameDAO.deleteGame(id);

	}

	public List<Game> getAllGame(int idGamer) {
		return this.gameDAO.getAllGame(idGamer);

	}

	public List<Poi> getAllPoi(int idg) {
		return this.gameDAO.getAllPoi(idg);

	}
	
	public boolean insertGame(Game game) {
		return this.gameDAO.insertGame(game);
	}

	public boolean updateGame(HttpServletRequest request) {
		return this.gameDAO.updateGame(request);
	}
	
	public List<Game> getGame(int id) {
		return this.gameDAO.getGame(id);

	}

}
