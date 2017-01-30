package com.raja.model;

import java.time.LocalDateTime;
import java.util.List;

import com.raja.dao.OrderDetailsDao;

public class TestOrderDetails {
	
	public static void main(String args[]){
		OrderDetailsDao trans=new OrderDetailsDao();
		OrderDetails od=new OrderDetails();
		
		od.setSeatNumber(11);
		od.setOrderId(21);
		od.setPrice(100);
		od.setStatus("ordered");
		od.setOrderedDate(LocalDateTime.now());
		
		//trans.save(od);
		
		List<OrderDetails> list=trans.list();
		for(OrderDetails ord:list)
		{
			System.out.println(ord);
		}
	}

}
