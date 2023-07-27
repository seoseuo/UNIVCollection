<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>춘자 : 처리중</title>
</head>
<body>

	<%
	request.setCharacterEncoding("UTF-8");
	String uName = (String)session.getAttribute("uNAME");
	String who = (String)session.getAttribute("who");
	%>


	
	<%
	
	String picsURL = getServletContext().getRealPath("/restPics");
	int maxSize = 1024 * 1024 * 30;
	MultipartRequest multi = new MultipartRequest(request,picsURL,maxSize,"utf-8",new DefaultFileRenamePolicy());
	
	String sControl2 = multi.getParameter("sControl2");
	System.out.println("sControl2 : "+sControl2);
	
	%>

	<jsp:useBean id="rowner" class="beans.ROwnerBean" scope="page" />
	<jsp:useBean id="customer" class="beans.CustomerBean" scope="page" />
	<jsp:useBean id="restaurant" class="beans.RestaurantBean" scope="page" />
	
	<jsp:useBean id="cuDO" class="dto.CustomerDTO" scope="page" />
	<jsp:useBean id="restDO" class="dto.RestaurantDTO" scope="page" />
	<jsp:useBean id="roDO" class="dto.ROwnerDTO" scope="page" />
	
	<%
	

	 if(sControl2.equals("roWrite")) {
		
		System.out.println("\n\nro_write processing.jsp-------------------------------------");
		System.out.println("reBODY :"+request.getParameter("rIntro"));
		System.out.println("reURL :"+request.getParameter("rURL"));
		System.out.println("uNAME :"+(String)session.getAttribute("uNAME"));
		
		//String restLOGO = multi.getFilesystemName("file");
		
		System.out.println("restLOGO PICS : "+multi.getFilesystemName("sRMALLPIC_main"));
		System.out.println("rest PICS1 : "+multi.getFilesystemName("sRMALLPIC_main"));
		System.out.println("rest PICS2 : "+multi.getFilesystemName("sRMALLPIC_main"));
		System.out.println("rest PICS3 : "+multi.getFilesystemName("sRMALLPIC_main"));
		System.out.println("-------------------------------------------------------------");
		
		
		
		%> 
		
		<jsp:setProperty name="restaurant" property="reNAME" value="<%=(String)session.getAttribute("uNAME") %>"/>
		<jsp:setProperty name="restaurant" property="reMALL" value="<%=roDO.ro_getDMall((String)session.getAttribute("uNAME")) %>"/>
		
		<jsp:setProperty name="restaurant" property="reURL" value="<%=multi.getParameter("rURL") %>"/>
		<jsp:setProperty name="restaurant" property="reBODY" value="<%=multi.getParameter("rIntro") %>"/>
		
		<jsp:setProperty name="restaurant" property="reLOGO" value="<%=multi.getFilesystemName("sRMALLPIC_main") %>"/>
		<jsp:setProperty name="restaurant" property="rePIC1" value="<%=multi.getFilesystemName("sRMALLPIC1") %>"/>
		<jsp:setProperty name="restaurant" property="rePIC2" value="<%=multi.getFilesystemName("sRMALLPIC2") %>"/>
		<jsp:setProperty name="restaurant" property="rePIC3" value="<%=multi.getFilesystemName("sRMALLPIC3") %>"/>
		
		<%
		
		int result = roDO.ro_write(restaurant);
			
			System.out.println(result);
			if(result==0) {
			//성공
				String roMALL = roDO.ro_getDMall(uName);
				System.out.println("write 작성 후 내 가게 페이지 보기 roMALL : "+roMALL);
				out.println("<script>alert('가게 홍보 작성이 완료되었습니다 !');location.href='RO/roMyView.jsp?roMALL="+roMALL+"';</script>");
		}
		else if(result==1){
			// 소개가 공백
			out.println("<script>alert('가게 소개를 작성해주세요 !'); history.go(-1);</script>");
		}
		else if(result==2) {
			out.println("<script>alert('URL을 입력해주세요 !'); history.go(-1);</script>");
		}
			
	}
	
	else if(sControl2.equals("roEdit")) {
		
		%>
		
		<jsp:setProperty name="restaurant" property="reNAME" value="<%=(String)session.getAttribute("uNAME") %>"/>
		<jsp:setProperty name="restaurant" property="reMALL" value="<%=roDO.ro_getDMall((String)session.getAttribute("uNAME")) %>"/>
		
		<jsp:setProperty name="restaurant" property="reURL" value="<%=multi.getParameter("rURL") %>"/>
		<jsp:setProperty name="restaurant" property="reBODY" value="<%=multi.getParameter("rIntro") %>"/>
		
		<jsp:setProperty name="restaurant" property="reLOGO" value="<%=multi.getFilesystemName("sRMALLPIC_main") %>"/>
		<jsp:setProperty name="restaurant" property="rePIC1" value="<%=multi.getFilesystemName("sRMALLPIC1") %>"/>
		<jsp:setProperty name="restaurant" property="rePIC2" value="<%=multi.getFilesystemName("sRMALLPIC2") %>"/>
		<jsp:setProperty name="restaurant" property="rePIC3" value="<%=multi.getFilesystemName("sRMALLPIC3") %>"/>
		
		<%
		
		int result = roDO.ro_edit(restaurant);
			
			System.out.println(result);
			if(result==0) {
			//성공
				String roMALL = roDO.ro_getDMall(uName);
				out.println("<script>alert('가게 홍보 수정이 완료되었습니다 !');location.href='RO/roMyView.jsp?roMALL"+roMALL+"';</script>");
		
		}
		else if(result==1){
			// 소개가 공백
			out.println("<script>alert('가게 소개를 작성해주세요 !'); history.go(-1);</script>");
		}
		else if(result==2) {
			out.println("<script>alert('URL을 입력해주세요 !'); history.go(-1);</script>");
		}
	}
	

	
	// 식당 부분
	
		
	%>

</body>
</html>
