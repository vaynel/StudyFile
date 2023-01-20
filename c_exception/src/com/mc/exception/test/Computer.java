package com.mc.exception.test;

public class Computer extends Product{
	
	// 자바에서 상속은 단일 상속만 가능하다.
	// 클래스의 부모클래스는 하나만 존재한다.
	protected String cpu;
	protected int ram;
	
	public Computer() {
		super();
	}
	
	
	public Computer(String brand, String pName, int price, String cpu, int ram) {
		//super() : 부모클래스의 생성자. 반드시 생성자의 가장 위에 위치
		//super   : 부모클래스의 주소를 저장하고 있는 레퍼런스
		super(brand, pName, price);
		this.cpu = cpu;
		this.ram = ram;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}
	
	
	
	
}
