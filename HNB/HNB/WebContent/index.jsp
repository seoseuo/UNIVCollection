<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Login</title>
     <style>
        body{
            margin: 0;
        }

        .logo-wrapper{
            display: flex;
        }

        #main-logo{
            width: 300px;
            height: 300px;
            margin: auto;
            margin-top: 50px;
            margin-bottom: 10px;
            fill: gray;
        }

        .title-wrapper {
            text-align: center;
            margin-bottom: 4px;
            font-size: 40px;
        }

        #hallym{
            margin: 0 auto;

        }

        .form-input{
            width: 510px;
            height: 40px;
            margin: 10px 10px;
            border-radius: 5px;
            border: 3px solid gray;
        }

        #info-box{
            align-items: center;
            display: flex;
        }

        #info{
            width: 530px;
            height: 100px;
            margin: auto;
        }

        #submit, #btn{
            cursor : pointer;
            display: block;
            width: 200px;
            height: 50px;
            margin: auto;
            margin-top: 8px;
            border-radius: 10px;
            border: 3px solid black;
            background-color: rgb(219, 219, 219);
        }
        #icon {
            text-align: center;
            margin-top: 10%;
        }

        a {
            color: #000000;
            text-decoration: none;
            text-align: center;
        }
    </style>

</head>
<body>
    <div id="icon">
        <img src="icon.png"/>
    </div>

    <div class="login-wrapper">
        <div class="title-wrapper">
            <label id="hallym"><b>한림 자유 게시판</b></label>
        </div>
         
         <input type="button" id="btn" value="접속하기" onclick="location.href='list.do'">

    </div>
</body>
</html>