package com.mc.coffeemanager.service;

public class ChocoDecorator extends ToppingDecorator{

	private String name = "샷";
	private int price = 300;
	
	public ChocoDecorator(Coffee coffee) {
		super(coffee);
		super.setName(name+ "이 추가 된"+super.getName());
		super.setPrice(price +super.getPrice());
	}


	
	
	
	
	
	

}
