package com.ankesh.dao;

import java.util.Comparator;
/*
 * compartor class to format customer data
 */
public class CustomerIDComparator implements Comparator<Project>{

	@Override
	public int compare(Project prj1, Project prj2) {
		if (prj1.getCustomerID() == prj2.getCustomerID())
            return 0;
        else if (prj1.getCustomerID() > prj2.getCustomerID())
            return 1;
        else
            return -1;
	}

}
