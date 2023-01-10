<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String str1 = request.getParameter("NUM1");
    String str2 = request.getParameter("NUM2");
    int num1 = Integer.parseInt(str1);
    int num2 = Integer.parseInt(str2);
%>
<HTML>
    <HEAD><TITLE>나눗셈 프로그램</TITLE></HEAD>
    <BODY>
        <c:catch var="e">
            <% int result = num1 / num2; %> 
            나눗셈의 결과는? <%= result %> 
        </c:catch>
        <c:if test="${e != null}" >
            에러 메시지: ${e.message}
        </c:if>
    </BODY>
</HTML>
