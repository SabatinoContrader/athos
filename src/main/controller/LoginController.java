package main.controller;

import main.MainDispatcher;
import main.model.User;
import main.service.LoginService;

public class LoginController implements Controller {
	private LoginService LogService;

	// int a = 0;

	public LoginController() {
		LogService = new LoginService();

	}

	public void doControl(Request request) {

		if (request != null) {

			String nomeUtente = request.get("nomeUtente").toString();
			String password = request.get("password").toString();
			User u = LogService.ruolo(nomeUtente, password);
			// a = LogService.testaruolo(nomeUtente, password);
			// int ruolo = u.getRole();
			// if (LogService.login(nomeUtente, password)) {
			if (u != null) {
				if (u.getRole() == 0) {
					System.out.println("Login corretto\n");
					MainDispatcher.getInstance().callView("HomeSuper", null);
				} else if (u.getRole() == 1) {
					System.out.println("Login corretto\n");
					MainDispatcher.getInstance().callView("HomeGamer", null);
				} else if (u.getRole() == 2) {
					System.out.println("Login corretto\n");
					MainDispatcher.getInstance().callView("HomePlayer", null);
				} else {
					System.out.println("Password o Username ERRATI\n");
					MainDispatcher.getInstance().callAction("Login", "doControl", request);
				}

			} else {
				System.out.println("Password o Username ERRATI\n");
				MainDispatcher.getInstance().callView("Login", null);
			}
		} else {
			// System.out.println("Password o Username ERRATI\n");
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
