package main.view.BotMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.BotMessage;
import main.service.BotMessageService;
import main.service.GommaService;
import main.view.View;

public class SelectBotMessageView implements View {

	    private BotMessageService botMessageService;
	    private String mode;

	  public SelectBotMessageView () {
	      this.botMessageService = new BotMessageService();
	      this.mode = "all";
	  }

	    @Override
	    public void showResults(Request request) {
	       this.mode  = (String) request.get("mode");
	    }

	    @Override
	    public void showOptions() {
	        switch (mode) {
	            case "all":
	                List<BotMessage> botMessage = botMessageService.getAllBotMessage();
	                System.out.println("----- BotMessage disponibili -----");
	                System.out.println();
	                botMessage.forEach(botMesssage -> System.out.println(botMesssage.getBotMessageId()+" : "+ botMesssage.getBotMessage()));
	                break;
	           
	        }
	    }

	    @Override
	    public String getInput() {
	        Scanner scanner = new Scanner(System.in);
	        return scanner.nextLine();
	  }

	    @Override
	    public void submit() {
	        MainDispatcher.getInstance().callAction("Home", "doControl", null);
	    }



	}


