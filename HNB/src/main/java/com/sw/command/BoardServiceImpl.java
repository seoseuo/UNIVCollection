package com.sw.command;

import java.util.ArrayList;

import com.sw.dao.BDao;
import com.sw.dao.BDaoImpl;
import com.sw.dto.BDto;

public class BoardServiceImpl implements BoardService {

	
	@Override
	public ArrayList<BDto> showBoardList() {
		
	BDao bdao = new BDaoImpl(); 
		ArrayList<BDto> dtos = bdao.showBoardList();
		// TODO Auto-generated method stub
		return dtos;
	}
	

	@Override
	public ArrayList<BDto> topGood() {
		
	BDao bdao = new BDaoImpl(); 
		ArrayList<BDto> dtos = bdao.topGood();
		// TODO Auto-generated method stub
		return dtos;
	}
	
	@Override
	public ArrayList<BDto> topHit() {
		
	BDao bdao = new BDaoImpl(); 
		ArrayList<BDto> dtos = bdao.topHit();
		// TODO Auto-generated method stub
		return dtos;
	}

	
	public void writeContent(BDto bdto) {
		BDao bdao = new BDaoImpl(); 
		bdao.writeContent(bdto);
	}
	
	public BDto viewContent(int bId) {
		BDao bdao = new BDaoImpl(); 
		BDto bdto = bdao.viewContent(bId);
		return bdto;
	}


	@Override
	public int deleteContent(int bId) {
		int ret=0;
		
		BDao bdao = new BDaoImpl(); 
		
		ret = bdao.deleteContent(bId);
		
		return ret;
	}
	@Override
	public int registerCheck(String Id) {
		BDao bdao = new BDaoImpl(); 

		return bdao.registerCheck(Id);
		
	}	
	@Override
	public void register(String Name,String Id,String Pw) {
		BDao bdao = new BDaoImpl(); 
		bdao.register(Name, Id, Pw);
	}
	@Override
	public int login(String Id,String Pw) {
		BDao bdao = new BDaoImpl(); 
		int result = bdao.login(Id, Pw);
		return result;
	}
	
	public String getUserName(String Id) {
		BDao bdao = new BDaoImpl(); 
		String UserName = bdao.getUserName(Id);
		return UserName;
	}
	
	public void good(int bId) {
		BDao bdao = new BDaoImpl(); 
		bdao.good(bId);
	}
	
	public int modifyContent(BDto bdto) {
		BDao bdao = new BDaoImpl(); 
		bdao.modifyContent(bdto);
		
		return 1;
	}


	

}
