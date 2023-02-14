package com.mc.app.member;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import com.mc.app.dto.Member;
import com.mc.app.repository.MemberRepository;

//가상으로 만들어지는 web.xml을 사용해 테스트환경을 구축
@WebAppConfiguration

//JUNIT의 실행방법을 지정
@RunWith(SpringJUnit4ClassRunner.class)

//테스트 때 사용할 가상의 ApplicationContext를 생성하고 관리
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*-context.xml" })
public class ProblemOfMemberUseMybatis {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MemberRepository memberRepository;

	@Test
	public void insertMember() {
		Member member = new Member();
		member.setUserId("admin4");
		member.setPassword("1234");
		member.setEmail("123@123.com");
		member.setTell("010-0000-0000");
		System.out.println(member);
		memberRepository.insertMember(member);
	}
	
	@Test
	public void selectMemberByIsLeave() {
		
		System.out.println(memberRepository.selectMemberByIsLeave());
	}
	
	

}
