package com.ankesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankesh.model.ContractCustomer;
import com.ankesh.model.Project;
import com.ankesh.model.ZoneBuildTime;
import com.ankesh.model.ZoneCustomer;
import com.ankesh.model.ZoneCustomerID;
import com.ankesh.model.ZoneCustomerResponse;
import com.ankesh.service.ProjectServiceImpl;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectServiceImpl projectservice;
	
	@PostMapping(path = "/add")
	public ResponseEntity<Object> postProjectDetail(@RequestBody List<Project> project_list) {
		projectservice.insertprojectdetail(project_list);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}
	@GetMapping(path = "/contractuniquecustomer")
	public List<ContractCustomer> getcustomercontract() throws Exception{
		return projectservice.getcustomercontract();
	}
	@GetMapping(path = "/zoneavgtime")
	public List<ZoneBuildTime> getzone_avg_buildtime() throws Exception{
		return projectservice.getzone_avg_buildtime();
	}
	@GetMapping(path = "/zonecustomerno")
	public List<ZoneCustomer> getzonecustomernum() throws Exception{
		return projectservice.getzonecustomernum();
	}
	@GetMapping(path = "/zonecustomerid")
	public List<ZoneCustomerResponse> getzonecustomerlist() throws Exception{
		return projectservice.getzonecustomerlist();
	}
	
}
