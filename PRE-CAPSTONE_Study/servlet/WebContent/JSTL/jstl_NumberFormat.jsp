<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML>
    <HEAD><TITLE>���� ����</TITLE></HEAD>
    <BODY>
        ù��° ��: <fmt:formatNumber value="1234500" groupingUsed="true" /> <BR>
        �ι�° ��: <fmt:formatNumber value="3.14158" pattern="#.##" /> <BR>
        ����° ��: <fmt:formatNumber value="10.5" pattern="#.00" /> 
    </BODY>
</HTML>
