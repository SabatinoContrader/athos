package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class HomeGamerView implements View {

	private int choice;
	private Request requestChoice;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void showOptions() {
		System.out.println("Benvenuto GameMaster, quale operazione vuoi effettuare?");
		System.out.println("");
		System.out.println("");
		System.out.println("-------MENU Gamer-------");
		System.out.println("");
		System.out.println("1) Gestione Punti Di Interesse ");
		System.out.println("2) Gestione Indovinelli ");
		System.out.println("3) Gestione Sponsor ");
		System.out.println("4) Gestione Tracciamenti ");
		System.out.println("5) Gestione Game ");
		System.out.println("6) Return");
		System.out.print(".> ");
		this.choice = Integer.parseInt(getInput());
	}

	public void showResults(Request request) {

	}

	public void submit() {
		if (choice < 1 || choice > 6) {
			System.out.println("Il numero scelto deve appartenere all'elenco");
			MainDispatcher.getInstance().callView("HomeGamer", null);
		} else if (choice == 6) {
			this.requestChoice = new Request();
			requestChoice.put("choice", "return");
			MainDispatcher.getInstance().callAction("HomeGamer", "doControl", requestChoice);
		} else {
			Request request = new Request();
			if (this.choice == 1) {
				request.put("choice", "poi");
			} else if (this.choice == 2) {
				request.put("choice", "label");
			} else if (this.choice == 3) {

				request.put("choice", "sponsor");
			} else if (this.choice == 4) {
				request.put("choice", "track");
			} else if (this.choice == 5) {
				request.put("choice", "game");
			}
			MainDispatcher.getInstance().callAction("HomeGamer", "doControl", request);
		}

	}
}
