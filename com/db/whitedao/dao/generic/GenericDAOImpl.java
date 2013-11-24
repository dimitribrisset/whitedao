package com.db.whitedao.dao.generic;


import com.google.common.collect.Lists;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class GenericDAOImpl<E extends IsEntity> {

	private final static Logger LOGGER = Logger.getLogger(GenericDAOImpl.class.getSimpleName());
	protected final static Objectify INSTANCE = ObjectifyService.ofy();

	private Class<E> clazz = null;

	protected GenericDAOImpl(final Class<E> clazz) {
		this.clazz = clazz;
	}

	protected List<E> genericList() {
		LOGGER.info("List : clazz=" + clazz.getSimpleName());
		return Lists.newArrayList(INSTANCE.load().type(clazz).list());
	}


	protected List<E> genericList(Collection<Long> ids) throws IOException {
		LOGGER.info("ListByIds : clazz=" + clazz.getSimpleName());
		return Lists.newArrayList(INSTANCE.load().type(clazz).ids(ids).values());
	}

	protected List<E> genericQueryByProperties(Map<String, Object> properties) {
		LOGGER.info("Query by property : clazz=" + clazz.getSimpleName());

		Query<E> query = INSTANCE.load().type(clazz);
		for (String property : properties.keySet()) {
			query = query.filter(property, properties.get(property));
		}
		return Lists.newArrayList(query.list());
	}

	protected E genericGet(Long id) throws NotFoundException, IOException {
		LOGGER.info("Get id : clazz=" + clazz.getSimpleName() + ", id=" + id);

		return INSTANCE.load().type(clazz).id(id).safe();
	}

	protected Long genericSave(E entity) throws IOException {
		LOGGER.info("Save : clazz=" + clazz.getSimpleName());
		final Key<E> key = INSTANCE.save().entity(entity).now();
		return key.getId();
	}

	protected List<E> genericSave(List<E> entities) throws IOException {
		LOGGER.info("SaveList : clazz=" + clazz.getSimpleName());
		final Map<Key<E>, E> now = INSTANCE.save().entities(entities).now();
		final List<E> values = Lists.newArrayList(now.values());
		return values;
	}


	protected void genericDelete(Long id) throws IOException {
		LOGGER.info("Delete : clazz=" + clazz.getSimpleName() + ", id=" + id);

		INSTANCE.delete().type(clazz).id(id).now();
	}


	protected void genericDelete(Collection<Long> ids) throws IOException {
		LOGGER.info("DeleteIds : clazz=" + clazz.getSimpleName() + ", ids=" + ids);

		INSTANCE.delete().type(clazz).ids(ids).now();
	}


}
