package com.rh.ssh.model;

import java.io.Serializable;

public class TbDevice implements Serializable {

	private Integer deviceId; // deviceId
	private String deviceName; // deviceName
	private Integer userId; // userId
	private Integer deviceKey; // deviceKey
	private Short isOnline; // isOnline

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(Integer deviceKey) {
		this.deviceKey = deviceKey;
	}

	public Short getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Short isOnline) {
		this.isOnline = isOnline;
	}
}