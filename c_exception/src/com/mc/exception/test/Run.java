package com.mc.exception.test;

import com.mc.exception.custom.TimeOutException;

public class Run {
	public static void main(String[] args) {
		SmartPhone phone = new SmartPhone();
		try {
			phone.setPrice(-10);
			phone.sendMessage();
		} catch (TimeOutException e) {
			System.out.println("상대방 서버에서 응답이 없어 서비스를 제공하지 못함" );
			e.printStackTrace();
		}
	}
}
