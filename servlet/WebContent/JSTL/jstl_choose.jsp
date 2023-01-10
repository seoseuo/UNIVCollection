<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	choose 문 <br>
	<c:choose>
		<c:when test= "${i <= 10}">
			10보다 큰수  <BR>
		</c:when>
		<c:when test= "${i <= 20}">
			11과 20 사이의 수 <BR>
		</c:when>
		<c:otherwise>
			그 이외 <BR>p
		</c:otherwise>
	</c:choose>

</body>
</html>


