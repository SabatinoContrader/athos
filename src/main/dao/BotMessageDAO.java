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
import main.model.BotMessage;
import main.model.Gomma;

public class BotMessageDAO {

	// query per recuperare tutte le tuple dalla tabella bot_messages
	private final String QUERY_ALL = "select * from bot_messages";

	// query per inserire una tupla bot_message
	private final String QUERY_INSERT = "insert into bot_messages (bot_message_id, bot_message , chatbot_fk)values (?, ?, ?)";

	// query per eliminare una tupla
	private final String QUERY_DELETE = "delete from bot_messages where bot_message_id = (?)";

	// aggiorna una tupla
	private final String QUERY_UPDATE = "update bot_messages set bot_message = (?) where bot_message_id = (?);";

	// Constructor senza parametri
	public BotMessageDAO() {
	}

	/**
	 * Ottiene e restituisce tutti i bot_message dal database
	 * 
	 * @return
	 */
	public List<BotMessage> getAllBotMessage() {
		// lista degli elementi da restituire
		List<BotMessage> botMessages = new ArrayList<>();
		// connessione al database
		Connection connection = ConnectionSingleton.getInstance();

		try {
			// oggetto usato per eseguire uno statement SQL
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			// ciclo tutti i risultati
			while (resultSet.next()) {

				// popolo i campi dell'entità
				Integer botMessageId = resultSet.getInt("bot_message_id");
				String botMessage = resultSet.getString("bot_message");
				Integer chatbotFK = resultSet.getInt("chatbot_fk");
				// inserisco nella lista da restituire la tupla letta
				botMessages.add(new BotMessage(botMessageId, botMessage, chatbotFK));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// restituisco l'insieme delle tuple trovate dalla query
		return botMessages;
	}

	/**
	 * Inserisce un bot_message nel database
	 * 
	 * @param botMessage
	 * @return
	 */
	public boolean insertBotMessage(BotMessage botMessage) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			// inseriamo i valori dell'entità nella query per l'inserimento
			preparedStatement.setInt(1, botMessage.getBotMessageId());
			preparedStatement.setString(2, botMessage.getBotMessage());
			preparedStatement.setInt(3, botMessage.getChatbotFK());

			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	/**
	 * Delete di una tupla bot_message dal db
	 * 
	 * @param bot_message_id
	 * @return
	 */
	public boolean deleteBotMessage(Integer botMessageId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, botMessageId);

			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	/**
	 * Aggiorna una tupla
	 * 
	 * @param botMessage
	 * @param botMessageId
	 * @return
	 */
	public boolean updateBotMessage(String botMessage, Integer botMessageId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			// inseriamo i campi per aggiornare la tupla
			preparedStatement.setString(1, botMessage);
			preparedStatement.setInt(2, botMessageId);

			return preparedStatement.execute();
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
}
