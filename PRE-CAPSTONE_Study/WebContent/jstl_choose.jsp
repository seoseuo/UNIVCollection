<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	choose문 <br>
	
	<c:choose>
	
		<c:when test = "${i<=10}">
			10보다 작은 수 <br>
		</c:when>
		
		<c:when test = "${i<=20}">
			11과 20 사이의 수 <br>
		</c:when>
		
		<c:otherwise>
			그 이외 <br>
		</c:otherwise>
		
	</c:choose>
	
</body>
</html>