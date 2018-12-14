package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class LoginController implements Controller {
	private LoginService LogService ;
	
public LoginController() {
	LogService= new LoginService(); 
	
}
public void doControl(Request request) {
	if (request != null)  {
		String nomeUtente= request.get("nomeUtente").toString();
		String password= request.get("password").toString();
		if (LogService.login(nomeUtente,password )) {
			System.out.println("Login corretto\n");
			MainDispatcher.getInstance().callView("HomeGamer", request);
	}
		else {
			System.out.println("Nome Utente o password sbagliata");
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
		}
	}
	else {
		MainDispatcher.getInstance().callView("Login", null );
	
		}
}
}

