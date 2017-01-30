package com.raja.model;

import java.util.List;

import com.raja.dao.MaxOrderDao;

public class TestMaxOrder {
	
	public static void main(String ars[]){

	MaxOrderDao maxorder=new MaxOrderDao();
	MaxOrder mx=new MaxOrder();
	mx.setId(2);
	mx.setOrderMax(10);
	maxorder.delete(mx);
	
	List<MaxOrder> list=maxorder.list();
	for(MaxOrder max:list)
	{
		System.out.println(max);
	}
	}
}
