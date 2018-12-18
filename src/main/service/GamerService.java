package main.service;

import java.util.ArrayList;

import main.dao.SuperDAO;
import main.model.User;

public class GamerService {

	private SuperDAO superDAO;

	public GamerService() {

		this.superDAO = new SuperDAO();

	}

	public ArrayList<User> viewAllUser() {
		return (ArrayList<User>) superDAO.getAllGamers();
	}
	
	public boolean removeGamer(int id) {
		return superDAO.deleteMaster(id);
	}
	
	public void updateGamerPassword(int id,String password) {
		superDAO.updateMasterPassword(id,password);
	}
	
	public void insertGamer(String username,String password) {
		superDAO.insertMaster(username,password);
	}
}
