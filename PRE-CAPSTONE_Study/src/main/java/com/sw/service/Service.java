package com.sw.service;

import java.io.IOException;
import javax.servlet.ServletException;
import com.sw.dto.MemberDto;

public interface Service {

	public int execute(MemberDto mdto) throws ServletException, IOException;
}
