package main.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.model.UserOld;

public class UserDAO2 {

	private final String QUERY_ALL = "select * from user";

	public UserDAO2() {
	}

	public List<UserOld> getAllUser() {
		List<UserOld> user = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				Integer userTypeFK = resultSet.getInt("user_type_fk");
				user.add(new UserOld(username, password, userTypeFK));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}
