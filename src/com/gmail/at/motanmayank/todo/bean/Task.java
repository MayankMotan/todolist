package com.gmail.at.motanmayank.todo.bean;

import java.util.Date;
// Bean, POJO, DTO
public class Task {

	private String taskName;
	private String projectName;
	private String status;
	private Date taskDate;

	public Task(String taskName, String projectName, String status, Date taskDate) {
		this.taskName = taskName;
		this.projectName = projectName;
		this.status = status;
		this.taskDate = taskDate;
	}

	public Task() {

	}

	/**
	 * @return The Task name.
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @return The Task Description
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return The Task Status
	 */
	public String getSatus() {
		return status;
	}

	/**
	 * @return the Task date
	 */
	public Date getTaskDate() {
		return taskDate;
	}

	/**
	 * @set/modify the Task satatus
	 */
	public void setStatus(String setStatus) {
		status = setStatus;
	}

	/**
	 * @set/modify the Task name
	 */
	public void setTaskName(String setTaskName) {
		taskName = setTaskName;
	}

	/**
	 * @set/modify the Task Description
	 */
	public void setProjectName(String setProjectName) {
		projectName = setProjectName;
	}

	/**
	 * @set/modify the Task Date
	 */
	public void setTaskDate(Date settaskDate) {
		taskDate = settaskDate;
	}

	@Override
	public String toString() {
		return "Task [taskName=" + taskName + ", projectName=" + projectName + ", status=" + status + ", taskDate="
				+ taskDate + "]";
	}

	
}
