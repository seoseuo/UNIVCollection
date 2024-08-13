<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP 페이지의 코드</title>
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
	
	
</body>
</html>