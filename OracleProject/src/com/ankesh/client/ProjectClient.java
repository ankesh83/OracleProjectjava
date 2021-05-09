package com.ankesh.client;


import java.util.List;
import com.ankesh.dao.Project;
import com.ankesh.impl.ProjectService;
import com.ankesh.impl.ProjectServiceImpl;
/*
 * Client class to execute java call
 */
public class ProjectClient {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ProjectService prj = new ProjectServiceImpl();
        List<Project> project_list = null;
        project_list = prj.createProjet();
		prj.contractcustomerno(project_list);
		prj.zonecustomer(project_list);
		prj.regionwise_build_avg(project_list);
		prj.getgeolist(project_list);
		
	}

}
