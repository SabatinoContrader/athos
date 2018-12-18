package main.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Poi;
import main.service.PoiService;
import main.view.View;

public class PoiReadView implements View {
	private String mode = "";
	private String scelta1;
	ArrayList<Poi> listpoi;

	public PoiReadView() {
	}

	@Override
	public void showResults(Request request) {

			this.listpoi = (ArrayList<Poi>) request.get("listaPoi");
			System.out.println("----- Visualizza point of interests-----");
			System.out.println();
			System.out.println();
			for (Poi poi : listpoi) {

				System.out.println(poi.getCity());
				System.out.println(poi.getId());
				System.out.println(poi.getHistorycal());
			}
			System.out.println();


	}

	@Override
	public void showOptions() {
		System.out.println("Ora cosa vuoi Fare?");

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();

	}

	@Override
	public void submit() {

	}

}