package com.sw.jstl;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class JstrAttribute
 */
@WebServlet("/JSTL/JstlForEachControllerList")
public class JstlForEachControllerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JstlForEachControllerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		
		ArrayList<MemberDTO> mdtoArrayList= new ArrayList <MemberDTO>();
		Map<String, String> mdtoStringMap= new HashMap<String, String>();
		Map<String, MemberDTO> mdtoObjMap= new HashMap<String, MemberDTO>();
		HttpSession httpSession = request.getSession();
		
		MemberDTO mdto = new MemberDTO();
		mdto.setName("mouse");
		mdto.setId("monitor");
		mdto.setPw("cup");
		mdtoArrayList.add(mdto);
		mdtoStringMap.put("monitor", "cup");
		mdtoObjMap.put("monitor", mdto);
		
		MemberDTO mdto1 = new MemberDTO();
		mdto1.setName("apple");
		mdto1.setId("orange");
		mdto1.setPw("desk");
		mdtoArrayList.add(mdto1);
		mdtoStringMap.put("orange", "desk");
		mdtoObjMap.put("orange", mdto1);
		

		httpSession.setAttribute("mdtosList", mdtoArrayList);
		httpSession.setAttribute("mdtosStringMap", mdtoStringMap);
		httpSession.setAttribute("mdtosObjectMap", mdtoObjMap);	
		
		response.sendRedirect("jstl_foreach_list.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}
	
}