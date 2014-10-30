package com.rh.ssh.model;

import java.io.Serializable;
import java.util.Date;

public class BgInfo implements Serializable {

	private Integer infoId; // infoId
	private Integer adminId; // adminId
	private Integer infoTypeId; // infoTypeId
	private String infoCon; // infoCon
	private String infoTitle; // infoTitle
	private Date infoDate; // infoDate
	private Integer infoHits; // infoHits

	private Date infoDateBegin;
	private Date infoDateEnd;

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public Integer getInfoTypeId() {
		return infoTypeId;
	}

	public void setInfoTypeId(Integer infoTypeId) {
		this.infoTypeId = infoTypeId;
	}

	public String getInfoCon() {
		return infoCon;
	}

	public void setInfoCon(String infoCon) {
		this.infoCon = infoCon;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public Date getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(Date infoDate) {
		this.infoDate = infoDate;
	}

	public Integer getInfoHits() {
		return infoHits;
	}

	public void setInfoHits(Integer infoHits) {
		this.infoHits = infoHits;
	}

	public Date getInfoDateBegin() {
		return infoDateBegin;
	}

	public void setInfoDateBegin(Date infoDateBegin) {
		this.infoDateBegin = infoDateBegin;
	}

	public Date getInfoDateEnd() {
		return infoDateEnd;
	}

	public void setInfoDateEnd(Date infoDateEnd) {
		this.infoDateEnd = infoDateEnd;
	}
}