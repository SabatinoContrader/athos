
package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Label;
import main.service.LabelService;
import main.view.View;

public class LabelReadView implements View {
	private String mode = "";
	private String scelta1;
	private LabelService labelService;

	public LabelReadView() {
		this.labelService = new LabelService();

	}

	@Override
	public void showResults(Request request) {
		if (request != null) {
			
			List<Label> listalabel = (List<Label>) request.get("listaLabel");
			System.out.println("----- Visualizza Indovinelli-----");
	        System.out.println();
	        System.out.println();
	        System.out.format("+------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		    System.out.format("%12s %40s %80s %12s %n","1. ID INDOVINELLO","2. NOME","3. DESCRIZIONE", "4. ID GAME ASSOCIATO");
		    System.out.format("+------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		  		  		
	  		
	        for(Label label:listalabel){
	        	    //String leftAlignFormat ="| %-4s | %-9s | %-15s |%n";
	                System.out.format( "%12s %40s %80s %12s %n", label.getId() , label.getName(), label.getDescription(), label.getIdGame());
	            }	
	          System.out.println();
		}

	}

	@Override
	public void showOptions() {

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();

	}

	@Override
	public void submit() {
		Request requestType = new Request();
		requestType.put("choice", "readLabel");
		MainDispatcher.getInstance().callAction("Label", "doControl", requestType);

	}

}
