package main.controller;

import main.MainDispatcher;
import main.service.LoginService;

public class HomeGamerController implements Controller {

    private LoginService loginService;

    
    public HomeGamerController() {
        loginService = new LoginService();

    }

    public void doControl(Request request) {
    	
    	String choice = request.get("choice").toString();
    	
        if (choice != null) {
        	
        	   switch (choice) {
                  case "poi":
            	       MainDispatcher.getInstance().callView("Sponsor", request);
            	       break;
                  case "label":
            	       MainDispatcher.getInstance().callView("Label", request);
            	       break;
                  case "sponsor":
            	       MainDispatcher.getInstance().callView("Sponsor", request);
            	       break;
                  case "track":
                	   MainDispatcher.getInstance().callView("Sponsor", request);
                	   break;
                  case "game":
               	   MainDispatcher.getInstance().callView("Sponsor", request);
               	   break;
                  case "return":
                	  MainDispatcher.getInstance().callView("Login", null);
                	  break;
            }
        }
        else {
        	MainDispatcher.getInstance().callView("HomeGamer", null);
        }
    }
}
