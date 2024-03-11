package com.magic.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {
	
	private static EmployeesDAO instance = new EmployeesDAO();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private EmployeesDAO() {
	
	}
	
	public static EmployeesDAO getInstance() {
		return instance;
	}

    public Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ezen";
		String password = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");

		return DriverManager.getConnection(url, user, password);
	}

	public int userCheck(String id, String pwd, String lev) {
		
		String sql = "select * from Employees where id= ?";
		
		int result = -1;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			System.out.println("id>>" + id + "pwd>>" + pwd + "lev >>" + lev);
			if(rs.next()){
				if(pwd.equals(rs.getString("pass"))) {
					if(lev.equals(rs.getString("lev"))) {
						result = lev.equals("A") ? 2 : 3; 
					}else {  //등급 틀림
						result = 1;
					}
				}else{
				result = -1;  //비밀번호 틀림
			}
		}else {
				result = -0;  //아이디 틀림
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
		return result;
	}
	
	//id 해당하는 전체 데이터 가져오기
	public EmployeesVO getMember(String id) {
		String sql = "select * from Employees where id =?";
		EmployeesVO vo = new EmployeesVO();
		int result = -1;
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				//rs.getString("DB이름");
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getDate("enter"));
				vo.setGender(Integer.parseInt(rs.getString("gender")));
				vo.setPhone(rs.getString("phone"));
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

	//수정
	public int updateEmployees(EmployeesVO vo) {
		String sql = "update employees set pass=?, name=?, lev=?, gender=?"
				+ ",phone=? where id=?";
		int result = -1;
	
		try{
	con = getConnection();
	pstmt = con.prepareStatement(sql);
	
	pstmt.setString(1, vo.getPass());
	pstmt.setString(2, vo.getName());
	pstmt.setString(3, vo.getLev());
	pstmt.setInt(4, vo.getGender());
	pstmt.setString(5, vo.getPhone());
	pstmt.setString(6, vo.getId());
	
	result = pstmt.executeUpdate();
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
return result;
}
	}
	

