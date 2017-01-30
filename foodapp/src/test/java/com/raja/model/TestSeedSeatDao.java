package com.raja.model;

import java.util.List;

import com.raja.dao.SeedSeatDao;

public class TestSeedSeatDao {
  public static void main(String[] args) {
	  SeedSeatDao SeatDao=new SeedSeatDao();
		
		SeedSeat seat=new SeedSeat();
		
		seat.setSeatno(21);
		seat.setStat("allotted");
		
		//SeatDao.delete(seat);

		List<SeedSeat> list=SeatDao.list();
		for(SeedSeat st:list)
		{
			System.out.println(st);
		}
  
  
  }
	
	
}
