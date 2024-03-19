<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>정보 수정</h2>
	<form action="mainServlet" method="post" name="frm">
	<input type ="hidden" name =command value ="update_member">
		<table border="1" width=600>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${Member.name}" size="40"
				readonly></td>
			</tr>
			<tr>
				<td>아이디</td> <!--READONLY 수정불가 -->
				<td><input type="text" name="userid"  id="userid" value ="${Member.userid}"
				size="40" readonly>
			    </td>
			</tr>
			<tr>
				<td>암 호 확인</td>
				<td><input type="password" name="pwd" size="20" ></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${Member.email}" size="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${Member.phone}"size="20"></td>
			</tr>
			<tr>
			    <td>주소</td>
			    <td><input type ="text" name="address" value="${Member.address }"size="20"></td>
		   </tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="수정">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
				</td>
			</tr>
			<tr>
				<td colspan="2">${message }</td>
			</tr>
		</table>
	</form>
</body>
</html>