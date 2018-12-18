package main.controller;

import java.util.ArrayList;
import java.util.List;

import main.MainDispatcher;
import main.model.Poi;
import main.service.PoiService;

public class PoiController implements Controller{
	private String message;
	private PoiService poiService;

	@Override
	public void doControl(Request request) {

		this.poiService = new PoiService();
		String scelta = request.get("operazione").toString();
		this.message = "";

		switch (scelta) {
		case "visualizzapoi":
			ArrayList<Poi> poi = (ArrayList<Poi>) poiService.getAllPoi();
			request.put("listaPoi", poi);
			MainDispatcher.getInstance().callView("PoiRead", request);
			break;

		case "readPoi":
			MainDispatcher.getInstance().callView("Poi", request);
			break;
		
		
		case "insert":
			MainDispatcher.getInstance().callView("PoiInsert", request);
			break;

		case "insertDB":

			Poi newPoi = new Poi();
			newPoi = (Poi) request.get("newPoi");
			if (poiService.insertPoi(newPoi)) {
				this.message = "Point of interesting inserito con successo...";
			} else {
				this.message = "Errore durante l'inserimento del Point of interesting!!!";
			}
			request.put("message", this.message);
        	MainDispatcher.getInstance().callView("GestionePoi", null);
			break;

		case "update":
			List<Poi> poi2 = poiService.getAllPoi();
			request.put("listaPoi", poi2);
			MainDispatcher.getInstance().callView("PoiUpdate", request);
			break;

		/*case "updatePoi":		
			if (PoiService.updatePoi(request)) {
				this.message = "Point of interest modificato con successo...";
			} else {
				this.message = "Errore durante la modifica del Point of interest!!!";
			}
			request.put("message", this.message);
        	MainDispatcher.getInstance().callView("Poi", request);
        	break;
        	*/
        case "delete":
        	List<Poi> poi3 = poiService.getAllPoi();
			request.put("listaPoi", poi3);
			MainDispatcher.getInstance().callView("PoiDelete", request);
			break;
			
		case "deletePoi":
			if (this.poiService.deletePoi(Integer.parseInt(request.get("deletePoi").toString()))) {

				this.message = "Cancellazione Point of interesting avvenuta correttamente";

			} else {
				this.message = "Errore durante la procedura di cancellazione del Point of interesting";
			}
			request.put("message", this.message);

			MainDispatcher.getInstance().callView("Poi", request);
			break;
			
		case "return" :
			MainDispatcher.getInstance().callView("HomeGamer", request);
			break;
			
		default: break;
		}

	}


}

