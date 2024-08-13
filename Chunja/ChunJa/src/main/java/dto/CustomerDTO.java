package dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CommentBean;
import beans.CustomerBean;
import dao.CustomerDAO;

public class CustomerDTO {
	
	CustomerDAO cDAO = new CustomerDAO();
	
	public int cu_login(CustomerBean c) {
		return cDAO.cu_loginIM(c);
	}
	
	public int cu_register(CustomerBean c) {
		return cDAO.cu_registerIM(c);
	}
	
	public int cu_commenting(CommentBean com) {

		return cDAO.cu_commentingIM(com);
	}
	
	public String cu_getDname(CustomerBean c) {
		return cDAO.cu_getDnaemIM(c);
	}
	
	public void cu_delComment(CommentBean com) {
		cDAO.cu_delCommentIM(com);
	}
	
	public ArrayList<CustomerBean> cu_list() {
		ArrayList<CustomerBean> list = cDAO.cu_listIM();
		return list;
	}
}
