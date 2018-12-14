package main.controller;

import main.MainDispatcher;

public class SubMenuBotMessageController implements Controller {

	@Override
	public void doControl(Request request) {
	      MainDispatcher.getInstance().callView("SubMenuBotMessage", request);
	}

}
