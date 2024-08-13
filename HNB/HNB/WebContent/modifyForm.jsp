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
	            color: white;
	        }
	
	        #create-content-box {
	            margin: 50px auto;
	            background-color: rgb(129, 137, 139);
	            width: 80%;
	            height: 580px;
	            padding: 20px 40px;
	            border-radius: 20px;
	        }
	
	        #input-title {
	            width: 100%;
	            height: 30px;
	            border-radius: 20px;
        	}
	
	        #input-content {
	            width: 100%;
	            height: 300px;
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
	        
	        #bNum {
                color: white;
            }
	        
	        
	    </style>
	</head>
	
	<body>
	    <div id="main-forum"> 
	        <a href="list.do"><img id="icon" src="icon.png"></a>
	        <b style="font-size: 50px;"><i>Hallym Notice Board 게시물 수정</i></b>
	
	    </div>  
	
	    <div id="create-content-box">
	    
		    <form action="modify.do" method="post">
		        <h2>제목</h2>
                <div id="bNum">
                    <input type="hidden" value="${beforemodi.bNum}" name="bNum">
                </div>
		        <div id="title-box">
		            <input type="text" id="input-title" name="input-title" value="${beforemodi.bTitle}" name="input-title">
		        </div>
		        <h2>내용</h2>
		        <div id="content-box">
		            <input type="text" id="input-content" name="input-content" value="${beforemodi.bDetail}" name="input-content">
		        </div>
				
		        <input type="submit" id="submit" value="작성">
		    </form>
		    
	        <button id="submit" onclick="location.href='list.do'">
	         취소
	        </button>
	        
	    </div>

	</body>
</html>