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
	---- for each List----<br>
	
	<c:forEach var="mdtosVal" items="${mdtosList}">
		id : ${mdtosVal.id}<br>
		pw : ${mdtosVal.pw}<br>
	</c:forEach>
</body>
</html>