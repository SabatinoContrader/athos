package main.view;

import java.util.Scanner;
import main.MainDispatcher;
import main.controller.Request;

public class HomeSuperView implements View {
	
	   public void showResults (Request request) {

	    }

	    public void showOptions () {
	    	 System.out.println("CIAOOOOOOOOOOOOOOOOO");
	    }
	    
	    public void submit() {
	     
	    }
	    
	    public String getInput () {
	    	 Scanner scanner = new Scanner(System.in);
	         return scanner.nextLine();
	    }
	}



