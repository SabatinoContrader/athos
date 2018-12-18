package main.view;

import java.util.Scanner;

import main.controller.Request;

public class GiocadasoloView implements View {

	private String INIZIA;

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub

	}

	public void showResults(Request request) {
		System.out.println("INIZIA");
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub

	}
}
