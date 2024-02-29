<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "paramJava.js">

</script>
</head>
<body>

<form name = "frm" action ="paramServlet" method = "get">
         아이디:<input type = "text" name ="id" placeholder="아이디를 입력하세요"><br>
         암&nbsp;&nbsp;호 :<input type = "password" name ="pass" placeholder="비밀번호를 입력하세요"><br>
         
         <input type ="submit" value="전송" onclick ="return check()">

</form>
</body>
</html>