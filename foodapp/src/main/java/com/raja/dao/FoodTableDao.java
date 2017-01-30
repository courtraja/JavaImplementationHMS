package com.raja.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.raja.model.FoodTable;
import com.raja.model.SeedFood;
import com.raja.model.SeedSession;
import com.raja.util.ConnectionUtil;

public class FoodTableDao {
     
	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(FoodTable foodtab) {

		String sql = "insert into food_table(s_id,foo_id,session_id,quantity_of_food) values(?,?,?,?)";
		Object[] params = {foodtab.getId(),foodtab.getFooId().getFooId(),foodtab.getSession().getId(),foodtab.getQuantityOfFood()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
		}
	public void update(FoodTable foodtab) {

		String sql = "update food_table set quantity_of_food=? where s_id=?";
		Object[] params = {foodtab.getQuantityOfFood(),foodtab.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
		}

	public void delete(FoodTable foodtab) {

		String sql = "delete from food_table where s_id=?";
		Object[] params = {foodtab.getId()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
		}
	
	public List<FoodTable> list()
	{
		String sql = "select * from food_table";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			FoodTable food = new FoodTable();
			SeedFood sd=new SeedFood();
			
		    SeedSession se=new SeedSession();
		    se.setId(rs.getInt("session_id"));
			sd.setFooId(rs.getInt("foo_id"));
			food.setId(rs.getInt("s_id"));
			food.setFooId(sd);
			food.setSession(se);
			food.setQuantityOfFood(rs.getInt("quantity_of_food"));
			
			
			return food;
			
		});
	
}
}
