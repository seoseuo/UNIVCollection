package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EX12_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		
		int retval = 0;
		
		String DBNAME = "bookstore_db";
		final String DBURL ="jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(DBURL,ID,PW);
			stmt = con.createStatement();
	
			String sql = "DELETE FROM book id =?"

			System.out.println(sql1);
			
			pstmt = con.prepareStatement(sql1);
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ! ! !");
		} catch(SQLException e) {
			System.out.println("SQLException");
		}
		
		finally
			{
			
			
			if (pstmt != null) {
				try{
					pstmt.close(); 
				} 
				catch(SQLException ex) {
					System.out.println("DB pstmt close exception !!");
				}
			}
			if (stmt != null) {
				try{
					stmt.close(); 
				} 
				catch(SQLException ex) {
					System.out.println("DB stmt close exception !!");
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
