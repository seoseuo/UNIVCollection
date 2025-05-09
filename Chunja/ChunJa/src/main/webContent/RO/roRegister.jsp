<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>춘자 : 사장님으로 회원가입</title>

    <link href="../index.css" rel="stylesheet" type="text/css" />

    <style>

    </style>

</head>

<body>

    <div class="title">
        <img class="logo" src="../pics/logo.png" onclick="location.href='../index.jsp'">
    </div>

    <div class="background-image">
        <div>.</div>

        <div class="login-border" style="margin-top : 10px; height : 600px">
            
        </div>
        <div class="login-box" style="margin-top : 10px; height : 610px">
            <div class="index-back-btn" onclick="location.href='../index.jsp'">
                ●
            </div>
            <br>
            <div style="font-size: 30px;font-weight:bold;">
                <b>사장님으로</b>
            </div>
            <div style="font-size: 50px;font-weight:bold;"><b>회원가입</b></div>

            <form action="../processing.jsp" method="post">

                <input class="input-box" type="text" name="sRID" placeholder="아이디를 입력해주세요.">
                <br>
                <input class="input-box" type="password" name="sRPW" placeholder="비밀번호를 입력해주세요.">
                <br>
                <input class="input-box" type="text" name="sRNAME" placeholder="이름을 입력해주세요.">
                <br>
                <input class="input-box" type="text" name="sRMALL" placeholder="가게 이름을 입력해주세요.">
                <br>
                <input class="input-box" type="text" name="sRADDRESS" placeholder="가게 주소를 입력해주세요.">
                <br>

                <input type="hidden" name="sControl" value="roRegister">
                <input class="submit-box" type="submit" value="회원가입">
            </form>

            
            
        </div>


    </div>

</body>

</html>