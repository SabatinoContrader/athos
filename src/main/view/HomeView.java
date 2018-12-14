package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

	private int choice;

	public void showResults(Request request) {

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

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

}
