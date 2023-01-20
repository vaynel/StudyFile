package strategy.framework.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class JDBCTemplate {
	
	private ConnectionCreator connectionCreator;
		
	// singleton pattern 임으로 프로그램내에서 한번만 호출되는 생성자
	public JDBCTemplate(ConnectionCreator connectionCreator) {
		try {
			// JVM에 com.mysql.cj.jdbc.Driver 클래스의 정보를 올리는 코드.
			// 클래스 정보 데이터는 static영역에 올라가기 때문에, 한번만 드라이버를 등록하면 프로그램 종료 때 까지 메모리에 내려오지 않는다.
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connectionCreator=connectionCreator;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setConfig(Map<String,String> conf) {
		
	}
	
	public Connection getConnection() {
		return connectionCreator.getConnection();
	}
	
	
//	public abstract Connection getConnection() ;
	
	public void commit(Connection conn) {
		
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void rollback(Connection conn) {
		
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void close(ResultSet rset) {
		
		try {
			
			if(rset != null && !rset.isClosed()) rset.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void close(Statement stmt) {
		
		try {
			
			if(stmt != null && !stmt.isClosed()) stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close(Connection conn) {
		
		try {
			
			if(conn != null && !conn.isClosed()) conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void close(ResultSet rset, Statement stmt) {
		close(rset);
		close(stmt);
	}
	
	
//	public Connection getConnection() {
//		
//		String url = "jdbc:mysql://localhost:3306/bm?useUnicode=true&characterEncoding=utf8";
//		
//		Connection conn = null;
//		
//		try {
//			conn = DriverManager.getConnection(url, "bm", "123qwe!@#QWE");
//			// 개발자가 트랜잭션관리를 직접할 수 있도록 auto commit을 종료
//			conn.setAutoCommit(false);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return conn;
//	}
//	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}