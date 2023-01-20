package aop03;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Developer {

	@Override
	public void develop() {
		System.out.println("자바스크리트로 개발한다.");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("수다");
	}
	
	

}
