<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <!DOCTYPE html>


<html>
<head>

<style>
 #nav table tr th:hover{background-color:gray;}
a { text-decoration: none;}
</style>

<meta charset="UTF-8">
<script type="text/javascript" src="JavaScript/Employees.js"></script>
<title>로그인 창</title>
</head>
<body>
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


	<form action="login.do" method="post" name="frm">
		<table width="550" border="1" colspan="2" rows="5" align="center">

			<tr>
				<th colspan=2>로그인</th>
			</tr>

			<tr align="center">
				<th>아이디</th>
				<td><input type="text" name="id" size=40px></td>
			</tr>
			<tr align="center">
				<th>비밀번호</th>
				<td><input type="password" name="pass" size=40px></td>
			</tr>
			<tr align="center">
				<th>레벨</th>
				<td><select name=lev>
						<option value="A" selected>운영자</option>
						<option value="B">일반회원</option>
				</select></td>
			</tr>
			<tr>
				<th colspan=3><input type="submit" value="로그인"
					onclick="return loginCheck()" id="login" name="login"> 
					<input type="button" value="취소"><br>&nbsp; <b>${message}</b>
				</th>

			</tr>



		</table>
	</form>
</body>
</html>