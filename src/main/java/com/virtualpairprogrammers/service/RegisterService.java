package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.RegisterDAO;
import com.virtualpairprogrammers.model.User;

public class RegisterService {
	
	private RegisterDAO registerDAO;

    public RegisterService() {
        this.registerDAO = new RegisterDAO();
    }

    public boolean register (User utente) {
        return this.registerDAO.register(utente);
    }

}
