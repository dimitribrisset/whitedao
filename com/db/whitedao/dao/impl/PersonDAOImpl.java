package com.db.whitedao.dao.impl;

import com.db.whitedao.dao.PersonDAO;
import com.db.whitedao.dao.generic.GenericDAOImpl;
import com.db.whitedao.model.Person;
import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PersonDAOImpl extends GenericDAOImpl<Person> implements PersonDAO {

	private final Function<Person, Long> personsToIds = new Function<Person, Long>() {
		@Override
		public Long apply(Person input) {
			return input.getId();
		}
	};

	public PersonDAOImpl() {
		super(Person.class);
	}

	@Override
	public Person get(Long id) throws IOException {
		return super.genericGet(id);
	}

	@Override
	public void save(Person person) throws IOException {
		super.genericSave(person);
	}

	@Override
	public List<Person> queryByBame(String name) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("name", name);
		return super.genericQueryByProperties(params);
	}

	@Override
	public void delete(Person person) throws IOException {
		super.genericDelete(person.getId());
	}

	@Override
	public void delete(List<Person> persons) throws IOException {
		super.genericDelete(Collections2.transform(persons, personsToIds));
	}
}
