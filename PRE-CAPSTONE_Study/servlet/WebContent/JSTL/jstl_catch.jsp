<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String str1 = request.getParameter("NUM1");
    String str2 = request.getParameter("NUM2");
    int num1 = Integer.parseInt(str1);
    int num2 = Integer.parseInt(str2);
%>
<HTML>
    <HEAD><TITLE>������ ���α׷�</TITLE></HEAD>
    <BODY>
        <c:catch var="e">
            <% int result = num1 / num2; %> 
            �������� �����? <%= result %> 
        </c:catch>
        <c:if test="${e != null}" >
            ���� �޽���: ${e.message}
        </c:if>
    </BODY>
</HTML>
