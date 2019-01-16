package com.virtualpairprogrammers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import javax.servlet.http.HttpServletRequest;
import com.virtualpairprogrammers.model.Poi;

public class PoiDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from poi ";
	private final String QUERY_INSERT = " insert into poi (id, city , hystorical ) values (?,?,?) ";
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
				Poi newPoi = new Poi();

				newPoi.setId(resultSet.getInt("id"));
				newPoi.setCity(resultSet.getString("city"));
				newPoi.setHystorical(resultSet.getString("hystorical"));
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
			preparedStatement.setString(3, poi.getHystorical());
			preparedStatement.execute();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updatePoi(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			String campo = (String) request.getParameter("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update poi set " + campo + "=? where id =?");
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

	public boolean deletePoi(int id) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public List<Poi> getPoi(int id) {
		List<Poi> poi = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from poi where id=" +id);
			while (resultSet.next()) {
				
				int idPoi= resultSet.getInt("id");
				String city = resultSet.getString("city");
				String hystorical = resultSet.getString("hystorical");
				
				poi.add(new Poi(id, city, hystorical));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dei poi!!");
		}

		return poi;

	}
	
}
