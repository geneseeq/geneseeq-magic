package com.geneseeq.common.pojo.doctor;

import java.io.Serializable;

public class DoctorResponseVO implements Serializable {

	private static final long serialVersionUID = -8230254920955269614L;

	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
