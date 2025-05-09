package practice;

import java.sql.*;

public class EX04_CreateTABLE_bookstroe_db {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		String DBNAME = "bookstore_db";
		final String DBURL ="jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		String sql = "insert into book values (?,?,?,?)";
		int retval = 0;
		
		try {
			Class.forName(DRIVERNAME);
			
			// !! DB를 만들 때 DBURL로 해당 DB를 연동시켜야 하는데 연동 후에 DB를 만들고 만든 DB에 테이블을 생성하기 위해선 연동을 다시 해줘야 하는 듯 하다.
			con = DriverManager.getConnection(DBURL,ID,PW);
//			stmt = con.createStatement();
			
			// 데이터 베이스 생성 코드 (DB와 테이블을 생성하는 코드는 SQL WORK BANCH 에서 동작시켰다.
			
//			stmt.execute("create database bookstore_db;");
//			System.out.println("create database successed ! ! !");
//			
			
			//테이블 생상 코드 , sql work banch에서 생성하였음.
			
//			stmt.execute("create table book ("
//					+ "id char(45) not null,"
//					+ "publisher char(45) not null,"
//					+ "name char(45) not null,"
//					+ "price int(11) not null,"
//					+ "primary key(id)"
//					+ ");");

//			
//			System.out.println("create table successed ! ! !");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "bk2344");
			pstmt.setString(2, "재능");
			pstmt.setString(3, "토끼와 사자");
			pstmt.setInt(4, 1000);
			
			retval = pstmt.executeUpdate();
			pstmt.clearParameters();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "bc5431");
			pstmt.setString(2, "우현");
			pstmt.setString(3, "세종");
			pstmt.setInt(4, 1900);
			
			retval = pstmt.executeUpdate();
			pstmt.clearParameters();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "ty6566");
			pstmt.setString(2, "생생");
			pstmt.setString(3, "피노키오");
			pstmt.setInt(4, 2000);
			
			retval = pstmt.executeUpdate();
			pstmt.clearParameters();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "ty6788");
			pstmt.setString(2, "재능");
			pstmt.setString(3, "이순신");
			pstmt.setInt(4, 2500);
			
			retval = pstmt.executeUpdate();
			pstmt.clearParameters();
			
	
//			pstmt.clearParameters();
//			pstmt.close();
//			행을 갱신할 때 위의 둘 중 하나는 사용해야함.
			
// 차이점 : close 하면 하나씩 넣어준 객체를 없애주는 것 이다.
// 			값들을 저장해 준 객체를 날린 후 초기화 시켜준다. 
			
			System.out.println("insert successed !!! ");
		
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
