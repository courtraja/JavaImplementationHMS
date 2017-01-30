package com.raja.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.MaxOrder;
import com.raja.util.ConnectionUtil;

public class MaxOrderDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(MaxOrder max) {

		String sql = "insert into order_max(id,max_order) values(?,?)";
		Object[] params = {max.getId(),max.getOrderMax()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
		}
	public void update(MaxOrder max) {

		String sql = "update order_max set max_order=? where id=?";
		Object[] params = {max.getOrderMax(),max.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
		}

	public void delete(MaxOrder max) {

		String sql = "delete from order_max where id=?";
		Object[] params = {max.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
		}
	
	public List<MaxOrder> list()
	{
		String sql = "select * from order_max";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			MaxOrder max = new MaxOrder();
			max.setId(rs.getInt("id"));
			max.setOrderMax(rs.getInt("max_order"));
			
			return max;
			
		});
	
}
}
