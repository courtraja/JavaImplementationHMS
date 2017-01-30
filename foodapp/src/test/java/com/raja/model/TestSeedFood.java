package com.raja.model;

import java.util.List;

import com.raja.dao.SeedFoodDao;

public class TestSeedFood {

	public static void main(String[] args) {
	SeedFoodDao food=new SeedFoodDao();
	SeedFood fd=new SeedFood();
	
	fd.setFooId(15);
	fd.setFoodName("chicken-fried-rice");
	fd.setFoodPrice(70);
	
	//food.delete(fd);

	List<SeedFood> list=food.list();
	for(SeedFood f:list)
	{
		System.out.println(f);
	}

	}

}
