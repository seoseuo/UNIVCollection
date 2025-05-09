<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="num1" value="7" />
<c:set var="num2" value="9" />
<c:set var="result" value="${num1*num2}" /> 
<HTML>
    <HEAD><TITLE>°ö¼À ÇÁ·Î±×·¥</TITLE></HEAD>
    <BODY>
        ${num1}°ú ${num2}ÀÇ °öÀº? ${result}
    </BODY>
</HTML> 

<c:remove var= "num1" />
<c:remove var= "num2" />
<c:remove var= "result" />