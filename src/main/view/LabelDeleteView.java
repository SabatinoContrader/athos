package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Label;

public class LabelDeleteView implements View {

	private Request request;

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Inserire l'id dell'indovinello da eliminare");
		System.out.println("Id.>");
		int id = Integer.parseInt(getInput());
		this.request = new Request();
		this.request.put("deleteLabel", id);
		this.request.put("choice", "deleteLabel");

	}

	@Override
	public void showResults(Request request) {
		List<Label> listalabel = (List<Label>) request.get("listaLabel");
		System.out.println("----- Visualizza Indovinelli-----");
		System.out.println();
		System.out.println();
		System.out.format(
				"+------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		System.out.format("%12s %40s %80s %12s %n", "1. ID INDOVINELLO", "2. NOME", "3. DESCRIZIONE",
				"4. ID GAME ASSOCIATO");
		System.out.format(
				"+------------------------------------------------------------------------------------------------------------------------------------------------+%n");

		for (Label label : listalabel) {
			// String leftAlignFormat ="| %-4s | %-9s | %-15s |%n";
			System.out.format("%12s %40s %80s %12s %n", label.getId(), label.getName(), label.getDescription(),
					label.getIdGame());
		}
		System.out.println();
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Label", "doControl", this.request);
	}

}