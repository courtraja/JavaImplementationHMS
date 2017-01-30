package com.raja.model;

import java.util.List;

import com.raja.dao.FoodTableDao;

public class TestFoodTable {

	public static void main(String[] args) {
		FoodTableDao TapDao=new FoodTableDao();
		FoodTable tab=new FoodTable();
		
		SeedFood sd=new SeedFood();
		sd.setFooId(15);
		
		SeedSession ss=new SeedSession();
		ss.setId(5);
		
		tab.setId(17);
		tab.setFooId(sd);
		tab.setSession(ss);
		tab.setQuantityOfFood(100);
		
		//TapDao.delete(tab);
		List<FoodTable> list=TapDao.list();
		for(FoodTable fd:list)
		{
			System.out.println(fd);
		}
		
		
	}

}
