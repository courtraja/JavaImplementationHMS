package com.raja.dao;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;
import com.raja.model.SeedSeat;
import com.raja.util.ConnectionUtil;
public class SeedSeatDao {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	

	public void save(SeedSeat seedseat) {

		String sql = "insert into seed_seat(seat_no,stat) values(?,?)";
		Object[] params = {seedseat.getSeatno(), seedseat.getStat() };
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows inserted: " + rows);
		}
	public void update(SeedSeat seedseat) {

		String sql = "update seed_seat set stat=? where seat_no=?";
		Object[] params = {seedseat.getStat(),seedseat.getSeatno()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows updated: " + rows);
		}

	public void delete(SeedSeat seedseat) {

		String sql = "delete from seed_seat where seat_no=?";
		Object[] params = {seedseat.getSeatno()};
		int rows = jdbcTemplate.update(sql, params);
		System.out.println("No of rows deleted: " + rows);
		}
	
	public List<SeedSeat> list()
	{
		String sql = "select * from seed_seat";
		
		return jdbcTemplate.query(sql, (rs,rowNum) ->
		{
			SeedSeat seat = new SeedSeat();
			seat.setSeatno(rs.getInt("seat_no"));
			seat.setStat(rs.getString("stat"));
			
			return seat;
			
		});
	
}
}
