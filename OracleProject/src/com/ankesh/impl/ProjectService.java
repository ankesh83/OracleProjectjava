package com.ankesh.impl;

import java.util.List;

import com.ankesh.dao.Project;

public interface ProjectService {
	public List<Project> createProjet();
	public void zonecustomer(List<Project> project_list);
	public void regionwise_build_avg(List<Project> project_list);
	public void getgeolist(List<Project> project_list);
	public void contractcustomerno(List<Project> project_list);
}
