<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<%@ include file="dbconn.jsp"%>

<%
String uNAME = request.getParameter("uNAME");
%>


<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>여러분의 의견을 작성해주세요.</title>

<link href="HW.css" rel="stylesheet" type="text/css" />

<style>
input[type="text"] {
	text-align: left;
}

.inputTitle {
	margin: 0 auto;
	height: 50px;
	width: 90%;
}

.inputContent {
	height: 500px;
	width: 96%;
}
</style>

</head>

<body>
	<div class="titleBox">

		<a href="mainLO.jsp?uNAME=<%=uNAME%>"><img class="logo"
			src="../pics/logo.png"></a> &nbsp;&nbsp;&nbsp;&nbsp;
		<h1>Hallym WIKI</h1>


		<a href="processing.jsp?control=logout">
			<p class="btn" style="margin-left: 450%;">로그아웃</p>
		</a>

	</div>

	<div class="container">

		<div class="leftBox">

			<div class="user">
				<h3><%=uNAME%>님, 반갑습니다.
				</h3>

				<a href="mainLO.jsp"><p class="btn"
						style="margin: 0 auto; margin-top: 30px; color: black;">메인</p></a> <br>

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
						<td><a href="viewLO.jsp?dTITLE=<%=dTITLE%>&uNAME=<%=uNAME%>"><%=dTITLE%></a></td>
					</tr>
				</table>
				<%
				}
				%>


			</div>

		</div>

		<div class="centerBox">

			<form action="processing.jsp" method="post">
				<h1>
					<input type="text" class="inputTitle" name="title"
						placeholder="제목을 입력하세요.">
				</h1>
				<hr>

				<div class="content">

					<textarea name="content" cols="114" rows="40"
						placeholder="본문을 입력하세요."></textarea>
					<input type="hidden" name="control" value="write" /> <input
						type="hidden" name="name" value=<%=uNAME%> />
				</div>

				<input type="submit" class="btn" value="완료" style="margin: 0 auto;">

			</form>


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
					<a href="viewLO.jsp?dTITLE=<%=rTITLE%>&uNAME=<%=uNAME%>"><%=rTITLE%></a>
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