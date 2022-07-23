package com.springrest.hibernate.OneToMany_Cascading;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProjectAssociation {
   
	
	@Id
	@Column(name="project_id")
	private int projectId;
	
	@Column(name="team_lead")
	private String teamLead;
		
    @OneToMany(mappedBy = "projectAssociation",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Employee> teamMembers;


	public ProjectAssociation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjectAssociation(int projectId, String teamLead, List<Employee> teamMembers) {
		super();
		this.projectId = projectId;
		this.teamLead = teamLead;
		this.teamMembers = teamMembers;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}

	public List<Employee> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(List<Employee> teamMembers) {
		this.teamMembers = teamMembers;
	}

	@Override
	public String toString() {
		return "ProjectAssociation [projectId=" + projectId + ", teamLead=" + teamLead + ", teamMembers=" + teamMembers
				+ "]";
	}
	
    
}
