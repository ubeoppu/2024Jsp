<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! 	Connection conn = null; 
	Statement stmt = null;	
	ResultSet rs = null;	

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "test";
	String password = "1234";
	String selectQuery = "SELECT * FROM LoginInfo"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" border="1">
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일주소</td>
		</tr>
		<%
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
				stmt = conn.createStatement(); // 쿼리 호출받아주고
				rs = stmt.executeQuery(selectQuery); // 쿼리를 집어넣음
				
				while(rs.next()) { // 값이 있을경우
		%>
                 <tr>
					    <td><%= rs.getInt("memberNum") %></td>
						<td><%= rs.getString("name") %></td>      <!-- get 메서드로 값을 불러옴 -->
						<td><%= rs.getString("id") %></td>
						<td><%= rs.getString("password") %></td>
                        <td><%= rs.getString("email") %></td>
                 </tr>
						<% 
				}
			} catch(SQLException se) {
				se.printStackTrace();
			} finally {
				try{
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				}catch(SQLException se){
					se.printStackTrace();
				}
			} 

%>
	</table>
</body>
</html>