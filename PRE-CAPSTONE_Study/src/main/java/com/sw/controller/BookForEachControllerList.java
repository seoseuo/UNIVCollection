package com.sw.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookForEachControllerList
 */
@WebServlet("/BookForEachControllerList")
public class BookForEachControllerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookForEachControllerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<BookDTO> arr = new ArrayList<BookDTO>();
		HttpSession s = request.getSession();
		
		BookDTO b1 = new BookDTO("bookName1","0001","500");
		BookDTO b2 = new BookDTO("bookName2","0002","1000");
		BookDTO b3 = new BookDTO("bookName3","0003","1500");
		BookDTO b4 = new BookDTO("bookName4","0004","3500");
		BookDTO b5 = new BookDTO("bookName5","0005","2500");
		
		arr.add(b1);
		arr.add(b2);
		arr.add(b3);
		arr.add(b4);
		arr.add(b5);
		
		s.setAttribute("BookDTOList", arr);
		response.sendRedirect("book_foreach_list.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
