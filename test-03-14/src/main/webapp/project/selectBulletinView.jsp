<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script type ="text/javascript" src="script/board.js"></script>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
</head>
<body>
<div id="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>게시글 번호</th>
				<td>${bulletin.bulletinNum}</td>
				<th>작성자</th>
				<td>${bulletin.name}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${bulletin.bulletinDate}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${bulletin.bulletinTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${bulletin.bulletinContent }</pre></td>
			</tr>
		</table>
		<br> <br> <input type="button" value="게시글 수정"
			onclick="open_wid('BoardServlet?command=board_check_pass_form&num=${board.num}', 'update')">
		<input type="button" value="게시글 삭제" onclick="location.href='OttServlet?command=myBulletin_delete&bulletinNum=${bulletin.bulletinNum}'">
		<input type="button" value="게시글 리스트"onclick="location.href='OttServlet?command=BulletinList_View'"> 
	</div>
</body>
</html>