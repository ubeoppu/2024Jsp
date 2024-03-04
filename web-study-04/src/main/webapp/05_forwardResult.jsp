<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="pink">
<%
    int age=Integer.parseInt(request.getParameter("age"));
    String name = (String)request.getAttribute("name");
    String name1 = request.getParameter("name1");
%>

 forward 방식으로 이동된 페이지<br><br>
나이:<%= age %>세
이름:<%=name %>
입력이름:<%= name1 %>

</body>
</html>