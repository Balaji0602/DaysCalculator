package com.daysCalculator.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daysCalculator.Model.Days;
import com.daysCalculator.Model.ResultDate;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping()
public class DaysController {
	
	private ResultDate result;
	
	public DaysController(ResultDate result) {
		this.result = result;
	}
	int monthWithDays[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	@PostMapping("DaysCalculator")
	public ResultDate CalculateDays(@RequestBody Days days) {
			String startDate = days.getStartDate();
			int duration = days.getDaysDuration();
			int direction = days.getDirection();
			 
			String[] splitedDate = startDate.split("[-]",0);
			
			int year= Integer.parseInt(splitedDate[0]);
			int month = Integer.parseInt(splitedDate[1]);
			int date = Integer.parseInt(splitedDate[2]);
			
			days.setDate(date);
			days.setMonth(month);
			days.setYear(year);
			if(direction == 1) {
				forwardCalculateDuration(days,duration);
			}
			else {
				backwaredCalculationDate(days,duration);
			}
			
			int resDate = result.getResultDate();
			int resMonth = result.getResultMonth();
			int resYear = result.getResultYear();
			
			return new ResultDate(resDate,resMonth,resYear);
	}
	
	@PostMapping("/DateCalculate")
	public ResultDate dateCalculate(@RequestBody Days days) {
		
		String strDate =days.getStartDate();
		String endDate = days.getEndDate();
		
		String[] splitFirDate = strDate.split("[-]",0);
        String ipyear= splitFirDate[0];
        String ipmonth = splitFirDate[1];
        String ipdate  = splitFirDate[2];
        
        int date = Integer.parseInt(ipdate);
        int month = Integer.parseInt(ipmonth);
        int year = Integer.parseInt(ipyear);


        String[] splitDate = endDate.split("[-]",0);
        String iptyear = splitDate[0];
        String iptmonth = splitDate[1];
        String iptdate= splitDate[2];
        
        int endingDate = Integer.parseInt(iptdate);
        int endingMonth = Integer.parseInt(iptmonth);
        int endingYear = Integer.parseInt(iptyear);
        
        boolean condition = true;
        int daysCount = 0;
        int weakCount = 0;
        int monthCount = 0;
        int yearCount = 0;

            while(condition){
                int checkedYear = checkyear(year);
                if(checkedYear == 1){
                	monthWithDays[1] = 29;
                    int getMonthOfDays = monthWithDays[month-1];
                    if(getMonthOfDays == date){
                        if(month == 12){
                            month =1;
                            date = 1;
                            year++;
                            monthCount++;
                            yearCount++;
                        }
                        else{
                            date=1;
                            month++;
                            monthCount++;
                        }
                    }
                    else{
                        date++;
                    }
                }
                else{
                	monthWithDays[1] = 28;
                    int getMonthOfDays = monthWithDays[month-1];
                    if(getMonthOfDays == date){
                        if(month == 12){
                            month =1;
                            date = 1;
                            year++;
                            monthCount++;
                            yearCount++;
                        }
                        else{
                            date=1;
                            month++;
                            monthCount++;
                        }
                    }
                    else{
                        date++;
                    }
                }
                if(date == endingDate && month == endingMonth && year == endingYear){
                    condition = false;
                }
                else{
                    daysCount++;
                    if(daysCount%7 == 0){
                        weakCount++;
                    }
                }
            }
            result.setDaysCount(daysCount);
            result.setWeakCount(weakCount);
            result.setMonthCount(monthCount);
            result.setYearCount(yearCount);
            
		int resDate = result.getDaysCount();
		int resMonth = result.getMonthCount();
		int resWeak = result.getWeakCount();
		int resYear = result.getYearCount();
		
		return new ResultDate(resDate,resWeak,resMonth,resYear);
	}
	private void forwardCalculateDuration(Days days, int duration) {
		int date = days.getDate();
		int month = days.getMonth();
		int year = days.getYear();
            while(duration > 0){
                int checkedYear = checkyear(year);
                if(checkedYear == 1){
                	monthWithDays[1] = 29;
                    int getMonthOfDays = monthWithDays[month-1];
                    if(getMonthOfDays == date){
                        if(month == 12){
                            month =1;
                            date = 1;
                            year++;
                        }
                        else{
                            date=1;
                            month++;
                        }
                    }
                    else{
                        date++;
                    }
                }
                else{
                	monthWithDays[1] = 28;
                    int getMonthOfDays = monthWithDays[month-1];
                    if(getMonthOfDays == date){
                        if(month == 12){
                            month =1;
                            date = 1;
                            year++;
                        }
                        else{
                            date=1;
                            month++;
                        }
                    }
                    else{
                        date++;
                    }
                }
                duration--;
            }
		result.setResultDate(date);
		result.setResultMonth(month);
		result.setResultYear(year);
	}
	public void  backwaredCalculationDate(Days days,int duration) {
		int date = days.getDate();
		int month = days.getMonth();
		int year = days.getYear();
		
		while(duration > 0){
            int checkedYear = checkyear(year);
            if(checkedYear == 1){
            	monthWithDays[1] = 29;
                if(date == 1){
                    if(month == 1){
                        month =12;
                        date = 31;
                        year--;
                    }
                    else{
                        month--;
                        date = monthWithDays[month-1];
                    }
                }
                else{
                    date--;
                }
            }
            else{
            	monthWithDays[1] = 28;
                if(date == 1){
                    if(month == 1){
                        month =12;
                        date = 31;
                        year--;
                    }
                    else{
                        month--;
                        date = monthWithDays[month-1];
                    }
                }
                else{
                    date--;
                }
            }
            duration--;
        }
		result.setResultDate(date);
		result.setResultMonth(month);
		result.setResultYear(year);
	}
	private int checkyear(int year) {
		if(year % 400 == 0 ){
            return 1;
        }
        if(year % 100 == 0){
            return 0;
        }
        if(year % 4 == 0 ){
            return 1;
        }
        return 0;
	}
}
