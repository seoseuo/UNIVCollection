<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<HTML>
    <HEAD><TITLE>숫자 포맷</TITLE></HEAD>
    <BODY>
        첫번째 수: <fmt:formatNumber value="1234500" groupingUsed="true" /> <BR>
        두번째 수: <fmt:formatNumber value="3.14158" pattern="#.##" /> <BR>
        세번째 수: <fmt:formatNumber value="10.5" pattern="#.00" /> 
    </BODY>
</HTML>
