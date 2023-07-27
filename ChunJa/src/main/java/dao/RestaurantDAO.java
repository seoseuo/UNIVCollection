package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.CommentBean;
import beans.CustomerBean;
import beans.RestaurantBean;

public class RestaurantDAO {

	public Connection con = null;
	public PreparedStatement pstmt = null;
	public DataSource ds = null;

	// JDBC 드라이버 로드 메소드
	public RestaurantDAO() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 메소드
	public void connect() {
		try {
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 헤제 메소드
	public void disconnect() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<RestaurantBean> rankIM() {
		ArrayList<RestaurantBean> rank = new ArrayList<RestaurantBean>();
		connect();

		System.out.println("rankIM START----------------------------------------------------------");

		try {
			String query = "SELECT * FROM RESTAURANT_TABLE ORDER BY roSCORE DESC LIMIT 3";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RestaurantBean restaurant = new RestaurantBean();
				restaurant.setReLOGO(rs.getString("roLOGO"));
				restaurant.setReMALL(rs.getString("roMALL"));
				restaurant.setReSCORE(rs.getFloat("roSCORE"));

				System.out.println("roLOGO :" + restaurant.getReLOGO());
				System.out.println("roMALL :" + restaurant.getReMALL());
				System.out.println("roSCORE :" + restaurant.getReLOGO());



				rank.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			disconnect();
		}

		System.out.println("rankIM FIN----------------------------------------------------------");

		return rank;
	}

	public ArrayList<RestaurantBean> listIM() {

		ArrayList<RestaurantBean> list = new ArrayList<RestaurantBean>();

		connect();

		try {
			String query = "SELECT * FROM RESTAURANT_TABLE";
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RestaurantBean restaurant = new RestaurantBean();
				restaurant.setReLOGO(rs.getString("roLOGO"));
				restaurant.setReMALL(rs.getString("roMALL"));
				restaurant.setReSCORE(rs.getFloat("roSCORE"));

				list.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			disconnect();
		}

		return list;
	}

	public ArrayList<RestaurantBean> viewIM(String roMALL) {
		ArrayList<RestaurantBean> view = new ArrayList<RestaurantBean>();
		connect();

		System.out.println("viewIM START ---------------------------------------");

		System.out.println("before try");
		try {

			System.out.println("in try");
			String query = "SELECT * FROM RESTAURANT_TABLE WHERE roMALL = ?";
			String getADDRESS = "SELECT * FROM OWNER_TABLE WHERE roMALL = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, roMALL);
			ResultSet rs = pstmt.executeQuery();

			RestaurantBean restaurant = new RestaurantBean();

			while (rs.next()) {

				restaurant.setReSCORE(rs.getFloat("roSCORE"));
				restaurant.setReURL(rs.getString("roURL"));
				restaurant.setReBODY(rs.getString("roBODY"));
				restaurant.setRePIC1(rs.getString("roPIC1"));
				restaurant.setRePIC2(rs.getString("roPIC2"));
				restaurant.setRePIC3(rs.getString("roPIC3"));
				restaurant.setReLOGO(rs.getString("roLOGO"));

				System.out.println("setReSCORE :" + restaurant.getReSCORE());
				System.out.println("setReURL :" + restaurant.getReURL());
				System.out.println("setReBODY :" + restaurant.getReBODY());
				System.out.println("setRePIC1 :" + restaurant.getRePIC1());
				System.out.println("setRePIC2 :" + restaurant.getRePIC2());
				System.out.println("setRePIC3 :" + restaurant.getRePIC3());

			}

			pstmt = con.prepareStatement(getADDRESS);
			pstmt.setString(1, roMALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				restaurant.setReADDRESS(rs.getString("roADDRESS"));

				System.out.println("setReADDRESS :" + restaurant.getReADDRESS());
			}

			view.add(restaurant);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			disconnect();
		}
		System.out.println("viewIM FIN ---------------------------------------");
		return view;
	}

	public ArrayList<CommentBean> getCommentIM(String roMALL) { // comment 타입으로 고칠 것.
		ArrayList<CommentBean> comList = new ArrayList<CommentBean>();
		connect();

		try {

			String getCommentQuery = "SELECT * FROM COMMENT_TABLE WHERE roMALL = ? ORDER BY COMMENT_TIME DESC";
			pstmt = con.prepareStatement(getCommentQuery);
			pstmt.setString(1, roMALL);
			ResultSet rs = pstmt.executeQuery();
			System.out.println(roMALL + "DAO댓글 리스트 가져오기 시작----------");
			while (rs.next()) {

				CommentBean c = new CommentBean();

				c.setComID(rs.getString("whoID"));
				c.setComSCORE(rs.getInt("cuSCORE"));
				c.setComBODY(rs.getString("cuCOMMENT"));
				c.setComTIME(rs.getTimestamp("COMMENT_TIME"));
				c.setComNAME(rs.getString("cuNAME"));

				System.out.println();
				

				System.out.println(" 작성자 아이디:" + c.getComID());
				System.out.println(" 작성자의 점수:" + c.getComSCORE());
				System.out.println(" 작성 내용:" + c.getComBODY());
				System.out.println(" 작성 시간:" + c.getComTIME());
				System.out.println(" 작성자 이름 :" + c.getComNAME());
				System.out.println();

				
				System.out.println();
				comList.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			disconnect();
		}
		System.out.println(roMALL + "댓글 리스트 가져오기 끝----------");
		return comList;
	}

	public ArrayList<RestaurantBean> searchIM(String s) {
		ArrayList<RestaurantBean> search = new ArrayList<RestaurantBean>();

		connect();
 
		try {

			System.out.println("SEARCH IM 시작----------");
			String searchQuery = "SELECT * FROM restaurant_table WHERE roMALL LIKE CONCAT('%', ?, '%')";
			pstmt = con.prepareStatement(searchQuery);
			pstmt.setString(1, s);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RestaurantBean restaurant = new RestaurantBean();
				restaurant.setReLOGO(rs.getString("roLOGO"));
				restaurant.setReMALL(rs.getString("roMALL"));
				restaurant.setReSCORE(rs.getFloat("roSCORE"));

				System.out.println("roLOGO :"+restaurant.getReLOGO());
				System.out.println("roMALL:"+restaurant.getReMALL());
				System.out.println("roSCORE :"+restaurant.getReSCORE());
				System.out.println();
				search.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			disconnect();
		}
		System.out.println("SEARCH IM 마무리----------");
		return search;
	}
	
	
	public ArrayList<CommentBean> reportComsIM() {
		connect();
		
		ArrayList<CommentBean> rcoms = new ArrayList<CommentBean>();
		
		String getRcoms = "SELECT * FROM COMMENT_TABLE WHERE REPORT = 1";
		
		try {
			pstmt = con.prepareStatement(getRcoms);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentBean com = new CommentBean();
				
				com.setRoMALL(rs.getString("roMALL"));
				com.setComNAME(rs.getString("cuNAME"));
				com.setComBODY(rs.getString("cuCOMMENT"));
				com.setComTIME(rs.getTimestamp("COMMENT_TIME"));
				
				rcoms.add(com);
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // 리소스 정리
			disconnect();
		}
		
		return rcoms;
	}

}
