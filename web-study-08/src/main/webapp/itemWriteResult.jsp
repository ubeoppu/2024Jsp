<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!Connection con = null;
	PreparedStatement pstmt = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String sql = "insert into item values(?,?,?)";%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("상품명");
	String price = request.getParameter("가격");
	String description = request.getParameter("설명");

	try {
		//1 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2 데이터베이스 연결
		con = DriverManager.getConnection(url, "ezen", "1234");
		//3 sql문 전송
		pstmt = con.prepareStatement(sql);
		//4 매핑
		pstmt.setString(1, request.getParameter("itemName"));
		pstmt.setString(2, request.getParameter("itemPrice"));
		pstmt.setString(3, request.getParameter("des"));
		//sql구문 실행
		int result = pstmt.executeUpdate();
		System.out.println("저장 성공 여부" + result);

		//5 연결 해제
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (con != null)
			con.close();
		if (pstmt != null)
			pstmt.close();
	}
	%>
	<h3>아이템 목록 생성 성공</h3>
	<a href="itemView.jsp">아이템 목록 확인~</a>
</body>
</html>