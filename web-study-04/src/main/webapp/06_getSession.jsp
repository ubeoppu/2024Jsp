<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>섹션에 결정된 모든 값 가져오기</h1>
<%
    Enumeration<String>names= session.getAttributeNames();

while(names.hasMoreElements()){
	String name = names.nextElement().toString();
		String value = session.getAttribute(name).toString();
		out.println(name + " : " + value + "<br>");
}
%>
</body>
</html>