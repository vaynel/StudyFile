package com.mc.exception._throws;

import java.net.MalformedURLException;
import java.net.URL;

public class _throws {

	// throws : 메서드 선언부에 사용하는 키워드로, 특정 예외 객체를 호출부로 반환
	// 호출부로 예외처리를 위임한다.
	
	//throws를 사용해 계속해서 호출부로 위임을 하면 최종적으로 main 메서드에 도착하게 되면 
	// main메서드에서 예외처리를 진행하지 않을 경우, jvm이 대신 처리해준다.
	//이는 결국 개발자가 예외처리를 하지 않은 것과 마찬가지임으로 바람직하지 않다.
	
	public static void main(String[] args) {
		_throws th = new _throws();
		th.testA();
	}

	public void testA()  {
		try {
			testB();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private void testB() throws MalformedURLException {
		testC();
	}

	// throws MalformedURLException
	// MalformedURLException 예외가 발생 시 즉시 호출부로 MalformedURLException 객체를 반환
	private void testC() throws MalformedURLException {

		URL url = new URL("https://www.naver.com");
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getProtocol());

	}

}
