package com.sw.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import com.sw.dto.BDto;

public class BDaoImpl implements BDao {
 


	@Override
	public ArrayList<BDto> showBoardList() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String query = "SELECT * FROM post_info_db order by Post_num";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	

				int dbNum = rs.getInt("Post_num");
				String dbTitle = rs.getString("Post_title");
				String dbName = rs.getString("PostUser_Nickname");
				int dbHit = rs.getInt("View_of_this_Post");
				int dbGood = rs.getInt("Num_of_GoodMark");
				String dbDetail = rs.getString("Post_details");
				String UserId = rs.getString("User_id");
				BDto bdto = new BDto(UserId,dbNum,dbTitle,dbName,dbHit,dbGood,dbDetail);
	
				
				dtos.add(bdto);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs,pstmt,con);
		}
		return dtos;
	}
	
	@Override
	public ArrayList<BDto> topHit() {
		
		System.out.println("최다 조회수----------------");
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		
		try {
			con = getConnection();
			
			String query = "SELECT * FROM post_info_db ORDER BY View_of_this_Post DESC";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			rs.next();
			
			
			for(int i=0; i<3; i++) {
				String dbTitle = rs.getString("Post_title");
				int dbNum = rs.getInt("Post_num");
				
				System.out.println(i+"등 => "+dbTitle);
				
				BDto bdto = new BDto(null,dbNum,dbTitle,null,0,0,null);
				dtos.add(bdto);
				
				rs.next();
			}
			
			System.out.println("최다 조회수 끝----------------");
			
			

			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs,pstmt,con);
		}
		return dtos;
	}
	
	@Override
	public ArrayList<BDto> topGood() {
		System.out.println("최다 따봉----------------");
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String query = "SELECT * FROM post_info_db ORDER BY Num_of_GoodMark DESC";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			rs.next();
			
			for(int i=0; i<3; i++) {
				String dbTitle = rs.getString("Post_title");
				int dbNum = rs.getInt("Post_num");
				
				System.out.println(i+"등 => "+dbTitle);
				
				BDto bdto = new BDto(null,dbNum,dbTitle,null,0,0,null);
				dtos.add(bdto);
				
				rs.next();
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs,pstmt,con);
		}
		return dtos;
	}


	@Override
	public int writeContent(BDto bdto) {
		
		int ret = 0; //성공시 0
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String bId = bdto.getUserId();
		String bName = bdto.getbName();
		String bTitle = bdto.getbTitle();
		int bHit = bdto.getbHit();
		int bGood = bdto.getbGood();
		String bDetail = bdto.getbDetail();
		
		try {
			con = getConnection();
			
			String query = "insert INTO post_info_db (PostUser_Nickname , Post_title , Post_details , View_of_this_Post , Num_of_GoodMark , User_id) VALUES (?,?,?,?,?,?);";
			
			pstmt = con.prepareStatement(query);
			

			pstmt.setString(1,bName);
			pstmt.setString(2,bTitle);
			pstmt.setString(3,bDetail);
			pstmt.setInt(4,bHit);
			pstmt.setInt(5,bGood);
			pstmt.setString(6, bId);
			
			ret = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		
		return ret;

	}

	@Override
	public BDto viewContent(int bId) { //여기서의 bId는 게시물 번호
			
			upHit(bId);
			
			BDto dto = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = getConnection();
				
				String query = "SELECT * FROM post_info_db where Post_num = ?";
				
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, bId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					int dbNum = rs.getInt("Post_num");
					String dbName = rs.getString("PostUser_Nickname");
					String dbTitle = rs.getString("Post_title");
					String dbdetail = rs.getString("Post_details");
					int dbgood = rs.getInt("Num_of_GoodMark");
					int dbHit = rs.getInt("View_of_this_Post");
					String UserId = rs.getString("User_id");
					
					dto = new BDto(UserId, dbNum, dbTitle, dbName, dbHit, dbgood, dbdetail);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				closeConnection(rs, pstmt, con);
			}
			
			// TODO Auto-generated method stub
			return dto;
		}
	
	
	@Override
	public int modifyContent(BDto bdto) {
		
		int ret = 0; //성공시 0
		
		System.out.println("수정 구현 진입.");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		int bNum = bdto.getbNum();
		String bTitle = bdto.getbTitle();
		String bDetail = bdto.getbDetail();
		
		
		System.out.println("수정 부분입니다.");
		System.out.println(bNum);
		System.out.println(bTitle);
		System.out.println(bDetail);
		
		try {
			con = getConnection();
			
			String query = "UPDATE post_info_db SET Post_title = ?,Post_details = ? WHERE Post_num = ?;";
			
			pstmt = con.prepareStatement(query);
			
			
			pstmt.setString(1,bTitle);
			pstmt.setString(2,bDetail);
			pstmt.setInt(3, bNum);

			ret = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		
		return ret;

	}

	@Override
	public int deleteContent(int bId) {
		
		int ret = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			con = getConnection();
			
			String query = "DELETE FROM post_info_db WHERE Post_num = ?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			ret = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		return ret;
	}
	
	public Connection getConnection() {
		// TODO Auto-generated method stub
		
		Connection con = null;
		final String DBURL ="jdbc:mysql://localhost:3306/hnb_db?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(DRIVERNAME);
			System.out.println("\nJDBC driver load success");
			
			con = DriverManager.getConnection(DBURL,ID,PW);
			
			System.out.println("Connection success");
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("\nJDBC driver load Not success");
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Connection Failed");
			}
		
		return con;
	}
	
	public void closeConnection(ResultSet set, PreparedStatement pstmt, Connection connection) {
		// TODO Auto-generated method stub
	
		if (set != null) {
			try{
				set.close();
			} 
			catch(SQLException ex) {
				System.out.println("DB resultSet close exception !!");
			}
		}
		if (pstmt != null) {
			try{
				pstmt.close(); 
			} 
			catch(SQLException ex) {
				System.out.println("DB pstmt close exception !!");
			}
		}
		if (connection != null) {
			try {
				connection.close(); 
			}
			catch(SQLException ex) {
				System.out.println("DB connection close exception !!");
			}
		}
		
	}
	
	public void good(int bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String query = "update post_info_db set Num_of_GoodMark = Num_of_GoodMark + 1 where Post_num = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			int rn = pstmt.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
	}
	
	private void upHit(int bId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			String query = "update post_info_db set View_of_this_Post = View_of_this_Post + 1 where Post_num = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			int rn = pstmt.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
	}
	
	public int registerCheck(String Id) {
		
		int result= 1; //중복 아니면 1 중복이면 0

		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String query = "SELECT * FROM user_info_db";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if((rs.getString("User_id").equals(Id))) {
					
					result=0;
					break;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		

		return result;
	}
	@Override
	public void register(String Name, String Id, String Pw) {
		// TODO Auto-generated method stub
	
		int ret = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("회원가입 실행");
		
		try {
			con = getConnection();
			
			String query = "insert INTO user_info_db (User_name , User_id , User_Password , User_Nickname) VALUES (? , ? , ? , ?);";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1,Name);
			pstmt.setString(2,Id);
			pstmt.setString(3,Pw);
			pstmt.setString(4,Name);
			
			ret = pstmt.executeUpdate();
			
			HttpServletResponse response = null;
			String msg = "회원가입을 완료하였습니다.";

			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
	
	}
	
	@Override
	public int login(String Id,String Pw) {
		
		int result=0; //성공 -> 1 실패 -> 0ㅣ

		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String query = "SELECT * FROM user_info_db";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if((rs.getString("User_id").equals(Id)) && (rs.getString("User_Password").equals(Pw))) {
					result=1;
					break;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		

		return result;
	}
	
	public String getUserName(String Id) {
		
		String result = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			con = getConnection();
			
			String query = "SELECT * FROM user_info_db";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if((rs.getString("User_id").equals(Id))) {
					result=(String)rs.getString("User_name");
					break;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, pstmt, con);
		}
		
		
		return result;
	}
	


	
}
