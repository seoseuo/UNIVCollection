package com.sw.dao;

import java.sql.*;

import com.mysql.cj.xdevapi.Result;
import com.sw.dto.MemberDto;

public interface MemberDao {

	public int insertMember(MemberDto mdto);
	public String loginMember(String id);
	public Connection getConnection();
	public void closeConnection(ResultSet Set, PreparedStatement pstmt, Connection connection);

}
