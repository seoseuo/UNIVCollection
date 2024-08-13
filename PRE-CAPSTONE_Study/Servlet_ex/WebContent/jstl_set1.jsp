<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix= "c" uri= "http://java.sun.com/jsp/jstl/core" %>

<c:set var ="num1" value="7" />
<c:set var ="num2" value="9" />
<c:set var ="result" value="${num1*num2}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL_SET1 곱셉 프로그램</title>
</head>
<body>
	${num1}과 ${num2}의 곱은? ${result}
</body>
</html>

<c:remove var ="num1"/>
<c:remove var ="num2"/>
<c:remove var ="result"/>