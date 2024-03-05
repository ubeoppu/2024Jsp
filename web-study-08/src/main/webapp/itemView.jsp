<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String sql = "select * from item";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 목록 확인</title>
</head>
<body>
	<table width="800" border="1">
		<%
		try {
			//1 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2 데이터베이스 연결
			conn = DriverManager.getConnection(url, "ezen", "1234");
			stmt = conn.createStatement(); //Statement 뜻 진술이며 실행가능한 최소의 독립적인 코드조각
			//3 sql구문 실행
			rs = stmt.executeQuery(sql);
			//4 데이터베이스 값 출력
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getInt("price")%></td>
			<td><%=rs.getString("description")%></td>
		</tr>


		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		} finally {
		if (conn != null)
		conn.close();
		if (stmt != null)
		stmt.close();
		if (rs != null)
		rs.close();

		}
		%>



	</table>
</body>
</html>