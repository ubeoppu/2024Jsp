<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String[]items = request.getParameterValues("item");
%>
당신이 선택한 항목입니다.<hr>
<c:forEach items="${items}" var="item" varStatus="status">
${item}<c:if test="${not status.last}">,</c:if>
</c:forEach>
</body>
</html>