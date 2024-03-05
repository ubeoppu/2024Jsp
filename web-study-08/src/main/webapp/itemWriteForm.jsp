<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="itemWriteResult.jsp">
<h3>정보 입력 폼</h3><br>
상품명<input type ="text" name="itemName"><br>

 가&nbsp;격 &nbsp;<input type ="text" name="itemPrice"><br>
 
 설명&nbsp;<textarea name="des" rows ="10" cols="70"></textarea>
<input type ="submit" value="전송"><br><br><br>
</form>
<form action = "itemdeleteForm.jsp">
<h4>삭제 입력</h4>
삭제할 상품명 입력<input type ="text" name ="names">
<input type = "submit" value ="삭제">
</form>
</body>
</html>