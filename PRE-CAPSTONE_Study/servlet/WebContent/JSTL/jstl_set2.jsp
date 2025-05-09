<%@page contentType="text/html; charset=euc-kr"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
<c:set var="CODE" value="80012" scope="request" /> 
<c:set var="NAME" value="온습도계" scope="request" /> 
<c:set var="PRICE" value="15000" scope="request" />
 --%>
 <c:set var="CODE" value="80012" scope="page" /> 
<c:set var="NAME" value="온습도계" scope="page" /> 
<c:set var="PRICE" value="15000" scope="page" />
<jsp:forward page="ProductInfoView.jsp" />
