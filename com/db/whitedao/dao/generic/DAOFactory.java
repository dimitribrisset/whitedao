package com.db.whitedao.dao.generic;

import com.db.whitedao.dao.MonthDataDAO;
import com.db.whitedao.dao.PersonDAO;
import com.db.whitedao.dao.impl.MonthDataDAOImpl;
import com.db.whitedao.dao.impl.PersonDAOImpl;
import com.db.whitedao.model.Person;
import com.db.whitedao.model.impl.MonthDataContainer;
import com.googlecode.objectify.ObjectifyService;

public class DAOFactory {


	static {
		ObjectifyService.register(Person.class);
		ObjectifyService.register(MonthDataContainer.class);
	}

	private static PersonDAO personDao = null;
	private static MonthDataDAO monthDataDAO = null;

	private static final DAOFactory INSTANCE = new DAOFactory();


	public static PersonDAO getPersonDao() {
		if(INSTANCE.personDao == null){
			INSTANCE.personDao = new PersonDAOImpl();
		}
		return INSTANCE.personDao;
	}

	public static MonthDataDAO getMonthDataDAO() {
		if(INSTANCE.monthDataDAO == null) {
			INSTANCE.monthDataDAO = new MonthDataDAOImpl();
		}
		return INSTANCE.monthDataDAO;
	}
}
