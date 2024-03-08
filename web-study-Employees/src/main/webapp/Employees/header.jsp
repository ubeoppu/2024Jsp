<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
a {
	text-decoration: none;
}

table {
	width: 800px;
}

* {
	text-align: center;
	color: black;
}

#nav table tr td:hover {
	background-color: gray;
}
</style>

</head>
<body>
	<!-- 0: login.jsp 1:main.jsp,join.jsp -->
	<c:if test="${sessionScope.number}== 0">
		<div id="nav">
			<table width="800" border="1">
				<tr>
					<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
					<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
					<th><a href="login.do">로그인</a></th>
					<th><a href="#">사원 등록<br>(괸라자로 로그인 후 사용가능)
					</a></th>
					<th><a href="#">마이페이지<br>(로그인 후 사용가능)
					</a></th>
				</tr>
			</table>
		</div>
	</c:if>


	<c:if test="${sessionScope.number}== 1">
		<div id="nav">

			<table border="1" align="center">

				<tr>
					<th>${name}님반갑습니다.</th>
					<th>레벨:${lev}</th>
					<td><a href="login.do">로그아웃</a></td>
					<td align="center"><a href="#">사원등록<br>(관리자 로그인 후
							사용가능)
					</a></td>
					<td><a href="join.do">마이페이지</a></td>
			</table>
		</div>
	</c:if>
	
	
</body>
</html>