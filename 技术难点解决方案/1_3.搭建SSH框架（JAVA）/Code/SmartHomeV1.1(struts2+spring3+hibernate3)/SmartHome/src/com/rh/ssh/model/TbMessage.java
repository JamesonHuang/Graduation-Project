package com.rh.ssh.model;

import java.io.Serializable;

public class TbMessage implements Serializable {

	private Integer messageId; // messageId
	private Integer messageTypeId; // messageTypeId
	private String messageCon; // messageCon

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public Integer getMessageTypeId() {
		return messageTypeId;
	}

	public void setMessageTypeId(Integer messageTypeId) {
		this.messageTypeId = messageTypeId;
	}

	public String getMessageCon() {
		return messageCon;
	}

	public void setMessageCon(String messageCon) {
		this.messageCon = messageCon;
	}
}