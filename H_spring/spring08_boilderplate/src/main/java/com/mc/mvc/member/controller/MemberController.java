package com.mc.mvc.member.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.CookieGenerator;

import com.mc.mvc.common.code.ErrorCode;
import com.mc.mvc.common.exception.HandlableException;
import com.mc.mvc.common.validator.ValidatorResult;
import com.mc.mvc.member.dto.Member;
import com.mc.mvc.member.service.MemberService;
import com.mc.mvc.member.validator.form.SignUpForm;
import com.mc.mvc.member.validator.form.SignUpFormValidator;

import lombok.RequiredArgsConstructor;


//@Controller
//1. 해당 클래스의 인스턴스를 ApplicationContext에 빈으로 등록
//2. Controller 역활을 수행하기 위한 Annotation을 사용할 수 있게 해준다.
//		@RequstMapping : 컨트롤러의 메서드와 매핑시킬 요청 url을 지정, 원하는 http method를 지정할 수 있다.
//		@GetMapping	   : 컨트롤러의 메서드와 매핑시킬 GET 방식의 요청 url을 지정
//		@PostMapping   : 컨트롤러의 메서드와 매핑시킬 POST 방식의 요청 url을 지정
//		@RequestParam  : content-type이 application/x-www-form-urlEncoded인 요청의
//						요청파라미터와 컨트롤러 메서드의 매개변수를 바인드
//						String 또는 primitive type 의 경우 default로 적용이 된다.
//						컨트롤러의 메서드의 매겨변수가 Map인 경우, @RequestParam을 명시적으로 적용 해줘야 한다.
// 						name : 요청파라미터명, 매개변수에 바인드 시킬 요청파라미터명을 지정
//								만약 매개변수명과 요청파라미터명이 일치할 경우 생략
//						required : 특정 요청파라미터의 필수여부를 지정, default : true
//								컨트롤러의 매개변수로 선언한 요청 파라미터가 전달되지 않을시 예외가 발생
//						defaultValue : required가 false인 매개변수에, 요청 파라미터가 전달 되지 않았을 경우 지정할 기본 값.
//						
//		@SessionAttribute : servlet의 HttpSession객체에 저장된 속성에 담긴 값을 컨트롤러의 매개변수에 바인드
//		@PathVarialbe : url 템플릿에 담긴 파라미터값을 컨트롤러의 매개변수에 바인드

//		@RequestBody : request body를 읽어서 자바의 객체에 bind, application/x-www-form-urlEncoded방식은 지원 안됨

//		@ModelAttridute : 컨트롤러의 매개변수에 DTO를 선언할 경우 set + 요청파라미터명으로 요청파라미터를 객체에 바인드

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	private final SignUpFormValidator signUpFormValidator;

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	// ModelAttrivute가 동작하는 시점에  Data Binder가 수행
	// @InitBinder
	@InitBinder(value ="signUpForm")
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(signUpFormValidator);
	}
	
	@GetMapping("/signup")
	public void signup() {};

	
	@PostMapping("/signup")
	public String authenticateMail(@Validated SignUpForm form // validator로 사용한 form 객체 바로 뒤에 errors 객체를 선언
			,Errors error, Model model, HttpSession session) {
		
		// 발송한 이메일이 포함된 url로 사용자가 재요청을 할 때 사용자의 정보를 DB에 저장
		// 재요청때 까지 데이터를 저장하기 위헤서 새션객체에 사용자의 정보를 저장
		// 리퀘스트 객체와 세션  객체의 차이를 알아야함 서블릿에서
			
		System.out.println(error.getFieldErrors());
		
		ValidatorResult vr = new ValidatorResult();
		model.addAttribute("error", vr.getErrors());
		
		if(error.hasErrors()) {
			vr.addErrors(error);
			model.addAttribute("errors", vr.getErrors());
			return "/member/signup";
		}
		
		// 발송한 이메일에 포함된 url로 사용자가 재요청할 때 사용자의 정보를 DB에 저장
		// 재요청때 까지 데이터를 저장하기 위해 세션객체에 사용자의 정보를 저장
		session.setAttribute("signupForm", form);
		
		// 사용자가 재요청시 해당 요청이 유요한 요청인지 확인하기 위한 Token을 발행
		String authToken = UUID.randomUUID().toString();
		session.setAttribute("authToken", authToken);
		
		memberService.authenticateEmail(form,authToken);
		// Email인증을 받은 후에 회원 가입을 시킬 것임
//		memberService.insertNewMember(member);
		
		return "redirect:/index";
	}
	
	
	
	// @PathVariable : url에서 특정위치의 값을 컨트롤러의 매개변수에 바인드해준다.
	// "/signupImpl/{authToken}" : /member/signImpl 로 시작하는 모든 요청을 대헤 메서드를 호출
	@GetMapping("/signupImpl/{authToken}")
	public String signup(HttpSession session,
			@PathVariable String authToken,
			@SessionAttribute(name = "authToken", required = false) String sessionToken,
			@SessionAttribute(name ="signupForm",required = false) SignUpForm form,
			Model model) {
//		Member member =(Member) session.getAttribute("signupForm");

		// 세션 토큰에서 authToken을 꺼냈을 때 PathVarivable로 받아온 authToken과 같지 않다면
		if(!authToken.equals(sessionToken)) {	
			throw new HandlableException(ErrorCode.EXPRIATION_SIGNUP_TOKEN);
		}
		
		//회원정보를 데이터베이스에 저장
		memberService.insertNewMember(form);
		
		// 세션에서 저장된 토큰을 삭제
		session.removeAttribute("authToken");
		
		return "redirect:/index";
	}

	
//	@GetMapping("/mypage")
//	public void mypage(Model model) {
//	}
	
	@GetMapping("/checkId")
	@ResponseBody
	public Map<String,Boolean> checkId(String userId){
		
		System.out.println(memberService.selectUserById());
		return Map.of("exist", memberService.existUser(userId));
		
	}
	
	@GetMapping("/login")
	public void login() {}
	

	// RedirectAttributes : RedirectAttribute에 저장한 데이터를 redircet 할 때 쿼리스트링으로 변환해서 응답
	
	@PostMapping("/login")
	public String loginImpl(Member member,HttpSession session,RedirectAttributes redirectAttr) {
		
		Member auth = memberService.authenticateUser(member);
		
		if(auth==null) {
			redirectAttr.addFlashAttribute("msg", "아이디나 비밀번호가 틀렸습니다.");
			System.out.println("auth = null");
			return "redirect:/member/login";
		}
		
		session.setAttribute("auth", auth);
		return "redirect:/board/board-form";
	}
	
	
	@GetMapping("mypage")
	public String mypage(@SessionAttribute(name="auth") Member auth,
						@CookieValue(name = "JSESSIONID") String sessionId,
						HttpServletResponse response) {
		
		logger.debug("JSESSIONID 값 : "+ sessionId);
//		response.addCookie(new Cookie("testCookie", "testCookie_with_httpServletResponse."));

		CookieGenerator cg = new CookieGenerator();
		cg.setCookieName("test cookie");
		cg.addCookie(response, "testCookie_with_CookieCenerator");
		return "member/mypage";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("auth");
		return "redirect:/index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
