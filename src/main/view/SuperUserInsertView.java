package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;

public class SuperUserInsertView implements View {

	public User gamemaster = new User();

	@Override
	public String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	@Override
	public void showOptions() {
		System.out.println("Admin");
		System.out.println("Inserisci username e password del GameMaster");
		System.out.println("username:");
		gamemaster.setUsername(getInput());
		System.out.println("password:");
		gamemaster.setPassword(getInput());
		gamemaster.setRole(1);
	}

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("operazione", "inserimento");
		request.put("username", this.gamemaster.getUsername().toString());
		request.put("password", this.gamemaster.getPassword().toString());
		MainDispatcher.getInstance().callAction("Super", "doControl", request);
	}

}
