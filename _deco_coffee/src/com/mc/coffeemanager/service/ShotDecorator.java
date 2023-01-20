package com.mc.coffeemanager.service;

public class ShotDecorator extends ToppingDecorator{

	private String name = "초코토핑";
	private int price = 500;
	
	public ShotDecorator(Coffee coffee) {
		super(coffee);
		super.setName(name+ "이 추가 된"+super.getName());
		super.setPrice(price +super.getPrice());
	}



	
	
	
	
	
	

}
