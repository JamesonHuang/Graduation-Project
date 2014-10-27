package com.rh.ssh.model;

import java.io.Serializable;

public class TbTask implements Serializable {

	private Integer taskId; // taskId
	private String taskName; // taskName
	private String taskType; // taskType
	private String taskFromPro; // taskFromPro
	private String taskFromTask; // taskFromTask
	private String taskDate; // taskDate
	private String taskTomatoesCount; // taskTomatoesCount

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getTaskFromPro() {
		return taskFromPro;
	}

	public void setTaskFromPro(String taskFromPro) {
		this.taskFromPro = taskFromPro;
	}

	public String getTaskFromTask() {
		return taskFromTask;
	}

	public void setTaskFromTask(String taskFromTask) {
		this.taskFromTask = taskFromTask;
	}

	public String getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}

	public String getTaskTomatoesCount() {
		return taskTomatoesCount;
	}

	public void setTaskTomatoesCount(String taskTomatoesCount) {
		this.taskTomatoesCount = taskTomatoesCount;
	}
}