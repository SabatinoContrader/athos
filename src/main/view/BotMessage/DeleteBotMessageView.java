package main.view.BotMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessage;
import main.service.BotMessageService;
import main.view.View;

public class DeleteBotMessageView implements View {

	private BotMessageService botMessageService;
	private String mode;

	public DeleteBotMessageView() {

		this.botMessageService = new BotMessageService();
		this.mode = "delete";
	}

	@Override
	public void showResults(Request request) {
		this.mode = (String) request.get("mode");
	}

	@Override
	public void showOptions() {
		switch (mode) {
		case "delete":

			System.out.println("-----------------------------------");
			List<BotMessage> botMessages = botMessageService.getAllBotMessage();
			System.out.println("----- BotMessage disponibili -----");
			System.out.println();
			botMessages.forEach(botMesssage -> System.out.println(botMesssage.getBotMessageId()+" : "+ botMesssage.getBotMessage()));
			System.out.println("-----------------------------------");

			System.out.println("Inseriesci l'id del botMessage da eliminare");
			String id = getInput();
			Integer.parseInt(id);
			botMessageService.deleteBotMessage(Integer.parseInt(id));

			System.out.println("botMessage eliminato con successo");
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
