package com.db.whitedao.service;

import com.db.whitedao.model.Person;

import java.io.IOException;

public interface PersonService {
	public Person get(Long id) throws IOException;
}
