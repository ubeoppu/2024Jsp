<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>출력 결과</h1>

<% 
   int n1 = (int)request.getAttribute("num1"); 
   int n2 = (int)request.getAttribute("num2");
%>
${num1} + ${num2} = ${add};

</body>
</html>