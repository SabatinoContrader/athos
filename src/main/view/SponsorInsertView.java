package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Sponsor;
import main.service.SponsorService;

public class SponsorInsertView implements View {

	private Request request;

	@Override
	public void showResults(Request request) {

		this.request = request;

	}

	@Override
	public void showOptions() {
	
		System.out.println ("Inserisci nuovo sponsor");
		System.out.println (" Id luogo di interesse : ");
		int idPoi = Integer.parseInt(getInput());
		System.out.println(" Nome Sponsor: ");
		String nome = getInput();
		System.out.println (" Descrizione : ");
		String descrizione = getInput();
		Sponsor insertSponsor = new Sponsor ();
		insertSponsor.setPoiID(idPoi);
		insertSponsor.setName(nome);
		insertSponsor.setDescription(descrizione);
		request = new Request () ;
		this.request.put("newSponsor", insertSponsor);
		this.request.put("choice", "insertDB");			
	}

	@Override
	public String getInput() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	@Override
	public void submit() {
		
		MainDispatcher.getInstance().callAction("Sponsor", "doControl", this.request);

	}

}
