package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//싱글톤 사용

public class MemberDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static MemberDAO instance = new MemberDAO();
	
private MemberDAO(){
	
}

public static MemberDAO getInstance() {
	return instance;
}

public Connection getConnection() throws Exception {
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String user = "ezen";
	String password = "1234";
	
	//1드라이브 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//2.데이터베이스 연결
	return DriverManager.getConnection(url, user, password);
	
}

//ID중복체크 메서드
public int confirmID(String userid) {
	
	
	int result = -1;
	
	String sql = "select userid from member where userid =?";
	
	try {
		//1. 연결
		con = getConnection();
		
		//2. SQL 구문 전송
		pstmt = con.prepareStatement(sql);
		
		//3. 매핑
		pstmt.setString(1, userid);
	
		//4. SQL 구문 실행
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			result = 1;
			
		}else {
			result = -1;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			//5.자원 반납
			if(con != null)con.close();
			if(pstmt != null)pstmt.close();
			if(rs != null)rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	return result;
}
}
