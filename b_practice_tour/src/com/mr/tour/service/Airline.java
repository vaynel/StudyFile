package com.mr.tour.service;

public class Airline {
	
	private String country;
	private int mileage;
	private int airfare;
	
	
	
	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public int getMileage() {
		return mileage;
	}



	public void setMileage(int mileage) {
		this.mileage = mileage;
	}



	public int getAirfare() {
		return airfare;
	}



	public void setAirfare(int airfare) {
		this.airfare = airfare;
	}



	public Airline(String country, int mileage, int airfare) {
		super();
		this.country = country;
		this.mileage = mileage;
		this.airfare = airfare;
	}



	public void showLine() {
		System.out.println(country+" "+ airfare +" "+mileage +" ");
		return;
		
	}

}
