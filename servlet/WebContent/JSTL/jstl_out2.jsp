<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<HTML>
    <HEAD><TITLE>간단한 인사</TITLE></HEAD>
    <BODY>
        안녕하세요, <c:out value="${param.ID}" default="guest" />님
    </BODY>
</HTML>
