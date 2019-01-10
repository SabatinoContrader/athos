package com.virtualpairprogrammers.service;

import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.model.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllGamer () {
        return this.userDAO.getAllGamer();
    }
    
    public List<User> getGamer (int id) {
        return this.userDAO.getGamer(id);
    }
    

   public boolean insertGamer (User gamer) {
       return this.userDAO.insertGamer(gamer);
    }
   
    public boolean deleteGamer(int idUser) {
    	return this.userDAO.deleteGamer(idUser);
    }
    
    public boolean updateGamer(HttpServletRequest request) {
    	return this.userDAO.updateGamer(request);
    }
}


