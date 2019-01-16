package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

public class RegisterDAO {

    private final String QUERY_REGISTER = "INSERT INTO `athos_db`.`user` ( `username`, `password`, role) VALUES (?, ?, ?)";

    public boolean register (User utente) {
        Connection connection = ConnectionSingleton.getInstance();
        boolean b=false;
        try {
        	PreparedStatement statement = connection.prepareStatement(QUERY_REGISTER);
        	
        	statement.setString(1, utente.getUsername());
            statement.setString(2, utente.getPassword());
            statement.setInt(3, utente.getRole());
             
            if(statement.executeUpdate()>0) {
            	b=true;
            }
            return b;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return b;
        }
		
    }
}


