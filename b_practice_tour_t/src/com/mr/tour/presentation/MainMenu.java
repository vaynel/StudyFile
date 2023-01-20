package com.mr.tour.presentation;

import java.util.Scanner;

import com.mr.tour.service.Airline;
import com.mr.tour.service.Tour;
import com.mr.tour.service.Tourist;

public class MainMenu {

	Scanner sc = new Scanner(System.in);
	private Tour tour;

	public void mainMenu() {

		while (canBuyAirline) {
			System.out.print("현재 보유 금액 : " +tour.bringMyMoney());
			System.out.print("현재 보유 마일리지 : " +tour.bringMyMile());
			System.out.println("--------------------------");
			System.out.print("목적지 선택(번호입력) : ");
			int Airnum = sc.nextInt();
			
			if(!tour.isAble(Airnum)) {
				System.out.println("현재 보유 금액이 부족하니다.");
				break;
			}
			switch (Airnum) {
			case 1:
				tour.buyTicket1();
				System.out.println("티케팅 후 잔액은 : "+tour.bringMyMoney());
				System.out.println("티케팅 후 마일리지은 : "+tour.bringMyMile());
				break;
			case 2:
				tour.buyTicket2();
				System.out.println("티케팅 후 잔액은 : "+tour.bringMyMoney());
				System.out.println("티케팅 후 마일리지은 : "+tour.bringMyMile());
				break;
			case 3:
				tour.buyTicket3();
				System.out.println("티케팅 후 잔액은 : "+tour.bringMyMoney());
				System.out.println("티케팅 후 마일리지은 : "+tour.bringMyMile());
				break;
			}
			

			System.out.println("--------------------------");

		}

	}

	Tourist tourist;
	Airline[] airlines;
	boolean canBuyAirline = true;

	public MainMenu(Tourist tourist, Airline[] airlines) {
		super();
		this.tourist = tourist;
		this.airlines = airlines;
	}

	public MainMenu() {
		// TODO Auto-generated constructor stub
	}


}
