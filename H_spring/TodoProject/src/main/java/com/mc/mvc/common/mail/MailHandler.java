package com.mc.mvc.common.mail;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// 요청을 받어야 하니까 Controller
@Controller
public class MailHandler {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	
	
	//@RequestBody 는  JSON 객체를 받을 수 있음 
	//@RequestParam은  JSON이 아닌 다른 하나의 ContentType만 받을 수 있음.
	@PostMapping("mailTest")
	public String sendMail(@RequestBody Map<String,Object> commandMap,Model model) {
		
		System.out.println("MailHandler userID : "+commandMap.get("userId"));
		System.out.println("MailHandler mailTemplate : "+commandMap.get("mailTemplate"));
		model.addAttribute("data", commandMap);
		
		return "mail-template/" + commandMap.get("mailTemplate");
	}
	
}
