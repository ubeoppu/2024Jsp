
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
          body {background-color:#212121 ;}
        .loginform {box-sizing: border-box;    width:600px;height: 500px; 
             background-color: #353535;text-align: center; margin: 0 auto;}
             .loginform > h1{color: white; text-align: center;}
             .loginform > h3{color:gray;}
             
             #loginform{color:#353535;}
           .loginButton{width: 440px; height: 60px; background-color:#0054FF ;border-radius: 90px;
            color:white;}
            .loginBar{width: 300px; height: 40px; background-color: #4C4C4C;}


    </style>
    
    
</head>
<body>

<div class="background">

<div class = "loginform">

<h1>로그인</h1>
<h3>name 계정으로 로그인</h3>
<div id="loginbox">
    <form action ="Test0202" method ="post">
    <input type ="text" name ="ID" placeholder="이메일 주소 또는 아이디" class="loginBar"><br><br>
    
    <input type ="password" name="PASS" placeholder="비밀번호" class="loginBar"><br><br>

    <input type="checkbox" value="아이디 저장">아이디 저장
    <input type="checkbox" value="자동 로그인">자동 로그인<br><br>

    <button class = "loginButton">로그인</button>
    </form>
    <form action ="joinPage.jsp" method = post>
    </form>
    
</div>
</div>
</div>
</body>
</html>