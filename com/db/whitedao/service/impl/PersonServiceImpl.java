package com.db.whitedao.service.impl;

import com.db.whitedao.dao.PersonDAO;
import com.db.whitedao.dao.generic.DAOFactory;
import com.db.whitedao.model.Person;
import com.db.whitedao.service.PersonService;

import java.io.IOException;

public class PersonServiceImpl implements PersonService {
	private PersonDAO personDAO = DAOFactory.getPersonDao();

	@Override
	public Person get(Long id) throws IOException {
		Person person = personDAO.get(id);
		return person;
	}
}
