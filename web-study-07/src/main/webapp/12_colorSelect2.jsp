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
<!--  
<c:if test="${param.color==1}">
<h1 style="background-color:red">빨강</h1>
</c:if>

<c:if test="${param.color==2}">
<h1 style="background-color:blue">파랑</h1>
</c:if>

<c:if test="${param.color==3}">
<h1 style="background-color:yellow">노랑</h1>
</c:if>
-->
<c:choose>


<c:when test="${param.color==1}">
<h1 style="background-color:red">빨강</h1>
</c:when>


<c:when test="${param.color==2}">
<h1 style="background-color:blue">파랑</h1>
</c:when>

<c:when test="${param.color==3}">
<h1 style="background-color:yellow">노랑</h1>
</c:when>
</c:choose>

</body>
</html>