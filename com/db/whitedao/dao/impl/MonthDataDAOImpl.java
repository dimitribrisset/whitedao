package com.db.whitedao.dao.impl;

import com.db.whitedao.dao.MonthDataDAO;
import com.db.whitedao.dao.generic.GenericDAOImpl;
import com.db.whitedao.model.MonthData;
import com.db.whitedao.model.impl.MonthDataContainer;

import java.io.IOException;

public class MonthDataDAOImpl extends GenericDAOImpl<MonthDataContainer> implements MonthDataDAO {
	public MonthDataDAOImpl() {
		super(MonthDataContainer.class);
	}

	@Override
	public MonthData get(Long id) throws IOException {
		return super.genericGet(id).fromPersistence();
	}

	@Override
	public void save(MonthData monthData) throws IOException {
		final MonthDataContainer monthDataContainer = new MonthDataContainer();
		monthDataContainer.toPersistence(monthData);
		super.genericSave(monthDataContainer);
	}

	@Override
	public void delete(MonthData monthData) throws IOException {
		super.genericDelete(monthData.getId());
	}
}
