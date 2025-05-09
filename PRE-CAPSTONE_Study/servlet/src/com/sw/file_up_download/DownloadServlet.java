package com.sw.file_up_download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/file/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String fileLocation = "c:\\New Mockup 1.png";	//change the path according to you
		String fileLocation = "C:\\Tomcat 8.5\\wtpwebapps\\file\\water.jpg";	//change the path according to you
		
		File file = new File(fileLocation);
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attatchment;filename=" + fileLocation);
				
		byte[] buffer = new byte[4096];
 
		while((fis.read(buffer, 0, 4096)) != -1){
			sos.write(buffer, 0, 4096);
		}
		
		fis.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imageFile =request.getParameter("image");
		System.out.println(imageFile);
		HttpSession session = request.getSession();
		session.setAttribute("image", imageFile);
		response.sendRedirect("imageDisplayResult.jsp");
		//<img  src="../uploadFiles/${productVO.image}"  />
	}

}
