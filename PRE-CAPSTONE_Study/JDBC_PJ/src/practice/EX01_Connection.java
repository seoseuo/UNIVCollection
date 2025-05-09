package practice;
//STEP 1 IMPORT
import java.sql.*;



public class EX01_Connection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null;
		final String DBURL ="jdbc:mysql://localhost:3306/jdbc_db?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
// 연습 코드들
		
		//STEP 2 DBMS 드라이버 로드
		try {
			Class.forName(DRIVERNAME);
			System.out.println("\nJDBC driver load success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("\nJDBC driver load Not success");
		}
		
		//STEP 3 DB에 연결
		try {
			con = DriverManager.getConnection(DBURL,ID,PW);
			
			System.out.println("Connection success");
			
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
			}
		
		//연결해제
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
		

	}
}
