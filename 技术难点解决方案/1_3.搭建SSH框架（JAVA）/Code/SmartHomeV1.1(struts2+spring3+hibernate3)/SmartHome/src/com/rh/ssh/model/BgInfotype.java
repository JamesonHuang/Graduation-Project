package com.rh.ssh.model;

import java.io.Serializable;

public class BgInfotype implements Serializable {

	private Integer infoTypeId; // infoTypeId
	private String infoTypeName; // infoTypeName

	public Integer getInfoTypeId() {
		return infoTypeId;
	}

	public void setInfoTypeId(Integer infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

	public String getInfoTypeName() {
		return infoTypeName;
	}

	public void setInfoTypeName(String infoTypeName) {
		this.infoTypeName = infoTypeName;
	}
}