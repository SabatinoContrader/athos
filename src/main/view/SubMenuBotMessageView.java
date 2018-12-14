package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class SubMenuBotMessageView implements View {

	private int choice;
	
	@Override
	public void showResults(Request request) {
		
	}

	@Override
	public void showOptions() {
		System.out.println("");
		System.out.println("Questo è il sub menu per bot_message");
		System.out.println("");
		System.out.println("Scegli che vuoi fare");
		System.out.println("1) insert");
		System.out.println("2) delete");
		System.out.println("3) update");
		System.out.println("4) read");
		this.choice = Integer.parseInt(getInput());
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("choice", choice);
		MainDispatcher.getInstance().callAction("BotMessage", "doControl", request);
	}

}
