package com.mc.coffeemanager.service;

public class ToppingDecorator extends Coffee {

	public ToppingDecorator(Coffee coffee) {
		super(coffee.getName(),
				coffee.getStock(), 
				coffee.getTotalSalesCnt(),
				coffee.getSafetyStock(),
				coffee.getCost(),
				coffee.getPrice());

	}

}
