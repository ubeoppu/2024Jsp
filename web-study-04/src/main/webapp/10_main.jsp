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
MemberVO vo = (MemberVO)session.getAttribute("member");
if(session.getAttribute("member") == null){
response.sendRedirect("10_loginForm.jsp");	
}else{
%>
<%=vo.getName()%>님 안녕하세요!<br>
아이디:<%=vo.getId()%><br>
비밀번호:<%=vo.getPwd()%><br>

<br>저희 홈페이지에 방문해 주셔서 감사합니다.
<br>즐거운 시간 되세요...
<br>
<form method="post" action="10_logout.jsp">
<input type="submit" value="로그아웃">
</form>
<%
}
%>
</body>
</html>