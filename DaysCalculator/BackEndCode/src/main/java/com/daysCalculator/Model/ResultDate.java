package com.daysCalculator.Model;

import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Configuration
public class ResultDate {
	private int resultDate;
	private int resultMonth;
	private int resultYear;
	
	private int daysCount;
	private int weakCount;
	private int monthCount;
	private int yearCount;
	
	public ResultDate(int resultDate, int resultMonth, int resultYear) {
		this.resultDate = resultDate;
		this.resultMonth = resultMonth;
		this.resultYear = resultYear;
	}

	public ResultDate(int daysCount, int weakCount, int monthCount, int yearCount) {
		this.daysCount = daysCount;
		this.weakCount = weakCount;
		this.monthCount = monthCount;
		this.yearCount = yearCount;
	}
	
}
