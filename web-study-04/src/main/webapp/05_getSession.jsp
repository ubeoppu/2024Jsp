<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String id = (String)session.getAttribute("id2");
String pwd = (String)session.getAttribute("pwd2");
int age = (int)session.getAttribute("age2");

%>

id : <%= id %><br>
pwd : <%= pwd %><br>
age : <%= age %>
</body>
</html>