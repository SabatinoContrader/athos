package main.controller;

import main.MainDispatcher;

public class GiocadasoloController implements Controller {

	public GiocadasoloController() {

	}

	public void doControl(Request request) {
		String choise = request.toString();
		MainDispatcher.getInstance().callView("Giocadasolo", request);

	}
}