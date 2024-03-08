<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type ="text/javascript" src="JavaScript/Employees.js">	</script>
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
<form action ="update.do" name ="frm">
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

	<table border="1" align="center">
		<tr>
			<td colspan ="2"><h2>사원 정보</h2><br><b>${message}</b></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" value="${id}" readonly></td>
		</tr>

		<tr>
			<td>비밀번호</td>
			<td><input type="password" value="" name="password"></td>
		</tr>
		
		<tr>
			<td>비밀번호 재확인</td>
			<td><input type="password" value="" name="CheckPassword"></td>
		</tr>

		<tr>
			<td>이름</td>
			<td><input type="text" value="${name}" name="name"></td>
		</tr>
		<tr>
			<td>권한</td>
			<td>${lev}</td>
		</tr>

		<tr>
			<td>성별</td>
			<td>${gender}</td>
		</tr>

		<tr>
			<td>전화번호</td>
			<td><input type ="text" value="${phone}" name="phone"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" value="수정" onclick="return passwordCheck()">
		<input type="button" value="취소"> 
		</td>
		</tr>
		
	</table>
	</form>
</body>
</html>