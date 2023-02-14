package com.mc.mvc.member;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mc.mvc.common.mail.MailSender;

//가상으로 만들어지는 web.xml을 사용해 테스트환경을 구축
@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
public class MemberServiceImplTest {
	
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	MailSender sender;
	
	@Autowired
	RestTemplate restTemplate;
	
	// 안됨 어이없음
	@Test
	   public void testSendMail() {
		
			sender.send("ssp04041@gmail.com", "test", "<h1>1231231<h1>");
					
	  }
	
	@Test
	public void testRestTemplate() throws RestClientException, URISyntaxException {
		
//		MultiValueMap<String, Object> body = new LinkedMultiValueMap<String, Object>();
//		body.add("userId", "JaeHyun");
//		body.add("mailTemplate", "signup-email-auth");
//		
//		
//		RequestEntity<MultiValueMap<String, Object>> request=
//				RequestEntity
//				.post("http://localhost:8081/mailTest")
//				.header("content-type",MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//				.body(body);
//		
//		
//		ResponseEntity<String> response=restTemplate.exchange(request, String.class);
//		String html = response.getBody();
//		
		
		Map<String, Object> body = new LinkedHashMap<String, Object>();
	      body.put("userId", "JaeHyun");
	      body.put("mailTemplate", "signup-email-auth");
	      
	      RequestEntity<Map<String, Object>> request = 
	            RequestEntity
	            .post(new URI("http://localhost:8081/mailTest"))
	            
	            // LinkedMultiValueMap => json형태로 변경
	            // 자바의 객체 => json문자열로 변경
	            
	            // 자바의 객체 => form-url-encoded 형태로 변경해주는 HttpMessageConverter는 존재하지만
	            // json으로 변경할 HttpMessageConverter는 존재하지 않음
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(body);

	      
	      ResponseEntity<String> response =  restTemplate.exchange(request, String.class);
	      String html = response.getBody();
	      
	      System.out.println(html);
	      sender.send("ssp04041@gmail.com", "메일템플릿 테스트", html);
		
	}
	
	
	@Test
	public void requestKakaoBookAPI() {
		
		// Map의 다형성을 활용하여서 LinkedHashMap을 사용함
		Map<String,Object> body = new LinkedHashMap<String, Object>();
		body.put("prompt", "강사가 폭주한다고");
		body.put("max_tokens",64);
		
		RequestEntity<Map<String,Object>> request = 
				RequestEntity.post("https://api.kakaobrain.com/v1/inference/kogpt/generation")
				.header("Authorization", "KakaoAK "+"beecf5b9b87939aa7ba73927bfc8ce5b")
				.contentType(MediaType.APPLICATION_JSON)
				.body(body);
		
		ResponseEntity<Map> response =
				restTemplate.exchange(request, Map.class);
		
		System.out.println(response.getBody());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
