package com.sw.command;

import java.io.IOException;

import javax.servlet.ServletException;

import com.sw.dao.MemberDao;
import com.sw.dao.MemberDaoimpl;
import com.sw.dto.MemberDto;
import com.sw.service.Service;

public class InsertCommand implements Service {

	@Override
	public int execute(MemberDto mdto) throws ServletException, IOException {

		MemberDao mdao = new MemberDaoimpl();
		int ret = mdao.insertMember(mdto);
		return ret;
	}

}
