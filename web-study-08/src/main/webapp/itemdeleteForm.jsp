<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    Connection conn = null;
    Statement stmt = null;
    
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
	//1 드라이버 로드
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//2 데이터베이스 연결
	conn = DriverMannager
	
}catch(Exception e){
	
}finally{
	
}

%>

</body>
</html>