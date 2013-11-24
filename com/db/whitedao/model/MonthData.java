package com.db.whitedao.model;

import com.db.whitedao.utils.Helper;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;

import java.util.Map;

public class MonthData {
	private Long id = Helper.randomId();
	private String name = null;
	private Long year = null;
	private Long month = null;
	private String description = null;
	private Map<Long, Amount> amounts = Maps.newHashMap();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}

	public Long getMonth() {
		return month;
	}

	public void setMonth(Long month) {
		this.month = month;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<Long, Amount> getAmounts() {
		return amounts;
	}

	public void setAmounts(Map<Long, Amount> amounts) {
		this.amounts.clear();
		this.amounts.putAll(amounts);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			final Person that = (Person) obj;
			return Objects.equal(getId(), that.getId());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", id)
				.add("name", name)
				.add("year", year)
				.add("month", month)
				.add("description", description)
				.add("amounts", amounts)
				.toString();
	}
}
