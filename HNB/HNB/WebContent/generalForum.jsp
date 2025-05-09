<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
	        integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
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
	
	        .form-input{
	            width: 150px;
	            height: 40px;
	            margin: 10px 10px;
	            border-radius: 5px;
	            background-color: #dddddd;
	            border: 3px solid gray;
	        }
	
	        #forum-name {
	            float: left;
	            width: 70%;
	            height: 100px;
	            background-color: rgb(255, 255, 255);
	            margin-top: 0px;
	            margin-left: 10px;
	        }
	
	        #forum-name-text {
	            font-size: 60px;
	        }
	
	        #popular-post {
	            float: right;
	            width: 28%;
	            background-color: rgb(129, 137, 139);
	            margin-top: 110px;
	            margin-right: 10px;
	            /* display: flex; */
	            /* flex-direction: column; */
	            padding: 10px 5px;
	            box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	        }
	
	        #popular-post-title {
	            margin-top: 10px;
	            color: white;
	
	        }
	
	        #main-forum-post {
	            /* background-color: #154871; */
	            /* float: left; */
	            width: 70%;
	            margin-top: 10px;
	            margin-left: 10px;
	            display: inline-block;
	        }
	
	        table {
	            border: 1px #a39485 solid;
	            font-size: .9em;
	            box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	            width: 100%;
	            border-collapse: collapse;
	            border-radius: 5px;
	            /* overflow: hidden; */
	        }
	
	        th {
	            text-align: left;
	        }
	
	        thead {
	            font-weight: bold;
	            color: #fff;
	            background: rgb(129, 137, 139);
	        }
	
	        td,
	        th {
	            padding: 1em .5em;
	            vertical-align: middle;
	        }
	
	        td {
	            border-bottom: 1px solid rgba(0, 0, 0, .1);
	            background: #fff;
	        }
	
	        a {
	            color: #000000;
	            text-decoration: none;
	        }
	        a:visited {
	            color : black;
	            text-decoration: none;
	          }
	          a:active {
	            color : rgb(0, 0, 0);
	            text-decoration: none;
	          }
	
	        .frame{
	            display: flex;
	            justify-content: end;
	            height: 50px;
	            /* background-color: green; */
	            margin-top: 10px;
	        }
	            
	        .frame > div {
	            margin-left: auto;
	        }
	
	
	
	        @media all and (max-width: 768px) {
	
	            table,
	            thead,
	            tbody,
	            th,
	            td,
	            tr {
	                display: block;
	            }
	
	            th {
	                text-align: right;
	            }
	
	            table {
	                position: relative;
	                padding-bottom: 0;
	                border: none;
	                box-shadow: 0 0 10px rgba(0, 0, 0, .2);
	            }
	
	            thead {
	                float: left;
	                white-space: nowrap;
	            }
	
	            tbody {
	                overflow-x: auto;
	                overflow-y: hidden;
	                position: relative;
	                white-space: nowrap;
	            }
	
	            tr {
	                display: inline-block;
	                vertical-align: top;
	            }
	
	            th {
	                border-bottom: 1px solid #a39485;
	            }
	
	            td {
	                border-bottom: 1px solid #e5e5e5;
	            }
	
	
	        }
	    </style>
	</head>
	
	<body>
	    <div id="main-forum"> 
	        <a href="list.do"><img id="icon" src="icon.png"></a>
	        <span style="font-size: 50px;"> ${UserName} 님</span>
	        방문을 환영합니다.
	        
    		<div style="text-align: right;">
            	<button type="button" class="form-input" onclick="location.href='logout.do'">로그아웃</button>
        	</div>
	        
	    </div>  
	        <div id="forum-name">
	            <span id="forum-name-text"><i><b>한림 자유 게시판</b></i></span>
	            <b>Hallym Notice Board
	            </b>    
	        </div>
	
	        <div id="popular-post">
	            <div id="popular-post-title">
	            
	                <b>가장 많은 조회수</b>
	            </div>
		            <ul class="list-group list-group-flush">
			      
				                <li class="list-group-item"><a href="content_view.do?bId=${bTopHit[0].bNum}">${bTopHit[0].bTitle}</a></li>
				                <li class="list-group-item"><a href="content_view.do?bId=${bTopHit[1].bNum}">${bTopHit[1].bTitle}</a></li>
				                <li class="list-group-item"><a href="content_view.do?bId=${bTopHit[2].bNum}">${bTopHit[2].bTitle}</a></li>

		            </ul>
	            <div id="popular-post-title">
	                <b>가장 많은 따봉</b>
	            </div>
		            <ul class="list-group list-group-flush">
			            
				                <li class="list-group-item"><a href="content_view.do?bId=${bTopGood[0].bNum}">${bTopGood[0].bTitle}</a></li>
				                <li class="list-group-item"><a href="content_view.do?bId=${bTopGood[1].bNum}">${bTopGood[1].bTitle}</a></li>
				                <li class="list-group-item"><a href="content_view.do?bId=${bTopGood[2].bNum}">${bTopGood[2].bTitle}</a></li>
			            
		            </ul>
	        </div>
	
	        <div id="main-forum-post">
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>조회수</th>
                        <th>따봉</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>공지</td>
                        <td><b>한림 자유 게시판에 오신것을 환영합니다.</b></td>
                        <td>개발자</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                    
                    <c:forEach items="${bList}" var="dto">
						<tr>
							<td>${dto.bNum}</td>
							<td><a href="content_view.do?bId=${dto.bNum}">${dto.bTitle}</a></td>					
							<td>${dto.bName}</td>
							<td>${dto.bHit}</td>
							<td>${dto.bGood}</td>
						</tr>
					</c:forEach>
                </tbody>
            </table>
	            <div class="frame">
						<button type="button" class="form-input" onclick="location.href='write_view.do'">작성하기</button>
	            </div>
	        </div>
	    
	</body>

</html>