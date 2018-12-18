package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Sponsor;

public class SponsorUpdateView implements View {

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

			System.out.println("Inserisci l'id dello Sponsor che vuoi modificare.> ");
			id = Integer.parseInt(getInput());

		} catch (Exception e) {
			System.out.println("L'ID dello Sponsor deve essere un INTERO");

		}

		System.out.println(
				"Inserisci il numero del campo che vuoi modificare: %n 1)Id del Luogo di Interesse %n  2) Nome Sponsor %n 3) Descrizione");
		int num = Integer.parseInt(getInput());
		String campo = "";

		if (num < 1 || num > 3) {
			System.out.println("Il numero scelto deve appartenere all'elenco");
			MainDispatcher.getInstance().callView("SponsorUpdate", null);
		} else {
			switch (num) {

			case 1:

				campo = "poi_id";
				break;

			case 2:

				campo = "name";
				break;

			case 3:

				campo = "description";
				break;
			}
		}

		System.out.println("Inserisci il nuovo valore");
		String newCampo = getInput();

		this.request = new Request();
		this.request.put("id", id);
		this.request.put("newCampo", newCampo);
		this.request.put("campo", campo);
		this.request.put("choice", "updateSponsor");
	}

	@Override
	public void showResults(Request request) {
		if (request != null) {

			List<Sponsor> listasponsor = (List<Sponsor>) request.get("listaSponsor");
			System.out.println("----- Modifica Sponsor-----");
			System.out.println();
			System.out.println();
			System.out.format(
					"+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
			System.out.format("%12s %20s %20s %30s %n", "1. ID SPONSOR", "2. ID POINT OF INTEREST", "3. NOME",
					"4. DESCRIZIONE");
			System.out.format(
					"+-----------------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");

			for (Sponsor sponsor : listasponsor) {
				// String leftAlignFormat ="| %-4s | %-9s | %-15s |%n";
				System.out.format("%12s %20s %20s %30s %n", sponsor.getId(), sponsor.getPoiID(), sponsor.getName(),
						sponsor.getDescription());
			}
			System.out.println();
		}

	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Sponsor", "doControl", this.request);
	}

}