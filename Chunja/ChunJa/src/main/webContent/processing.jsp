<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.sql.Timestamp" %>
	


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>춘자 : 처리중</title>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");
	%>

	<%
	String sControl = request.getParameter("sControl");
	System.out.println("sControl : "+sControl);
	
	%>
	

	<jsp:useBean id="rowner" class="beans.ROwnerBean" scope="page" />
	<jsp:useBean id="customer" class="beans.CustomerBean" scope="page" />
	<jsp:useBean id="restaurant" class="beans.RestaurantBean" scope="page" />
	<jsp:useBean id="comment" class="beans.CommentBean" scope="page" />
	
	<jsp:useBean id="roDO" class="dto.ROwnerDTO" scope="page" />
	<jsp:useBean id="cuDO" class="dto.CustomerDTO" scope="page" />
	<jsp:useBean id="restDO" class="dto.RestaurantDTO" scope="page" />

	
	<%
	
	

	// 사장 부분
	if(sControl.equals("roLogin")) {
		
		%>
		<jsp:setProperty name="rowner" property="roID" value="<%=request.getParameter("sRID") %>"/>
		<jsp:setProperty name="rowner" property="roPW" value="<%=request.getParameter("sRPW") %>"/>
		<%
		
		int result =2;
		result=roDO.ro_login(rowner);


			if(result==0) {
				String uNAME = roDO.ro_getDnaem(rowner);
				
				session.setAttribute("uNAME",uNAME);
				session.setAttribute("who","RO");
				
				System.out.println("ro세션에 저장되는 uName : "+uNAME);
				
				out.println("<script>alert('"+uNAME+"사장님! 춘자 방문을 환영합니다.');location.href='RO/roRank.jsp'</script>");
				
			}
			
			else if(result==1){
				out.println("<script>alert('아이디 또는 비밀번호가 공백입니다.'); history.go(-1);</script>");
			}

			else if(result==2){
				out.println("<script>alert('존재하지 않는 아이디입니다.'); history.go(-1);</script>");
			}

			else if(result==3){
				out.println("<script>alert('비밀번호가 틀립니다.') history.go(-1);;</script>");
			}
			



			
	}
	
	else if(sControl.equals("roRegister")) {
		%>
		<jsp:setProperty name="rowner" property="roID" value="<%=request.getParameter("sRID") %>"/>
		<jsp:setProperty name="rowner" property="roPW" value="<%=request.getParameter("sRPW") %>"/>
		<jsp:setProperty name="rowner" property="roNAME" value="<%=request.getParameter("sRNAME") %>"/>
		<jsp:setProperty name="rowner" property="roMALL" value="<%=request.getParameter("sRMALL") %>"/>
		<jsp:setProperty name="rowner" property="roADDRESS" value="<%=request.getParameter("sRADDRESS") %>"/>
		<%
		
		int result = roDO.ro_register(rowner);
		
		if (result==0) {
			out.println("<script>alert('회원가입이 완료되었습니다.');location.href='RO/roLogin.jsp'</script>");
			
		}
		
		else if(result==1) {
			out.println("<script>alert('입력 칸이 비어있습니다.');history.go(-1);</script>");

		}
		
		else if(result==2) {
			out.println("<script>alert('아이디가 중복되었습니다.');history.go(-1);</script>");			
		}
		
		else if(result==3) {
			out.println("<script>alert('중복된 이름입니다.');history.go(-1);</script>");
		}
		
		else if(result==4) {
			out.println("<script>alert('중복된 가게 이름입니다.');history.go(-1);</script>");
		}
		
		else if(result==5) {
			out.println("<script>alert('중복된 가게 주소입니다.');history.go(-1);</script>");
		}
		
	}
	
	else if(sControl.equals("roView")) {
		

		String uNAME = (String)session.getAttribute("uNAME");
		
		if(uNAME.equals(roDO.ro_getDNameFromMall(rowner))) {
			out.println("<script>location.href='RO/roMyView.jsp'</script>");
		}
		else {
			out.println("<script>location.href='RO/roView.jsp'</script>");
		}
			
		
	}

	
	else if(sControl.equals("roCheck")) {
		String uNAME = (String)session.getAttribute("uNAME");
		String roMALL = roDO.ro_getDMall(uNAME);
		System.out.println("roChck/ro.getDMall : "+roMALL);
		
		if(roDO.ro_Check(uNAME)) {
			out.println("<script>location.href='RO/roMyView.jsp?roMALL="+roMALL+"';</script>");
			
		}
		else {
			out.println("<script>location.href='RO/roWrite.jsp?roMALL="+roMALL+"';</script>");
		}
	}
	
	else if(sControl.equals("roReport")) {
		
		String cuNAME = request.getParameter("comment_cuNAME");
		String comment_body = request.getParameter("comment_body");
		String roMALL = request.getParameter("roMALL");
		
		%>
		
		<jsp:setProperty name="comment" property="comNAME" value="<%=cuNAME %>"/>
		<jsp:setProperty name="comment" property="comBODY" value="<%=comment_body %>"/>
		<jsp:setProperty name="comment" property="roMALL" value="<%=roMALL %>"/>
		
		<%
		
		roDO.ro_Report(comment);
		
		out.println("<script>");
		out.println("alert('댓글 신고가 완료되었습니다.');");
		out.println("location.href='RO/roMyView.jsp';");
		out.println("</script>");
		
		
	}

	
	// 손님 부분
	else if(sControl.equals("cuLogin")) {
		%>
		<jsp:setProperty name="customer" property="cuID" value="<%=request.getParameter("sCID") %>"/>
		<jsp:setProperty name="customer" property="cuPW" value="<%=request.getParameter("sCPW") %>"/>
		<%
		
		int result = cuDO.cu_login(customer);
		
		
		if(result==0) {
			
			String uNAME = cuDO.cu_getDname(customer);
			String uID = customer.getCuID();
			
			session.setAttribute("uID",uID);
			session.setAttribute("uNAME",uNAME);
			session.setAttribute("who","CU");
			
			//랭크 받고
			//세션에 넣기
			
			
			out.println("<script>alert('"+uNAME+"손님! 춘자 방문을 환영합니다.');location.href='CU/cuRank.jsp';</script>");
			
		}
		
		else if(result==1){	
			out.println("<script>alert('아이디 또는 비밀번호가 공백입니다.'); history.go(-1);</script>");
		}

		else if(result==2){
			out.println("<script>alert('존재하지 않는 아이디입니다.'); history.go(-1);</script>");
		}

		else if(result==3){
			out.println("<script>alert('비밀번호가 틀립니다.'); history.go(-1);</script>");
		}
		
		else if(result==4) {
			session.setAttribute("who","admin");
			out.println("<script>alert('관리자님! 춘자 방문을 환영합니다.');location.href='adminMain.jsp'</script>");
		}
	}
	
	else if(sControl.equals("cuRegister")) {
		
		%>
		
		<jsp:setProperty name="customer" property="cuID" value="<%=request.getParameter("sCID") %>"/>
		<jsp:setProperty name="customer" property="cuPW" value="<%=request.getParameter("sCPW") %>"/>
		<jsp:setProperty name="customer" property="cuNAME" value="<%=request.getParameter("sCNAME") %>"/>
		
	
		<%
		
		int result = cuDO.cu_register(customer);
		
		if (result==0) {
			out.println("<script>alert('회원가입이 완료되었습니다.');location.href='CU/cuLogin.jsp'</script>");
			
		}
		
		else if(result==1) {
			out.println("<script>alert('입력 칸이 비어있습니다.');history.go(-1);</script>");

		}
		
		else if(result==2) {
			out.println("<script>alert('아이디가 중복되었습니다.');history.go(-1);</script>");			
		}
		
		else if(result==3) {
			out.println("<script>alert('중복된 이름입니다.');history.go(-1);</script>");
		}
		
		
		
	}
	
	else if(sControl.equals("cuCommenting")) {
		
		String uID = (String)session.getAttribute("uID");
		String uNAME = (String)session.getAttribute("uNAME");
		int flowerScore = Integer.parseInt(request.getParameter("flowerScore"));
		String com = request.getParameter("comment");
		String roMALL = request.getParameter("roMALL");
		%>
		
		<jsp:setProperty name="comment" property="comID" value="<%=uID %>"/>
		<jsp:setProperty name="comment" property="comSCORE" value="<%=flowerScore %>"/>
		<jsp:setProperty name="comment" property="comNAME" value="<%=uNAME %>"/>
		<jsp:setProperty name="comment" property="comBODY" value="<%=com %>"/>
		<jsp:setProperty name="comment" property="roMALL" value="<%=roMALL %>"/>
		
		<%
		System.out.println("Comment - processing.jsp");
		System.out.println("cuID :"+uID);
		System.out.println("cuNAME :"+uNAME);
		System.out.println("score :"+flowerScore);
		System.out.println("comment :"+comment);
		System.out.println("roMALL :"+roMALL);
		
		int result = cuDO.cu_commenting(comment);
		
		if(result==0) { //성공일 때
			out.println("<script>alert('한마디 작성이 완료되었습니다.');location.href='CU/cuView.jsp?roMALL="+roMALL+"'</script>");
		}
		
		else if(result==1){ //공백일 때
			out.println("<script>alert('한마디가 없습니다.');history.go(-1);</script>");
		}
		
	}
	
	else if(sControl.equals("DelComment")) {
		
		String comment_body= request.getParameter("comment_body");
		String comment_name= request.getParameter("comment_name");
		String roMALL= request.getParameter("roMALL");
		
		%>
		
		<jsp:setProperty name="comment" property="comNAME" value="<%=comment_name %>"/>
		<jsp:setProperty name="comment" property="comBODY" value="<%=comment_body %>"/>
		<jsp:setProperty name="comment" property="roMALL" value="<%=roMALL%>"/>
		
		<%
		cuDO.cu_delComment(comment);
		
		String who =(String)session.getAttribute("who");
		if(who.equals("CU")) {
			out.println("<script>");
			out.println("alert('댓글 삭제가 완료되었습니다.');");
			out.println("location.href='CU/cuView.jsp?roMALL=" + roMALL + "';");
			out.println("</script>");
		}
		else {
			out.println("<script>");
			out.println("alert('댓글 삭제가 완료되었습니다.');");
			out.println("location.href='adminReport.jsp';");
			out.println("</script>");
		}
	}
		

	
//기타 기능
	else if(sControl.equals("logout")) {
		// 세션에 있는 모든 데이터 삭제
		session.invalidate();
		out.println("<script>location.href='index.jsp';</script>");
		
	}
	
	else if (sControl.equals("main")) {
		
		String who = (String)session.getAttribute("who");
		if(who.equals("RO")) {
			out.println("<script>location.href='RO/roRank.jsp'</script>");
		}
		
		else {
			out.println("<script>location.href='CU/cuRank.jsp'</script>");
		}
	}
	
	
	%>

</body>
</html>
