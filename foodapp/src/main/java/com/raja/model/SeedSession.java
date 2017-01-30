package com.raja.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class SeedSession {

	 private int id;
	 private String sessions;
	 private LocalTime fromTime;
	 private LocalTime toTime;
}
