package com.sw.command;

import java.util.ArrayList;

import com.sw.dto.BDto;

public interface BoardService {

	ArrayList<BDto> showBoardList();
	void writeContent(BDto bdto);
	BDto viewContent(int bId);
	
	public int modifyContent(BDto bdto);
	int deleteContent(int bId);
	int registerCheck(String id);
	void register(String Name,String Id,String Pw);
	int login(String Id,String Pw);
	public String getUserName(String Id);
	public void good(int bId);
	public ArrayList<BDto> topGood();
	public ArrayList<BDto> topHit();
	
	
}
