package com.mc.lang.wrapper;

public class WrapperClass {
	
	// primitive type의 갮을 객체로 다루기 위해 제공되는 클래스
	
	// primitive 	-> wrapper
	// byte 		-> Byte
	// short	 	-> Short
	// int 			-> Integer
	// long 		-> Long
	// double		-> Double
	// boolean 		-> Boolean
	// char			-> Character

	public void studyBoxing() {
		
		// 0.1 : primitive double type
		Double wd =0.1; //auto-boxing  : primitive 타입의 값으 자동으로 wrapper 클래스 타입으로 변환
		double d = wd; // auto-unboxing 
		
		Boolean isEasy = true;
		boolean isHappy = isEasy;
	}
	
	public void printTypeSize() {
		System.out.println("byte의 max : "+Byte.MAX_VALUE);
		System.out.println("short의 max : "+Short.MAX_VALUE);
		System.out.println("int의 max : "+Integer.MAX_VALUE);
		System.out.println("byte의 max : "+Long.MAX_VALUE);
		System.out.println("byte의 max : "+Double.MAX_VALUE);
		System.out.println("byte의 max : "+Character.MAX_VALUE);
		
	}
	
	// Parsing : 어떠한 값을 내부 시스템에서 활용하기 위한 형태로 변경
	// 외부와 데이터를 주고 받을 때는 문자열로 데이터를 주고 받는다.
	// 외부로부터 전달받은 문자열 값을 내부 시스템에서 활용하기 위한 알맞은 타입으로 변환을 진행 
	public void parse() {
		String price = "100";
		
		byte bnum = Byte.parseByte(price);
		short snum = Short.parseShort(price);
		int inum = Integer.parseInt(price);
		
		System.out.println(bnum+snum+inum);
	}
	
}
