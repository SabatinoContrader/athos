package main.view;

import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Poi;

public class PoiUpdateView implements View {
	
	private Request request;
	

	@Override
	public void showResults(Request request) {
		if(request != null ){	 

			List<Poi> listaPoi = (List<Poi>) request.get("listaPoi");
			System.out.println("----- Visualizza Point of interest-----");
	        System.out.println();
	        System.out.println();
	        System.out.format("+------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		    System.out.format("%12s %40s %80s %12s %n","1. ID","2. CITY","3. HYSTORICAL");
		    System.out.format("+------------------------------------------------------------------------------------------------------------------------------------------------+%n");
		  		  		
	  		
	        for(Poi poi:listaPoi){
	        	    //String leftAlignFormat ="| %-4s | %-9s | %-15s |%n";
	                System.out.format( "%12s %40s %80s %12s %n", poi.getId() , poi.getCity(), poi.getHistorycal());
	            }	
	          System.out.println();
	       }

	}

	@Override
	public void showOptions() {
		int id = 0;
		try {
			
			System.out.println("Inserisci l'id del point of interest che vuoi modificare.> ");
		    id= Integer.parseInt(getInput());

		} catch (Exception e) {
			System.out.println("L'ID del point of interest deve essere un INTERO");

		}
		
		System.out.println("Inserisci il numero del campo che vuoi modificare: 1) City 2) Hystorical");
		int num= Integer.parseInt(getInput());
		String campo="";
		
		if(num < 1 || num > 2) {
			System.out.println("Il numero scelto deve appartenere all'elenco");
            MainDispatcher.getInstance().callView("PoiUpdate", null);
		}
		else {
			switch(num){
					
				case 1: 
					
					campo = "city";
					break;
					
				case 2: 
					
					campo = "hystorical";
					break;
				
			}
		}
		
		System.out.println("Inserisci il nuovo valore");
		String newCampo = getInput();
		
		this.request = new Request();
		this.request.put("id", id);
		this.request.put("newCampo", newCampo);
		this.request.put("campo", campo);
		this.request.put("choice", "updatePoi");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		MainDispatcher.getInstance().callAction("Poi", "doControl", this.request);
	}

}
