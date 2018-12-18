package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class SponsorView implements View {

	private int choice;
	private Request requestChoice;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void showOptions() {
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU Sponsor-------");
		System.out.println("");
		System.out.println("1) Visualizza la lista di Sponsor ");
		System.out.println("2) Crea un nuovo sponsor ");
		System.out.println("3) Modifica uno Sponsor ");
		System.out.println("4) Elimina uno Sponsor ");
		System.out.println("5) Return");
		System.out.print(".> ");
		this.choice = Integer.parseInt(getInput());
	}

	public void showResults(Request request) {

	}

	public void submit() {
		if (choice < 1 || choice > 5) {
			System.out.println("Il numero scelto deve appartenere all'elenco");
			MainDispatcher.getInstance().callView("Sponsor", null);
		} else if (choice == 5) {
			this.requestChoice = new Request();
			requestChoice.put("choice", "return");
			MainDispatcher.getInstance().callAction("Sponsor", "doControl", requestChoice);
		} else {
			Request request = new Request();
			if (this.choice == 1) {
				request.put("choice", "read");
			} else if (this.choice == 2) {
				request.put("choice", "insert");
			} else if (this.choice == 3) {

				request.put("choice", "update");
			} else if (this.choice == 4) {
				request.put("choice", "delete");
			}
			MainDispatcher.getInstance().callAction("Sponsor", "doControl", request);
		}

	}
}
