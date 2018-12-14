package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.User;
import main.model.UserOld;

public class UserDAO {

	 private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";

	public UserDAO() {
	}
	  public boolean getUserByUsernameAndPassword (String username, String password) {

	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
	            statement.setString(1, username);
	            statement.setString(2, password);
	            return statement.executeQuery().next();
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }
	    }
}