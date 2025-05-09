package com.sw.dao;

import java.util.ArrayList;

import com.sw.dto.BDto;

public interface BDao {
	
	public ArrayList<BDto> showBoardList();
	public int writeContent(BDto bdto);
	public BDto viewContent(int bId);

	
	public int modifyContent(BDto bdto);
	public int deleteContent(int bId);
	
	public int registerCheck(String Id);
	public void register(String Name,String Id,String Pw);
	public int login(String Id,String Pw);
	public String getUserName(String Id);
	public void good(int bId);
	
	public ArrayList<BDto> topGood();
	public ArrayList<BDto> topHit();
	


}
