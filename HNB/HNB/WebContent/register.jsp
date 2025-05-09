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
            fill: black;
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
            margin: 5px 10px;
            border-radius: 5px;
            border: 3px solid gray;
        }

        #info-box{
            align-items: center;
            display: flex;
            padding-top: 5px;
        }

        #info{
            width: 530px;
            height: 100px;
            margin: auto;
        }

        #submit {
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
        
    </style>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Pacifico&display=swap" rel="stylesheet">
</head>
<body>
    <div class="logo-wrapper">
        <svg id="main-logo" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 1000 1000" enable-background="new 0 0 1000 1000" xml:space="preserve">
            <metadata> Svg Vector Icons : http://www.onlinewebfonts.com/icon </metadata>
            <g><path d="M729.9,637.9c-30.3-22.5-62.9-40.7-97.1-54.5c19.4-12.3,37.6-26.8,54.3-43.4c58.6-58.6,90.9-136.6,90.9-219.5c0-82.9-32.3-160.9-90.9-219.5C628.4,42.3,550.4,10,467.5,10c-82.9,0-160.9,32.3-219.5,90.9c-58.6,58.6-90.9,136.6-90.9,219.5c0,82.9,32.3,160.9,90.9,219.5c16.8,16.8,35.1,31.4,54.7,43.7c0,0,0,0,0,0c-0.1,0-0.2,0.1-0.3,0.1h0.2c-46.7,18.9-90.2,45.9-128.4,80.2C94,735.9,43,834.2,30.7,940.7c-2.1,17.9,10.7,34,28.6,36.1c1.3,0.1,2.5,0.2,3.8,0.2c16.3,0,30.4-12.2,32.3-28.8c10.5-90.7,53.9-174.4,122.2-235.7c68.9-61.8,157.8-95.8,250.4-95.8c81,0,158.2,25.4,223.1,73.5c14.5,10.7,34.8,7.7,45.6-6.8C747.4,669,744.3,648.6,729.9,637.9z M294.1,493.9c-46.3-46.3-71.8-107.9-71.8-173.5s25.5-127.1,71.8-173.5c46.3-46.3,107.9-71.8,173.5-71.8c65.5,0,127.1,25.5,173.5,71.8s71.8,107.9,71.8,173.5S687.3,447.6,641,493.9c-30.3,30.2-67,51.6-107.1,62.8c-25.1,7-51.3,9.9-77.4,8.8c-18.7-0.8-37.3-3.8-55.3-8.8c0,0-0.1,0-0.1,0l0,0C361,545.5,324.3,524.1,294.1,493.9z M936.9,808.5h-83.8v-83.8c0-18-14.6-32.6-32.6-32.6c-18,0-32.6,14.6-32.6,32.6v83.8h-83.8c-18,0-32.6,14.6-32.6,32.6c0,18,14.6,32.6,32.6,32.6H788v83.8c0,18,14.6,32.6,32.6,32.6c18,0,32.6-14.6,32.6-32.6v-83.8h83.8c18,0,32.6-14.6,32.6-32.6C969.5,823.1,954.9,808.5,936.9,808.5z"/></g>
        </svg>
    </div>

    <div class="login-wrapper">
        <div class="title-wrapper">
            <label id="hallym">한림 자유 게시판</label>
        </div>

        <form action="join.do" method="post">
            <div id="info">
           
                <label>
                    <input type="text" class="form-input" placeholder="이름" name="name"/>
                </label>
                <label>
                    <input type="text" class="form-input" placeholder="ID" name="id"/>
                </label>
                <label>
                    <input type="password" class="form-input" placeholder="PW" name="pw"/>
                </label>

                <input type="submit" id="submit" value="회원가입">
            </div>
    
        </form>
    
    </div>
</body>
</html>

