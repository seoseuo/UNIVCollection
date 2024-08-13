<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



		<head>
		
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    
	    <style>
        body {
            background-color: rgb(255, 255, 255);
        }

        #icon {
            margin-left: 20px;
            width: 150px;
        }

        #main-forum {
            background-color: rgb(199, 218, 223);
            height: 150px;
            margin: 50px auto;
        }

        


        h2 {
            color: rgb(0, 0, 0);
        }

        #create-content-box {
            margin: 50px auto;
            background-color: rgb(231, 231, 231);
            width: 80%;
            height: 550px;
            padding: 20px 40px;
            border-radius: 20px;
        }
        
        #submit{
            float: right;
        }

        #clear{
            float: right;
        }

        #submit{
            cursor : pointer;
            display: block;
            width: 100px;
            height: 50px;
            margin-left: 20px;
            margin-top: 8px;
            border-radius: 10px;
            border: 3px solid black;
            background-color: rgb(219, 219, 219);
        }

        #title-box {
            border-radius: 20px;
            background-color: rgb(255, 255, 255);
            width: 100%;
            margin: 0px auto;
        }

        #content-box {
            border-radius: 20px;
            background-color: rgb(255, 255, 255);
            width: 100%;
            height: 300px;
            margin: 0px auto;
        }
        
        

    </style>
</head>

<body>
    <div id="main-forum"> 
        <a href="list.do"><img id="icon" src="icon.png"></a>
        <b style="font-size: 50px;"><i>Hallym Notice Board 게시물 열람</i></b>

    </div>  

        <div id="create-content-box">
            <div style="text-align: right;">
                <b><i>따봉 :${bdto.bGood} , 조회수 :${bdto.bHit}</i></b>
            </div>
            <h1>${bdto.bTitle}</h1>
            작성자 : ${bdto.bName}
            

            <h2>내용</h2>
            <div id="content-box"><br>
                &nbsp ${bdto.bDetail}
            </div>
            
            <div id="button-box">
                
                <button id="submit" onclick="location.href='list.do'">
                    뒤로가기
                </button>

                 <button id="submit" onclick="location.href='good.do?bId=${bdto.bNum}'">
                    따봉</button>
            </div>
        </div>
       

</body>

</html>