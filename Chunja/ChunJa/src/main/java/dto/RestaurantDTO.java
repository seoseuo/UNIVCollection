package dto;

import java.util.ArrayList;

import beans.CommentBean;
import beans.RestaurantBean;
import dao.CustomerDAO;
import dao.RestaurantDAO;

public class RestaurantDTO {
	
	RestaurantDAO reDAO = new RestaurantDAO();
	
	public ArrayList<RestaurantBean> rank() {
		return reDAO.rankIM();
	}
				
	public ArrayList<RestaurantBean> list() {
		return reDAO.listIM();
	}
	
	public ArrayList<RestaurantBean> view(String roMALL) {
		return reDAO.viewIM(roMALL);
	}
	
	public ArrayList<RestaurantBean> search(String s) {
		return reDAO.searchIM(s);
	}
	
	public ArrayList<CommentBean> getComment(String roMALL) {
		System.out.println(roMALL+"DTO댓글 리스트 가져오기 시작----------");
		return reDAO.getCommentIM(roMALL);
	}
	
	public ArrayList<CommentBean> reportComs() {
		 ArrayList<CommentBean> rcoms= reDAO.reportComsIM();
		 return rcoms;
	}
}
