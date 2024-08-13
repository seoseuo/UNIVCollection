<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>숫자 포멧</title>
</head>
<body>
	
	첫번째 수 : <fmt:formatNumber value = "1234500" groupingUsed = "true" /><br>
	두번째 수 : <fmt:formatNumber value = "3.14558" pattern = "#.##" /><br>
	세번째 수 : <fmt:formatNumber value = "3.14558" pattern = "#.00" />
	
	<hr>
	
	금액 : <fmt:formatNumber value="1000000" type="currency" currencySymbol="$"/><br>
	퍼센트: <fmt:formatNumber value= "0.99" type= "percent" />

	<hr>
	
	<c:set var= "num" value= "10.5555" />
	10.5555<br>
	반올림 : <fmt:formatNumber value= "${num}" pattern= "#.00" /><br>
	소숫점없앰 : <fmt:parseNumber var= "integerVal" value= "${num}" integerOnly= "true"/>
	${integerVal}
</body>
</html>