<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
pageContext : <%= pageContext.getAttribute("name") %><br>

request : <%= request.getAttribute("name") %> <br>

session : <%= session.getAttribute("name") %> <br>

application : <%= application.getAttribute("name") %>

<a href ="07_thirdPage.jsp">세번째 페이지</a>

</body>
</html>