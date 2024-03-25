<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
   <div id="wrap" align="center">
      <h1>게시글 수정</h1>
      <form name="frm" method="post" action="OttServlet">
         <input type="hidden" name="command" value="bulletin_update"> <input
            type="hidden" name="bulletinNum" value="${bulletin.bulletinNum}">
         <table>
            <tr>
               <th>작성자</th>
               <td><input type="text" size="12" name="name" readonly value="${bulletin.name}"> </td>
            </tr>
            <tr>
               <th>아이디</th>
               <td><input type="text" name="userId" value="test1234" readonly></td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" name="bulletinTitle"
                  value="${bulletin.bulletinTitle}"></td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="bulletinContent">${bulletin.bulletinContent}</textarea></td>
            </tr>
         </table>
         <br>
         <br> <input type="submit" value="등록">
              <input type="reset" value="다시 작성">
              <input type="button" value="목록" onclick="location.href='OttServlet?command=bulletin_list'">
      </form>
   </div>
</body>
</html>