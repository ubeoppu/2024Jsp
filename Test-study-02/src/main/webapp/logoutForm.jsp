<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
alert("로그아웃에 성공하셨습니다.")
</script>
<%
response.sendRedirect("loginForm2.jsp");
%>
</body>
</html>