<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>춘자 : 사장님 로그인</title>

    <link href="../index.css" rel="stylesheet" type="text/css" />



</head>

<body>

    <div class="title">
        <img class="logo" src="../pics/logo.png" onclick="location.href='../index.jsp'">
    </div>

    <div class="background-image">
        <div>.</div>

        <div class="login-border">
            
        </div>
        <div class="login-box">
            <div class="index-back-btn" onclick="location.href='../index.jsp'">
                ●
            </div>
            <br>
            <div style="font-size: 30px;font-weight:bold;">
                사장님으로
            </div>
            <div style="font-size: 50px;font-weight:bold;">로그인</div>

            <form action="../processing.jsp" method="post">

                <input class="input-box" type="text" name="sRID" placeholder="아이디를 입력해주세요.">
                <br>
                <input class="input-box" type="password" name="sRPW" placeholder="비밀번호를 입력해주세요.">
                <br>
                <input type="hidden" name="sControl" value="roLogin">
                <input class="submit-box" type="submit" value="로그인">
            </form>

            <div class="login-bottom">
                처음이시라면 <b onclick="location.href='roRegister.jsp'" style="cursor:pointer">회원가입</b>
            </div>
            
        </div>


    </div>

</body>

</html>