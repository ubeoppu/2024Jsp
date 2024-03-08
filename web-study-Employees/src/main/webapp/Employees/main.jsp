<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file ="header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
a {text-decoration:none;}
table {width: 800px;}
* {text-align: center; color:black;}
#nav table tr td:hover{background-color:gray;}
</style>
</head>
<body>
<div id = "nav">
<table border ="1" align = "center">
<tr>
<th>${name}님 반갑습니다.</th>
<th>레벨:${lev}</th>
<td><a href = "login.do">로그아웃</a></td>
<td align ="center"><a href = "#">사원등록<br>(관리자 로그인 후 사용가능)</a></td>
<td><a href ="join.do">마이페이지</a></td>
</table>
</div>
<h1>회원 전용 페이지</h1>
<img src = "">

</body>
</html>