package main.controller;

import main.MainDispatcher;
import main.service.GamerService;

public class SuperController implements Controller {
	GamerService gamerservice = new GamerService();

	@Override
	public void doControl(Request request) {
		String operazione = request.getString("operazione").toString();

		switch (operazione) {
		case "inserimento":
			gamerservice.insertGamer(request.get("username").toString(),request.get("password").toString());
			MainDispatcher.getInstance().callView("GestioneGamer",null);
			break;
		case "modifica":
			gamerservice.updateGamerPassword(Integer.parseInt(request.get("idmodificare").toString()),request.get("nuovapassword").toString());
			MainDispatcher.getInstance().callView("GestioneGamer",null);
			break;
		case "rimozione":
			int id=Integer.parseInt(request.get("removegamer").toString());
			System.out.println("id: "+id);
			gamerservice.removeGamer(id);
			MainDispatcher.getInstance().callView("GestioneGamer",null);
			break;
		default:
			break;
		}
	}

}
