package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.EmployeeVO;

public class EmployeeDAO {
	
	private static EmployeeDAO instance = new EmployeeDAO();
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;	
	
	public EmployeeDAO(){
		
	}
	
	public static EmployeeDAO getInstance() {
		return instance;
	}

	private Connection getConnector() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "ezen";
		String password = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, id, password);
	}

	//데이터베이스 아이디 체크
	//-1:아이디 틀림 0: 비밀번호 틀림 1:로그인 성공~~
	public int EmployeeCheck(String id, String pass) {
		int result = -1;
		
		
		String sql = "select pass from Employees where id =?";
		try {
			//DB연결
			System.out.println("id>>>"+id);
			con = getConnector();
			//SQL구문 전송
			pstmt = con.prepareStatement(sql);
			//매핑
			pstmt.setString(1, id);
			//SQL구문 실행
			rs = pstmt.executeQuery();
			System.out.println("result db값>>>"+ rs);
			
			if(rs.next()) {
			if(pass.equals(rs.getString("pass"))) {
			result = 1;
			}else {
				result = 0;
			}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		try {
			if(rs != null) rs.close();
			if(pstmt != null)pstmt.close();
			if(con != null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		System.out.println("result값>>>" + result);
		
		return result;
	}
	
	//회원 정보 보여주기
	public EmployeeVO EmployeeInfo(String id) {
	System.out.println("INFO ID>>>" + id);
	EmployeeVO vo = new EmployeeVO();
	
	String sql = "select * from Employees Where id = ?";
	try {
	con = getConnector();
	
	pstmt = con.prepareStatement(sql);
	
	pstmt.setString(1, id);
	
	rs = pstmt.executeQuery();
    
	if(rs.next()) {
		vo.setId(rs.getString("id"));
		vo.setPass(rs.getString("pass"));
		vo.setName(rs.getString("name"));
		vo.setLev(rs.getString("lev"));
		vo.setEnter(rs.getString("enter"));
		vo.setGender(rs.getString("gender"));
		vo.setPhone(rs.getString("phone"));
	}
	if("1".equals(vo.getGender())) {
		vo.setGender("남자");
		System.out.println("참이라서 실행됨");
	}else if("1".equals(vo.getGender())) {
		vo.setGender("여자");
	}
	
	System.out.println("Gender결과 후>>" + vo.getGender());
	System.out.println("vo정보 값>>>" + vo);
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
}
