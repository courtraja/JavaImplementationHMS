package com.raja.model;

import lombok.Data;

@Data
public class FoodOrdered {
	private int OrderId;
	private String FoodName;
	private int quantity;
	private int price;
}
