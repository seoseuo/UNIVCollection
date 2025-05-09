<%@ page import= "java.sql.*" %>
<%
	Connection conn = null;

	String url = "jdbc:mysql://localhost:3306/HWDB";
	
	String user = "root";
	String password = "990920";
	
	Class.forName("com.mysql.jdbc.Driver");
	
	conn = DriverManager.getConnection(url, user, password);
%>