<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div id="wrap" align="center">
      <h1>컨텐츠 등록</h1>
      <form  name="frm" method="post" action="mainServlet">
         <input type="hidden" name="command" value="insert_content">
         <table>
            <tr>
               <th>제목</th>
               <td><input type="text" size="70" name="title"></td>
            </tr> <tr>
               <th>장르</th>
               <td><input type="text" size="70" name="genre"></td>
            </tr> <tr>
               <th>배우</th>
               <td><input type="text" size="70" name="actor"></td>
            </tr> <tr>
               <th>개봉연도</th>
               <td><input type="text" size="70" name="year"></td>
            </tr>
            <tr>
               <th>내용</th>
               <td><textarea cols="70" rows="15" name="story"></textarea></td>
            </tr>
            <tr>
               <th>파일</th>
               <td><input type="file" name="poster"></td>
            </tr>
         </table>
         <br>
         <br> <input type="submit" value="등록"> 
         <input type="reset" value="다시 작성">
          <input type="button" value="목록" onclick="location.href='NetServlet?command=content_info'">
      </form>
   </div>
</body>
</html>