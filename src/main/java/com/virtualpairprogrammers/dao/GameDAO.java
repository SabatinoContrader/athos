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
import com.virtualpairprogrammers.model.Poi;

public class GameDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from game where idCreatore=? ";
	private final String QUERY_INSERT = " insert into game (idCreatore,nome, descrPercorso) values (?,?,?) ";
	private String QUERY_DELETE = " delete from game where id = ?";
    private  String QUERY_POI = "select * from poi where id in( select idPoi from rel_giochi_poi where idGiochi = ?)";
	private final String QUERY_INSERT_REL_GIOCHIPOI = " insert into rel_giochi_poi (idPoi,idGiochi, ordine) values (?,?,?) ";

	
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

	public List<Game> getAllGame(int idGamer) {
		List<Game> allGame = new ArrayList<Game>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			preparedStatement.setInt(1, idGamer);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Game newGame = new Game();

				newGame.setId(resultSet.getInt("id"));
				newGame.setIdCreatore(resultSet.getInt("idCreatore"));
				newGame.setNome(resultSet.getString("nome"));
				newGame.setDescrPercorso(resultSet.getString("descrPercorso"));
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
			preparedStatement.setInt(1, game.getIdCreatore());
			preparedStatement.setString(2, game.getNome());
			preparedStatement.setString(3, game.getDescrPercorso());
			
			if(preparedStatement.execute()) {
				Statement statement = connection.createStatement();
				ResultSet resultSet= statement.executeQuery("select max(id) from game");
				while (resultSet.next()) {
					game.setId(resultSet.getInt("id"));
				}
			}
			
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}
	
	public boolean insertRelGiochiPoi(int idGioco,String[] idPoi, String[] ordine) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			for(int i=0;i<idPoi.length;i++) {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_REL_GIOCHIPOI);
			preparedStatement.setInt(2, idGioco);
			preparedStatement.setString(1, idPoi[i]);
			preparedStatement.setString(3, ordine[i]);
			preparedStatement.execute();
			}	
			
			
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
	
	public List<Game> getGame(int id) {
		List<Game> game = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from game where id=" +id);
			while (resultSet.next()) {
				
				int idGame= resultSet.getInt("id");
				int idCreatore=resultSet.getInt("idCreatore");
				String nome= resultSet.getString("nome");
				String descrPercorso= resultSet.getString("descrPercorso");
				
				game.add(new Game(idGame, idCreatore, nome, descrPercorso));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dei giochi!!");
		}

		return game;

	}
	
	
	public List<Poi> getAllPoi(int idg) {
		List<Poi> allPoi = new ArrayList<Poi>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_POI);
			preparedStatement.setInt(1, idg);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Poi newPoi = new Poi();

				newPoi.setId(resultSet.getInt("id"));
				newPoi.setLatitudine(resultSet.getFloat("latitudine"));
				newPoi.setLongitudine(resultSet.getFloat("longitudine"));
				newPoi.setIndizio(resultSet.getString("indizio"));
				newPoi.setIdSponsor(resultSet.getInt("idSponsor"));
				allPoi.add(newPoi);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella restituzione dei poi del gioco!!");
		}

		return allPoi;

	}

}
