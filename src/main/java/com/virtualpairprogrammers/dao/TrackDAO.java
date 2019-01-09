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
import com.virtualpairprogrammers.model.Track;

public class TrackDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from track ";
	private final String QUERY_INSERT = " insert into track (name,start_poi_id,end_poi_id) values (?,?,?) ";
	private String QUERY_DELETE = " delete from track where id = ?";

	public TrackDAO() {

	}

	public boolean deleteTrack(int id) {
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

	public List<Track> getAllTrack() {
		List<Track> allTrack = new ArrayList<Track>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Track newTrack = new Track();

				newTrack.setId(resultSet.getInt("id"));
				newTrack.setName(resultSet.getString("name"));
				newTrack.setStartPoiId(resultSet.getInt("start_poi_id"));
				newTrack.setEndPoiId(resultSet.getInt("end_poi_id"));
				allTrack.add(newTrack);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca del percorso!!");
		}

		return allTrack;

	}

	public boolean insertTrack(Track track) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, track.getName());
			preparedStatement.setLong(2, track.getStartPoiId());
			preparedStatement.setLong(3, track.getEndPoiId());
			preparedStatement.executeUpdate();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updateTrack(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			String campo = (String) request.getParameter("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update track set " + campo + "=? where id =?");
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
	
	public List<Track> getTrack(long id) {
		List<Track> track = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from track where id=" +id);
			while (resultSet.next()) {
				
				int idTrack= resultSet.getInt("id");
				String nome= resultSet.getString("name");
				int startId=resultSet.getInt("start_poi_id");
				int endId=resultSet.getInt("end_poi_id");
				
				track.add(new Track(idTrack, nome, startId, endId));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca dei percorsi!!");
		}

		return track;

	}

}
