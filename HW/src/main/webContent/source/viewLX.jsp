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


		<a href="login.html">
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

		<%
		String vTITLE = request.getParameter("dTITLE");
		String vBODY = null;
		int vHIT = 0;
		PreparedStatement pstmt = null;

		sql = "SELECT * FROM CONTENT_TABLE WHERE TITLE = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vTITLE);
		rs = pstmt.executeQuery();

		while (rs.next()) {
			vBODY = rs.getString("BODY");
			vHIT = rs.getInt("HIT");

		}

		++vHIT;

		sql = "UPDATE CONTENT_TABLE SET HIT = HIT + 1 WHERE TITLE = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vTITLE);
		pstmt.executeUpdate();
		pstmt.close();
		%>

		<div class="centerBox">
			<h1 style="text-align: left; margin-left: 20px"><%=vTITLE%></h1>
			<pre style="text-align: left; margin-left: 30px;">조회수 :&nbsp<%=vHIT%></pre>

			<hr>

			<div class="content">
				<%=vBODY%>
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