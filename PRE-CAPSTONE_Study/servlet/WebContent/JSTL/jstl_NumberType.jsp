<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML>
    <HEAD><TITLE>���� ����</TITLE></HEAD>
    <BODY>
        �ݾ�: <fmt:formatNumber value="1000000" type="currency" currencySymbol="��" /> <BR>
        �ۼ�Ʈ: <fmt:formatNumber value="0.99" type="percent"  /> 
    </BODY>
</HTML>
