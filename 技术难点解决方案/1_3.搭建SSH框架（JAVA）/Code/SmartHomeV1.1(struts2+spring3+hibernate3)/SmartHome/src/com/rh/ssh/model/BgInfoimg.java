package com.rh.ssh.model;

import java.io.Serializable;

public class BgInfoimg implements Serializable {

	private Integer infoImgId; // infoImgId
	private Integer infoId; // infoId
	private String infoImgName; // infoImgName
	private String infoImgPath; // infoImgPath

	public Integer getInfoImgId() {
		return infoImgId;
	}

	public void setInfoImgId(Integer infoImgId) {
		this.infoImgId = infoImgId;
	}

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getInfoImgName() {
		return infoImgName;
	}

	public void setInfoImgName(String infoImgName) {
		this.infoImgName = infoImgName;
	}

	public String getInfoImgPath() {
		return infoImgPath;
	}

	public void setInfoImgPath(String infoImgPath) {
		this.infoImgPath = infoImgPath;
	}
}