package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Sponsor;
import main.service.SponsorService;

public class SponsorController implements Controller {

	private String message;
	private SponsorService sponsorService;

	@Override
	public void doControl(Request request) {

		this.sponsorService = new SponsorService();
		String choice = request.get("choice").toString();
		this.message = "";

		switch (choice) {
		case "read":
			List<Sponsor> sponsor = sponsorService.getAllSponsor();
			request.put("listaSponsor", sponsor);
			MainDispatcher.getInstance().callView("SponsorRead", request);
			break;

		case "readSponsor":
			MainDispatcher.getInstance().callView("Sponsor", request);
			break;

		case "insert":
			MainDispatcher.getInstance().callView("SponsorInsert", request);
			break;

		case "insertDB":

			Sponsor newSponsor = new Sponsor();
			newSponsor = (Sponsor) request.get("newSponsor");
			if (sponsorService.insertSponsor(newSponsor)) {
				this.message = "Sponsor inserito con successo...";
			} else {
				this.message = "Errore durante l'inserimento del sponsor...!!!";
			}
			request.put("message", this.message);
			MainDispatcher.getInstance().callView("Sponsor", request);
			break;

		case "update":
			List<Sponsor> sponsor2 = sponsorService.getAllSponsor();
			request.put("listaSponsor", sponsor2);
			MainDispatcher.getInstance().callView("SponsorUpdate", request);
			break;

		case "updateSponsor":
			if (sponsorService.updateSponsor(request)) {
				this.message = "Sponsor modificato con successo...";
			} else {
				this.message = "Errore durante la modifica dello Sponsor!!!";
			}
			request.put("message", this.message);
			MainDispatcher.getInstance().callView("Sponsor", request);
			break;

		case "delete":
			List<Sponsor> sponsor3 = sponsorService.getAllSponsor();
			request.put("listaSponsor", sponsor3);
			MainDispatcher.getInstance().callView("SponsorDelete", request);
			break;

		case "deleteSponsor":
			if (this.sponsorService.deleteSponsor(Integer.parseInt(request.get("deleteSponsor").toString()))) {

				this.message = "Cancellazione Sponsor avvenuta correttamente";

			} else {
				this.message = "Errore durante la procedura di cancellazione sponsor";
			}
			request.put("message", this.message);

			MainDispatcher.getInstance().callView("Sponsor", request);
			break;

		case "return":
			MainDispatcher.getInstance().callView("HomeGamer", request);
			break;
		}

	}

}
