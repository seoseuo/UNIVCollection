package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EX06_JdbcSelectWhere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		String DBNAME = "jdbc_db";
		final String DBURL ="jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		String sql = "select addr from user where id=?";
		String userID = "apple";
		
		try {
			Class.forName(DRIVERNAME);
			
			// !! DB를 만들 때 DBURL로 해당 DB를 연동시켜야 하는데 연동 후에 DB를 만들고 만든 DB에 테이블을 생성하기 위해선 연동을 다시 해줘야 하는 듯 하다.
			con = DriverManager.getConnection(DBURL,ID,PW);
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userID);
			resultSet = pstmt.executeQuery();
			
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("addr"));
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ! ! !");
		} catch(SQLException e) {
			System.out.println("SQLException");
		}
		
		finally
			{
			if (resultSet != null) {
				try{
					resultSet.close(); 
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
			if (con != null) {
				try {
					con.close(); 
				}
				catch(SQLException ex) {
					System.out.println("DB connection close exception !!");
				}
			}
		}
	}

}
