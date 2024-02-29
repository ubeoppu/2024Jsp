<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



      <%   

      int num1 = 10;
      int num2 = 20;
      int add = num1+num2;

      %>
      
      <%= num1 %> + <%= num2 %> = <b><%= add %></b><br>
      
      <%
      String name = "임재현";
      int age = 24;
      
      int ran = (int)(Math.random()*10)+1;
      %>
     <%  for(int i = 0; i < 3; i++)   %>
     
      이름 : <%=name %> <br>
      나이 : <%= age %><br>
      랜덤 : <%= ran %>
      
</body>
</html>