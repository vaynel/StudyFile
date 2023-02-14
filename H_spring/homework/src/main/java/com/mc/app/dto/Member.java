package com.mc.app.dto;

import lombok.Data;

@Data
public class Member {
	
	private String userId;
	private String password;
	private String email;
	private String tell;
	private char isLeave;
	private String grade;
	
}
