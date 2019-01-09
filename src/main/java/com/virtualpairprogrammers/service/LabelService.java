package com.virtualpairprogrammers.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.dao.LabelDAO;
import com.virtualpairprogrammers.model.Label;
import com.virtualpairprogrammers.model.Sponsor;

public class LabelService {

	private LabelDAO labelDAO;

	public LabelService() {
		labelDAO = new LabelDAO();

	}

	public boolean deleteLabel(int id) {
		return this.labelDAO.deleteLabel(id);

	}

	public List<Label> getAllLabel() {
		return this.labelDAO.getAllLabel();

	}

	public boolean insertLabel(Label label) {
		return this.labelDAO.insertLabel(label);
	}

	public boolean updateLabel(HttpServletRequest request) {
		return this.labelDAO.updateLabel(request);
	}
	
	public List<Label> getLabel(long id) {
		return this.labelDAO.getLabel(id);

	}

}
