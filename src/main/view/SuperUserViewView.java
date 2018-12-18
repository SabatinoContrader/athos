package main.view;

import java.util.ArrayList;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;

public class SuperUserViewView implements View {
	ArrayList<User> listautenti;
	int scelta;

	@Override
	public String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	@Override
	public void showOptions() {
		System.out.println("Cosa vuoi fare adesso?");
		System.out.println("1-Indietro");
		System.out.println("2-Logout");
		this.scelta = Integer.parseInt(getInput());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void showResults(Request request) {
		this.listautenti = (ArrayList<User>) request.get("listautenti");
		System.out.println("_________________Lista GameMaster:___________________");
		for (User gamemaster : this.listautenti) {
			System.out.println("\n" + "______GameMaster" + gamemaster.getId() + "_________" + "\n" + "UserName: "
					+ gamemaster.getUsername() + "\n" + "Password: " + gamemaster.getPassword() + "\n" + "Ruolo: "
					+ gamemaster.getRole() + "\n");
		}

	}

	@Override
	public void submit() {
		Request request = new Request();
		switch (this.scelta) {
		case 1:
			request.put("operazione", "indietro");
			MainDispatcher.getInstance().callAction("GestioneGamer", "doControl", request);
			break;
		case 2:
			request.put("operazione", "logout");
			MainDispatcher.getInstance().callAction("HomeSuper", "doControl", request);
			break;
		default:
			break;
		}

	}

}
