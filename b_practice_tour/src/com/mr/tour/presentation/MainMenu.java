package com.mr.tour.presentation;

import java.util.Scanner;

import com.mr.tour.service.Airline;
import com.mr.tour.service.Tour;
import com.mr.tour.service.Tourist;

public class MainMenu {

	Tourist tourist;
	Airline[] airlines;
	boolean canBuyAirline = true;

	public MainMenu(Tourist tourist, Airline[] airlines) {
		super();
		this.tourist = tourist;
		this.airlines = airlines;
	}

	public void mainMenu() {
		
		while(canBuyAirline) {
		System.out.print("현재 보유 금액 : ");
		System.out.print(tourist.haveMoney() + "\n");

		System.out.print("현재 보유 마일리지 : ");
		System.out.print(tourist.haveMile() + "\n");

		showAirLine();
		System.out.println("--------------------------");
		selectDestination();
		showTouristMoneyAndMile();
		if(tourist.getMyMoney()<0) break;
		
		System.out.println("--------------------------");
			
		}
		

	}

	private void showTouristMoneyAndMile() {
		Tour.bringMyMoney(tourist);
		Tour.bringMyMile(tourist);
	}

	private void selectDestination() {

		System.out.print("목적지 선택(번호입력) : ");

		Scanner sc = new Scanner(System.in);
		int Airnum = sc.nextInt();
		System.out.println(airlines[Airnum - 1].getCountry() + "을 선택하였습니다.");

		// 갈 수 있는지 검증하기
		if (!Tour.isAble(tourist,airlines[Airnum-1])) {
			System.out.println("잔액이 부족합니다.");
			canBuyAirline=false;
		} 
		else {
			TourController(Airnum - 1);
		}
	}

	private void TourController(int airnum) {
		switch (airnum) {
		case 0:
			Tour.butTicket1(tourist, 300000, 3000);
			break;
		case 1:
			Tour.butTicket2(tourist, 200000, 2000);
			break;
		case 2:
			Tour.butTicket3(tourist, 150000, 1500);
			break;
		}
		
	}

	private void showAirLine() {

		System.out.println("번호     목적지       가격           마일리지 ");
		for (int i = 0; i < airlines.length; i++) {
			System.out.println((i + 1) + "    " + airlines[i].getCountry() + "    " + airlines[i].getAirfare() + "    "
					+ airlines[i].getMileage());
		}
	}

}
