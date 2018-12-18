package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class HomePlayerView implements View {

	private int choice;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void showOptions() {
		System.out.println("BenvenutoUtente");
		System.out.println("1-Giocadasolo");

		System.out.println("2-Giocaingruppo");

		this.choice = Integer.parseInt(getInput());
	}

	public void showResults(Request request) {

	}

	public void submit() {

		if (choice == 1) {
			Request request = new Request();
			request.put("scelta", choice);
			MainDispatcher.getInstance().callAction("Giocadasolo", "doControl", request);

		} else if (choice == 2) {
			Request request = new Request();
			request.put("scelta", choice);
			MainDispatcher.getInstance().callAction("Giocaingruppo", "doControl", request);

		}
	}
}
