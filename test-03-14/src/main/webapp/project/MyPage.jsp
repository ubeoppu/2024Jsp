<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "mainServlet" method ="post">
<h3>마이페이지입니다.</h3>
<input type ="hidden" name ="userid" value= ${userid }>
<a href ="OttServlet?command=changeUser_InformationForm">개인정보 변경</a><br>
<a href ="OttServlet?command=BulletinList_View">내가 작성한 게시글 확인</a><br>
<a href ="OttServlet?command=contentWishList_View">내가 찜한 작품</a><br>
<a href ="OttServlet?command=bulletinWishList_View">내가 찜한 게시글</a><br>
<a href ="OttServlet?command=delete_User">회원 탈퇴</a><br><br>
<a href ="OttServlet?command=logout_User">로그아웃</a>
${message}
</form>
</body>
</html>