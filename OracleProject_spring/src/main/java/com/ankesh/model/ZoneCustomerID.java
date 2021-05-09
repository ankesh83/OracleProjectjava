package com.ankesh.model;

import java.util.List;

public class ZoneCustomerID {
	private Region geozone;
	private Long cutomerid;
	
	public ZoneCustomerID() {
		
	}
	public ZoneCustomerID(Region geozone, Long cutomerid) {
		super();
		this.geozone = geozone;
		this.cutomerid = cutomerid;
	}
	public Region getGeozone() {
		return geozone;
	}
	public void setGeozone(Region geozone) {
		this.geozone = geozone;
	}
	public Long getCutomerID() {
		return cutomerid;
	}
	public void setCutomerID(Long cutomerid) {
		this.cutomerid = cutomerid;
	}
	
}
