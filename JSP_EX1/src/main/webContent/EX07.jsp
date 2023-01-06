<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title> 여러 가지 주석을 포함하는 JSP 페이지 </title>
	<!--  이것은 JSP에 의해 생성된 HTML 문서입니다. -->	
</head>
<body>
	<%-- 다음은 데이터를 처리하는 스크립툴릿입니다. --%>
	<% int result = 1;
		/* 1부터 10까지 곱하는 반복문 */
		
		for(int cnt = 1; cnt <=10; cnt++) {
			result*=cnt;
		}
	%>
	1부터 10까지 곱한 값은 ? <%=result %>
</body>
</html>




