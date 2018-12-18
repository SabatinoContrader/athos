package main.view;

import java.util.ArrayList;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
import sun.applet.Main;

public class SuperUserModifyView implements View {
	
	ArrayList<User> listautenti = new ArrayList<User>();
	int id;
	String password;
	
	@Override
	public String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire id del gamemaster da modificare:");
		this.id = Integer.parseInt(getInput());
		System.out.println("Inserire la nuova password");
		this.password=getInput();

	}

	@Override
	public void showResults(Request request) {
		System.out.println("Quale gamemaster vuoi rimuovere Admin?");
		this.listautenti = (ArrayList<User>) request.get("listautenti");
		System.out.println("_________________Lista GameMaster:___________________");
		for (User gamemaster : this.listautenti) {
			System.out.println("\n" + "______GameMaster" + gamemaster.getId() + "_________" + "\n" + "UserName: "
					+ gamemaster.getUsername() + "\n" + "Password: " + gamemaster.getPassword() + "\n" + "Ruolo: "
					+ gamemaster.getRole() + "\n");
		}

	}

	@Override
	public void submit() {
		Request request = new Request();
		request.put("operazione", "modifica");
		request.put("idmodificare", this.id);
		request.put("nuovapassword", this.password);
		MainDispatcher.getInstance().callAction("Super", "doControl", request);

	}

}
