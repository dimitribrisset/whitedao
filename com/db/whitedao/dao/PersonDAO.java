package com.db.whitedao.dao;

import com.db.whitedao.model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonDAO {
	public Person get(Long id) throws IOException;
	public void save(Person person) throws IOException;
	public List<Person> queryByBame(String name);
	public void delete(Person person) throws IOException;
	public void delete(List<Person> persons) throws IOException;
}
