<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>한림위키에 오신것을 환영합니다.</title>

<link href="HW.css" rel="stylesheet" type="text/css" />

</head>


<%@ include file="dbconn.jsp"%>



<body>
	<div class="titleBox">

		<a href="mainLX.jsp"><img class="logo" src="../pics/logo.png"></a>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<h1>Hallym WIKI</h1>


		<a href="login.jsp">
			<p class="btn" style="margin-left: 450%;">로그인</p>
		</a>

	</div>

	<div class="container">

		<div class="leftBox">

			<div class="user">
				<h3>GUEST님, 반갑습니다.</h3>

				<a href="login.jsp"><p class="btn"
						style="margin: 0 auto; margin-top: 30px; color: black;">작성</p></a> <br>

				<h1>문서</h1>

				<hr>

				<%
				ResultSet rs = null;
				Statement stmt = null;

				try {
					String sql = "select * from CONTENT_TABLE";
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);

					while (rs.next()) {
						String dTITLE = rs.getString("TITLE");
				%>

				<table>
					<tr>
						<td><a href="viewLX.jsp?dTITLE=<%=dTITLE%>"><%=dTITLE%></a></td>
					</tr>
				</table>
				<%
				}
				%>


			</div>

		</div>

		<div class="centerBox">
			<h1 style="text-align: left; margin-left: 20px">한림위키 : 대문</h1>

			<hr>

			<div class="content">
				안녕하세요!<br> <br> 한림위키 웹사이트에 오신 것을 환영합니다.<br> 저희는 지식과
				정보를 공유하고 함께 성장하는 공간을 만들기 위해 노력하고 있는 커뮤니티입니다.<br> 이곳에서는 한림대학교에
				대한 다채로운 정보를 찾을 수 있으며, 여러분의 지식과 경험을 공유하고<br> 다른 사람들과 함께 배워나갈 수
				있는 기회를 제공하고자 합니다.<br> <br> 한림위키는 열린 마음과 다양성을 존중하는 곳입니다.<br>
				우리는 모두가 서로를 존중하고협력하는 커뮤니티를 지향합니다.<br> 어떤 주제든 환영하며, 다양한 의견과 관점을
				공유하는 것을 즐깁니다. 함께 참여하고 토론합니다.<br> 우리는 한림대학교의 가치를 중요시 여기고, 지식과
				정보의 자유로운 접근을 지지합니다.여러분의 참여와 기여가 항상<br> 환영되며, 함께 만들어가는 한림위키의 가치를
				높여나갈 수 있습니다.<br> <br> 한림위키에서는 한림대학교에서의 일상생활에 유용한 정보까지 다양한
				주제를 다룹니다.<br> 여러분께서는 한림위키의 회원이 되어 직접 기여할 수도 있습니다. 자신의 지식과 관심
				분야에 대해 글을 작성하거나<br> 수정함으로써, 다른 사람들에게 도움을 주고 가치있는 커뮤니티를 형성할 수
				있습니다. 또한, 다른 회원들과의 토론에<br> 참여하고 의견을 나누는 것도 큰 가치를 지니고 있습니다. <br>
				<br> 한림위키는 지식의 공유와 발전을 위한 자리이기 때문에, 우리 모두는 상호 존중과 예의를 갖추며 활동하는
				것을<br> 당부드립니다. 다른 사람의 의견을 경청하고 서로의 생각을 존중하는 마음가짐을 갖고 함께 하면, 보다
				풍부하고 의미있는 경험을 함께할 수 있을 것입니다.<br> <br> 한림위키에 오신 여러분들을 다시 한
				번 환영합니다. 지식을 나누고 함께 성장하는 여정에 함께해 주셔서 감사합니다. 한림위키는 여러분들과 함께 만들어가는 소중한
				공동체입니다. 언제든지 질문이 있거나 도움이 필요하신 경우, 우리 커뮤니티의 다른 회원들이 도움을 줄 것입니다. <br>
				<br>즐거운 시간 되세요!
			</div>

		</div>

		<div class="rightBox">
			<div class="rankBox">
				<h3>최다 조회수</h3>

				<%
				sql = "SELECT * FROM CONTENT_TABLE ORDER BY HIT DESC;";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);

				int i = 0;

				while (rs.next()) {
					String rTITLE = rs.getString("TITLE");
					i++;

					if (i == 5) {
						break;
					}
				%>
				<div class="rankContent">
					<a href="viewLX.jsp?dTITLE=<%=rTITLE%>"><%=rTITLE%></a>
				</div>

				<%
				}
				%>

			</div>


			<a href="https://linktr.ee/hallym_season"> <img class="add"
				src="../pics/sadd.jfif">
			</a>

		</div>

	</div>

</body>

</html>

<%
} catch (SQLException ex) {
out.println("CONTENT 테이블 호출이 실패했습니다.<br>");
out.println("SQLException: " + ex.getMessage());

} finally {
if (rs != null)
	rs.close();
if (stmt != null)
	stmt.close();
if (conn != null)
	conn.close();
}
%>