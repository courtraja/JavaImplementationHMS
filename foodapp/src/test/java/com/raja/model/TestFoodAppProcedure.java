package com.raja.model;

import com.raja.dao.FoodAppProcedure;

public class TestFoodAppProcedure {
	public static void main(String args[]){
	FoodAppProcedure app=new FoodAppProcedure();
	String status =app.hms("idly,vada","2,3",1,2,19,"@message"); 
    System.out.println(status);
}
}
