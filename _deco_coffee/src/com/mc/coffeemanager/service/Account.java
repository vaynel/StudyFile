package com.mc.coffeemanager.service;

public class Account {
	
	private int balance = 100000;
	private int salesVolumn; //매출
	private int expences;    //지출
	
	//SingleTon 패턴
	//한번만 생성해야하는 클래스가 있을 경우 사용
	
	private static final Account ACCOUNT = new Account();
	
	//Account.ACCOUNT
	//Account.getInstace() : 읽는 개발자들이 singleton 방식으로 생성된 인스턴스라는 것을 바로 앎
	public static Account getInstance() {
		return ACCOUNT;
	}
	
	//외부에서 생성자를 사용해서 instance 생성을 못하도록 처리
	private Account() {
		
	}
	
	public boolean registerExpences(int budget) {
		
		if(balance > budget) {
			balance -= budget;
			expences += budget;
			return true;
		}
		
		return false;
	}
	
	public void registerSales(int payPrice) {
		balance += payPrice;
		salesVolumn += payPrice;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getSalesVolumn() {
		return salesVolumn;
	}
	public void setSalesVolumn(int salesVolumn) {
		this.salesVolumn = salesVolumn;
	}
	public int getExpences() {
		return expences;
	}
	public void setExpences(int expences) {
		this.expences = expences;
	}


	

	
	
}
