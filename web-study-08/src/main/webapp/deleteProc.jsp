<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    Connection con = null;
    PreparedStatement pstmt = null;
    
    String username = "ezen";
    String password = "1234";
    String url ="jdbc:oracle:thin:@localhost:1521:xe";
    String sql = "delete from member where userid =?";
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try{
	//1.드라이브 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	//2 데이터베이스 연결
	con = DriverManager.getConnection(url, username, password);
	
	//3 sql전송
	pstmt = con.prepareStatement(sql);
	
	//4 맵핑
	pstmt.setString(1, request.getParameter("id"));
	
	//5 sql구문 실행
	pstmt.executeUpdate();
	
}catch(Exception e){
	e.printStackTrace();
	
}finally{
	try{
		if(pstmt != null) pstmt.close();
		if(con != null) con.close();
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>
<h3>회원 삭제 성공</h3>
<a href="01_allMember.jsp">회원 목록 확인하러 가기</a>
</body>
</html>