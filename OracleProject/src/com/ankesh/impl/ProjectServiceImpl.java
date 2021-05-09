package com.ankesh.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ankesh.client.ProjectClient;
import com.ankesh.dao.CustomerIDComparator;
import com.ankesh.dao.Project;
import com.ankesh.dao.Region;
import com.ankesh.dao.ZoneComparator;
import com.ankesh.view.ProjectResultView;
/*
 * Service class with concrete code for sorting data
 */
public class ProjectServiceImpl implements ProjectService{
	/*
	 * (non-Javadoc)
	 * @see com.ankesh.impl.ProjectService#createProjet()
	 * create project list from csv data
	 */
	public List<Project> createProjet(){
		String input = null;
		Project proj = null;
		List<Project> projectlist = new ArrayList<>();
		InputStream inputstream = ProjectClient.class.getResourceAsStream("../../../com/ankesh/resources/project.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
        try {
			while ((input = reader.readLine()) != null) {
				String[] str1 = input.split("\\r?\\n|\\r");
				for(String str2 : str1){
					String[] str3 = str2.split(",");
					proj = new Project(Integer.parseInt(str3[0]),
							Integer.parseInt(str3[1]),
							str3[3],
							str3[4],
							Region.valueOf(str3[2]),
							Integer.parseInt(str3[5].substring(0,str3[5].length() - 1))
							);
					projectlist.add(proj);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return projectlist;
	}
	/*
	 * sort data on basis of Zone and Customer comparator to group
	 */
	private List<Project> formatdata(List<Project> proj_list){
		Collections.sort(proj_list,new ZoneComparator());
		Collections.sort(proj_list,new CustomerIDComparator());
		return proj_list;
	}
	/*
	 * method to find unique customer for each contractID
	 * @Param List<Project>
	 * 
	 */
	public void  zonecustomer(List<Project> project_list){
		ProjectResultView prj_view = new ProjectResultView();
		List<Project> sorted_list = formatdata(project_list);
		Map<Region, Integer> contractmap = new HashMap<>();
		
		long prev_customer = 0;
		for(Project prj : sorted_list){
			contractmap.put(prj.getGeozone(), contractmap.containsKey(prj.getGeozone()) ? prev_customer != prj.getCustomerID() ? (contractmap.get(prj.getGeozone()) + 1) : contractmap.get(prj.getGeozone()) : 1);	
			prev_customer = prj.getCustomerID();
		}
		prj_view.zonecustomerreport(contractmap);
	}
	/*
	 * (non-Javadoc)
	 * @see com.ankesh.impl.ProjectService#regionwise_build_avg(java.util.List)
	 * @Param List<Project>
	 * method to find zone wise build average.
	 * 
	 */
	public void regionwise_build_avg(List<Project> project_list){
		ProjectResultView prj_view = new ProjectResultView();
		List<Project> sorted_list = formatdata(project_list);
    	Map<Region, Double> avg_map = new HashMap<>();
    	Region geo = null;
    	int count  = 0;
    	for(Project prj : sorted_list){
    		if(avg_map.containsKey(prj.getGeozone()))
    			count++;
    		else if(geo != prj.getGeozone() && !avg_map.isEmpty()){
    			avg_map.put(geo,avg_map.get(geo)/count);
    			count = 1;
    		}
    			else
    				count = 1;
    			
      			
    		avg_map.put(prj.getGeozone(), avg_map.containsKey(prj.getGeozone()) ? avg_map.get(prj.getGeozone()) + prj.getBuildduration() : prj.getBuildduration());
    		geo = prj.getGeozone();
    	}
    	avg_map.put(geo,avg_map.get(geo)/count);
    	prj_view.zoneavgdurationreport(avg_map);
    }
	/*
	 * (non-Javadoc)
	 * @see com.ankesh.impl.ProjectService#getgeolist(java.util.List)
	 * @param List<Project>
	 * find customer list zone wise.
	 */
	public void getgeolist(List<Project> project_list){
		ProjectResultView prj_view = new ProjectResultView();
		List<Project> sorted_list = formatdata(project_list);
		Map<Region, List<Long>> geocustomer = new HashMap<>();
		List<Long> customer_list = new ArrayList<>();
		Region geo = null;
		for(Project prj : sorted_list){
			if(geo == prj.getGeozone()){
				customer_list.add(prj.getCustomerID());
			}else{
				customer_list = new ArrayList<>();
				customer_list.add(prj.getCustomerID());
			}
			geocustomer.put(prj.getGeozone(), customer_list);	
			geo = prj.getGeozone();
		}
		prj_view.zonecustomerlistreport(geocustomer);
	}
	/*
	 * (non-Javadoc)
	 * @see com.ankesh.impl.ProjectService#contractcustomerno(java.util.List)
	 * @param List<Project>
	 * find unique customer for each contract
	 */
	public void contractcustomerno(List<Project> project_list){
		ProjectResultView prj_view = new ProjectResultView();
		List<Project> sorted_list = formatdata(project_list);
		Map<Long, Integer> contractcusmap = new HashMap<>();
		Long contract = null;
		for(Project prj : sorted_list){
			contractcusmap.put(prj.getContractID(), contractcusmap.containsKey(prj.getContractID()) ? contract != prj.getCustomerID() ? (contractcusmap.get(prj.getContractID()) + 1) : contractcusmap.get(prj.getContractID()) : 1);	
			contract = prj.getContractID();
		}
		prj_view.contractcustomerreport(contractcusmap);
	}
}
