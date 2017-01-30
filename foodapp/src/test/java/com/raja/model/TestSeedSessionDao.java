package com.raja.model;

import java.util.List;

import com.raja.dao.SeedSessionDao;

public class TestSeedSessionDao {
 
	public static void main(String args[])
	{
		//SeedSession sess=new SeedSession();
		SeedSessionDao sessdao=new SeedSessionDao();
		
		
		
		//sessdao.delete(sess);
		List<SeedSession> list=sessdao.list();
		for(SeedSession s:list)
		{
			System.out.println(s);
		}
		
	}
}
