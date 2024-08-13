package com.sw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import com.sw.dto.MemberDto;

public class MemberDaoimpl implements MemberDao {

	@Override
	public int insertMember(MemberDto mdto) {
		
		System.out.println("---MemberDaoimpl :: insertMember()---");
		
		Connection conn = null;
		ResultSet set = null;
		PreparedStatement pstmt = null;
		
		int ret = 0;
		String sql = "insert into members (id,pw,name) values (?,?,?)";
		
		try {
			conn=getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			String id = mdto.getId();
			String pw = mdto.getPw();
			String name = mdto.getName();
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			
			ret = pstmt.executeUpdate();
			//성공하면 1이 채워진다.
			
		} catch (SQLException e) {
			ret = -1;
			System.out.println("access error.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		finally {
			closeConnection(set,pstmt,conn);
		}
		
		return ret;
	}

	@Override
	public String loginMember(String id) {
		// TODO Auto-generated method stub
		
		System.out.println("---MemberDaoimpl :: loginMember()---");
		
		Connection conn = null;
		ResultSet set = null;
		PreparedStatement pstmt = null;
		
		String sql = "select pw from members where id = ?";
		String pwDb = null;
		
		try {
			conn=getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			set = pstmt.executeQuery();
			
			while(set.next()) {
				pwDb = set.getString("pw");
				System.out.println("pw : "+pwDb);
			}
		} catch(SQLException e){
			System.out.println("SQLException error.");
			e.printStackTrace();

		}
		finally {
			closeConnection(set,pstmt,conn);
		}
		
		return pwDb;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		
		Connection con = null;
		final String DBURL ="jdbc:mysql://localhost:3306/jsp_servlet_db?useSSL=false";
		final String PW = "990920";		
		final String ID = "root";
		final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(DRIVERNAME);
			System.out.println("\nJDBC driver load success");
			
			con = DriverManager.getConnection(DBURL,ID,PW);
			
			System.out.println("Connection success");
			
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("\nJDBC driver load Not success");
			} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Connection Failed");
			}
		
		return con;
	}

	@Override
	public void closeConnection(ResultSet set, PreparedStatement pstmt, Connection connection) {
		// TODO Auto-generated method stub
	
		if (set != null) {
			try{
				set.close();
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
		if (connection != null) {
			try {
				connection.close(); 
			}
			catch(SQLException ex) {
				System.out.println("DB connection close exception !!");
			}
		}
		
	}
}


