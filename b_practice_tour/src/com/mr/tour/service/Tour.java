package com.mr.tour.service;

public class Tour {

	Tourist tourist = new Tourist();
	public static boolean isAble(Tourist tourist, Airline airline) {
		int myMoney = tourist.getMyMoney();
		int airfare = airline.getAirfare();
		if (myMoney<airfare) {
			return false;
		}
		return true;
		
	}

	public static void butTicket1(Tourist tourist, int airFare, int airMile) {
		tourist.setMyMile(tourist.getMyMile()+airMile);
		tourist.setMyMoney(tourist.getMyMoney()-airFare);
		return;
	}

	public static void butTicket2(Tourist tourist, int airFare, int airMile) {
		tourist.setMyMile(tourist.getMyMile()+airMile);
		tourist.setMyMoney(tourist.getMyMoney()-airFare);
		return;
	}
	public static void butTicket3(Tourist tourist, int airFare, int airMile) {
		tourist.setMyMile(tourist.getMyMile()+airMile);
		tourist.setMyMoney(tourist.getMyMoney()-airFare);
		return;
	}

	public static void bringMyMoney(Tourist tourist) {
		System.out.println("티케팅 후 잔액 : " + tourist.getMyMoney());
	}
	public static void bringMyMile(Tourist tourist) {
		System.out.println("티케팅 후 마일리지 : " + tourist.getMyMile());
	}


}
