package com.mc.lang.String;

//String은 생성된 이후 값을 변경 할 수 없는 불변 객체이다.
// String a= 'a';
//String을 결합하여 수정할 경우 ,해당 인스턴스에 값이 변경되는 것이 아니라 새로운 인스턴스를 생성한다.
public class StringConcatenation {
	
	public void testConcat() {
		
		//heap 영역에 String Constant pool에 "JAVA"라는 값을 가지는 객체 생성
		String java = "JAVA";
		String java2 = "JAVA";
		System.out.println("수정 전 주소 :"+System.identityHashCode(java));
		System.out.println("리터럴 JAVA 주소 :"+System.identityHashCode("JAVA"));
		System.out.println("java2 주소 :"+System.identityHashCode(java2));
		
		// 값은 값의 문자열을 리터럴로 생성할 경우 등위비교 연산자를 사용하면 true가 나온다.
		// 리터럴로 생성할 경우 값은 같이면, 같은 객체이기 때문이다.
		// 주소값이 똑같이 때문에 true를 반환
		System.out.println("java==java2 :"+(java==java2));

		//생성자를 사용해 String을 생성할 경우 , String Constant pool 대신 일반적인 heap영역에 생성된다.
		// String Constant pool을 사용해 얻을 수 있는 메모리상 이점이 사라지게 된다.
		String java3 = new String("JAVA");
		System.out.println("java==java3 :"+(java==java3));
		java+="Script";
		System.out.println("수정 후 주소 :"+System.identityHashCode(java));
	}

}
