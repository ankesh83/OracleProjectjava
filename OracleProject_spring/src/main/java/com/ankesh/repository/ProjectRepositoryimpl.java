package com.ankesh.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ankesh.model.ContractCustomer;
import com.ankesh.model.Project;
import com.ankesh.model.Region;
import com.ankesh.model.ZoneBuildTime;
import com.ankesh.model.ZoneCustomer;
import com.ankesh.model.ZoneCustomerID;
import com.ankesh.server.main.exception.NotFoundException;

@Repository
public class ProjectRepositoryimpl implements ProjectRepository{
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	String sql = null;
	

	@Override
	public void create(List<Project> project_list) {
		String sql = "Insert into `project` (customerID,contractID,projectname,geoZone,teamname,buildduration) VALUES(?,?,?,?,?,?)";
		jdbcTemplateObject.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Project project_data = project_list.get(i);
				ps.setLong(1,project_data.getCustomerID());
				ps.setInt(2,project_data.getContractID());
				ps.setString(3,project_data.getProject_name());
				ps.setString(4,project_data.getGeozone());
				ps.setString(5,project_data.getTeam_name());
				ps.setInt(6,project_data.getBuildduration());
				
				
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return project_list.size();
			}
	    	
	    });		
	}

	@Override
	public List<ContractCustomer> getcustomercontract() {
		// TODO Auto-generated method stub
		 
		try {
		sql = "select contractID, count( distinct customerID) from project group by contractID";
		}
		catch (DataAccessException e)
		{
		    throw new NotFoundException("A problem occurred while retrieving my data");
		}
		return jdbcTemplateObject.query(sql, new ContractCustomerMapper());
	}

	@Override
	public List<ZoneBuildTime> getzone_avg_buildtime() {
		try {
			sql = "select geoZone, avg(buildduration) from project group by geoZone";
		}
		catch (DataAccessException e)
		{
		    throw new NotFoundException("A problem occurred while retrieving my data");
		}
		return jdbcTemplateObject.query(sql, new ZoneAvgBuilddurationMapper());
	}

	@Override
	public List<ZoneCustomer> getzonecustomernum() {
		try {
			sql = "select geoZone, count(distinct customerID) from project group by geoZone";
		}
		catch (DataAccessException e)
		{
		    throw new NotFoundException("A problem occurred while retrieving my data");
		}
		return jdbcTemplateObject.query(sql, new ZoneCustomerNoMapper());
	}

	@Override
	public List<ZoneCustomerID> getzonecustomerlist() {
		try {
			sql = "select distinct geoZone,customerID from project order by geoZone OFFSET 10";
		}
		catch (Exception e)
		{
		    throw new NotFoundException("A problem occurred while retrieving my data");
		}
		return jdbcTemplateObject.query(sql, new ZoneCustomerIDMapper());
	}
	private static final class ContractCustomerMapper implements RowMapper<ContractCustomer> {
	    public ContractCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	ContractCustomer contractcus = new ContractCustomer();
	    	contractcus.setContractID(rs.getLong(1));
	    	contractcus.setUniquecustomer(rs.getInt(2));
	    	return contractcus;
	    }
	  }
	private static final class ZoneAvgBuilddurationMapper implements RowMapper<ZoneBuildTime> {
	    public ZoneBuildTime mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	ZoneBuildTime zonebuildtime = new ZoneBuildTime();
	    	zonebuildtime.setGeozone(Region.valueOf(rs.getString(1)));
	    	zonebuildtime.setAvg_buildduration(rs.getDouble(2));
	    	return zonebuildtime;
	    }
	  }
	private static final class ZoneCustomerNoMapper implements RowMapper<ZoneCustomer> {
	    public ZoneCustomer mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	ZoneCustomer zonecustomer = new ZoneCustomer();
	    	zonecustomer.setGeozone(Region.valueOf(rs.getString(1)));
	    	zonecustomer.setUniquecustomerno(rs.getInt(2));
	    	return zonecustomer;
	    }
	  }
	private static final class ZoneCustomerIDMapper implements RowMapper<ZoneCustomerID> {
	    public ZoneCustomerID mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	ZoneCustomerID zonecustomerID = new ZoneCustomerID();
	    	zonecustomerID.setGeozone(Region.valueOf(rs.getString(1)));
	    	zonecustomerID.setCutomerID(rs.getLong(2));
	    	return zonecustomerID;
	    }
	  }

}
