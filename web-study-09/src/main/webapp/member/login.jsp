<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>로그인</h2>
	<form action="login.do" method="post" name="frm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid" value="${userid}"></td>
			</tr>
			<tr>
				<td>암 호</td>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<td  colspan="2" align="center"><input type="submit" value="로그인"
					onclick="return loginCheck()">&nbsp;&nbsp; <input
					type="reset" value="취소"> &nbsp;&nbsp; <input type="button"					
					value="회원 가입" onclick="location.href='join.do'"></td><!-- location:현재 창의 URL을 나타내는 객체, href:현재 창의 URL을 나타내는 속성 -->
			</tr>
			<tr>
				<td colspan="2">${message}</td>
			</tr>
		</table>
	</form>
</body>
</html>