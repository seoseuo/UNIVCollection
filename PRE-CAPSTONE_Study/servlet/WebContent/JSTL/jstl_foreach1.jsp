<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
    <HEAD><TITLE>�޾Ƹ�</TITLE></HEAD>
    <BODY>
        <c:forEach var="cnt" begin="1" end="5"> 
            <FONT size=${cnt}> ��~ȣ~ </FONT> <BR>
        </c:forEach> 
    </BODY>
</HTML> 
