<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>한림위키 : 로그인</title>

    <link href="HW.css" rel="stylesheet" type="text/css" />

    <style>
        .form-input {
            width: 380px;
            height: 40px;
            margin: 10px 10px;
            border-radius: 20px;
            border: 3px solid gray;
        }

        .center {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100px;
        }

    </style>

</head>

<body>


    <div class="container">

        <div class="leftBox">

        </div>

        <div class="centerBox">
            <h1 style="text-align: left;
                margin-left:20px">한림위키 : 로그인
            </h1>

                
            <hr>


            <div>
                <a href="mainLX.jsp">
                    <img src="../pics/logo.png" style="width: 280px; height: 300px;">
                </a>
            </div>

            <form action="processing.jsp" method="post">

                <div style="margin: auto;">
                    <input type="text" class="form-input" placeholder="id" name="id" /><br>
                    <input type="password" class="form-input" placeholder="password" name="pw" />
					<input type="hidden" name="control" value="login"/>

                    <div class="center">
                        <input type="submit" class="btn" value="로그인">
                        <input type="button" class="btn" value="회원가입" onclick="location.href='register.jsp'">

                    </div>

                </div>


            </form>

        </div>

        <div class="rightBox">


        </div>

    </div>

</body>

</html>