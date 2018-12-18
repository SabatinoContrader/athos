package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Label;

public class LabelUpdateView implements View {

	private Request request;

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void showOptions() {
		int id = 0;
		try {

			System.out.println("Inserisci l'id dell'indovinello che vuoi modificare.> ");
			id = Integer.parseInt(getInput());

		} catch (Exception e) {
			System.out.println("L'ID dell'indovinello deve essere un INTERO");

		}

		System.out.println(
				"Inserisci il numero del campo che vuoi modificare: 1) Nome Sponsor 2) Descrizione 3) Id Game Associato");
		int num = Integer.parseInt(getInput());
		String campo = "";

		if (num < 1 || num > 3) {
			System.out.println("Il numero scelto deve appartenere all'elenco");
			MainDispatcher.getInstance().callView("LabelUpdate", null);
		} else {
			switch (num) {

			case 1:

				campo = "name";
				break;

			case 2:

				campo = "description";
				break;

			case 3:

				campo = "idGame";
				break;
			}
		}

		System.out.println("Inserisci il nuovo valore");
		String newCampo = getInput();

		this.request = new Request();
		this.request.put("id", id);
		this.request.put("newCampo", newCampo);
		this.request.put("campo", campo);
		this.request.put("choice", "updateLabel");
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {

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

	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Label", "doControl", this.request);
	}

}
