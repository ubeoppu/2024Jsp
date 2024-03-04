<%@page import="unit01.MemberVO"%>
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
String id="pinksung";
String pwd="1234";
String name="성윤정";

MemberVO member = new MemberVO();

member.setId(id);
member.setName(name);
member.setPwd(pwd);

if(id.equals(request.getParameter("id"))&&
		pwd.equals(request.getParameter("pwd")) ){
	session.setAttribute("member", member);
	response.sendRedirect("10_main.jsp");
}else{
	response.sendRedirect("10_loginForm.jsp");
}
%>
</body>
</html>