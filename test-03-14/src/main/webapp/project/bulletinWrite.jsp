<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>Insert title here</title>
</head>
<body>
<div id="wrap" align="center">
      <h1>게시글 등록</h1>
      <form name="frm" method="post" action="OttServlet">
         <input type="hidden" name="command" value="board_write">
         <table>
            <tr>
               <th>제목</th>
               <td><input type="text" size="68" name="title"> </td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="content"></textarea></td>
            </tr>
         </table>
         <br>
         <br> <input type="submit" value="등록" onclick="location.href='BoardServlet?command=board_write'"> 
              <input type="reset" value="다시 작성"> 
              <input type="button" value="목록"onclick="location.href='BoardServlet?command=board_list'">
      </form>
   </div>
   </body>
</html>