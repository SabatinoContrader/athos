package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.controller.Request;
import main.model.Label;

public class LabelDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from label ";
	private final String QUERY_INSERT = " insert into label (name,description, idGame) values (?,?,?) ";
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

				newLabel.setId(resultSet.getInt("id"));
				newLabel.setName(resultSet.getString("name"));
				newLabel.setDescription(resultSet.getString("description"));
				newLabel.setIdGame(resultSet.getInt("idGame"));
				allLabel.add(newLabel);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dello sponsor!!");
		}

		return allLabel;

	}

	public boolean insertLabel(Label sponsor) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, sponsor.getName());
			preparedStatement.setString(2, sponsor.getDescription());
			preparedStatement.setLong(3, sponsor.getIdGame());
			preparedStatement.execute();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updateLabel(Request request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			campo = (String) request.get("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update label set " + campo + "=? where id =?");
			preparedStatement.setString(1, (String) request.get("newCampo"));
			preparedStatement.setInt(2, (Integer) request.get("id"));
			preparedStatement.execute();
			return true;

		}

		catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

}
