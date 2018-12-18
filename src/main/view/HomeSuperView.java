package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;

public class HomeSuperView implements View {
	private int scelta;

	@Override
	public String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	@Override
	public void showOptions() {
		System.out.println("______Benvenuto Admin :) , seleziona una operazione___________");
		System.out.println("1-Gestione Gamer");
		System.out.println("2-Logout");
		this.scelta = Integer.parseInt(getInput());

	}

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void submit() {
		Request request = new Request();
		switch (this.scelta) {
		case 1:
			request.put("operazione", "gestionegamer");
			MainDispatcher.getInstance().callAction("HomeSuper", "doControl", request);
			break;
		case 2:
			request.put("operazione", "logout");
			MainDispatcher.getInstance().callAction("HomeSuper", "doControl", request);
			break;
		}

	}

}
