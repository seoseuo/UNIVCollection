<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>선언부를 포함한 JSP 페이지 (실습)</title>
</head>
<body>
	
	10+3 = <%= add(10,3) %><br>
	10-3 = <%= min(10,3) %><br>

	10*3 = <%= mul(10,3) %><br>
	10/3 = <%= div(10,3) %><br>
	

	
</body>
</html>

<%! private double add(double a, double b) {
	return a+b;
}
%>
<%! private double min(double a, double b) {
	return a-b;
}
%>
<%! private double mul(double a, double b) {
	return a*b;
}
%>
<%! private double div(double a, double b) {
	return a/b;
}
%>



