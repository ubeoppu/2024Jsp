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
//String id = request.getParameter("id");
//String pass = request.getParameter("password");

String id = "test1234";
String pass = "1234";
String name = "비밀이야";

if(id.equals(request.getParameter("id")) && pass.equals(request.getParameter("password")) ){
    session.setAttribute("loginUser", name);
	response.sendRedirect("loginForm29.jsp");
}else{
	response.sendRedirect("loginForm2.jsp");
}
%>

</body>
</html>