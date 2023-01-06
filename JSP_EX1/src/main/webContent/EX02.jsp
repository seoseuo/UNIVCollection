<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 여러 개의 스크립틀릿이 있는 JSP 페이지</title>
</head>
<body>
	<% 
	int total = 0;
	for(int i=1; i<=100; i++) {
		total+=i;
	}
	System.out.println("total : "+total);
	%>
	
	1부터 100까지 더한 값은 ? <%= total %>
	
	<% 
	total = 0;
	for(int i=1; i<=200; i++) {
		total+=i;
	}
	System.out.println("total : "+total);
	%>
	
	<br>
	
	1부터 200까지 더한 값은 ? <%= total %>
	
	
</body>
</html>