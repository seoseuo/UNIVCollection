package practice;

import java.sql.*;

public class EX05_JdbcSelectAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		String DBNAME = "jdbc_db";
		final String DBURL ="jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		PreparedStatement pstmt = null;
		
		String sql = "select * from user";
		ResultSet resultSet = null;
		
		try {
			Class.forName(DRIVERNAME);
			
			// !! DB를 만들 때 DBURL로 해당 DB를 연동시켜야 하는데 연동 후에 DB를 만들고 만든 DB에 테이블을 생성하기 위해선 연동을 다시 해줘야 하는 듯 하다.
			con = DriverManager.getConnection(DBURL,ID,PW);
			pstmt=con.prepareStatement(sql);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("id")+"\t");
				System.out.println(resultSet.getString("pw")+"\t");
				System.out.println(resultSet.getString("addr")+"\t");
				System.out.println(resultSet.getInt("cash"));
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
