package com.rh.ssh.model;

import java.io.Serializable;

public class TbProject implements Serializable {

	private Integer proId; // proId
	private String proName; // proName
	private String proIntro; // proIntro
	private Integer userId; // userId

	public Integer getProId() {
		return proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProIntro() {
		return proIntro;
	}

	public void setProIntro(String proIntro) {
		this.proIntro = proIntro;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}