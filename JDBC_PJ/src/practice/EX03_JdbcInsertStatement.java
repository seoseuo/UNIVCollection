package practice;

import java.sql.*;



public class EX03_JdbcInsertStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		final String DBURL ="jdbc:mysql://localhost:3306/jdbc_db?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		//실습 user 테이블 값 추가 ---------------------------------------------
		
		try {
			Class.forName(DRIVERNAME);
			
			con = DriverManager.getConnection(DBURL,ID,PW);
			Statement stmt = con.createStatement();
			
			System.out.println("Connection success\n");
			
			// 1. sql에 밑에 있는 주키 값들이 들어 있는 상태에서 밑의 코드를 입력하여 오류가 났음
			// 2. sql branch로 중복된 값들을 delete , apply 한 후 밑의 코드를 적용하였더니 정상적으로 입력
			// 3.후에 다시 입력하는 코드를 동작시키면 1번과 같은 결과 식별.
			
			stmt.executeUpdate("insert into User values ('apple', 'orange', 'melon',20000);");
			stmt.executeUpdate("insert into User values ('chair', 'desk', 'key',1000);");
			stmt.executeUpdate("insert into User values ('deck', 'keyboard', 'mouse',0);");
			System.out.println("3 rows is inserted");
			//레코드 추가 하기.
			
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC driver load fail !!");
			} catch (SQLException e) {
			System.out.println("DB SQLException fail !!");
			}
		

			finally // exception이 나던 안나던 진행
			{
				try {
					if(con!=null) {
						con.close();
						System.out.println("DB connection close success");
					}
				}
				catch (SQLException e) {
					System.out.println("DB connection close exception ! !");
				}
			}
		//-----------------------------------------------------------------
		


		
		
	}
}
