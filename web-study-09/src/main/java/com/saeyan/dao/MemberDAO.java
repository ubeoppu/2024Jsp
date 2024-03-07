package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.dto.MemberVO;

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

public int insertMember(MemberVO vo) {
	int result = -1;
	
	String sql = "insert into member values(?,?,?,?,?,?)";
	
	try {
		//2.데이터베이스 연결
		con = getConnection();//호출한 메서드 = 1.드라이버로드
		//3.SQL구문 전송
		pstmt = con.prepareStatement(sql);
		//4.매핑
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getUserid());
		pstmt.setString(3, vo.getPwd());
		pstmt.setString(4, vo.getEmail());
		pstmt.setString(5, vo.getPhone());
		pstmt.setInt(6, vo.getAdmin());
		
		//5.구문 실행
		result = pstmt.executeUpdate();
     	}catch(Exception e) {
		e.printStackTrace();
		
	}finally {
		try {
		if(con != null)con.close();
		if(pstmt != null)pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return result;
}

public int userCheck(String userid, String pwd) {
	
	int result = -1;
	
	String sql = "select pwd from member where userid =?";
	
	try {
		con = getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userid);
		
		rs = pstmt.executeQuery(); //SELECT한 구문을 찾을 수 없으면 0출력 찾은 행의 개수만큼 출력
		
		if(rs.next()) {
			if(rs.getString("pwd").equals(pwd)) {
				result = 1; //로그인 성공
			}else {
				result = -1; //비밀번호 불일치
			}
		}else {
			result = 0; //아이디 불일치
		}
	}catch(Exception e) {
		
	}finally {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)rs.close();
			if(con != null)con.close();
			
		}catch(Exception e) {
			
		}
	}
      
	return result;
}

//로그인 한 회원정보 가져오기
public MemberVO getMember(String userid) {
	
	String sql = "select * from member where userid =?";
	MemberVO vo = new MemberVO();
	
	try {
		con = getConnection();
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, userid);

		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			vo.setName(rs.getString("name"));
			
			vo.setUserid(rs.getString("userid"));
			
			vo.setPwd(rs.getString("pwd"));
			
			vo.setEmail(rs.getString("email"));
			
			vo.setPhone(rs.getString("phone"));
			
			vo.setAdmin(rs.getInt("admin"));
			
		}else {
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}finally {
		
		try {
			
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(con != null)con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	return vo;
}

public int updateMember(MemberVO vo) {
int result = -1;
	
	String sql = "update member set name=?, pwd=?, email=?,"
			+ "phone=?, admin=? where userid=?";
	
	try {
		//2.데이터베이스 연결
		con = getConnection();//호출한 메서드 = 1.드라이버로드
		//3.SQL구문 전송
		pstmt = con.prepareStatement(sql);
		//4.매핑
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getEmail());
		pstmt.setString(4, vo.getPhone());
		pstmt.setInt(5, vo.getAdmin());
		pstmt.setString(6, vo.getUserid());
		
		//5.구문 실행
		result = pstmt.executeUpdate();
		System.out.println("result>>>"+result);
     	}catch(Exception e) {
		e.printStackTrace();
		
	}finally {
		try {
		if(con != null)con.close();
		if(pstmt != null)pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return result;
}
	
}

