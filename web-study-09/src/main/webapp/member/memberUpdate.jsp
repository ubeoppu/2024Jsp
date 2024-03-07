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
	<h2>회원 가입</h2>
	'*' 표시 항목은 필수 입력 항목입니다.
	<form action="memberUpdate.do" method="post" name="frm">
		<table border="1" width=600>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${mVo.name}" size="40"
				readonly>*</td>
			</tr>
			<tr>
				<td>아이디</td> <!--READONLY 수정불가 -->
				<td><input type="text" name="userid"  id="userid" value ="${mVo.userid}"
				size="40" readonly>*
			    </td>
			</tr>
			<tr>
				<td>암 호</td>
				<td><input type="password" name="pwd" size="20" >*</td>
			</tr>
			<tr height="30">
				<td width="80">암호 확인</td>
				<td><input type="password" name="pwd_check" size="20">*</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${mVo.email}" size="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${mVo.phone}"size="20"></td>
			</tr>
			<tr>
				<td>등급</td>
				<td>
				<c:choose>
				  <c:when test="${mVo.admin==0}">
				        <input type="radio" name="admin" value="0" checked>일반회원
				        <input type="radio" name="admin" value="1">관리자
				  </c:when>
				  <c:otherwise>
				       <input type="radio" name="admin" value="0" checked>일반회원
				        <input type="radio" name="admin" value="1">관리자
				  </c:otherwise>
				</c:choose>
				</td>
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