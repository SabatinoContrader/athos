package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Sponsor;

public class SponsorDeleteView implements View {

	private Request request;

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("Inserire l'id dello Sponsor da eliminare");
		System.out.println("Id.>");
		int id = Integer.parseInt(getInput());
		this.request = new Request();
		this.request.put("deleteSponsor", id);
		this.request.put("choice", "deleteSponsor");

	}

	@Override
	public void showResults(Request request) {
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

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Sponsor", "doControl", this.request);
	}

}
