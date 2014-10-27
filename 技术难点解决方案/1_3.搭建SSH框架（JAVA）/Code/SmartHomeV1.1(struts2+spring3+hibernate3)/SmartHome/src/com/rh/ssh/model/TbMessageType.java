package com.rh.ssh.model;

import java.io.Serializable;

public class TbMessageType implements Serializable {

	private Integer messageTypeId; // messageTypeId
	private String messageTypeName; // messageTypeName

	public Integer getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(Integer messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getMessageTypeName() {
		return messageTypeName;
	}

	public void setMessageTypeName(String messageTypeName) {
		this.messageTypeName = messageTypeName;
	}
}