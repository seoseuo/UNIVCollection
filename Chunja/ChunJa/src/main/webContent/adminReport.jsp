<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>
    
     <%@ page import="java.util.ArrayList, beans.CommentBean, java.util.Collections" %>
	<jsp:useBean id="restDO" class="dto.RestaurantDTO" scope="page" />

    <link href="index.css" rel="stylesheet" type="text/css" />

    <style>

        .admin_table {
            padding: 20px;
            background-color: #ffffff;
            margin: 30px;
            border: 2px black solid;
            width: 95%;
            border-radius: 20px
            
        } 
        


    </style>

</head>


<body>

    <div class="title">
         <span class="user">관리자님, 환영합니다 !</span>
        <span class="logout-box" onclick="location.href='processing.jsp?sControl=logout'">로그아웃</span>

    </div>

    <table class="title-back">
        <td style=" width:760px; height: 260px;">

                </div>
            </div>
        </td>
        <td style=" width:760px; height: 260px; text-align: right; font-family: 'CJFONT';
        color: #FFF3FD;">
            <div style="margin-right: 40px"><br>
                <span style="font-size: 50px; font-weight:bold;font-weight:bold;">관리자 페이지</span><br>
                <span style="font-size: 70px; font-weight:bold;font-weight:bold;"></span>
            </div>
        </td>
    </table>

    <div style="text-align:center;">
        <b class="s2" onclick="location.href='adminMain.jsp'">춘자 회원 명단</b>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <b class="s1" onclick="location.href='adminReport.jsp'">춘자 한마디 신고 목록</b>
    </div>


<%
		ArrayList<CommentBean> rcoms = restDO.reportComs();
%>
    <div class="RankView">
        
        
        <table class="admin_table">
            <tr><b>
                <td><b>가게</b></td>
                <td><b>한마디 손님</b></td>
                <td><b>한마디 내용</b></td>
                <td><b>시간</b></td>
                <td><b>결정</b></td>
            </tr>


			<%
				for(CommentBean coms : rcoms) {
					
			%> 
			
			<tr>
                <td><%=coms.getRoMALL() %></td>
                <td><%=coms.getComNAME() %></td>
                <td><pre><%=coms.getComBODY() %></pre></td>
                <td><%=coms.getComTIME() %></td>
                <td>
                    <span onclick="location.href='processing.jsp?sControl=DelComment&comment_body=<%= coms.getComBODY() %>&comment_name=<%= coms.getComNAME() %>&roMALL=<%= coms.getRoMALL() %>';" style="cursor: pointer;">🗑️</span>
                </td>
            </tr>
			
			<%
				}
			%>
		

            
        </table>


        

        
    </div>


</body>

</html>