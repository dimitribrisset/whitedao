package com.db.whitedao.model;

import com.db.whitedao.utils.Helper;
import com.google.common.base.Objects;

public class Amount {
	private Long id = Helper.randomId();
	private String name = null;
	private String value = null;
	private String recipient = null;

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Amount) {
			final Amount that = (Amount) obj;
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
				.add("name", name)
				.toString();
	}
}
