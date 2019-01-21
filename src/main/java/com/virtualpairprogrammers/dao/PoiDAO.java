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
	private final String QUERY_INSERT = " insert into poi (latitudine,longitudine ,idSponsor,indizio) values (?,?,?,?) ";
	private final String QUERY_DELETE = " delete from poi where id = ?";
	private final String query_tutto= "select p.id, p.latitudine,p.longitudine, p.indizio, s.name from sponsor as s right join poi as p on s.id=p.idSponsor";

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
				newPoi.setLatitudine(resultSet.getFloat("latitudine"));
				newPoi.setLongitudine(resultSet.getFloat("longitudine"));
				newPoi.setIdSponsor(resultSet.getInt("idSponsor"));
				newPoi.setIndizio(resultSet.getString("indizio"));
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

            preparedStatement.setFloat(1, (float) poi.getLatitudine());
			preparedStatement.setFloat(2, (float) poi.getLongitudine());
			preparedStatement.setInt(3, (int) poi.getIdSponsor());
			preparedStatement.setString(4, poi.getIndizio());
			preparedStatement.executeUpdate();
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
				float latitudine = resultSet.getFloat("latitudine");
				float longitudine = resultSet.getFloat("longitudine");
				int idSponsor = resultSet.getInt("idSponsor");
				String indizio = resultSet.getString("indizio");
				
				poi.add(new Poi(id, latitudine, longitudine, idSponsor, indizio));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dei poi!!");
		}

		return poi;

	}
	
}
