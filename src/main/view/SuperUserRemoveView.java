package main.view;

import java.util.ArrayList;
import java.util.Scanner;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;

public class SuperUserRemoveView implements View {
	
	ArrayList<User> listautenti;
	public int id;

	@Override
	public String getInput() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	@Override
	public void showOptions() {
		System.out.println("Inserire l'id del gamemaster da rimuovere:");
		this.id = Integer.parseInt(getInput());

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
		Request request=new Request();
		request.put("operazione", "rimozione");
		request.put("removegamer", this.id);
		MainDispatcher.getInstance().callAction("Super", "doControl", request);

	}

}
