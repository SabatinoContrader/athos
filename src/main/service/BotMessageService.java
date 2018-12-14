package main.service;

import main.dao.BotMessageDAO;
import main.model.BotMessage;
import main.model.Gomma;

import java.util.List;
/**
 * Classe utilizzata per mediare le comunicazioni tra il controller e il model 
 *
 */
public class BotMessageService {

	private BotMessageDAO botMessageDAO;

	public BotMessageService() {
		this.botMessageDAO = new BotMessageDAO();
	}

	public List<BotMessage> getAllBotMessage() {
		return this.botMessageDAO.getAllBotMessage();
	}

	public boolean insertBotMessage(BotMessage botMessage) {
		return this.botMessageDAO.insertBotMessage(botMessage);
	}

	public boolean deleteBotMessage(Integer botMessageId) {
		return this.botMessageDAO.deleteBotMessage(botMessageId);
	}
	
	public boolean updateBotMessage(String botMessage, Integer botMessageId) {
		return this.botMessageDAO.updateBotMessage(botMessage, botMessageId);
	}
}
