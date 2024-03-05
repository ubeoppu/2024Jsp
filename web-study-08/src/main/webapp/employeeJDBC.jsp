<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    Connection con = null;
    ResultSet rs = null;
    Statement stmt = null;   
    
    String sql = "select * from EMPLOYEE";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width = 800 border= "1">
<%
try{
//1 드라이버 로드
Class.forName("oracle.jdbc.driver.OracleDriver");

//2 데이터베이스 연결
con = DriverManager.getConnection(url, "ezen", "1234");
//3 sql구문 실행
stmt = con.createStatement();
rs =  stmt.executeQuery(sql);
//4 데이터베이스 값 출력

while(rs.next()){%>
<tr>
<td><%= rs.getString("name")%></td>
<td><%= rs.getString("address")%></td>
<td><%= rs.getString("ssn") %></td>
</tr>
<% }
//연결 해제
}catch(Exception e){
	e.printStackTrace();
}finally{
	if(rs != null)rs.close();
	if(stmt != null)stmt.close();
	if(con != null)con.close();
}

%>
</table>
</body>
</html>