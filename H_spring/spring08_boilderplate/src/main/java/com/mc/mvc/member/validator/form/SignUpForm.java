package com.mc.mvc.member.validator.form;

import lombok.Data;


// lombok에 있는 어노테이션중 Data를 통해서 get/set/toString를 명시하지않아도 사용이 가능함.
@Data
public class SignUpForm {

	private String userId;
	private String password;
	private String tell;
	private String email;
	
	
	
}
