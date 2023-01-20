package com.mc.util.app;

import java.util.Calendar;

public class DayCalculator {
	
	public long calDDay(int year, int month, int date) {
		
		//사용자의 dday
		Calendar dday = Calendar.getInstance();
		dday.set(year, month-1, date);
		
		//오늘 날짜
		Calendar now = Calendar.getInstance();
		
		long between = dday.getTimeInMillis() - now.getTimeInMillis();
		
		//milleseconds  -> 일로 변환
		System.out.println(between);
		
		between /= 1000;
		between /= 3600;
		between /= 24;
		
		return between;
	}

}
