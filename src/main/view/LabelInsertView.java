package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Label;

public class LabelInsertView implements View {

	private Request request;

	@Override
	public String getInput() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	@Override
	public void showOptions() {

		System.out.println("Inserisci nuovo indovinello");
		System.out.println(" Nome Indovinello: ");
		String nome = getInput();
		System.out.println(" Descrizione : ");
		String descrizione = getInput();
		System.out.println(" Id Game Associato : ");
		int idGame = Integer.parseInt(getInput());
		Label insertLabel = new Label();
		insertLabel.setName(nome);
		insertLabel.setDescription(descrizione);
		insertLabel.setIdGame(idGame);
		request = new Request();
		this.request.put("newLabel", insertLabel);
		this.request.put("choice", "insertDB");
	}

	@Override
	public void showResults(Request request) {

		this.request = request;

	}

	@Override
	public void submit() {

		MainDispatcher.getInstance().callAction("Label", "doControl", this.request);

	}

}