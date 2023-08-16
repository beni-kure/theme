package model;

import java.util.List;

import dao.SearchDAO;

public class ChangeLogic {
	@SuppressWarnings("rawtypes")
	public List execute(BasicInfo basicinfo){
		SearchDAO dao=new SearchDAO();
		List List=dao.aList(basicinfo);
		return List;
	}
}
