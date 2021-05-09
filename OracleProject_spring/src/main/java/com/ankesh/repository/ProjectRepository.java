package com.ankesh.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ankesh.model.ContractCustomer;
import com.ankesh.model.Project;
import com.ankesh.model.ZoneBuildTime;
import com.ankesh.model.ZoneCustomer;
import com.ankesh.model.ZoneCustomerID;

public interface ProjectRepository {
	
  public void create(List<Project> project_list); 
  public List<ContractCustomer> getcustomercontract();
  public List<ZoneBuildTime> getzone_avg_buildtime();
  public List<ZoneCustomer> getzonecustomernum();
  public List<ZoneCustomerID> getzonecustomerlist();
}


