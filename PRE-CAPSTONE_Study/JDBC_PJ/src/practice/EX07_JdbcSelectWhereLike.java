package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EX07_JdbcSelectWhereLike {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		String DBNAME = "jdbc_db";
		final String DBURL ="jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		String sql = "select id from user where id like ?";
		String UserId="_"+"pp"+"%";
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(DBURL,ID,PW);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,UserId);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				System.out.println(resultSet.getString("id"));
			}
		}  catch (ClassNotFoundException e) {
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
