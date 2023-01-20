package com.mc.coffeemanager.service;

import java.time.LocalDate;

public class SeasonCoffee extends Coffee{
	
	private int[] seasonMonth;

	public SeasonCoffee(String name, int stock, int totalSalesCnt, int safetyStock, int cost, int price, int[] seasonMonth) {
		super(name, stock, totalSalesCnt, safetyStock, cost, price);
		this.seasonMonth = seasonMonth;
	}

	public boolean isSeason() {
		
		//현재 월을 구하는 코드
		int nowMonth = LocalDate.now().getMonthValue();
		
		for (int month : seasonMonth) {
			if(nowMonth == month) return true;
		}
		
		return false;
	}

	
	
	
	
	
	
}
