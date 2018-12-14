package main.service;

import main.dao.LoginDAO;

public class LoginService2 {

    private LoginDAO loginDAO;

    public LoginService2() {
        this.loginDAO = new LoginDAO();
    }

    public boolean login (String username, String password) {
        return this.loginDAO.login(username, password);
    }
}
