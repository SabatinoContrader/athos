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
import main.controller.Request;
import main.model.Poi;

public class PoiDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from poi ";
	private final String QUERY_INSERT = " insert into poi (id,city,hystorical) values (?,?,?) ";
	private String QUERY_DELETE = " delete from poi where id = ?";

	public PoiDAO() {

	}

	public List<Poi> getAllPoi() {
		List<Poi> allPoi = new ArrayList<Poi>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Poi newPoi = new Poi(resultSet.getInt("id"),resultSet.getString("city"),resultSet.getString("hystorical"));
				allPoi.add(newPoi);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca del poi!!");
		}

		return allPoi;

	}

	public boolean insertPoi(Poi poi) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, (int) poi.getId());
			preparedStatement.setString(2, poi.getCity());
			preparedStatement.setString(3, poi.getHistorycal());
			preparedStatement.execute();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updatePoi(Request request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			campo = (String) request.get("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update poi set " + campo + "=? where id =?");
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

	public boolean deletePoi(int id) {
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

}
