package main.view.BotMessage;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessage;
import main.service.BotMessageService;
import main.view.View;

public class UpdateBotMessageView implements View {

	private BotMessageService botMessageService;
	private String mode;

	public UpdateBotMessageView() {
		this.botMessageService = new BotMessageService();
		this.mode = "update";
	}

	@Override
	public void showResults(Request request) {
		this.mode = (String) request.get("mode");
	}

	@Override
	public void showOptions() {
		switch (mode) {
		case "update":

			System.out.println("-----------------------------------");
			List<BotMessage> botMessages = botMessageService.getAllBotMessage();
			System.out.println("----- BotMessage disponibili -----");
			System.out.println();
			botMessages.forEach(botMesssage -> System.out.println(botMesssage.getBotMessageId()+" : "+ botMesssage.getBotMessage()));
			System.out.println("-----------------------------------");
			
			System.out.println("Inseriesci l'id del botMessage da modificare");
			String id = getInput();
			System.out.println("Inserisci la frase da aggiornare ");
			String text = getInput();

			botMessageService.updateBotMessage(text, Integer.parseInt(id));

			break;

		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Home", "doControl", null);
	}


}
