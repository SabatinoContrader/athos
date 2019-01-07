package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.model.User;

public class LoginService {

	private UserDAO userdao;

	public LoginService() {
		this.userdao = new UserDAO();
	}

	public boolean login(String username, String password) {
		return this.userdao.getUserByUsernameAndPassword(username, password);
	}

	public User ruolo(String username, String password) {
		return this.userdao.ruolo(username, password);

	}

	public int testaruolo(String username, String password) {
		return this.userdao.testaruolo(username, password);
	}
}