package main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.model.UserType;

public class UserTypeDAO {
	private final String QUERY_ALL = "select * from user_types";
    
	public List<UserType> getAllUserType () {
        List<UserType> user_types = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               Integer userTypeId = resultSet.getInt("user_type_id");
               String typeUser = resultSet.getString("user_type");
               
               user_types.add(new UserType(userTypeId, typeUser));
           }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return user_types;
    }

}
