package com.mc.lang.String;

import java.util.Arrays;

public class _String {

	private String str = "		The String class represents character strings.			";

	public void readAPIDocumnet() {
		
		String res="";
		

		// 1. str의 길이를 출력하세요.
		System.out.println("1. str의 길이 : "+ str.length());

		// 2. str을 모두 대문자로 바꿔 출력 해주세요.
		res=str.toUpperCase();
		System.out.println("2. 대문자로 바꾸기 ");
		System.out.println(res);

		// 3. str을 모두 소문자로 바꿔 출력 해주세요.
		res=str.toLowerCase();
		System.out.println("3. 서문자로 바꾸기 ");
		System.out.println(res);

		// 4. str에 있는 "class"를 "java"로 바꿔 출력 해주세요
		res = str.replace("class", "java");
		System.out.println("4. class를 java로 바꾸기 ");
		System.out.println(res);

		// 5. str에서 첫번째 t의 위치를 구해주세요.
		int n;
		n = str.indexOf("t");
		System.out.println("5.str에서 첫번째 t의 위치를 구해주세요. ");
		System.out.println(n);


		// 6. str의 앞 뒤 공백을 제거해서 출력해주세요
		res = str.replace("	", "");
		System.out.println("6. str의 앞 뒤 공백을 제거해서 출력해주세요 ");
		System.out.println(str.trim());

		// 7. str을 char[]형태로 출력 해주세요.
		char[] bb= str.toCharArray();
		System.out.println("7. str을 char[]형태로 출력 해주세요. ");
		System.out.println(Arrays.toString(bb));
		
	}
}
 