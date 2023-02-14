package com.mc.mvc.common.code;

public enum ErrorCode {

	EXPRIATION_SIGNUP_TOKEN("인증이 만료된 토큰입니다.","/member/signup"),
	FAILED_SEND_EMAIL("이메일 전송에 실패했습니다. "),
	UNAUTHORIZED_REQUEST("니한테 권한없어","/member/login"),
	FAILED_UPLOAD_FILE("파일 업로드 작업 중 에러가 발생했습니다."),
	NOT_EXISTS("존재하지 않습니다.");
	
	public String msg;
	public String redirect;
	
	private ErrorCode(String msg,String redirect) {
		this.msg=msg;
		this.redirect=redirect;
	}
	private ErrorCode(String msg) {
		this.msg=msg;
		this.redirect="/index";
	}
	
}
