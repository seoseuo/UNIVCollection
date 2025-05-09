package com.sw.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sw.dao.MemberDao;
import com.sw.dao.MemberDaoimpl;
import com.sw.dto.MemberDto;
import com.sw.service.Service;

public class LoginCommand implements Service {

	@Override
	public int execute(MemberDto mdto) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MemberDao mdao = new MemberDaoimpl();
		
		int ret=0;
		String id = mdto.getId();
		String pw = mdto.getPw(); //사용자가 입력한 pw
		String Dbpw = mdao.loginMember(id); //db에서 꺼내오는 패스워드
		
		
		if(pw.equals(Dbpw)) {
			ret = 1;
		}
		else {
			ret = 0;
		}
		return ret;
	}
}
