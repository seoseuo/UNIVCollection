package beans;

public class RestaurantBean {

	private String reMALL;
	private String reADDRESS;
	private String reNAME;
	
	public String getReNAME() {
		return reNAME;
	}
	public void setReNAME(String reNAME) {
		this.reNAME = reNAME;
	}
	private String reURL;
	private float reSCORE;
	private String reBODY;
	
	private String reLOGO;

	private String rePIC1;
	private String rePIC2;
	private String rePIC3;
	
	public String getReMALL() {
		return reMALL;
	}
	public void setReMALL(String reMALL) {
		this.reMALL = reMALL;
	}
	public String getReADDRESS() {
		return reADDRESS;
	}
	public void setReADDRESS(String reADDRESS) {
		this.reADDRESS = reADDRESS;
	}
	public String getReURL() {
		return reURL;
	}
	public void setReURL(String reURL) {
		this.reURL = reURL;
	}
	public double getReSCORE() {
		return Math.round(reSCORE * 10) / 10.0;
	}
	public void setReSCORE(float reSCORE) {
	    // 소수점 첫 번째 자리까지만 표현하도록 전처리
	    float roundedReSCORE = Math.round(reSCORE * 10) / 10.0f;
	    
	    this.reSCORE = roundedReSCORE;
	}

	public String getReBODY() {
		return reBODY;
	}
	public void setReBODY(String reBODY) {
		this.reBODY = reBODY;
	}
	public String getReLOGO() {
		return reLOGO;
	}
	public void setReLOGO(String reLOGO) {
		this.reLOGO = reLOGO;
	}
	public String getRePIC1() {
		return rePIC1;
	}
	public void setRePIC1(String rePIC1) {
		this.rePIC1 = rePIC1;
	}
	public String getRePIC2() {
		return rePIC2;
	}
	public void setRePIC2(String rePIC2) {
		this.rePIC2 = rePIC2;
	}
	public String getRePIC3() {
		return rePIC3;
	}
	public void setRePIC3(String rePIC3) {
		this.rePIC3 = rePIC3;
	}
	
	
	
	

}
