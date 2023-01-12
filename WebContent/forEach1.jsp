<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메아리</title>
</head>
<body>
	<c:forEach var="cnt" begin="1" end="5">
		<FONT size =${cnt}>야호</FONT><br>
	</c:forEach>
	
	
	<c:forEach var="cnt" begin="1" end="10">
		${cnt}<br>
	</c:forEach>
	
</body>
</html>