package main.view;

import main.controller.Request;

public interface View {

	public String getInput();

	public void showOptions();

	public void showResults(Request request);

	public void submit();
}
