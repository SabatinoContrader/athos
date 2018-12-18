package main.controller;

import main.MainDispatcher;
import main.service.GamerService;

public class GestioneGamerController implements Controller {

	GamerService gamerservice = new GamerService();

	@Override
	public void doControl(Request request) {
		if (request != null) {
			String operazione = request.get("operazione").toString();

			switch (operazione) {

			case "insert":
				MainDispatcher.getInstance().callView("SuperUserInsert", request);
				return;
			case "modify":
				request.put("listautenti", gamerservice.viewAllUser());
				MainDispatcher.getInstance().callView("SuperUserModify", request);
				return;
			case "remove":
				request.put("listautenti", gamerservice.viewAllUser());
				MainDispatcher.getInstance().callView("SuperUserRemove", request);
				return;
			case "view":
				request.put("listautenti", gamerservice.viewAllUser());
				MainDispatcher.getInstance().callView("SuperUserView", request);
				return;
			case "indietro":
				MainDispatcher.getInstance().callView("HomeSuper", request);
				break;
			case "logout":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				return;

			}
		}

	}

}
