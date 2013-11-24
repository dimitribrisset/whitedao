package com.db.whitedao.model.impl;

import com.db.whitedao.dao.generic.IsEntity;
import com.db.whitedao.model.MonthData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.datastore.Text;
import com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.io.IOException;

@Entity
@Cache
public class MonthDataContainer implements IsEntity {
	@Id
	private Long id = null;
	private Text json = null;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public MonthData fromPersistence() throws IOException {

		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json.getValue(), MonthData.class);
	}

	public void toPersistence(MonthData monthData) throws IOException {
		id = monthData.getId();
		final ObjectMapper mapper = new ObjectMapper();
		json = new Text(mapper.writeValueAsString(monthData));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof MonthDataContainer) {
			final MonthDataContainer that = (MonthDataContainer) obj;
			return Objects.equal(id, that.id);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("json", json != null ? json.getValue() : "json null")
				.toString();
	}

}
