<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.meta.dao.CommentDAO" %>
<%@page import="com.meta.dto.CommentVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<style>
.centerd{
position:fixed;
left:50%;
}
.comment{
width:500px;
height:50px;

}
</style>
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
		

		<c:if test="${userid eq bulletin.userid}">
		<br> <br> <input type="button" value="게시글 수정" onclick="location.href='OttServlet?command=Bulletin_Update_Form&bulletinNum=${bulletin.bulletinNum}'">
		<input type="button" value="게시글 삭제" onclick="location.href='OttServlet?command=Bulletin_delete&bulletinNum=${bulletin.bulletinNum}'">
		</c:if>
		<input type="button" value="나의 게시글 리스트" onclick="location.href='OttServlet?command=BulletinList_View'"> 
		<input type="button" value="나의 찜목록 게시글 리스트" onclick="location.href='OttServlet?command=bulletinWishList_View'">
	</div>
		
		<form action ="OttServlet" method="post">
		<input type="hidden" name="command" value="comment_Insert">
		<input type="hidden" name="bulletinNum" value="${bulletin.bulletinNum }">
		<input type ="text" name="commentContent" placeholder="댓글을 입력하세요" class="comment">
		<input type ="submit" value="댓글 달기">
		</form>
		<table>
		<c:forEach var="comment" items="${comment}">
		<tr>
		<td>작성자 명 :${comment.userid} 작성 날짜: ${comment.commentDate }</td>

		</tr> 
		<tr>
		<td>${comment.commentContent } &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${userid eq comment.userid}">
		<input type="button" value="삭제" onclick="return checkComment(${comment.commentNum},${bulletinNum })">
		<input type="button" value="수정" onclick="open_wid('OttServlet?command=comment_Update_Form&commentNum=${comment.commentNum}', 'update')">
		</c:if>
		</td>
		</tr>
		</c:forEach>
		</table>
<script>
function open_wid(url, name){
	window.open(url, name, "width=500, height=230");
};

function checkComment(commentNum, bulletinNum){
if(confirm("삭제하시겠습니까?")){
	location.href="OttServlet?command=comment_Delete&commentNum="+ commentNum + "&bulletinNum=" + bulletinNum	
}
}
</script>

		
									
										
</body>
</html>