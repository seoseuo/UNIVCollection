<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@page import ="java.io.*"%>

<%--- ȸ�� ������ �����ϴ� JSP ������ ---%>

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