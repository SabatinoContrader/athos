package main.view.BotMessage;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessage;
import main.service.BotMessageService;
import main.view.View;

public class InsertBotMessageView implements View {

	private BotMessageService botMessageService;
	private String mode;

	public InsertBotMessageView() {
		this.botMessageService = new BotMessageService();
		this.mode = "insert";
	}

	@Override
	public void showResults(Request request) {
		this.mode = (String) request.get("mode");
	}

	@Override
	public void showOptions() {
		switch (mode) {
		case "insert":

			System.out.println("Inseriesci l'id del botMessage");
			String id = getInput();
			System.out.println("Inserisci un frase da inserire: ");
			String text = getInput();
			System.out.println("Inserisci il codice chatBox: ");
			String codice = getInput();

			BotMessage bm = new BotMessage();
			bm.setBotMessageId(Integer.parseInt(id));
			bm.setBotMessage(text);
			bm.setChatbotFK(Integer.parseInt(codice));

			botMessageService.insertBotMessage(bm);

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
