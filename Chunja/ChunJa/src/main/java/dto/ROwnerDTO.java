package dto;

import java.util.ArrayList;

import beans.CommentBean;
import beans.ROwnerBean;
import beans.RestaurantBean;
import dao.ROwnerDAO;

public class ROwnerDTO {
	
	ROwnerDAO roDAO = new ROwnerDAO();
	
	public int ro_login(ROwnerBean ro) {
		return roDAO.ro_loginIM(ro);
	}
	
	public int ro_register(ROwnerBean ro) {
		return roDAO.ro_registerIM(ro);
	}
	
	public int ro_write(RestaurantBean re) {
		return roDAO.ro_writeIM(re);
	}
	
	public int ro_edit(RestaurantBean re) {
		return roDAO.ro_editIM(re);
	}
	
	public String ro_getDnaem(ROwnerBean r) {
		return roDAO.ro_getDnaemIM(r);
	}
	
	public String ro_getDMall(String r) {
		return roDAO.ro_getDMallIM(r);
	}
	
	public String ro_getDNameFromMall(ROwnerBean r) {
		return roDAO.ro_getDNameFromMallIM(r);
	}
	
	public boolean ro_Check(String roNAME) {
		return roDAO.roCheckIM(roNAME);
	}
	
	public void ro_Report(CommentBean com) {
		roDAO.ro_ReportIM(com);
	}
	
	public ArrayList<ROwnerBean> ro_list() {
		ArrayList<ROwnerBean> list = roDAO.ro_listIM();
		return list;
	}
}

