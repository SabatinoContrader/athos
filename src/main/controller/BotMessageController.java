package main.controller;

import main.MainDispatcher;

/**
 * Classe che si occupa di fare le richieste al model e reindirizza il risultato alla view corretta
 *
 */
public class BotMessageController implements Controller {

	//Campo aggiunto per la creazione by reflection dopo l'aggiunta del sub package
	private static final String SUB_PACKAGE = "BotMessage.";

	@Override
	public void doControl(Request request) {

		int choice = (int) request.get("choice");
		
		switch (choice) {
		case 1:
			request.put("mode", "insert");
			MainDispatcher.getInstance().callView(SUB_PACKAGE+" InsertBotMessage", request);
			break;

		case 2:
			request.put("mode", "delete");
			MainDispatcher.getInstance().callView(SUB_PACKAGE+"DeleteBotMessage", request);
			break;

		case 3:
			request.put("mode", "update");
			MainDispatcher.getInstance().callView(SUB_PACKAGE+"BotMessage.UpdateBotMessage", request);
			break;
			
		case 4:
			request.put("mode", "all");
			MainDispatcher.getInstance().callView(SUB_PACKAGE+"BotMessage.SelectBotMessage", request);
			break;

		}
	}

}
