package com.daysCalculator.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Days {
	
	private String startDate;
	private String endDate;
	private int daysDuration;
	private int direction;
	private int date;
	private int month;
	private int year;
}