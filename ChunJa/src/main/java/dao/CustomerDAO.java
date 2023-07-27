package dao;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.CommentBean;
import beans.CustomerBean;


public class CustomerDAO {
	
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public DataSource ds = null;

	// JDBC 드라이버 로드 메소드
	public CustomerDAO() {
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
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public int cu_loginIM(CustomerBean c) {
		connect();
		
	    if (c.getCuID().equals("") || c.getCuPW().equals("")) {
	        return 1; // 필수 필드가 비어 있을 경우 1을 리턴
	    }
	   
	    String selectPwQuery = "SELECT cuPW FROM CUSTOMER_TABLE WHERE cuID = ?";

	    try {  
	        // 입력한 ID로 데이터베이스에서 PW 가져오기
	        pstmt = con.prepareStatement(selectPwQuery);
	        pstmt.setString(1, c.getCuID());
	        ResultSet pwResult = pstmt.executeQuery();
	        if (pwResult.next()) {
	            String dbPw = pwResult.getString("cuPW");
	            String inputPw = c.getCuPW();
	            if (!dbPw.equals(inputPw)) {
	                return 3; // PW가 일치하지 않을 경우 2를 리턴
	            }
	        } else {
	            return 2; // 해당 ID가 존재하지 않을 경우 3을 리턴
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        
	    	disconnect();
	    }
	    
	    if(c.getCuID().equals("admin")) {
        	return 4;
        }

	    return 0; // 로그인 성공적으로 완료된 경우 0을 리턴
	}
		
	public int cu_registerIM(CustomerBean c) {
		connect();

		if (c.getCuID().equals("") || c.getCuPW().equals("") || c.getCuNAME().equals("")) {
	        return 1; // 필수 필드가 비어 있을 경우 1을 리턴
	    }

	    String checkIdQuery = "SELECT COUNT(*) FROM CUSTOMER_TABLE WHERE cuID = ?";
	    String checkNameQuery = "SELECT COUNT(*) FROM CUSTOMER_TABLE WHERE cuNAME = ?";
	    String insertQuery = "INSERT INTO CUSTOMER_TABLE (cuID, cuPW, cuNAME) VALUES (?, ?, ?)";


	    
	    try {  
	        // 중복된 ID 체크
	        pstmt = con.prepareStatement(checkIdQuery);
	        pstmt.setString(1, c.getCuID());
	        ResultSet idResult = pstmt.executeQuery();
	        if (idResult.next() && idResult.getInt(1) > 0) {
	            return 2; // 중복된 ID가 있을 경우 2를 리턴
	        }

	        // 중복된 NAME 체크
	        pstmt = con.prepareStatement(checkNameQuery);
	        pstmt.setString(1, c.getCuNAME());
	        ResultSet nameResult = pstmt.executeQuery();
	        if (nameResult.next() && nameResult.getInt(1) > 0) {
	            return 3; // 중복된 NAME이 있을 경우 3을 리턴
	        }

	        // 새로운 사용자 등록
	        pstmt = con.prepareStatement(insertQuery);
	        pstmt.setString(1, c.getCuID());
	        pstmt.setString(2, c.getCuPW());
	        pstmt.setString(3, c.getCuNAME());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 정리
	    	disconnect();

	    }

	    return 0; // 성공적으로 등록된 경우 0을 리턴
	}
	
	public int cu_commentingIM(CommentBean com) {
		System.out.println("cu_commentingIM DAO -----------");
		System.out.println("cuID :"+com.getComID());
		System.out.println("cuNAME :"+com.getComNAME());
		System.out.println("score :"+com.getComSCORE());
		System.out.println("comment :"+com.getComBODY());
		System.out.println("roMALL :"+com.getRoMALL());
		System.out.println("------------------------------");

		// cuCOMMENT에 아무 값도 없는 경우
	    if (com.getComBODY().equals("")) {
	        return 1;
	    }     
	    
	    try {
	        connect();
	        
	        // 현재 시각 가져오기
	        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
	        
	        // COMMENT_TIME 업데이트
	        String insertQuery = "INSERT INTO COMMENT_TABLE (whoID, cuCOMMENT, roMALL, COMMENT_TIME, cuNAME, cuSCORE) VALUES (?, ?, ?, ?, ?,?)";
	        pstmt = con.prepareStatement(insertQuery);
	        
	        pstmt.setString(1, com.getComID());
	        pstmt.setString(2, com.getComBODY());
	        pstmt.setString(3, com.getRoMALL());
	        pstmt.setTimestamp(4, currentTime);
	        pstmt.setString(5, com.getComNAME());
	        pstmt.setInt(6, com.getComSCORE());
	        
	        pstmt.executeUpdate();
	        
	        String insertRestScore = "UPDATE RESTAURANT_TABLE SET roSCORE = ROUND((SELECT AVG(cuSCORE) FROM COMMENT_TABLE WHERE roMALL = ?), 2) WHERE roMALL = ?;";
	        pstmt=con.prepareStatement(insertRestScore);
	        
	        pstmt.setString(1,com.getRoMALL());
	        pstmt.setString(2,com.getRoMALL());

	        pstmt.executeUpdate();
	        
	        // 성공적으로 코드가 실행됐다면 result 값을 0으로 설정
	        return 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 정리
	    	disconnect();
	    }

	    
	    
	    return 0;
	}
	
	
	public String cu_getDnaemIM(CustomerBean c) {
		connect();
		String uName = null;
		String getRoNameQuery = "SELECT cuNAME FROM CUSTOMER_TABLE WHERE cuID = ?";
		try {
		    pstmt = con.prepareStatement(getRoNameQuery);
		    pstmt.setString(1, c.getCuID());
		    ResultSet resultSet = pstmt.executeQuery();
		    if (resultSet.next()) {
		        uName = resultSet.getString("cuNAME");
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // 리소스 정리
			disconnect();
		}
		return uName;
	}
	
	public void cu_delCommentIM(CommentBean com) {
		connect();
		
		String deleteComQuery = "DELETE FROM comment_table WHERE cuNAME = ? AND cuCOMMENT = ?";
		String avgScore = "SELECT AVG(cuSCORE) AS average_score FROM comment_table WHERE roMALL = ?";
		String setAVG = "UPDATE restaurant_table SET roSCORE = ? WHERE roMALL = ?";
		
		try {
			pstmt = con.prepareStatement(deleteComQuery);
			pstmt.setString(1, com.getComNAME());
			pstmt.setString(2, com.getComBODY());
			pstmt.executeUpdate();
			
			pstmt = con.prepareStatement(avgScore);
			pstmt.setString(1, com.getRoMALL());
			ResultSet rs = pstmt.executeQuery();
			
			float score = 0; 
			while(rs.next()) {
				score = rs.getFloat("average_score");
			}
			
			pstmt = con.prepareStatement(setAVG);
			pstmt.setFloat(1, score);
			pstmt.setString(2, com.getRoMALL());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // 리소스 정리
			disconnect();
		}
		
	}
	
	public ArrayList<CustomerBean> cu_listIM() {
		ArrayList<CustomerBean> list = new ArrayList<CustomerBean>();
		
		
		connect();
		
		String getList = "SELECT * FROM CUSTOMER_TABLE";
		
		try {
			pstmt = con.prepareStatement(getList);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerBean c = new CustomerBean();
				c.setCuID(rs.getString("cuID"));
				c.setCuNAME(rs.getString("cuNAME"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // 리소스 정리
			disconnect();
		}
		return list;
	}

}
