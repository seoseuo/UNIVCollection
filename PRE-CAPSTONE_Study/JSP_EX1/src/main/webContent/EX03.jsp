<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 선언부를 포함한 JSP 페이지</title>
</head>
<body>
	2 ^ 1 = <%= power(2, 1) %> <BR>
	2 ^ 2 = <%= power(2, 2) %> <BR>
	2 ^ 3 = <%= power(2, 3) %> <BR>
	2 ^ 4 = <%= power(2, 4) %> <BR>
	2 ^ 5 = <%= power(2, 5) %> <BR>


	
</body>
</html>

	<%!
	final static int Max = 10000; %>
	
	<%! private int add(int num1,int num2) {
		int sum = num1 + num2;
		return sum;
	}
	%>
	
	<%! private int power(int base, int exponent) {
		int result = 1;
		for(int cnt = 0; cnt < exponent; cnt++)
			result*=base;
		return result;
	}
	%>