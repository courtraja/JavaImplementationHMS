package com.raja.model;

import com.raja.dao.CancelOrderProcedure;

public class TestCancelOrderProcedure {

	public static void main(String args[]){
		CancelOrderProcedure app=new CancelOrderProcedure();
		String status =app.CancelOrder(1,19,"@message"); 
	    System.out.println(status);
	}
}
