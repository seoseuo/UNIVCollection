package com.sw.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sw.command.InsertCommand;
import com.sw.command.LoginCommand;
import com.sw.dto.MemberDto;
import com.sw.service.Service;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		System.out.println("uri : "+uri);
		
		String conPath = request.getContextPath();
		System.out.println("conPath : "+conPath);
		
		String command = uri.substring(conPath.length());
		System.out.println("command : "+command);
		
		
		
		String id = null;
		String pw = null;
		String name = null;
		
		int result = 0;
		
		MemberDto mdto = new MemberDto();
		
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		
		mdto.setId(id);
		mdto.setPw(pw);
		mdto.setName(name);
		
		Service service = null;
		HttpSession session = request.getSession();
		
		if(command.equals("/join.do")) {
	
			System.out.println("---join---");
			System.out.println("----------------");
			
			service = new InsertCommand();
			result = service.execute(mdto);
			if(result==1) {
				session.setAttribute("insertResult", "join session");
			}
			else {
				session.setAttribute("insertResult", "joinFail");
			}
			response.sendRedirect("join_result.jsp");
			
		}
		else if(command.equals("/login.do")) {
			
			System.out.println("---login---");
			System.out.println("----------------");
			
			service = new LoginCommand();
			result = service.execute(mdto);
			
			if(result==1) {
				session.setAttribute("loginResult", "Login sucess");
			}
			else {
				session.setAttribute("loginResult", "Login Fail");
			}
			response.sendRedirect("login_result.jsp");			
		}
	}

}
