<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 결과</title>
</head>
<body>
<%@page import="java.sql.*" %>
<%

Connection con = null;	
PreparedStatement pstmt = null;	
ResultSet resultSet = null;

String DBNAME = "jdbc_db";
final String DBURL ="jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false";
final String PW = "990920";		
final String ID = "root";
final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";

String id = request.getParameter("ID");
String pw = request.getParameter("PW");
String result="fail";
String pwDb=null;

try {
	Class.forName(DRIVERNAME);
	//System.out.println("Class found successed");
	
	con = DriverManager.getConnection(DBURL,ID,PW);
	//System.out.println("sql found successed");
	
	
	String sql = "select pw from user where id =?";
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,id);

	resultSet = pstmt.executeQuery();
	
	if(resultSet.isBeforeFirst()) {
		
		while(resultSet.next()) {
			
			pwDb = resultSet.getString("pw");
			//out.println("<br> Password :"+pwDb);
			
			if(pw.equals(pwDb)) {
				result = "success";
				}
			else {
				System.out.println("invalid id");
			
			}
		}
	}
	

	
	
} catch (ClassNotFoundException e) {
	System.out.println("ClassNotFoundException ! ! !");
} catch(SQLException e) {
	System.out.println("SQLException");
}

finally
	{
	if (resultSet != null) {
		try{
			resultSet.close(); 
		} 
		catch(SQLException ex) {
			System.out.println("DB resultSet close exception !!");
		}
	}
	if (pstmt != null) {
		try{
			pstmt.close(); 
		} 
		catch(SQLException ex) {
			System.out.println("DB pstmt close exception !!");
		}
	}
	if (con != null) {
		try {
			con.close(); 
		}
		catch(SQLException ex) {
			System.out.println("DB connection close exception !!");
		}
	}
}

%>

<%
	out.println("login:"+result+"<br/>");
	out.println("id:"+id+"<br/>");
	out.println("password:"+pw+"<br/>");
%>



	</body>
</html>