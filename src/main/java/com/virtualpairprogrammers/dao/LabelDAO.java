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
import com.virtualpairprogrammers.model.Label;

public class LabelDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from label ";
	private final String QUERY_INSERT = " insert into label (orders,description,idGame) values (?,?,?) ";
	private String QUERY_DELETE = " delete from label where id = ?";

	public LabelDAO() {

	}

	public boolean deleteLabel(int id) {
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

	public List<Label> getAllLabel() {
		List<Label> allLabel = new ArrayList<Label>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Label newLabel = new Label();

				newLabel.setId(resultSet.getLong("id"));
				newLabel.setOrders(resultSet.getLong("orders"));
				newLabel.setDescription(resultSet.getString("description"));
				newLabel.setIdGame(resultSet.getLong("idGame"));
				allLabel.add(newLabel);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dell' indovinello!!");
		}

		return allLabel;

	}

	public boolean insertLabel(Label label) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setLong(1, label.getOrders());
			preparedStatement.setString(2, label.getDescription());
			preparedStatement.setLong(3, label.getIdGame());
			preparedStatement.executeUpdate();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updateLabel(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			String campo = (String) request.getParameter("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update label set " + campo + "=? where id =?");
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
	
	public List<Label> getLabel(long id) {
		List<Label> label = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from label where id=" +id);
			while (resultSet.next()) {
				
				int idLabel= resultSet.getInt("id");
				int order=resultSet.getInt("orders");
				String descrizione= resultSet.getString("description");
				int idGame=resultSet.getInt("idGame");
				
				label.add(new Label(idLabel, order, descrizione, idGame));

			}

		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println("Errore nella ricerca degli indovinelli!!");
		}

		return label;

	}

}
