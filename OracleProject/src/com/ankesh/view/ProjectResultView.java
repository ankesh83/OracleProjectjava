package com.ankesh.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ankesh.dao.Project;
import com.ankesh.dao.Region;
/*
 * Class is for presenting data in formatted version for undersatnding.
 */

public class ProjectResultView {
	public void projectreport(List<Project> project_list){
		System.out.println("-----------------------------------------------------------------------------");
	    System.out.printf("%10s %20s %20s %10s %10s %10s", "CUSTOMER_ID", "CONTRACT_ID", "PROJECT_CODE", "TEAM_CODE", "GEO_ZONE", "BUILD_DURATION");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------");
	    		for(Project prj : project_list){
	    			System.out.format("%10d %20s %20s %10s %10s %10d",
	    					prj.getCustomerID(), prj.getContractID(), prj.getProject_name(), prj.getTeam_name(), prj.getGeozone(),prj.getBuildduration());
	    	        System.out.println();
			
		}
	}
	public void zonecustomerreport(Map<Region, Integer> contractmap){
		System.out.println("-----------------------------------------");
	    System.out.printf("%10s %20s", "GEO_ZONE", "UNIQUE_CUSTOMER_ID");
	    System.out.println();
	    System.out.println("-----------------------------------------");
	    
		Iterator<Map.Entry<Region, Integer>> itr = contractmap.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Region, Integer> entry = itr.next();
			System.out.format("%10s %10s", entry.getKey(), entry.getValue());
	        System.out.println();
		}
	}
	public void zoneavgdurationreport(Map<Region, Double> avg_map){
		System.out.println("-----------------------------------------");
	    System.out.printf("%10s %20s", "GEO_ZONE", "Average_build_time");
	    System.out.println();
	    System.out.println("-----------------------------------------");
	    
		Iterator<Map.Entry<Region, Double>> itr = avg_map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Region, Double> entry = itr.next();
			System.out.format("%10s %10s", entry.getKey(), entry.getValue());
	        System.out.println();
		}
	}
	public void contractcustomerreport(Map<Long, Integer> contractcusmap){
		System.out.println("-----------------------------------------");
	    System.out.printf("%10s %20s", "CONTRACTID", "CUSTOMER_NO");
	    System.out.println();
	    System.out.println("-----------------------------------------");
	    
		Iterator<Map.Entry<Long, Integer>> itr3 = contractcusmap.entrySet().iterator();
		while(itr3.hasNext()){
			Map.Entry<Long, Integer> entry = itr3.next();
			System.out.format("%10s %20s", entry.getKey(), entry.getValue());
	        System.out.println();
		}
	}
	public void zonecustomerlistreport(Map<Region, List<Long>> geolistmap){
		System.out.println("-----------------------------------------");
	    System.out.printf("%10s %20s", "GEO_ZONE", "customer_list");
	    System.out.println();
	    System.out.println("-----------------------------------------");
		Iterator<Map.Entry<Region, List<Long>>> itr2 = geolistmap.entrySet().iterator();
		while(itr2.hasNext()){
			Map.Entry<Region, List<Long>> entry = itr2.next();
			System.out.format("%10s %10s", entry.getKey(), entry.getValue());
	        System.out.println();
		}
	}
}
