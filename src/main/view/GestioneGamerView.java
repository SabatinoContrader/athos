package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class GestioneGamerView implements View {

	private int scelta;

	public String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public void showOptions() {
		System.out.println("Cosa vuoi fare Admin?");
		System.out.println("1-Inserisci Game Master");
		System.out.println("2-Modifica Game Master");
		System.out.println("3-Rimuovi Game Master");
		System.out.println("4-Visualizza i Game Master");
		System.out.println("5-Indietro");
		System.out.println("6-Logout");
		scelta = Integer.parseInt(getInput());

	}

	public void showResults(Request request) {

	}

	public void submit() {
		Request request = new Request();
		switch (this.scelta) {
		case 1:
			request.put("operazione", "insert");
			MainDispatcher.getInstance().callAction("GestioneGamer", "doControl", request);
			return;
		case 2:
			request.put("operazione", "modify");
			MainDispatcher.getInstance().callAction("GestioneGamer", "doControl", request);
			return;
		case 3:
			request.put("operazione", "remove");
			MainDispatcher.getInstance().callAction("GestioneGamer", "doControl", request);
		case 4:
			request.put("operazione", "view");

			MainDispatcher.getInstance().callAction("GestioneGamer", "doControl", request);
		case 5:
			request.put("operazione", "indietro");
			MainDispatcher.getInstance().callAction("GestioneGamer", "doControl", request);
			break;
		case 6:
			request.put("operazione", "logout");
			MainDispatcher.getInstance().callAction("GestioneGamer", "doControl", request);
		default:
			return;
		}

	}

}
