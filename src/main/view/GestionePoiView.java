package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.service.PoiService;

public class GestionePoiView implements View {

	 int scelta;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public void showOptions() {
		System.out.println("Gestisci POI");
		System.out.println("1-Insert");
		System.out.println("2-View");
		System.out.println("3-Modify");
		System.out.println("4-Delete");

		this.scelta = Integer.parseInt(getInput());

	}

	public void showResults(Request request) {

	}

	public void submit() {
		Request request = new Request();
		switch (this.scelta) {
		case 1:
			request.put("operazione", "insert");
			MainDispatcher.getInstance().callAction("Poi", "doControl", request);
			return;
		case 2:
			request.put("operazione", "visualizzapoi");
			MainDispatcher.getInstance().callAction("Poi", "doControl", request);
			return;
		case 3:
			request.put("operazione", "modify");
			MainDispatcher.getInstance().callAction("Poi", "doControl", request);
			return;
		case 4:
			request.put("operazione", "delete");
			MainDispatcher.getInstance().callAction("Poi", "doControl", request);
			return;
		default:
			return;
		}

	}
}