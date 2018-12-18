package main.view;

import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Poi;
import main.service.PoiService;

public class PoiInsertView implements View {

	private Request request;

	@Override
	public void showResults(Request request) {

		this.request = request;

	}

	@Override
	public void showOptions() {
	
		System.out.println ("Inserisci nuovo point of interes");
		System.out.println(" City point of interest: ");
		String city = getInput();
		System.out.println (" Hystorical : ");
		String hystorical = getInput();
		Poi insertPoi = new Poi ();
		insertPoi.setCity(city);
		insertPoi.setHistorycal(hystorical);
		request = new Request () ;
		this.request.put("newPoi", insertPoi);
		this.request.put("operazione", "insertDB");			
	}

	@Override
	public String getInput() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}

	@Override
	public void submit() {
		
		MainDispatcher.getInstance().callAction("Poi", "doControl", this.request);

	}

}