
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JoinPage</title>
    <style>
          body {background-color:#212121 ;}
        .loginform {box-sizing: border-box;    width:850px;height: 550px; 
             background-color: #353535;text-align: center; margin: 0 auto;padding:10px;}
             .loginform > h1{color: white; text-align: center;}
             .loginform > h3{color:gray;}
             
             #loginform{color:#353535;}
           .joinButton{width: 440px; height: 60px; background-color:#0054FF ;border-radius: 90px;
            color:white;}
            .loginBar{width: 300px; height: 40px; background-color: #4C4C4C;}
            #idCheck{color:lightgray; background-color:#0054FF; border-radius:90px;}


    </style>
    
    
</head>
<body>
<div class="background">
<div class = "loginform">
<h1>회원가입</h1>
<h3>이메일과 비밀번호를 입력해주세요!</h3>
<div id="loginbox">
    <input type ="text" name ="ID" placeholder="ex)ID@email.com" class="loginBar">
       &nbsp;  <input type ="submit" value ="중복 확인" id="idCheck">
    <br><br>
    <input type ="password" name="PASS" placeholder="비밀번호 설정" class="loginBar"> <br><br>
     <input type ="password" name="PASS" placeholder="비밀번호 재확인" class="loginBar"><br><br>

    <input type="checkbox" value="아이디 저장">아이디 저장
    <input type="checkbox" value="자동 로그인">자동 로그인<br><br>
    <form action ="Test0202" method ="get">
    <button class = "joinButton">회원가입</button>
    </form>
    <form action ="join" method = get>
    <a href = "http://localhost:8181/web-study-0202/RadioServlet?gender=%EB%82%A81%EC%9E%90&chk_mail=yes&content=%E3%85%87%E3%85%87">회원가입</a>
    </form>
    
</div>
</div>
</div>
</body>
</html>