package com.mc.lang.object;

// 모드 클래스는 object 클래스의 후손 클래스이다.
public class Book implements Cloneable{

	private String title;
	private Author author;
	private int price;

	public Book(String title, Author author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	// hashCode : 인스턴스를 식별 할 수 있는 식별값을 반환하는 메서드
	// 동일성 비교 : 주소값으로 비교
	// 동등성 비교 : 객체의 속성에 담긴 값이 같으면 같은 객체로 판단
	
	// hash : 어떠한 데이터를 일정한 크기의 값으로 나타내는 것 
	// 해시함수 : 어떠한 데이터를 일정한 크기의 값으로 변환해 주는 함수 
	// 		1. 같은 값을 넣으면 언제나 같은 값을 반환해야 한다.
	//		2. 다른 값을 넣으면 언제나 다른 값을 반환해야 한다.
	// hashCode는 this에 대한 해시함수이다.
	// 해시충돌 : 다른 갑승ㄹ 해시함수에 넣었는데 같은 해시값이 반환되는 경우 
	// 보통 해시함수에서는 해시충돌을 최소화하기 위해 소수를 연산에 많이 사용
	// 31은 해시함수를 만들때 적절한 크기의 소수이기 때문에 관습적으로 사용되는 값
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	// heap 영역에 저장된 primitive 타입은 상관이 없지만
	// heap 
	public Object clone()  {
		
		Object obj = null;
		try {
			obj=super.clone();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return obj;
		
	}

}
