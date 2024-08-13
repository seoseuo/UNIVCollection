<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>춘자 : 춘자 리스트</title>

    <link href="../index.css" rel="stylesheet" type="text/css" />
    
            <%@ page import="java.util.ArrayList, dto.RestaurantDTO , beans.RestaurantBean, beans.CommentBean, java.util.Collections" %>
    <jsp:useBean id="restDO" class="dto.RestaurantDTO" scope="page" />

</head>

<% String dRNAME = (String) session.getAttribute("uNAME");
String roMALL = request.getParameter("roMALL") == null ? (String) session.getAttribute("roMALL") : request.getParameter("roMALL");
session.setAttribute("roMALL", roMALL);
%>
<body>

    <div class="title">
        <img class="logo" src="../pics/logo.png" onclick="location.href='roRank.jsp'">
        <span class="user"><%= dRNAME%> 사장님, 환영합니다 !</span>
        <span class="serachsubmit" onclick="location.href='../processing.jsp?sControl=logout'">로그아웃</span>

    </div>

    <table class="title-back">
        <td style=" width:760px; height: 260px;">
            <div style="margin-left: 50px">
                <div class="index-border" style="text-align: center;">
                    수정하기
                </div>
                <div class="index-box" onclick="location.href='roEdit.jsp?roMALL<%=roMALL%>'">
                </div>
            </div>
        </td>
        <td style=" width:760px; height: 260px; text-align: right; font-family: 'CJFONT';
        color: #FFF3FD;">
            <div style="margin-right: 40px"><br>
                <span style="font-size: 70px;font-weight:bold;"><%=roMALL %></span>
            </div>
        </td>
    </table>
    
        <% 

	ArrayList<RestaurantBean> view = restDO.view(roMALL);
	String[] pics = {view.get(0).getRePIC1(),view.get(0).getRePIC3(),view.get(0).getRePIC2()};
	
	
%>
    

    <div class="view-section">

		<div class="view-left">
			<div class="view-section-title">가게 소개</div>

			<hr class="hr1">

			<div class="view-intro">
				<b>평균 꽃점</b> <img class="view-flower" src="../pics/f.png" /> <%=view.get(0).getReSCORE()%>점
				<br><br> <b>가게 주소 📍 </b><br> <%=view.get(0).getReADDRESS() %> <br> <br> 
				<b>가게지도 🗺️</b> <br> <br>
				<iframe
					src="<%=view.get(0).getReURL() %>"
					width="410" height="300" style="border: 0;" allowfullscreen=""
					loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
				</iframe>
				<br> <br> <b>가게 소개</b>
				<pre><%=view.get(0).getReBODY()%></pre>
			</div>

		</div>
		

			
			<div class="view-center">
			<div class="view-section-title">가게 사진</div>

			<hr class="hr1">
			<div class="view-intro">
			
			<% 
				for(String pic : pics) {
					if(pic==null || pic.equals(null) || pic.equals("")) break;
			%>

				<img class="view-center-pic" src="../restPics/<%=pic %>"><br><br>
				
				<%
				}
				%>
			</div>
		</div>
		
		
        <div class="view-right">
            <div class="view-section-title">
                손님 한마디 
            </div>

            <hr class="hr1">
            <%
			
			ArrayList<CommentBean> comList = restDO.getComment(roMALL);
			
			for(CommentBean coms : comList) {
						
			%>
			
			<br> <br>
			<div class="view-intro">
				<b><%=coms.getComNAME() %></b> 
				<br> <%=coms.getComBODY() %><br> 
				
				<%for(int i=0; i<coms.getComSCORE(); i++) { %>
				
					<img class="view-flower" src="../pics/f.png" />
				<%} %>
				
				<div style="text-align: right; font-size: small"><span onclick="location.href='../processing.jsp?sControl=roReport&roMALL=<%=roMALL%>&comment_body=<%=coms.getComBODY() %>&comment_cuNAME=<%=coms.getComNAME() %>';" style="cursor: pointer;">🚨</span><%=coms.getComTIME()%></div>
			</div>
			
			<%
			}
			%>
            
        </div>
        
        

    </div>


    


</body>

</html>