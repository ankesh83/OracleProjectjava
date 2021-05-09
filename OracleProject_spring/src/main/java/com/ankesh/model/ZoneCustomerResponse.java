package com.ankesh.model;

import java.util.List;

public class ZoneCustomerResponse {
	private Region geoZone;
	private List<Long> customeridlist;
	public Region getGeoZone() {
		return geoZone;
	}
	public void setGeoZone(Region geoZone) {
		this.geoZone = geoZone;
	}
	public List<Long> getCustomeridlist() {
		return customeridlist;
	}
	public void setCustomeridlist(List<Long> customeridlist) {
		this.customeridlist = customeridlist;
	}
	
	
}
