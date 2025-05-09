<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>processing</title>

<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp" %>

</head>
<body>


	<% request.setCharacterEncoding("UTF-8"); %>
	<%
	String sControl = request.getParameter("control");
	System.out.println(sControl);

	String sql = null;

	ResultSet rs = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	try {
		if (sControl.equals("register")) {
			String sNAME = request.getParameter("name");
			String sID = request.getParameter("id");
			String sPW = request.getParameter("pw");

			if (sNAME == "" || sID == "" || sPW == "") {
				out.println("<script>alert('공백은 허용하지 않습니다.');</script>");
				out.println("<script>history.back();</script>");
			} else {
				int count = 0;

				sql = "SELECT COUNT(*) FROM USER_TABLE WHERE ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sID);
				rs = pstmt.executeQuery();
				rs.next();
				count = rs.getInt(1);

				if (count > 0) {
					out.println("<script>alert('이미 존재하는 ID입니다.');</script>");
					out.println("<script>history.back();</script>");
				} else {
					sql = "INSERT INTO USER_TABLE (NAME, ID, PW) VALUES (?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, sNAME);
					pstmt.setString(2, sID);
					pstmt.setString(3, sPW);
					pstmt.executeUpdate();

					out.println("<script>alert('회원가입이 완료되었습니다.');</script>");
					out.println("<script>location.href='login.jsp';</script>");
				}
			}
		} else if (sControl.equals("login")) {
			String sID = request.getParameter("id");
			String sPW = request.getParameter("pw");

			try {
				sql = "SELECT PW, NAME FROM USER_TABLE WHERE ID = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sID);
				rs = pstmt.executeQuery();
				rs.next();
				String dPW = rs.getString(1);
				String dNAME = rs.getString(2);
				
				if(sPW.equals(dPW)) {
					out.println("<script>alert('"+dNAME+"님, 환영합니다.');</script>");
					out.println("<script>location.href='mainLO.jsp?uNAME="+dNAME+"';</script>");
				
				}
				else {
					out.println("<script>alert('비밀번호가 틀렸습니다.');</script>");
					out.println("<script>history.back();</script>");
				}
				
				
			} catch(SQLException e) {
				out.println("<script>alert('존재하지 않는 아이디입니다.');</script>");
				out.println("<script>history.back();</script>");
			} 
			
		
		}
		else if(sControl.equals("logout")) {
			out.println("<script>alert('로그아웃 합니다.');</script>");
			out.println("<script>window.close();</script>");
			out.println("<script>window.open('mainLX.jsp', '_blank');</script>");
		}
		
		else if(sControl.equals("write")) {
			String uNAME = request.getParameter("name");
			String sTITLE = request.getParameter("title");
			String sBODY = request.getParameter("content");
			
			sql = "INSERT INTO CONTENT_TABLE (TITLE,BODY,HIT) VALUES (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sTITLE);
			pstmt.setString(2, sBODY);
			pstmt.setInt(3, 0);
			pstmt.executeUpdate();
			
			out.println("<script>location.href='viewLO.jsp?uNAME="+uNAME+"&dTITLE="+sTITLE+"';</script>");
			out.println("<script>alert('게시물이 작성되었습니다.');</script>");

		}
		else {
			
			sql = "UPDATE CONTENT_TABLE SET BODY = ? WHERE TITLE = ?";
			
			String sTITLE = request.getParameter("title");
			String sBODY = request.getParameter("content");
			String sNAME = request.getParameter("uNAME");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sBODY);
			pstmt.setString(2, sTITLE);

			int rowsAffected = pstmt.executeUpdate();
			
			out.println("<script>location.href='viewLO.jsp?uNAME="+sNAME+"&dTITLE="+sTITLE+"';</script>");
			out.println("<script>alert('게시물이 수정되었습니다.');</script>");
			
			
		}
	} catch (SQLException ex) {
		out.println("CONTENT 테이블 호출이 실패했습니다.<br>");
		out.println("SQLException: " + ex.getMessage());
	} finally {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}

	%>
</body>
</html>
