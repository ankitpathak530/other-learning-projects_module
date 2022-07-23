package com.springrest.hibernate.OneToMany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {
    
	
	@Id
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_client")
	private String projectClient;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projectName, String projectClient) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectClient = projectClient;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectClient() {
		return projectClient;
	}

	public void setProjectClient(String projectClient) {
		this.projectClient = projectClient;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectClient=" + projectClient
				+ "]";
	}

}
