package com.rh.ssh.model;

import java.io.Serializable;

public class TbProDetail implements Serializable {

	private Integer proDetailId; // proDetailId
	private String proDetailFromTask; // proDetailFromTask
	private String proDetailCon; // proDetailCon

	public Integer getProDetailId() {
		return proDetailId;
	}

	public void setProDetailId(Integer proDetailId) {
		this.proDetailId = proDetailId;
	}

	public String getProDetailFromTask() {
		return proDetailFromTask;
	}

	public void setProDetailFromTask(String proDetailFromTask) {
		this.proDetailFromTask = proDetailFromTask;
	}

	public String getProDetailCon() {
		return proDetailCon;
	}

	public void setProDetailCon(String proDetailCon) {
		this.proDetailCon = proDetailCon;
	}
}