package com.ankesh.service;

import java.util.List;

import javax.sql.DataSource;

import com.ankesh.model.ContractCustomer;
import com.ankesh.model.Project;
import com.ankesh.model.ZoneBuildTime;
import com.ankesh.model.ZoneCustomer;
import com.ankesh.model.ZoneCustomerID;
import com.ankesh.model.ZoneCustomerResponse;

public interface ProjectService {
	/** 
     * This is the method to be used to initialize
     * database resources ie. connection.
  */
 // public void setDataSource(DataSource ds);
  
  /** 
     * This is the method to be used to create
     * a record in the Student table.
  */
  public void insertprojectdetail(List<Project> project_list);
  
  public List<ContractCustomer> getcustomercontract();
  public List<ZoneBuildTime> getzone_avg_buildtime();
  public List<ZoneCustomer> getzonecustomernum();
  public List<ZoneCustomerResponse> getzonecustomerlist();
}
