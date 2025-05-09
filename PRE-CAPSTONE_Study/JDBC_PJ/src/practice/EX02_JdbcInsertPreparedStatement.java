package practice;

import java.sql.*;

public class EX02_JdbcInsertPreparedStatement {

	public static void main(String args[]) {
		Connection con = null;
		final String DBURL ="jdbc:mysql://localhost:3306/jdbc_db?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		PreparedStatement pstmt=null;
		int retval = 0;
		
		String sql = "insert into user values(?,?,?,?)";
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(DBURL,ID,PW);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "dog");
			pstmt.setString(2, "cat");
			pstmt.setString(3, "lion");
			pstmt.setInt(4,5000);
			retval = pstmt.executeUpdate();
			
			System.out.println("insert Successed ! ! !");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver load fail !!");
		} catch (SQLException e) {
		System.out.println("DB SQLException fail !!");
		}
		
		finally
			{
			if (pstmt != null) {
				try{
					pstmt.close(); 
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
