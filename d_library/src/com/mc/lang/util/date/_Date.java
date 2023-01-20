package com.mc.util.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class _Date {
	
	public void studyDate() {
		Date today = new Date();
		System.out.println(today);
		
		//today.setMonth(1);
		
		System.out.println("연도 : " + (today.getYear()+1900));
		System.out.println("월   : " + (today.getMonth()+1));
		System.out.println("일   : " + today.getDate());
		System.out.println("시   : " + today.getHours());
		System.out.println("분   : " + today.getMinutes());
		System.out.println("초   : " + today.getSeconds());
	}
	
	public void studyCalendar() {
		Calendar calendar = Calendar.getInstance();
		//calendar.set(Calendar.MONTH, 1);
		
		System.out.println("연도 : " + (calendar.get(Calendar.YEAR)));
		System.out.println("월   : " + (calendar.get(Calendar.MONTH)+1));
		System.out.println("일   : " + calendar.get(Calendar.DATE));
		System.out.println("시   : " + calendar.get(Calendar.HOUR));
		System.out.println("분   : " + calendar.get(Calendar.MINUTE));
		System.out.println("초   : " + calendar.get(Calendar.SECOND));
	}
	
	public void studyLocalDateTime() {
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("연도 : " + now.get(ChronoField.YEAR));
		System.out.println("월   : " + now.get(ChronoField.MONTH_OF_YEAR));
		System.out.println("일   : " + now.getDayOfMonth());
		System.out.println("시   : " + now.getHour());
		System.out.println("분   : " + now.getMinute());
		System.out.println("초   : " + now.getSecond());
		
		now = now.plusDays(100).plusHours(3).minusMonths(2);
		
		System.out.println(now);
		
	}
}
