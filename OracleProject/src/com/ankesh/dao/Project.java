package com.ankesh.dao;

/*
 * Project data class
 */
public class Project {
	private long customerID;
	private long contractID;
	private String project_name;
	private String team_name;
	private Region geozone;
	private int buildduration;
	
	public Project(long customerID, int contractID, String project_name, String team_name,
			Region geozone, int buildduration) {
		super();
		this.customerID = customerID;
		this.contractID = contractID;
		this.project_name = project_name;
		this.team_name = team_name;
		this.geozone = geozone;
		this.buildduration = buildduration;
	}
	
	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public long getContractID() {
		return contractID;
	}
	public void setContractID(long contractID) {
		this.contractID = contractID;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public Region getGeozone() {
		return geozone;
	}
	public void setGeozone(Region geozone) {
		this.geozone = geozone;
	}
	public int getBuildduration() {
		return buildduration;
	}
	public void setBuildduration(int buildduration) {
		this.buildduration = buildduration;
	}
	@Override
	public String toString() {
		return "Project [ customerID=" + customerID + ", contractID=" + contractID
				+ ", project_name=" + project_name + ", team_name=" + team_name + ", geozone=" + geozone
				+ ", buildduration=" + buildduration + "]";
	}
	
	
}
