package main.service;


import main.dao.UserDAO;
import main.model.User;

public class LoginService {
	
	private UserDAO userdao;
	
	public LoginService() {
		this.userdao=new UserDAO();
	}
	
	//public User login(String username,String password)  {
//		return this.userdao.getUserByUsernameAndPassword(username,password);
//	}
	
	public boolean login(String username,String password)  {
		return this.userdao.getUserByUsernameAndPassword(username,password);
	}
}