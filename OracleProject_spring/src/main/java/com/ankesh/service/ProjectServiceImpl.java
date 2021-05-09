package com.ankesh.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ankesh.model.ContractCustomer;
import com.ankesh.model.Project;
import com.ankesh.model.Region;
import com.ankesh.model.ZoneBuildTime;
import com.ankesh.model.ZoneCustomer;
import com.ankesh.model.ZoneCustomerID;
import com.ankesh.model.ZoneCustomerResponse;
import com.ankesh.repository.ProjectRepository;

@Service
@Component
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectRepository projectrepo;
	
	
	
	
	
	@Override
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertprojectdetail(List<Project> project_list) {
		projectrepo.create(project_list);
	}
	@Override
	public List<ContractCustomer> getcustomercontract(){
		return projectrepo.getcustomercontract();
	}
	@Override
	public List<ZoneBuildTime> getzone_avg_buildtime(){
		return projectrepo.getzone_avg_buildtime();
	}
	@Override
	public List<ZoneCustomer> getzonecustomernum(){
		return projectrepo.getzonecustomernum();
	}
	@Override
	public List<ZoneCustomerResponse> getzonecustomerlist(){
		List<Long> cuslist = new ArrayList<>();;
		List<ZoneCustomerID> zonecusID = new ArrayList<>();
		ZoneCustomerResponse cusres = new ZoneCustomerResponse();
		List<ZoneCustomerResponse> zonecusresponse = new ArrayList<>(); 
		zonecusID =  projectrepo.getzonecustomerlist();
		Region geo = null;
		for(ZoneCustomerID zonecustlist : zonecusID){
			if(geo == zonecustlist.getGeozone() && geo != null){
				cuslist.add(zonecustlist.getCutomerID());
			}else{
				if(geo != null) {
					cusres.setCustomeridlist(cuslist);
					zonecusresponse.add(cusres); 
					cusres = new ZoneCustomerResponse();
					cuslist = new ArrayList<>();
				}
				
				cuslist.add(zonecustlist.getCutomerID());
				cusres.setGeoZone(zonecustlist.getGeozone());
			}
			geo = zonecustlist.getGeozone();
		}
		if(!zonecusID.isEmpty()) {
			cusres.setCustomeridlist(cuslist);
		zonecusresponse.add(cusres);
		}
		return zonecusresponse;
	}
	
	
}
 