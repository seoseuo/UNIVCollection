package com.sw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sw.command.BoardService;
import com.sw.command.BoardServiceImpl;
import com.sw.dto.BDto;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
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
			request.setCharacterEncoding("UTF-8");
			
			String uri = request.getRequestURI();
			System.out.println("uri : "+uri);
			
			String conPath = request.getContextPath();
			System.out.println("conPath : "+conPath);
			
			String com = uri.substring(conPath.length());
			System.out.println("command : "+com);
			

			String viewPage = null;
			
			BoardService bCmd = new BoardServiceImpl();
			HttpSession session = request.getSession();
			
			System.out.println("actionDo - "+com);
			
				if(com.equals("/list.do")) {
					System.out.println("-----/list do -----");

					String log = (String)session.getAttribute("Login?");
					System.out.println("목록으로 , 로그인 여부 ? =>"+log);
					
					ArrayList<BDto> bList = bCmd.showBoardList(); //게시물 나열
					session.setAttribute("bList", bList);
					
					BoardService tH = new BoardServiceImpl(); // 최다 조회수 나열
					ArrayList<BDto> Thit = tH.topHit();
					session.setAttribute("bTopHit", Thit);		

					BoardService tG = new BoardServiceImpl(); //최다 좋아요 나열
					ArrayList<BDto> Tgood = tG.topGood();
					session.setAttribute("bTopGood", Tgood);		
					
					
					if(log==null) {
						
						viewPage = "generalForumLogX.jsp";
					}
					else {
						
						String userId = (String)session.getAttribute("ID");
						String bName = bCmd.getUserName(userId);
						
						session.setAttribute("UserName", bName);
						
						
						viewPage = "generalForum.jsp";
					}
				} 
				
	
				
				
				else if(com.equals("/join.do")) {
					
					String bName = request.getParameter("name");
					String bId = request.getParameter("id");
					String bPw = request.getParameter("pw");

					System.out.println("회원가입 체크");
					System.out.println("bName =>"+bName);
					System.out.println("bId =>"+bId);
					
					
					if(bName.equals("") || bId.equals("")) {
						alertAndGo(response,"아이디나 이름은 공백으로 둘 수 없습니다.","register.jsp");
					}
					
					else {
						int result = bCmd.registerCheck(bId);
						
						if(result==1) {
							alertAndGo(response,"회원가입에 성공하셨습니다.","login.jsp");
							bCmd.register(bName, bId, bPw);
						}
						else {
							
							System.out.println("얍");
							alertAndGo(response,"중복된 아이디 입니다.","register.jsp");
						}
					}
		
					
				}
				
				else if(com.equals("/login_view.do")) {
					viewPage = "login.jsp";
				}
				
				else if(com.equals("/login.do")) {
					String bId = request.getParameter("id");
					String bPw = request.getParameter("pw");
					
					int result = bCmd.login(bId, bPw);
					
					if(result == 0) {
						String msg = "로그인에 실패하였습니다.";
						alertAndGo(response,msg,"login.jsp");
						
						viewPage = "login.jsp"; 
					}
					
					else {
						session.setAttribute("ID", bId); //아이디를 세션에 저장
						session.setAttribute("Login?", "yes"); //로그인 했다는 뜻.
						
						viewPage ="list.do";  
					}
					
					
				} 
				
				else if(com.equals("/logout.do")) {
					
					session.invalidate();
					
					alertAndGo(response,"로그아웃 합니다.","list.do");
				} 
				
				else if(com.equals("/write_view.do")) {
					
					String log = (String)session.getAttribute("Login?");
					
					System.out.println(log);
					
					if(log==null) {
						alertAndGo(response,"글을 작성하시려면 로그인을 하셔야합니다.","generalForumLogX.jsp");
					}
					else{
						viewPage = "createForm.jsp";
					}
				} 
				
				else if(com.equals("/write.do")) {
					
					String bTitle =request.getParameter("input-title");
					String bDetail =request.getParameter("input-content");
					String userId = (String)session.getAttribute("ID");
					
					
					
					if(userId==null) System.out.println("Session s getAttr is NULL !!!");

					String bName = bCmd.getUserName(userId);
					
					System.out.println(bTitle);
					System.out.println(bDetail);
					System.out.println(userId);
					System.out.println(bName);
					
					BDto bdto= new BDto(userId,bTitle, bName,0,0,bDetail);
					
					bCmd.writeContent(bdto);
					
					alertAndGo(response,"게시물이 성공적으로 작성되었습니다.","list.do");
					
				}
				
				else if(com.equals("/content_view.do")) {
					
					//내 글인지 남의 글인지 확인하기
					System.out.println("내 글인지 남의 글인지 가져오기 테스트");
					String UserId=(String)session.getAttribute("ID");
					
					System.out.println("세션에서 가져온 아이디 =>"+UserId);

					System.out.println("\n게시물 열람 실행.");

					String sNum = request.getParameter("bId");
					int bNum = Integer.parseInt(sNum);
					
					System.out.println("게시물 번호 sNum =>"+bNum);
					
					
					BDto bdto = bCmd.viewContent(bNum);
					
					//여기서 비교가 들어가야합니다.
					
					String dbId=bdto.UserId;
					System.out.println("db에서 가져온 게시글의 id =>"+dbId);
					

					
					session.setAttribute("bdto",bdto);
					
					if(dbId.equals(UserId)) {
						viewPage = "browseMyPost.jsp";
					}
					else if(UserId==null) {
						viewPage = "browsePost.jsp";
					}
					else {
						viewPage = "browsePost.jsp";
					}

					System.out.println("\n게시물 열람 실행완료.");
				}
				
				else if(com.equals("/modify_view.do")) {
					
					String sId = request.getParameter("bId"); //게시물 번호가 넘어온다.
					int bId=Integer.parseInt(sId);
					
					BDto bdto = bCmd.viewContent(bId); //bId 는 게시물 번호
					
					session.setAttribute("beforemodi",bdto);
					
					viewPage = "modifyForm.jsp";
				}
				
				else if(com.equals("/modify.do")) {
					
					String bTitle =request.getParameter("input-title");
					String bDetail =request.getParameter("input-content");
					String sNum=request.getParameter("bNum");
							
					int bNum=Integer.parseInt(sNum);
					
					
					
					BDto bdto= new BDto(null,bNum,bTitle,null,0,0,bDetail);	
					
					bCmd.modifyContent(bdto);
					
					alertAndGo(response,"게시글 수정이 완료되었습니다.","list.do");
				}
				
				else if(com.equals("/good.do")) {

					System.out.println("따봉 시작");
					String sId = request.getParameter("bId"); //게시물 번호가 넘어온다.
					int bId=Integer.parseInt(sId);

				
					String Id = (String)session.getAttribute("ID");
					
					if(Id==null) {
						alertAndGo(response,"로그인 후 사용 가능한 기능입니다..","javascript:window.history.back()");
					}
					else {
						
						bCmd.good(bId);
						alertAndBack(response,"이 게시글을 좋아합니다.");
						
					}
					
				}
				
				else if(com.equals("/delete.do")) {
					String sId = request.getParameter("bId"); //게시물 번호가 넘어온다.

					int bId=Integer.parseInt(sId);
					
					bCmd.deleteContent(bId);
					viewPage = "list.do";
					
					alertAndGo(response,"게시물이 성공적으로 삭제되었습니다.","list.do");

				}
				
				response.sendRedirect(viewPage);
			
		}

		public static void alertAndGo(HttpServletResponse response, String msg, String url) {
		    try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('"+msg+"');location.href='"+url+"';</script>");
		        w.flush();
		        w.close();
		    	} catch(Exception e) {
		        e.printStackTrace();
		    }
		    
		    
		}
		
		
		public static void alertAndBack(HttpServletResponse response, String msg) {
		    try {
		        response.setContentType("text/html; charset=utf-8");
		        PrintWriter w = response.getWriter();
		        w.write("<script>alert('"+msg+"');history.go(-1);</script>");
		        w.flush();
		        w.close();
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		}
	
}
