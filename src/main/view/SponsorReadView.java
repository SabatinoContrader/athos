
package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Sponsor;
import main.service.SponsorService;

public class SponsorReadView implements View {
	private String mode = "";
	private String scelta1;
	private SponsorService sponsorService;

	public SponsorReadView() {
		this.sponsorService = new SponsorService();

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();

	}

	@Override
	public void showOptions() {

	}

	@Override
	public void showResults(Request request) {
		if (request != null) {

			List<Sponsor> listasponsor = (List<Sponsor>) request.get("listaSponsor");
			System.out.println("----- Visualizza Sponsor-----");
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
		Request requestType = new Request();
		requestType.put("choice", "readSponsor");
		MainDispatcher.getInstance().callAction("Sponsor", "doControl", requestType);

	}

}
