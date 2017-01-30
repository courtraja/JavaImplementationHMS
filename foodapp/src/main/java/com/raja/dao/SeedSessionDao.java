package com.raja.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.SeedSession;
import com.raja.util.ConnectionUtil;

public class SeedSessionDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(SeedSession session) {

		String sql = "insert into seed_session(id,sessions,from_time,to_time) values(?,?,?,?)";
		Object[] params = {session.getId(),session.getSessions(),session.getFromTime(),session.getToTime()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
		}
	public void update(SeedSession session) {

		String sql = "update seed_session set sessions=? where id=?";
		Object[] params = {session.getSessions(),session.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
		}

	public void delete(SeedSession session) {

		String sql = "delete from seed_session where id=?";
		Object[] params = {session.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
		}
	
	public List<SeedSession> list()
	{
		String sql = "select id,sessions,from_time,to_time from seed_session";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			SeedSession session = new SeedSession();
			session.setId(rs.getInt("id"));
			session.setSessions(rs.getString("sessions"));
			session.setFromTime(rs.getTime("from_time").toLocalTime());
			session.setToTime(rs.getTime("to_time").toLocalTime());
			return session;
			
		});
	}
}
