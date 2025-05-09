<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>춘자 : 춘자 랭킹</title>

    <link href="../index.css" rel="stylesheet" type="text/css" />

</head>
<% String dRNAME = (String) session.getAttribute("uNAME"); %>



<%@ page import="java.util.ArrayList, dto.RestaurantDTO , beans.RestaurantBean" %>
<jsp:useBean id="restDO" class="dto.RestaurantDTO" scope="page" />





<body>

    <div class="title">
        <img class="logo" src="../pics/logo.png" onclick="location.href='roRank.jsp'">
        <span class="user"><%= dRNAME%> 사장님, 환영합니다 !</span>
        <span class="logout-box" onclick="location.href='../processing.jsp?sControl=logout'">로그아웃</span>

    </div>

    <table class="title-back">
        <td style=" width:760px; height: 260px;">
            <div style="margin-left: 50px">
                <div class="index-border" style="text-align: center;">
                    내 가게
                </div>
                <div class="index-box" onclick="location.href='../processing.jsp?sControl=roCheck'">
                </div>
            </div>
        </td>
        <td style=" width:760px; height: 260px; text-align: right; font-family: 'CJFONT';
        color: #FFF3FD;">
            <div style="margin-right: 40px"><br>
                <span style="font-size: 50px; font-weight:bold;font-weight:bold;">춘천 자영업 화이팅</span><br>
                <span style="font-size: 70px; font-weight:bold;font-weight:bold;">춘자</span>
            </div>
        </td>
    </table>
	
    <div style="text-align:center;">
        <b class="s1" onclick="location.href='roRank.jsp'">춘자 랭킹</b>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <b class="s2" onclick="location.href='roList.jsp'">춘자 가게들</b>
    </div>
	
    <table class="RankView">
    <tr>
        <th>🥇</th>
        <th>🥈</th>
        <th>🥉</th>
    </tr>
    
    <%        
    ArrayList<RestaurantBean> rank = restDO.rank();
    
    int count = 0; // 행 카운트 변수
    
    for (RestaurantBean r : rank) {
        if (count % 3 == 0) {
            // 새로운 행 시작
            out.println("<tr>");
        }
    %>
    
    <td class="view-Box" onclick="location.href='roView.jsp?roMALL=<%=r.getReMALL() %>'">
        <div class="view-PicBox">
            <img class="view-Pic" src="../restPics/<%=r.getReLOGO() %>" />
        </div>
        <div class="view-Title"><b><%= r.getReMALL() %></b></div>
        
        <%
        for (int i = 0; i < (int) r.getReSCORE(); i++) {
        %>
        <img class="view-flower" src="../pics/f.png" />
        <%
        }
        %>
    </td>
    
    <%
        count++;
        
        if (count % 3 == 0) {
            // 행 닫기
            out.println("</tr>");
        }
    }
    
    // 행이 완전하지 않을 경우 남은 셀을 빈 셀로 채움
    while (count % 3 != 0) {
        out.println("<td></td>");
        count++;
    }
    
    if (count % 3 != 0) {
        // 마지막 행 닫기
        out.println("</tr>");
    }
    %>
</table>


</body>

</html>