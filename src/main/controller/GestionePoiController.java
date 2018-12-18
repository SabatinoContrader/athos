package main.controller;

import main.MainDispatcher;

public class GestionePoiController implements Controller {

	public void doControl(Request request) {

		String choice = request.get("scelta").toString();

		switch (choice) {
		case "insert":
			request.put("scelta", "insert");
			MainDispatcher.getInstance().callView("InsertPOI", request);
			break;

		case "view":
			request.put("scelta", "view");
			MainDispatcher.getInstance().callView("ViewPOI", request);
			break;

		case "modify":
			request.put("scelta", "modify");
			MainDispatcher.getInstance().callView("ModifyPOI", request);
			break;

		case "delete":
			request.put("scelta", "delete");
			MainDispatcher.getInstance().callView("DeletePOI", request);
			break;

		}

	}

	public void GestionePOI() {

	}

}
