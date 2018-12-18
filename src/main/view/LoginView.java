package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class LoginView implements View {

	private String nomeUtente;
	private String password;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

	public void showOptions() {
		System.out.println("-----LOGIN----");
		System.out.println("Nome utente:");
		nomeUtente = getInput();
		System.out.println("Password:");
		password = getInput();
	}

	public void showResults(Request request) {
		if (request != null) {
			String messaggio = (String) request.get("messaggio");
			if (messaggio != null) {
				System.out.println(messaggio);
			}
		}
	}

	public void submit() {
		Request request = new Request();
		request.put("nomeUtente", nomeUtente);
		request.put("password", password);
		MainDispatcher.getInstance().callAction("Login", "doControl", request);
	}

}
