package com.rh.ssh.model;

import java.io.Serializable;

public class TbTaskDetail implements Serializable {

	private Integer taskDetailId; // taskDetailId
	private String taskDetailFromTask; // taskDetailFromTask
	private String taskDetailCon; // taskDetailCon

	public Integer getTaskDetailId() {
		return taskDetailId;
	}

	public void setTaskDetailId(Integer taskDetailId) {
		this.taskDetailId = taskDetailId;
	}

	public String getTaskDetailFromTask() {
		return taskDetailFromTask;
	}

	public void setTaskDetailFromTask(String taskDetailFromTask) {
		this.taskDetailFromTask = taskDetailFromTask;
	}

	public String getTaskDetailCon() {
		return taskDetailCon;
	}

	public void setTaskDetailCon(String taskDetailCon) {
		this.taskDetailCon = taskDetailCon;
	}
}