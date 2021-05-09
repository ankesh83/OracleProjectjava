package com.ankesh.dao;

import java.util.Comparator;
/*
 * comparator class to format zone data.
 */
public class ZoneComparator implements Comparator<Project>{

	@Override
	public int compare(Project prj1, Project prj2) {
		 return prj1.getGeozone().compareTo(prj2.getGeozone());
	}

}
