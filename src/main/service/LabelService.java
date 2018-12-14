package main.service;

import java.util.List;

import main.controller.Request;
import main.dao.LabelDAO;
import main.model.Label;

public class LabelService {

	private LabelDAO labelDAO;

	public LabelService() {
		labelDAO = new LabelDAO();

	}

	public List<Label> getAllLabel() {
		return this.labelDAO.getAllLabel();

	}

	public boolean insertLabel(Label label) {
		return this.labelDAO.insertLabel(label);
	}

	public boolean updateLabel(Request request) {
		return this.labelDAO.updateLabel(request);
	}

	public boolean deleteLabel(int id) {
		return this.labelDAO.deleteLabel(id);

	}

}
