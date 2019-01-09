package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Game;

public class GameDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from game ";
	private final String QUERY_INSERT = " insert into game (name,gamer_id,location, help) values (?,?,?,?) ";
	private String QUERY_DELETE = " delete from game where id = ?";

	public GameDAO() {

	}

	public boolean deleteGame(int id) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setLong(1, id);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public List<Game> getAllGame() {
		List<Game> allGame = new ArrayList<Game>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Game newGame = new Game();

				newGame.setId(resultSet.getInt("id"));
				newGame.setName(resultSet.getString("name"));
				newGame.setGamerId(resultSet.getInt("gamer_id"));
				newGame.setLocation(resultSet.getString("location"));
				newGame.setHelp(resultSet.getString("help"));
				allGame.add(newGame);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca del gioco!!");
		}

		return allGame;

	}

	public boolean insertGame(Game game) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, game.getName());
			preparedStatement.setLong(2, game.getGamerId());
			preparedStatement.setString(3, game.getLocation());
			preparedStatement.setString(4, game.getHelp());
			preparedStatement.executeUpdate();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updateGame(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			String campo = (String) request.getParameter("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update game set " + campo + "=? where id =?");
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
	
	public List<Game> getGame(long id) {
		List<Game> game = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from game where id=" +id);
			while (resultSet.next()) {
				
				int idGame= resultSet.getInt("id");
				String nome= resultSet.getString("name");
				int gamerId=resultSet.getInt("gamer_id");
				String location= resultSet.getString("location");
				String help= resultSet.getString("help");
				
				game.add(new Game(idGame, nome, gamerId, location, help));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dei giochi!!");
		}

		return game;

	}

}
