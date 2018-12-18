package main.controller;

import java.util.List;

import main.MainDispatcher;
import main.model.Label;
import main.service.LabelService;

public class LabelController implements Controller {

	private String message;
	private LabelService labelService;

	@Override
	public void doControl(Request request) {

		this.labelService = new LabelService();
		String choice = request.get("choice").toString();
		this.message = "";

		switch (choice) {
		case "read":
			List<Label> label = labelService.getAllLabel();
			request.put("listaLabel", label);
			MainDispatcher.getInstance().callView("LabelRead", request);
			break;

		case "readLabel":
			MainDispatcher.getInstance().callView("Label", request);
			break;

		case "insert":
			MainDispatcher.getInstance().callView("LabelInsert", request);
			break;

		case "insertDB":

			Label newLabel = new Label();
			newLabel = (Label) request.get("newLabel");
			if (labelService.insertLabel(newLabel)) {
				this.message = "Indovinello inserito con successo...";
			} else {
				this.message = "Errore durante l'inserimento dell'indovinello!!!";
			}
			request.put("message", this.message);
			MainDispatcher.getInstance().callView("Label", request);
			break;

		case "update":
			List<Label> label2 = labelService.getAllLabel();
			request.put("listaLabel", label2);
			MainDispatcher.getInstance().callView("LabelUpdate", request);
			break;

		case "updateLabel":
			if (labelService.updateLabel(request)) {
				this.message = "Indovinello modificato con successo...";
			} else {
				this.message = "Errore durante la modifica dell'indovinello!!!";
			}
			request.put("message", this.message);
			MainDispatcher.getInstance().callView("Label", request);
			break;

		case "delete":
			List<Label> label3 = labelService.getAllLabel();
			request.put("listaLabel", label3);
			MainDispatcher.getInstance().callView("LabelDelete", request);
			break;

		case "deleteLabel":
			if (this.labelService.deleteLabel(Integer.parseInt(request.get("deleteLabel").toString()))) {

				this.message = "Cancellazione indovinello avvenuta correttamente";

			} else {
				this.message = "Errore durante la procedura di cancellazione dell'indovinello";
			}
			request.put("message", this.message);

			MainDispatcher.getInstance().callView("Label", request);
			break;

		case "return":
			MainDispatcher.getInstance().callView("HomeGamer", request);
			break;
		}

	}

}
