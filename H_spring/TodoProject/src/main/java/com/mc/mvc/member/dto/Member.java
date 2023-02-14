package com.mc.mvc.member.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Member {
	private String userId;
	private String password;
	private String email;
	private String grade;
	private String tell;
	private boolean isLeave;
	private LocalDateTime regDate;
	private LocalDateTime rentableDate;
	
	// DTO (Data Transfer Object)
	// 데이터 전송을 담당하는 객체
	// 테이블에 존재하는 컬럼을 속성으로 구현, getter/setter 구현
	
	// 자바빈 규약
	// 1. 모든 필드변수는 private
	// 2. 반드시 기본 생성자가 존재한다.
	// 3. 모든 필드변수는 getter/setter를 가진다.
	
	// `USER_ID`, `PASSWORD`, `EMAIL`, `GRADE`, `TELL`, `IS_LEAVE`, `REG_DATE`, `RENTABLE_DATE`
	
	//    mysql	     java
	// 문자열 타입 : String
	// timestamp   : timestamp
	// 숫자		   : int, double
	// boolean	   : boolean
	
	
	
}

