<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>클라이언트로 얻어온 Cookie</h3>
<%
Cookie[]cookiess = request.getCookies();

for(Cookie cookie : cookiess)
	out.println(cookie.getName() + " : " +
cookie.getValue()+ "<br>");

%>

</body>
</html>