package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import beans.CommentBean;
import beans.CustomerBean;
import beans.ROwnerBean;
import beans.RestaurantBean;

public class ROwnerDAO {
	public Connection con = null;
	public PreparedStatement pstmt = null;
	public DataSource ds = null;

	// JDBC 드라이버 로드 메소드
	public ROwnerDAO() {
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
	
	public int ro_loginIM(ROwnerBean r) {
	    connect();

	    if (r.getRoID().equals("") || r.getRoPW().equals("")) {
	        return 1; // 필수 필드가 비어 있을 경우 1을 리턴
	    }

	    String checkIdQuery = "SELECT COUNT(*) FROM OWNER_TABLE WHERE roID = ?";
	    String selectPwQuery = "SELECT roPW FROM OWNER_TABLE WHERE roID = ?";

	    try {
	        // 입력한 ID의 존재 여부 확인
	        pstmt = con.prepareStatement(checkIdQuery);
	        pstmt.setString(1, r.getRoID());
	        ResultSet idResult = pstmt.executeQuery();
	        if (idResult.next()) {
	            int count = idResult.getInt(1);
	            if (count == 0) {
	                return 2; // 해당 ID가 존재하지 않을 경우 2를 리턴
	            }
	        }

	        // 입력한 ID로 데이터베이스에서 PW 가져오기
	        pstmt = con.prepareStatement(selectPwQuery);
	        pstmt.setString(1, r.getRoID());
	        ResultSet pwResult = pstmt.executeQuery();
	        if (pwResult.next()) {
	            String dbPw = pwResult.getString("roPW");
	            String inputPw = r.getRoPW();
	            if (!dbPw.equals(inputPw)) {
	                return 3; // PW가 일치하지 않을 경우 3을 리턴
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 정리
	        disconnect();
	    }
	    return 0;
	}

	
	public int ro_registerIM(ROwnerBean r) {
		connect();

		if (r.getRoID().equals("") || r.getRoPW().equals("") || r.getRoNAME().equals("")) {
	        return 1; // 필수 필드가 비어 있을 경우 1을 리턴
	    }

	    String checkIdQuery = "SELECT COUNT(*) FROM OWNER_TABLE WHERE roID = ?";
	    String checkNameQuery = "SELECT COUNT(*) FROM OWNER_TABLE WHERE roNAME = ?";
	    String checkMallName = "SELECT COUNT(*) FROM OWNER_TABLE WHERE roMALL = ?";
	    String checkAddress = "SELECT COUNT(*) FROM OWNER_TABLE WHERE roADDRESS = ?";
	    String insertQuery = "INSERT INTO OWNER_TABLE (roID,roPW,roNAME,roMALL,roADDRESS) VALUES (?, ?, ?, ?, ?)";


	    
	    try {  
	        // 중복된 ID 체크
	        pstmt = con.prepareStatement(checkIdQuery);
	        pstmt.setString(1, r.getRoID());
	        ResultSet idResult = pstmt.executeQuery();
	        if (idResult.next() && idResult.getInt(1) > 0) {
	            return 2; // 중복된 ID가 있을 경우 2를 리턴
	        }

	        // 중복된 NAME 체크
	        pstmt = con.prepareStatement(checkNameQuery);
	        pstmt.setString(1, r.getRoNAME());
	        ResultSet nameResult = pstmt.executeQuery();
	        if (nameResult.next() && nameResult.getInt(1) > 0) {
	            return 3; // 중복된 NAME이 있을 경우 3을 리턴
	        }
	        
	        // 중복된 가게이름 체크
	        pstmt = con.prepareStatement(checkMallName);
	        pstmt.setString(1, r.getRoMALL());
	        ResultSet MallResult = pstmt.executeQuery();
	        if (MallResult.next() && MallResult.getInt(1) > 0) {
	        	return 4; // 중복된 가게NAME이 있을 경우 3을 리턴
	        }
	        
	        // 중복된 가게 주소 체크
	        pstmt = con.prepareStatement(checkAddress);
	        pstmt.setString(1, r.getRoADDRESS());
	        ResultSet AddressResult = pstmt.executeQuery();
	        if (AddressResult.next() && AddressResult.getInt(1) > 0) {
	        	return 5; // 중복된 NAME이 있을 경우 3을 리턴
	        }

	        // 새로운 사용자 등록
	        pstmt = con.prepareStatement(insertQuery);
	        pstmt.setString(1, r.getRoID());
	        pstmt.setString(2, r.getRoPW());
	        pstmt.setString(3, r.getRoNAME());
	        pstmt.setString(4, r.getRoMALL());
	        pstmt.setString(5, r.getRoADDRESS());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 정리
	    	disconnect();

	    }
	    return 0;
	}
	
	public int ro_writeIM(RestaurantBean rest) {
	    connect();

	    System.out.println("ro_writeIM DAO");
	    System.out.println("getReBODY: " + rest.getReBODY());
	    System.out.println("getReURL: " + rest.getReURL());

	    if (rest.getReBODY() == null || rest.getReBODY().equals("")) {
	        return 1;
	    }
	    if (rest.getReURL() == null || rest.getReURL().equals("")) {
	        return 2;
	    }

	    String insertQuery = "INSERT INTO RESTAURANT_TABLE (roNAME, roURL, roBODY, roLOGO, roPIC1, roPIC2, roPIC3,roMALL,roSCORE) VALUES (?, ?,?, ?, ?, ?, ?, ?, ?)";
	   
	    try {
	        pstmt = con.prepareStatement(insertQuery);

	        pstmt.setString(1, rest.getReNAME());
	        pstmt.setString(2, rest.getReURL());
	        pstmt.setString(3, rest.getReBODY());
	        pstmt.setString(4, rest.getReLOGO());
	        pstmt.setString(5, rest.getRePIC1());
	        pstmt.setString(6, rest.getRePIC2());
	        pstmt.setString(7, rest.getRePIC3());
	        pstmt.setString(8, rest.getReMALL());
	        pstmt.setFloat(9,0);
	        pstmt.executeUpdate();


	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 정리
	        disconnect();
	    }
	    return 0;
	}
	
	public int ro_editIM(RestaurantBean rest) {
		connect();

	    System.out.println("ro_writeIM DAO");
	    System.out.println("getReBODY: " + rest.getReBODY());
	    System.out.println("getReURL: " + rest.getReURL());

	    if (rest.getReBODY() == null || rest.getReBODY().equals("")) {
	        return 1;
	    }
	    if (rest.getReURL() == null || rest.getReURL().equals("")) {
	        return 2;
	    }

	    String updateQuery = "UPDATE RESTAURANT_TABLE SET roNAME = ?, roURL = ?, roBODY = ?, roLOGO = ?, roPIC1 = ?, roPIC2 = ?, roPIC3 = ? WHERE roMALL = ?";

	    try {
	        pstmt = con.prepareStatement(updateQuery);

	        pstmt.setString(1, rest.getReNAME());
	        pstmt.setString(2, rest.getReURL());
	        pstmt.setString(3, rest.getReBODY());
	        pstmt.setString(4, rest.getReLOGO());
	        pstmt.setString(5, rest.getRePIC1());
	        pstmt.setString(6, rest.getRePIC2());
	        pstmt.setString(7, rest.getRePIC3());
	        pstmt.setString(8, rest.getReMALL());

	        pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // 리소스 정리
	        disconnect();
	    }
	    return 0;
	}

	public String ro_getDnaemIM(ROwnerBean r) {
		connect();
		String uName = null;
		String getRoNameQuery = "SELECT roNAME FROM OWNER_TABLE WHERE roID = ?";

		try {
		    pstmt = con.prepareStatement(getRoNameQuery);
		    pstmt.setString(1, r.getRoID());
		    ResultSet resultSet = pstmt.executeQuery();
		    if (resultSet.next()) {
		        uName = resultSet.getString("roNAME");
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // 리소스 정리
			disconnect();
		}
		System.out.println("ro_getDnaemIM : "+uName);
		return uName;
	}
	
	public String ro_getDMallIM(String r) {
		connect();
		String dMALL = null;
		String getRoNameQuery = "SELECT roMALL FROM OWNER_TABLE WHERE roNAME = ?";

		try {
		    pstmt = con.prepareStatement(getRoNameQuery);
		    pstmt.setString(1, r);
		    ResultSet resultSet = pstmt.executeQuery();
		    if (resultSet.next()) {
		    	dMALL = resultSet.getString("roMALL");
		    }
		} catch (SQLException e) { 
		    e.printStackTrace();
		} finally {
		    // 리소스 정리
			disconnect();
		}
		System.out.println("ro_getDMallIM : "+dMALL);
		return dMALL;
	}
	
	public String ro_getDNameFromMallIM(ROwnerBean r) {
		connect();
		String uName = null;
		String getRoNameQuery = "SELECT roNAME FROM OWNER_TABLE WHERE roMALL = ?";

		try {
		    pstmt = con.prepareStatement(getRoNameQuery);
		    pstmt.setString(1, r.getRoMALL());
		    ResultSet resultSet = pstmt.executeQuery();
		    if (resultSet.next()) {
		        uName = resultSet.getString("roNAME");
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // 리소스 정리
			disconnect();
		}
		System.out.println("ro_getDnaemIM : "+uName);
		return uName;
	}


public boolean roCheckIM(String roNAME) {
	System.out.println("roCHECK START-----------------------------------");
	boolean check = true;

	connect();

	String checkQuery = "SELECT COUNT(*) FROM RESTAURANT_TABLE WHERE roNAME = ?";

	try {
		// 중복된 ID 체크
		pstmt = con.prepareStatement(checkQuery);
		pstmt.setString(1, roNAME);
		ResultSet Result = pstmt.executeQuery();

		if (Result.next() && Result.getInt(1) > 0) {
			System.out.println("CHECK :"+check);
			return check;
		}

		else {
			System.out.println("CHECK :"+check);
			check = false;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		// 리소스 정리
		disconnect();

	}
	System.out.println("roCHECK FIN-----------------------------------");
	return check;
	
	}

	public void ro_ReportIM(CommentBean com) {
	connect();
	String reportSet = "UPDATE comment_table SET report = 1 WHERE roMALL = ? AND cuNAME = ? AND cuCOMMENT = ?";
	
	
	System.out.println("ro_ReportIM START------------------------------------------");
	
	System.out.println("getRoMALL :"+com.getRoMALL());
	System.out.println("getComNAME :"+com.getComNAME());
	System.out.println("getComBODY :"+com.getComBODY());
	try {
		pstmt = con.prepareStatement(reportSet);
		pstmt.setString(1,com.getRoMALL());
		pstmt.setString(2,com.getComNAME());
		pstmt.setString(3,com.getComBODY());
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		// 리소스 정리
		disconnect();
	}
	System.out.println("ro_ReportIM FIN------------------------------------------");
		
	}
	
	
	public ArrayList<ROwnerBean> ro_listIM() {
		ArrayList<ROwnerBean> list = new ArrayList<ROwnerBean>();
		
		
		connect();
		
		String getList = "SELECT * FROM OWNER_TABLE";
		
		try {
			pstmt = con.prepareStatement(getList);
			pstmt.executeQuery();
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ROwnerBean r = new ROwnerBean();
				
				r.setRoNAME(rs.getString("roNAME"));
				r.setRoID(rs.getString("roID"));
				r.setRoMALL(rs.getString("roMALL"));
				r.setRoADDRESS(rs.getString("roADDRESS"));
				
				list.add(r);
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
