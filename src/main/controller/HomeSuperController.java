package main.controller;

import main.MainDispatcher;

public class HomeSuperController implements Controller {

	@Override
	public void doControl(Request request) {
		try {
			if (request != null) {
				String operazione = request.get("operazione").toString();
				switch (operazione) {
				case "gestionegamer":
					MainDispatcher.getInstance().callView("GestioneGamer", request);
					break;
				case "logout":
					MainDispatcher.getInstance().callView("Login", request);
					break;

				default:
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
