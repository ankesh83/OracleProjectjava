package com.ankesh.model;



public class Project {
	private long customerID;
	private int contractID;
	private String project_name;
	private String team_name;
	private String geozone;
	private int buildduration;
	
	public Project(long customerID, int contractID, String project_name, String team_name,
			String geozone, int buildduration) {
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
	public int getContractID() {
		return contractID;
	}
	public void setContractID(int contractID) {
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
	public String getGeozone() {
		return geozone;
	}
	public void setGeozone(String geozone) {
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
