package com.mc.coffeemanager.service;

public class Payment {
	
	private Order order;
	private int payPrice;
	
	public Payment(Order order) {
		super();
		this.order = order;
		this.payPrice = order.getOrderPrice();
	}
	
	public void excute() {
		payPrice -= PercentDiscount.calDiscountAboutOrderPrice(order);
		Account.getInstance().registerSales(payPrice);
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(int payPrice) {
		this.payPrice = payPrice;
	}


	
	
	
	

}
