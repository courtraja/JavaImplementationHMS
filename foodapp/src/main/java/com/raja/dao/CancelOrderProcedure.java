package com.raja.dao;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.raja.util.ConnectionUtil;

public class CancelOrderProcedure {

	JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();
	public String CancelOrder(int orderid,int seat,String mess) {
		SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate).withProcedureName("cancel").declareParameters(
				
				new SqlParameter("get_order_id", Types.INTEGER), new SqlParameter("get_seat_number", Types.INTEGER),
				new SqlOutParameter("message", Types.VARCHAR));
		call.setAccessCallParameterMetaData(false);
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("get_order_id", orderid)
				.addValue("get_seat_number", seat).addValue("messages", mess);

		Map<String, Object> execute = call.execute(in);
		String status = (String) execute.get("message");
		return status;

	}
}
