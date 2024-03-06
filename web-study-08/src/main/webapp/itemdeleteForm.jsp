<%@page import="org.apache.catalina.filters.SetCharacterEncodingFilter"%>
<%@page import="org.eclipse.jdt.internal.compiler.util.SimpleSetOfCharArray"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    Connection conn = null;
    PreparedStatement pstmt = null;
    
    
    String sql = "delete from item where name = ? ";
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
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
	request.setCharacterEncoding("utf-8");
	//1 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//2 데이터베이스 연결
	conn = DriverManager.getConnection(url, "ezen", "1234");
	//3 sql구문 전송
	pstmt = conn.prepareStatement(sql);
	//4. 맵핑
	pstmt.setString(1, request.getParameter("names"));
	//5. sql구문 실행
	pstmt.executeUpdate();
	
}catch(Exception e){
	e.printStackTrace();
}finally{
	if(conn != null)conn.close();
	if(pstmt != null)pstmt.close();
}

%>
<h3>삭제 완료하였습니다</h3>
<a href = "itemView.jsp">아이템 목록 보러가기</a>
</body>
</html>