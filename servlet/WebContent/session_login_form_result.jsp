<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>   
<%
              request.setCharacterEncoding( "EUC-KR");
              String id = (String)session.getAttribute( "id");
              String pw = (String)session.getAttribute( "pw");             
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
session_login_form_result <br>
id : <%= id%>
pw : <%= pw%>
</body>
</html>