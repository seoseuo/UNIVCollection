<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>춘자 : 춘자 작성하기</title>

    <link href="../index.css" rel="stylesheet" type="text/css" />

</head>

<% String dRNAME = (String) session.getAttribute("uNAME"); %>

<body>

    <div class="title">
        <img class="logo" src="../pics/logo.png" onclick="location.href='roRank.jsp'">
        <span class="user"><%= dRNAME%> 사장님, 환영합니다 !</span>
        <span class="serachsubmit" onclick="location.href='../processing.jsp?sControl=logout'">로그아웃</span>

    </div>

    <form action="../processingData.jsp" method="post" enctype="multipart/form-data">

    <table class="title-back">
        <td style=" width:760px; height: 260px;">
            <div style="margin-left: 50px">
                <div class="index-border" style="text-align: center;">
                    작성완료
                </div>
                <input class="index-box" type="submit" value="">
               
            </div>
        </td>
        <td style=" width:760px; height: 260px; text-align: right; font-family: 'CJFONT';
        color: #FFF3FD;">
            <div style="margin-right: 40px"><br>
                <span style="font-size: 70px;font-weight:bold;">내 가게 홍보하기</span>
            </div>
        </td>
    </table>

    <div class="view-section">

        <div class="view-left">
            <div class="view-section-title">
                가게 소개    
            </div>

            <hr class="hr1">
            
            <div class="view-intro" style="padding-left: 40px;">
                    <br>
                    <input class="serachbox" type="text" name="rURL" placeholder="가게 주소의 URL을 입력해주세요." style="height:30px; width:365px; margin-bottom:5px">
                    <br><br>
                    
                    <textarea class="serachbox" name="rIntro" style="width: 365px; height:145px" placeholder="가게를 소개해주세요"></textarea>
                    
                    
                
            </div>
            
        </div>
        <div class="view-center">
            <div class="view-section-title">
                가게 사진
            </div>
            
            <hr class="hr1">
            <div class="view-intro">
                
                
                <b>로고 사진</b>
                <div style="text-align: left; font-size:small">170*190 px</div><br>
                <input type="file" name="sRMALLPIC_main"><br><br>
    
                <b>본문 사진</b><br>
                
                <div style="text-align: left; font-size:small">사진 첨부는 최대 3장까지 가능합니다. 470*280 px</div><br>
    
                <input type="file" name="sRMALLPIC1"><br>
                
                <input type="file" name="sRMALLPIC2"><br>
                
                <input type="file" name="sRMALLPIC3"><br>
                
                <input type="hidden" name="sControl2" value="roWrite"/>
                <div style="visibility: hidden; font-size:small">.</div>
                
                </div>
        </div>
        <div class="view-right">
            
            
        </div>

    </div>


    
</form>

</body>

</html>