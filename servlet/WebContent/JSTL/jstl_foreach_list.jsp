<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

---- for each List----<br>
<c:forEach var="mdtosVal" items="${mdtosList}">
	id : ${mdtosVal.id}, pw :${mdtosVal.pw}<br>
</c:forEach><br>

---- for each String map ----<br>
<c:forEach var="mdtosString" items="${mdtosStringMap}">
	id : ${mdtosString.key}, pw :${mdtosString.value}<br>
</c:forEach><br>

---- for each Object map ----<br>
<c:forEach var="mdtosObj" items="${mdtosObjectMap}">
id : ${mdtosObj.key}, pw :${mdtosObj.value.pw}<br>
</c:forEach><br>

</body>
</html>