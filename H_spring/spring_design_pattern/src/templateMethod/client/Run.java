package templateMethod.client;

import java.util.List;


import templateMethod.framework.JDBCRepository;

public class Run {
	public static void main(String[] args) {
		
		
		JDBCRepository resRepository = new JDBCRepository(new ClientJDBCTemplate());
		
		String sql = "select user_id,email from member where user_id='super'";
		System.out.println(resRepository.selectOne(sql, List.of("user_id","email")));
		
	}
}
