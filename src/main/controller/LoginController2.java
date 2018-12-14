package main.controller;

import main.MainDispatcher;

public class LoginController2 implements Controller {

    public LoginController2() {
    }

    public void doControl (Request request) {
        MainDispatcher.getInstance().callView("Login", request);
    }
}
