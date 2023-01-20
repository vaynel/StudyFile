package com.mr.tour.service;

public class Tourist {

	private int myMoney;
	private int myMile;
	
	public Tourist(int myMoney, int myMile) {
		super();
		this.myMoney = myMoney;
		this.myMile = myMile;
	}

	public Tourist() {
		// TODO Auto-generated constructor stub
	}

	public int getMyMoney() {
		return myMoney;
	}

	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}

	public int getMyMile() {
		return myMile;
	}

	public void setMyMile(int myMile) {
		this.myMile = myMile;
	}

	public int haveMoney() {
		return this.myMoney;
	}

	public int haveMile() {
		return this.myMile;
		
	}

}
