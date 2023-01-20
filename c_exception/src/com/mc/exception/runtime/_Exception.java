package com.mc.exception.runtime;

import java.util.Scanner;

public class _Exception {

	// Compile Exception : 컴파일 시점에 발생하는 예외, 이클립스가 빨간 줄로 표시해주는 예외
	// Runtime Exception : 실행되는 상황에서 발생하는 예외
	//
	//
	// Checked Exception : 코드로 예외발생을 차단 할 수 없기 때문에, 예외처리를 강제하는 Exception
	// Unchecked Exception : 코드로 예외발생을 차단 할 수 있기 때문에, 에외 처리를 강제하지 않는 Exception

	// 예외 처리 방법
	// try-catch 문 : try 블록에 예외가 발생할 수 있는 코드를 작성, catch 블록에 예외 처리에 필요한 코드를 작성
	// try-catch-finally : finally 블록에 예외 발생 여부와 상관없이 수행 되어야 하는 코드를 작성

	public void arithEx() {

		// ArithmeticException : 수학적으로 예외적인 상황이 되었을 때 발생되는 예외
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("피제수 하나를 정수로 입력하세요.");
			int num = sc.nextInt();
			int random = (int) (Math.random() * 4);

			if (random == 0)
				continue;
			int result = num / random;
			System.out.println("나누어진 몫은 : " + result);
		}
	}

	// 2. try-catch
	public void arithEx2() {

		// ArithmeticException : 수학적으로 예외적인 상황이 되었을 때 발생되는 예외
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("피제수 하나를 정수로 입력하세요.");
				int num = sc.nextInt();
				int random = (int) (Math.random() * 4);
				int result = num / random;
				System.out.println("나누어진 몫은 : " + result);
			} catch (ArithmeticException e) {
				System.out.println("0임");
				continue;
			}
		}
	}

	// 3. try-catch-finally
	public void arithEx3() {

		// ArithmeticException : 수학적으로 예외적인 상황이 되었을 때 발생되는 예외
		Scanner sc = new Scanner(System.in);
		System.out.println("피제수 하나를 정수로 입력하세요.");
		int num = sc.nextInt();
		while (true) {
			try {

				int random = (int) (Math.random() * 4);
				int result = num / random;
				System.out.println("나누어진 몫은 : " + result);
			} catch (ArithmeticException e) {
				System.out.println("0임");
				break;
			} finally {
				System.out.println("--------------------------");
			}
		}
	}

	// try 문 안에서 여러종류의 예외가 발생할 때 처리하는 방법
	public void studyMultiException() {

		try {
			// ClassCastException : 형변환 과정에서 문제가 생겼을 때 발생
			Object obj = new Object();
			String str = (String) obj;

			// ArrayIndexOutOfBoundsException;
			int[] arr = new int[2];
			arr[2] = 3;

			// NullPointerException : 레퍼런스에 주소값 대신 null이 들어가 있는데, 참조를 시도할 경우 발생하는 예외
			String nullStr = null;
			nullStr.equals("a");
		}
			//발생하는 예외에 따라서 필요한 예외처리가 모두 다를 때 사용하는 방법
//		} catch (ClassCastException e) {
//			System.out.println("예외가 발생했습니다.");
//			System.out.println(e.getMessage());
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("예외가 발생했습니다.");
//			System.out.println(e.getMessage());
//		} catch (NullPointerException e) {
//			System.out.println("예외가 발생했습니다.");
//			System.out.println(e.getMessage());
//		}
		// 자바 1.7 부터 지원
			catch(ClassCastException|ArrayIndexOutOfBoundsException|NullPointerException e){
				System.out.println("예외가 발생했습니다.");
				System.out.println(e.getMessage());
			}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
