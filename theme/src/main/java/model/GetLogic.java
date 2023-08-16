package model;

import java.util.List;

import dao.SearchDAO;

public class GetLogic {
@SuppressWarnings("rawtypes")
public List[] execute(BasicInfo basicinfo){
	SearchDAO dao=new SearchDAO();
	List[] List=dao.findByInfo(basicinfo);
	return List;
}
}
