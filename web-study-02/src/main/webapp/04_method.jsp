<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>                        <!-- 생략가능 -->
<form action="MethodServlet" method="get">
         <input type = "submit" value = "get방식으로 처리">
</form>
<br>
<hr>
<form action="MethodServlet" method="post">
         <input type = "submit" value = "post방식으로 처리">
</form>
</body>
</html>