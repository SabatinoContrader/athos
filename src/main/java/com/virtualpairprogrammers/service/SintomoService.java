package com.virtualpairprogrammers.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.virtualpairprogrammers.dao.SintomoDAO;
import com.virtualpairprogrammers.model.Asset;
import com.virtualpairprogrammers.model.Sintomo;
import com.virtualpairprogrammers.servlets.Request;

public class SintomoService {
	
private SintomoDAO sintomoDAO;
	
	public SintomoService() {
        sintomoDAO = new SintomoDAO();
    }

	public List<Sintomo> getAllSympthom () {
        return this.sintomoDAO.getAllSympthom();
    }
	
	public boolean insertSypthom(Sintomo sintomo) {
		return this.sintomoDAO.insertSypthom(sintomo);
	}
	
	public boolean updateSypthom(HttpServletRequest request) {
		return this.sintomoDAO.updateSypthom(request); 
	}
	
	public boolean DeleteSintomo(int idSintomo) {
		return this.sintomoDAO.DeleteSintomo(idSintomo);
	}
	
	public boolean updateSympthom(int idSintomo) {
		return this.sintomoDAO.updateSympthom(idSintomo); 
	}
	
	public List<Sintomo> getSintomo(int id) {
        return this.sintomoDAO.getSintomo(id);
    }
	
}
