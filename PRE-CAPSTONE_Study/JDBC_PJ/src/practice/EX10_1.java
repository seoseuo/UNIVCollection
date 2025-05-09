package practice;

import java.sql.*;

public class EX10_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//실습 48p DB를 만들고 다음과 같이 작성하시오.
		
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		
		String DBNAME = "bookstore_db";
		final String DBURL ="jdbc:mysql://localhost:3306/"+DBNAME+"?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(DBURL,ID,PW);
			stmt = con.createStatement();
			
//			stmt.executeUpdate("create database bookstore_db;"); 생성 완료 하였기 때문에 주석처리 (중복)
//			db 생성 하였기 때문에 DBNAME을 bookstore_db로 변경해주었다. 수작업
			
			//테이블 생성
//			stmt.executeUpdate("create table book ("
//					+ "id char(45) not null,"
//					+ "publisher char(45) not null,"
//					+ "name char(45) not null,"
//					+ "price int(10),"
//					+ "primary key(id)"
//					+ ");");
			
//			stmt.executeUpdate("insert into book values ('bk2344','재능','토끼와사자','1000');");
//			stmt.executeUpdate("insert into book values ('bc5431','우현','세종','1900');");
//			stmt.executeUpdate("insert into book values ('ty6566','생생','피노키오','2000');");
//			stmt.executeUpdate("insert into book values ('ty6788','재능','이순신','2500');");
//			
			String sql1 = "select * from book;";
			String sql2 = "select publisher, name from book;";
			
			String sql3 = "select name, price from book where publisher = ? ";
			String pb = "우현";
			

			System.out.println(sql1);
			
			pstmt = con.prepareStatement(sql1);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String publisher = resultSet.getString("publisher");
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				System.out.println(id+" , "+publisher+" , "+name+" , "+price);
			}
			pstmt.clearParameters();
			
			
			
			System.out.println("\n"+sql2);
			
			pstmt = con.prepareStatement(sql2);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				String publisher = resultSet.getString("publisher");
				String name = resultSet.getString("name");

				System.out.println(publisher+" , "+name);
			}
			
			pstmt.clearParameters();
			
			
			System.out.println("\n"+sql3+pb);

			pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, pb);
			resultSet = pstmt.executeQuery();
			
			while(resultSet.next()) {
				String name = resultSet.getString("name");
				int price = resultSet.getInt("price");
				
				System.out.println(name+" , "+price);
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
