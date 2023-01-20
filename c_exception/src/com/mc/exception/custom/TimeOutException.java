package com.mc.exception.custom;

// 예외 클래스를 직접만들어보자 

// Checked Exception : Exception 클래스를 상속받은 클래스를 만들면, Checked Exception으로 사용할 수 있다.
// Unchecked Exception(Runtime Exception) ; RuntimeException을 상속받은 클래스를 만듬녀 UnChekcked Exception으로 사용 할 수 있다.

public class TimeOutException extends Exception {

	// 객체 직렬화 시에 사용
	// 객체 직렬화 : 통신에서 객체를 전달하기 위해 디지털 신호로 표현하기 위한 2진 값으로 변경 
	// serialVersionUID : 직렬화 과정에서 클래스를 고유하게 식별하기 위한 ID
						//만약 작성하지 않을 경우 ,JVM이 임의로 부여한다.
	private static final long serialVersionUID = -3387516993124229948L;
	
	
	public TimeOutException() {
		// TODO Auto-generated constructor stub
	}


	// message : 예외에 대한 안내
	public TimeOutException(String message) {
		// Exception의 생성자 매개변수로 message를 전달
		// getMessage()를 통해서 확인
		// statckTrace를 출력시 함께 출력됨
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
