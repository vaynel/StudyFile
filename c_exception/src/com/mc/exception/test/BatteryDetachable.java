package com.mc.exception.test;

//인터페이스는 다른 시스템이 결합되기 위해 지켜야하는 약속
//인터페이스는 인터페이스를 구현하는 모든 클래스들이 지켜야하는 공통의 규약
// 상속은 단일 상속만 가능하지만, 인터페이스는 구현은 다중 구현이 가능한다.

// 인터페이스 -> 클래스 : 구현
// 인터페이스 -> 인터페이스 : 상속

// 인터페이스의 구현은 추상클래스의 상속과 마찬가지로 추상메서드에 데한 구현과, 타입을 물려준다.
//인터페이스끼리의 상속은 다중 상속이 가능한다.

public interface BatteryDetachable {

	// 인터페이스의 필드 변수는 묵시적으로 public static final이다.
	String INFO = "베터리를 탈부착할 수 있는 제품입니다.";
	
	// 인터페이스의 인스턴스메서드는 묵시적으로 public abstarct메서드이다.
	void detachBattery();
	void attaceBattery();
	
	// 인터페이스의 클래스 메서드는 클래스와 동일
	// private는 자바 9버전부터 사용 가능
	private static void printInfo() {
		System.out.println(INFO);
	}
	
	// 자바 8버전이후 default 도입
	// 인터페이스 내에서 구현구를 가진 인스턴스메서드
	default void upgradBattery() {
		System.out.println("베터리를 업테이트합ㄴ디ㅏ.");
	}
}
