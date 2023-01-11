<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("ID");
	String password = request.getParameter("PASSWORD");
	String name = request.getParameter("NAME");
	
	session.setAttribute("ID",id);
	session.setAttribute("PASSWORD",password);
	session.setAttribute("NAME",name);
	
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>약관 동의 화면을 제공하는 JSP 페이지</title>
</head>
<body>
	<H3>약관</H3>
	-------------------------------------------- <BR>
	1. 회원 정보는 웹 사이트의 운영을 위해서만 사용됩니다. <BR>
	2. 웹 사이트의 정상 운영을 방해하는 회원은 탈퇴 처리합니다. <BR>
	-------------------------------------------- <BR>
	<FORM ACTION=Subscribe.jsp METHOD=POST>
	위의 약관에 동의하십니까?
	<input type = submit value='확인'>
	</FORM>
</body>
</html>