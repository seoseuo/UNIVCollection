<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML>
    <HEAD><TITLE>숫자 포맷</TITLE></HEAD>
    <BODY>
        금액: <fmt:formatNumber value="1000000" type="currency" currencySymbol="￦" /> <BR>
        퍼센트: <fmt:formatNumber value="0.99" type="percent"  /> 
    </BODY>
</HTML>
