package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class HomeView implements View {

	private int choice;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void showOptions() {
		System.out.println("");
		System.out.println("Benvenuto in ContraderFramework");
		System.out.println("");
		System.out.println("-------MENU-------");
		System.out.println("");
		System.out.println("Scegli su quale entità lavorare:");
		System.out.println("1) Visualizza lista UserType");
		System.out.println("2) BotMessage");
		this.choice = Integer.parseInt(getInput());
	}

	public void showResults(Request request) {

	}

	public void submit() {

		if (choice == 1) {
			Request request = new Request();
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("UserType", "doControl", request);

		} else if (choice == 2) {
			Request request = new Request();
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("SubMenuBotMessage", "doControl", request);

		}
	}

}
