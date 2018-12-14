package main.model;

public class BotMessage {

	// chiave primaria della tabella bot_messages
	private Integer botMessageId;

	// rappresenta il contenuto del messaggio
	private String botMessage;

	// chiave esterna alla chiave primaria della tabella chatbots
	private Integer chatbotFK;

	// Constructor senza parametri
	public BotMessage() {
	}

	// Constructor con parametri
	public BotMessage(Integer botMessageId, String botMessage, Integer chatbotFK) {
		this.botMessageId = botMessageId;
		this.botMessage = botMessage;
		this.chatbotFK = chatbotFK;
	}
	/////////////////////////////////////////////////
	// SETTER AND GETTER BELOW
	/////////////////////////////////////////////////

	public Integer getBotMessageId() {
		return botMessageId;
	}

	public void setBotMessageId(Integer botMessageId) {
		this.botMessageId = botMessageId;
	}

	public String getBotMessage() {
		return botMessage;
	}

	public void setBotMessage(String botMessage) {
		this.botMessage = botMessage;
	}

	public Integer getChatbotFK() {
		return chatbotFK;
	}

	public void setChatbotFK(Integer chatBotFK) {
		this.chatbotFK = chatBotFK;
	}

}
