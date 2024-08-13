<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>춘자 : 손님 회원가입</title>

    <link href="../index.css" rel="stylesheet" type="text/css" />

    <style>

    </style>

</head>

<body>

    <div class="title">
        <img class="logo" src="../pics/logo.png" onclick="location.href='../processing.jsp?sControl=main'">
    </div>

    <div class="background-image">
        <div>.</div>

        <div class="login-border" style=" margin-top: 80px; height : 470px">
            
        </div>
        <div class="login-box" style=" margin-top: 80px; height : 480px">
            <div class="index-back-btn" onclick="location.href='../index.jsp'">
                ●
            </div>
            <br>
            <div style="font-size: 30px;">
                <b>손님으로</b>
            </div>
            <div style="font-size: 50px;"><b>회원가입</b></div>

            <form action="../processing.jsp" method="post">

                <input class="input-box" type="text" name="sCID" placeholder="아이디를 입력해주세요.">
                <br>
                <input class="input-box" type="password" name="sCPW" placeholder="비밀번호를 입력해주세요.">
                <br>
                <input class="input-box" type="text" name="sCNAME" placeholder="이름을 입력해주세요.">
                <br>

                <input type="hidden" name="sControl" value="cuRegister">
                <input class="submit-box" type="submit" value="회원가입">
            </form>

            
            
        </div>


    </div>

</body>

</html>