package com.mc.util.collection.dto;

public class Student implements Comparable<Student>{
	
	private String name;
	private int age;
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Student o) {
		// this가 작으면 음수, 같으면 0, 크면 양수를 반환 
		//System.out.println(this + "와 " + o + "를 비교");

		
		//quize : 나이로 오름차순 정렬하되, 만약 나이가 같다면 이름으로 내림차순 정렬
		
		//나이 순 정렬
		//return this.age - o.age;
		
		//이름 순 정렬
		return -(this.name.compareTo(o.name));
	}
	
	

}
