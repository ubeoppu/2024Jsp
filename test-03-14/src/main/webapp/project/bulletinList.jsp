<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 목록</h1>
${bulletin}
  <c:forEach var="bulletin" items="${bulletin}">
  ${bulletin.bulletinTitle}
  ${bulletin.bulletinDate }
  ${bulletin.bulletinContent }

</c:forEach>

</body>
</html>