package com.raja.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.FoodOrdered;
import com.raja.util.ConnectionUtil;

public class FoodOrderedDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(FoodOrdered order) {

		String sql = "insert into food_ordered(order_id,food_name,quantity,price) values(?,?,?,?)";
		Object[] params = {order.getOrderId(),order.getFoodName(),order.getQuantity(),order.getPrice()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
		}
	public void update(FoodOrdered order) {

		String sql = "update food_ordered set quantity=? where order_id=?";
		Object[] params = {order.getQuantity(),order.getOrderId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
		}

	public void delete(FoodOrdered order) {

		String sql = "delete from food_ordered where order_id=?";
		Object[] params = {order.getOrderId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
		}
	
	public List<FoodOrdered> list()
	{
		String sql = "select * from food_ordered";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			FoodOrdered order = new FoodOrdered();
			
			
		    
			order.setOrderId(rs.getInt("order_id"));
			order.setFoodName(rs.getString("food_name"));
			order.setQuantity(rs.getInt("quantity"));
			
			order.setPrice(rs.getInt("price"));
			
			
			return order;
			
		});
	
}
}
