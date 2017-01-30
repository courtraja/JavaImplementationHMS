package com.raja.model;

import com.raja.dao.PayBillProcedure;

public class TestPayBillProcedure {

	public static void main(String[] args) {
		PayBillProcedure app=new PayBillProcedure();
		String status =app.PayBill(1,19,"@message"); 
	    System.out.println(status);

	}

}
