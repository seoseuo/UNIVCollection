<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@page import= "java.util.GregorianCalendar"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>page 지시자의 import 애트리뷰트 사용 예
</title>
</head>
<body>
	
	<% 
		GregorianCalendar now = new GregorianCalendar();
		String data = String.format("%TF",now);
		String time = String.format("%TT",now);
		%>
		
		오늘의 날짜 <%= data %> <br>
		현재의 시각 <%= time %> 
	

	
</body>
</html>




