package com.raja.model;

import java.util.List;

import com.raja.dao.FoodOrderedDao;

public abstract class TestFoodOrdered {

	public static void main(String[] args) {
		FoodOrderedDao ordered=new FoodOrderedDao();
		FoodOrdered fd=new FoodOrdered();
		
		fd.setOrderId(5);
		fd.setFoodName("chicken-rice");
		fd.setQuantity(10);
		fd.setPrice(70);
		
		//ordered.delete(fd);
		
		List<FoodOrdered> list=ordered.list();
		for(FoodOrdered od:list)
		{
			System.out.println(od);
		}
		
	}

}
