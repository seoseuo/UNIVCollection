<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@page import ="java.io.*"%>

<%--- 회원 정보를 저장하는 JSP 페이지 ---%>

<% 
	String result = "success";
	String id = (String)session.getAttribute("ID");
	String password = (String)session.getAttribute("PASSWORD");
	String name = (String)session.getAttribute("NAME");
	session.invalidate();
%>

Subscribe.jsp
<%= id %><br>
<%= password %><br>
<%= name %><br>