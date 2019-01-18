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
import com.virtualpairprogrammers.model.Sponsor;

public class SponsorDAO {

	String campo = "";

	private final String QUERY_ALL = " select * from sponsor ";
	private final String QUERY_INSERT = " insert into sponsor (name,description) values (?,?) ";
	private String QUERY_DELETE = " delete from sponsor where id = ?";
	private String QUERY_RETURN_NOME = "select name from sponsor where id = ?";

	public SponsorDAO() {

	}

	public boolean deleteSponsor(int id) {
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

	public List<Sponsor> getAllSponsor() {
		List<Sponsor> allSponsor = new ArrayList<Sponsor>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Sponsor newSponsor = new Sponsor();

				newSponsor.setId(resultSet.getInt("id"));
				newSponsor.setName(resultSet.getString("name"));
				newSponsor.setDescription(resultSet.getString("description"));
				allSponsor.add(newSponsor);

			}

		} catch (Exception e) {
			e.printStackTrace();
			 System.out.println("Errore nella ricerca dello sponsor!!");
		}

		return allSponsor;

	}

	public boolean insertSponsor(Sponsor sponsor) {

		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, sponsor.getName());
			preparedStatement.setString(2, sponsor.getDescription());
			preparedStatement.executeUpdate();
			return true;

		}

		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;

		}
	}

	public boolean updateSponsor(HttpServletRequest request) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			String campo = (String) request.getParameter("campo");
			PreparedStatement preparedStatement = connection
					.prepareStatement("update sponsor set " + campo + "=? where id =?");
			preparedStatement.setString(1, (String) request.getParameter("newCampo"));
			preparedStatement.setInt(2,  Integer.parseInt(request.getParameter("id")));
			preparedStatement.execute();
			return true;

		}

		catch (SQLException e) {

			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}
	
	public List<Sponsor> getSponsor(int id) {
		List<Sponsor> sponsor = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from sponsor where id=" +id);
			while (resultSet.next()) {
				
				int idSponsor= resultSet.getInt("id");
				String name=resultSet.getString("name");
				String description= resultSet.getString("description");
				
				sponsor.add(new Sponsor(idSponsor, name, description));

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Errore nella ricerca degli sponsor!!");
		}

		return sponsor;

	}

	public String getNome(int id) {
		String spot = "";
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_RETURN_NOME);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				spot = "";
				spot = resultSet.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
			 System.out.println("Errore nella ricerca dello sponsor!!");
		}

		return spot;

	}
	
}

