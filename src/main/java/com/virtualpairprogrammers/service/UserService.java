package com.virtualpairprogrammers.service;



import com.virtualpairprogrammers.dao.UserDAO;
import com.virtualpairprogrammers.model.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class UserService {

    private UserDAO userDAO;
    //private UserAssetDAO userAssetDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers () {
        return this.userDAO.getAllUsers();
    }
    
    public User getUser (int id) {
        return this.userDAO.getUser(id);
    }
    

    public boolean insertUser (User user) {
        return this.userDAO.insertUser(user);
    }
    
    public boolean deleteUser(int idUser) {
    	return this.userDAO.deleteUser(idUser);
    }
    
    
    public boolean updateUser(HttpServletRequest request) {
    	return this.userDAO.updateUser(request);
    }
}


