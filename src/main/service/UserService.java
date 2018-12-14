package main.service;

import java.util.List;

import main.dao.UserDAO2;
import main.model.Gomma;
import main.model.UserOld;

public class UserService {
	
	private UserDAO2 userDAO;
	public UserService() {
		this.userDAO = new UserDAO2 ();
	}
	public List<UserOld> getAllUser () {
        return this.userDAO.getAllUser();
    }
}
