package com.db.whitedao.dao;

import com.db.whitedao.model.MonthData;
import com.db.whitedao.model.Person;

import java.io.IOException;

public interface MonthDataDAO {
	public MonthData get(Long id) throws IOException;

	public void save(MonthData monthData) throws IOException;

	public void delete(MonthData monthData) throws IOException;
}
