package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private final String QUERY_LOGIN = "select * from utente where username = ? and password = ?";
    private final String QUERY_LOGIN_RUOLO = "select * from utente where username = ? and password = ? and ruolo = ?";

    public boolean login (String username, String password) {

    	boolean ritorno= false;
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
            statement.setString(1, username);
            statement.setString(2, password);
           ResultSet risultato=statement.executeQuery();
           // return true;
            while(risultato.next()) {
            	ritorno=true;
            }
            
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    	
        return ritorno;
    }
    
}
