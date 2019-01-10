package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.model.User;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import javax.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	private final String QUERY_LOGIN = "select * from user where username = ? and password = ?";
	private final String QUERY_ALL_GAMER = " select * from user where role=1 ";
	private final String QUERY_INSERT_GAMER = " insert into user (username,password,role) values (?,?,1) ";
	private String QUERY_DELETE_GAMER = " delete from user where id = ?";
	
	public UserDAO() {
	}

	public User ruolo(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		ResultSet resultSet = null;
		try {

			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();

			User utente = null;

			if (resultSet.next()) {
				utente = new User(resultSet.getInt("id"), resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getInt("role"));

			}

			return utente;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	
	public boolean deleteGamer(int id) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_GAMER);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public List<User> getAllGamer() {
		List<User> allGamer = new ArrayList<User>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_GAMER);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				User newGamer = new User();

				newGamer.setId(resultSet.getInt("id"));
				newGamer.setUsername(resultSet.getString("username"));
				newGamer.setPassword(resultSet.getString("password"));
				newGamer.setRole(resultSet.getInt("role"));
				allGamer.add(newGamer);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca del Gamer!!");
		}

		return allGamer;

	}

	public boolean insertGamer(User gamer) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_GAMER);
			preparedStatement.setString(1, gamer.getUsername());
			preparedStatement.setString(2, gamer.getPassword());
			preparedStatement.executeUpdate();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updateGamer(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			String campo = (String) request.getParameter("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user set " + campo + "=? where id =?");
			preparedStatement.setString(1, (String) request.getParameter("newCampo"));
			preparedStatement.setInt(2, Integer.parseInt(request.getParameter("id")));
			preparedStatement.execute();
			return true;

		}

		catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
	
	public List<User> getGamer(int id) {
		List<User> gamer = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user where id=" +id); 
			while (resultSet.next()) {
				
				int idGamer= resultSet.getInt("id");
				String username=resultSet.getString("username");
				String password= resultSet.getString("password");
				int ruolo=resultSet.getInt("role");
				
				gamer.add(new User(idGamer, username, password, ruolo));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dei gamer!!");
		}

		return gamer;

	}
	
}