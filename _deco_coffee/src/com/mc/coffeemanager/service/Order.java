package com.mc.coffeemanager.service;

import java.time.LocalDateTime;
import com.mc.coffeemanager.service.code.OrderStatus;

public class Order {
	
	private Coffee coffee; // 주문한 커피
	private int orderCnt;
	private LocalDateTime orderTime;
	private int orderPrice;
	private String orderTitle; //주문명
	private OrderStatus status;


	public static Order createOrder(Coffee coffee, int orderCnt) {
		
		Order order = new Order(coffee, orderCnt);
		OrderStatus status= checkOrderStatus(coffee,orderCnt);
		order.status=status;
		return order;
	}
	
	private static OrderStatus checkOrderStatus(Coffee coffee, int orderCnt) {
		if(coffee.getStock()<orderCnt) return OrderStatus.Fail_CAUSE_STOCK;
		
		if(coffee instanceof SeasonCoffee) {
			SeasonCoffee seasonCoffee =  (SeasonCoffee) coffee;
			if(!seasonCoffee.isSeason())return OrderStatus.Fail_CAUSE_SEASON;
		}
		return OrderStatus.Ok; 
	}

	private Order(Coffee coffee, int orderCnt) {
		super();
		this.coffee = coffee;
		this.orderCnt = orderCnt;
		this.orderTitle = coffee.getName() + "[" + orderCnt + "잔]";
		this.orderTime = LocalDateTime.now(); //현재 시간
		this.orderPrice = coffee.getPrice() * orderCnt;
	}
	
	
	
	public void execute() {
		coffee.offer(orderCnt);
	}
	
	public OrderStatus getStatus() {
		return status;
		
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Coffee getCoffee() {
		return coffee;
	}
	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	public int getOrderCnt() {
		return orderCnt;
	}
	public void setOrderCnt(int orderCnt) {
		this.orderCnt = orderCnt;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getOrderTitle() {
		return orderTitle;
	}
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	@Override
	public String toString() {
		return "Order [coffee=" + coffee + ", orderCnt=" + orderCnt + ", orderTime=" + orderTime + ", orderPrice="
				+ orderPrice + ", orderTitle=" + orderTitle + "]";
	}
	
	
	

}
