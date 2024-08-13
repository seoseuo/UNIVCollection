package com.sw.dto;



public class BDto {
	
	public int bNum;
	public String UserId;
	public String bTitle;
	public String bName;
	public int bHit;
	public int bGood;
	public String bDetail;
	
	public BDto() {
		
	}
	


	public BDto(String UserId,String bTitle, String bName, int bHit, int bGood, String bDetail) { //게시글 작성할 때
		
		this.UserId=UserId;
		this.bTitle=bTitle;
		this.bName=bName;
		this.bHit=bHit;
		this.bGood=bGood;
		this.bDetail = bDetail;
	}
	
	public BDto(String UserId, int bNum, String bTitle, String bName, int bHit, int bGood, String bDetail) {
		//게시물 받아올 때
		this.UserId = UserId;
		this.bNum = bNum;
		this.bTitle=bTitle;
		this.bName=bName;
		this.bHit=bHit;
		this.bGood=bGood;
		this.bDetail = bDetail;
	}
	

	public String getUserId() {
		return UserId;
	}


	public void setUserId(String userId) {
		UserId = userId;
	}



	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}


	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getbHit() {
		return bHit;
	}

	public String getbDetail() {
		return bDetail;
	}

	public void setbDetail(String detail) {
		this.bDetail = detail;
	}

	public void setbHit(int bHit) {
		this.bHit = bHit;
	}

	public int getbGood() {
		return bGood;
	}

	public void setbGood(int bGood) {
		this.bGood = bGood;
	}
	
}
