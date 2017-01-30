package com.raja.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.SeedFood;

import com.raja.util.ConnectionUtil;

public class SeedFoodDao {

JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(SeedFood food) {

		String sql = "insert into seed_food(foo_id,food_name,food_price) values(?,?,?)";
		Object[] params = {food.getFooId(), food.getFoodName(),food.getFoodPrice()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
		}
	public void update(SeedFood food) {

		String sql = "update seed_food set food_name=? where foo_id=?";
		Object[] params = {food.getFoodName(),food.getFooId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
		}

	public void delete(SeedFood food) {

		String sql = "delete from seed_food where foo_id=?";
		Object[] params = {food.getFooId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
		}
	public List<SeedFood> list()
	{
		String sql = "select * from seed_food";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			SeedFood food = new SeedFood();
			food.setFooId(rs.getInt("foo_id"));
			food.setFoodName(rs.getString("food_name"));
			food.setFoodPrice(rs.getInt("food_price"));
			
			return food;
			
		});
	
}
}
