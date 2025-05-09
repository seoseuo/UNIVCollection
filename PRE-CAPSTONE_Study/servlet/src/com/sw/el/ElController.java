package com.sw.el;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/EL/ElController")
public class ElController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession = request.getSession();
		
		MemberDto mdto = new MemberDto();
		mdto.setName("mouse");
		mdto.setId("monitor");
		mdto.setPw("cup");
		
		String str ="apple";
		int i=10;

		httpSession.setAttribute("mdtos", mdto);	
		httpSession.setAttribute("elStr", str);
		httpSession.setAttribute("elInt", i);
		
		response.sendRedirect("el_output.jsp");
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
