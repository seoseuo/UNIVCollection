package beans;

import java.sql.Timestamp;

public class CommentBean {

	private String comID;
	private String comNAME;

	private String comBODY;
	private int comSCORE;
	private String roMALL;
	
	private Timestamp comTIME;
	
	
	public Timestamp getComTIME() {
		return comTIME;
	}
	public void setComTIME(Timestamp comTIME) {
		this.comTIME = comTIME;
	}
	public String getComID() {
		return comID;
	} 
	public void setComID(String comID) {
		this.comID = comID;
	}
	public String getComBODY() {
		return comBODY;
	}
	public void setComBODY(String comBODY) {
		this.comBODY = comBODY;
	}
	public int getComSCORE() {
		return comSCORE;
	}
	public void setComSCORE(int comSCORE) {
		this.comSCORE = comSCORE;
	}
	public String getRoMALL() {
		return roMALL;
	}
	public void setRoMALL(String roMALL) {
		this.roMALL = roMALL;
	}
	
	public String getComNAME() {
		return comNAME;
	}
	public void setComNAME(String comNAME) {
		this.comNAME = comNAME;
	}
}
