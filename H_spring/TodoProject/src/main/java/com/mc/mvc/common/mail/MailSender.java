package com.mc.mvc.common.mail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.mc.mvc.common.code.Code;
import com.mc.mvc.common.code.ErrorCode;
import com.mc.mvc.common.exception.HandlableException;

import lombok.RequiredArgsConstructor;


// Spring의 bean으로 만들어줌  -> 그래야지 JavaMailSender를 받을 수 있음
@Component
@RequiredArgsConstructor
public class MailSender {
	
	private final JavaMailSender mailSender;
	
	public void send(String to,String subject, String html) {
		
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			msg.setFrom(Code.STMP_FROM.desc);
			msg.setRecipients(Message.RecipientType.TO, to);
			msg.setSubject(subject);
			msg.setContent(html,"text/html; charset=UTF-8");
			
			mailSender.send(msg);
			
		} catch (MessagingException e) {

			throw new HandlableException(ErrorCode.FAILED_SEND_EMAIL);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
