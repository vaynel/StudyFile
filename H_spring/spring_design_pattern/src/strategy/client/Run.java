package strategy.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import strategy.framework.common.JDBCRepository;

public class Run {
	public static void main(String[] args) {

		JDBCRepository resRepository = new JDBCRepository(() -> {
			String url = "jdbc:mysql://localhost:3306/bm?useUnicode=true&characterEncoding=utf8";

			Connection conn = null;

			try {
				conn = DriverManager.getConnection(url, "bm", "123qwe!@#QWE");
				// 개발자가 트랜잭션관리를 직접할 수 있도록 auto commit을 종료
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return conn;
		});

		String sql = "select * from member where user_id='super'";
		System.out.println(resRepository.selectOne(sql, List.of("user_id", "tell")));

	}
}

//		@Override
//		public Connection getConnection() {
//			
//			String url = "jdbc:mysql://localhost:3306/bm?useUnicode=true&characterEncoding=utf8";
//			
//			Connection conn = null;
//			
//			try {
//				conn = DriverManager.getConnection(url, "bm", "123qwe!@#QWE");
//				// 개발자가 트랜잭션관리를 직접할 수 있도록 auto commit을 종료
//				conn.setAutoCommit(false);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			return conn;
//		}