<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type ="text/javascript" src ="script/board.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="BoardServlet" method="post" name ="frm">
<span>해당 게시글 번호 : ${board.num}</span>
비밀번호 : <input type="password" name="pass" placeholder="비밀번호를 입력해주세요">
<input type="submit" value="확인" onclick ="location.href='BoardServlet?command=BoardCheckPass&num=${board.num}}'">
<h4>${message}</h4>
</form>
</body>
</html>