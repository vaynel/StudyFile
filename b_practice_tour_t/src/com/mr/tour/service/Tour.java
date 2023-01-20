package com.mr.tour.service;

public class Tour {

	private Airline al1 = new Airline("미국행", 3000, 300000);
	private Airline al2 = new Airline("중국행", 2000, 200000);
	private Airline al3 = new Airline("일본행", 1500, 150000);
	private Tourist tourist = new Tourist(1000000,1000);
	
	public Tour() {
		
	}
	
	public boolean isAble(int num) {
		if(num==1) return tourist.getMyMoney()>=al1.getAirfare();
		if(num==2) return tourist.getMyMoney()>=al2.getAirfare();
		if(num==3) return tourist.getMyMoney()>=al3.getAirfare();
		
		return false;
	}
	
	public void buyTicket1() {
		tourist.setMyMoney(tourist.getMyMoney()-al1.getAirfare());
		tourist.setMyMile(tourist.getMyMile()+al1.getMileage());
		
	}
	public void buyTicket2() {
		tourist.setMyMoney(tourist.getMyMoney()-al2.getAirfare());
		tourist.setMyMile(tourist.getMyMile()+al2.getMileage());
	}
	public void buyTicket3() {
		tourist.setMyMoney(tourist.getMyMoney()-al2.getAirfare());
		tourist.setMyMile(tourist.getMyMile()+al2.getMileage());
	}
	public int bringMyMoney() {
		return tourist.getMyMoney();
	}
	
	public int bringMyMile() {
		return tourist.getMyMile();
	}
	

}
