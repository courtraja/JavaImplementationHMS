package com.raja.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.raja.model.OrderDetails;
import com.raja.util.ConnectionUtil;

public class OrderDetailsDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(OrderDetails detail) {

		String sql = "insert into order_details(seat_no,order_id,price,statuss,ordered_date) values(?,?,?,?,?)";
		Object[] params = {detail.getSeatNumber(),detail.getOrderId(),detail.getPrice(),detail.getStatus(),detail.getOrderedDate()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
		}
	public void update(OrderDetails detail) {

		String sql = "update order_details set statuss=? where seat_no=?";
		Object[] params = {detail.getStatus(),detail.getSeatNumber()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
		}

	public void delete(OrderDetails detail) {

		String sql = "delete from order_details where order_id=?";
		Object[] params = {detail.getOrderId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
		}
	
	public List<OrderDetails> list()
	{
		String sql = "select * from order_details";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			OrderDetails order = new OrderDetails();
			order.setSeatNumber(rs.getInt("seat_no"));
			order.setOrderId(rs.getInt("order_id"));
			order.setPrice(rs.getInt("price"));
			order.setStatus(rs.getString("statuss"));
			order.setOrderedDate(rs.getTimestamp("ordered_date").toLocalDateTime());
			
			return order;
			
		});
	
}
}
