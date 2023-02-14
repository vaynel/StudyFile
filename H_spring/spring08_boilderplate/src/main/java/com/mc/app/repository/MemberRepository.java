package com.mc.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.mc.app.dto.Member;

@Repository
public interface MemberRepository {

	@Insert("insert into mem (user_id, password, tell, email) " + "values(#{userId}, #{password}, #{tell},#{email})")
	void insertMember(Member member);

	@Select("select * from mem where is_leave = 'N' ")
	List<Member> selectMemberByIsLeave();

}
