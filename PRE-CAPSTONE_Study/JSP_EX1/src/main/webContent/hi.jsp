<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 입력된 이름을 가지고 인사말을 출력하는 JSP 페이지 </title>
</head>
<body>

<h1>인사하기</h1>

	안녕하세요, <%= request.getParameter("YOURNAME") %>님
</body>
</html>