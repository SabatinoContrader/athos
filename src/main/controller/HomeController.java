package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeController implements Controller {

	private LoginService loginService;

	public HomeController() {
		loginService = new LoginService();
	}

	public void doControl(Request request) {
		if (request != null) {
			String nomeUtente = request.get("nomeUtente").toString();
			String password = request.get("password").toString();
			if (loginService.login(nomeUtente, password)) {
				System.out.println("Login corretto\n");
				MainDispatcher.getInstance().callView("Home", request);
			} else {
				System.out.println("Username o password errata \n");
				MainDispatcher.getInstance().callAction("Login", "doControl", request);
			}
		} else
			MainDispatcher.getInstance().callView("Home", null);

	}
}
