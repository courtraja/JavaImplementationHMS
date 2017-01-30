package com.raja.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderDetails {

	private int seatNumber;
	private int orderId;
	private int Price;
	private String status;
	private LocalDateTime orderedDate;
	
}
