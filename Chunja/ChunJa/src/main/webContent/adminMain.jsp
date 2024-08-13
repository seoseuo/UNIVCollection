<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 페이지</title>

    <link href="index.css" rel="stylesheet" type="text/css" />

        <%@ page import="java.util.ArrayList, dto.CustomerDTO, dto.ROwnerDTO , beans.CustomerBean,beans.ROwnerBean, java.util.Collections" %>
    	<jsp:useBean id="restDO" class="dto.RestaurantDTO" scope="page" />

		<jsp:useBean id="roDO" class="dto.ROwnerDTO" scope="page" />
		<jsp:useBean id="cuDO" class="dto.CustomerDTO" scope="page" />

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
        <b class="s1" onclick="location.href='adminMain.jsp'">춘자 회원 명단</b>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <b class="s2" onclick="location.href='adminReport.jsp'">춘자 한마디 신고 목록</b>
    </div>

<%

	ArrayList<CustomerBean> clist = cuDO.cu_list();
	ArrayList<ROwnerBean> rlist = roDO.ro_list();

%>

        
        <table class="admin_table">
            <tr>
                <td><b>사장님 이름</b></td>
                <td><b>사장님 아이디</b></td>
                <td><b>사장님 가게이름</b></td>
                <td><b>사장님 가게 주소</b></td>
            </tr>

			<%
			
			for(ROwnerBean r : rlist) {
				
				
				%> 
				
			<tr>
                <td><%=r.getRoNAME()%></td>
                <td><%=r.getRoID()%></td>
                <td><%=r.getRoMALL()%></td>
                <td><%=r.getRoADDRESS()%></td>
            </tr>
				
				<%
			}
			
			%>

            
        </table>

        <table class="admin_table">
            <tr>
                <td><b>손님 이름</b></td>
                <td><b>손님 아이디</b></td>

            </tr>

			<%
			
			for(CustomerBean c : clist) {
				
				if(c.getCuID().equals("admin")) {
					continue;
				}
				
				%> 
				
			<tr>
                <td><%=c.getCuNAME() %></td>
                <td><%=c.getCuID() %></td>

            </tr>
				
				<%
			}
			
			%>

            
        </table>



</body>

</html>