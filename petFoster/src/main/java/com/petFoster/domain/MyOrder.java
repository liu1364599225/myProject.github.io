package com.petFoster.domain;


public class MyOrder {
	private Long oId;

    private String fosterUserName;

    private String petName;

    private String oFosterstyle;

    private String oFosterplaceName;

    private Long oFosterday;

    private String oOrderdate;

    private String oOrderstatus;

	public MyOrder() {
		
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public String getFosterUserName() {
		return fosterUserName;
	}

	public void setFosterUserName(String fosterUserName) {
		this.fosterUserName = fosterUserName;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getoFosterstyle() {
		return oFosterstyle;
	}

	public void setoFosterstyle(String oFosterstyle) {
		this.oFosterstyle = oFosterstyle;
	}

	public String getoFosterplaceName() {
		return oFosterplaceName;
	}

	public void setoFosterplaceName(String oFosterplaceName) {
		this.oFosterplaceName = oFosterplaceName;
	}

	public Long getoFosterday() {
		return oFosterday;
	}

	public void setoFosterday(Long oFosterday) {
		this.oFosterday = oFosterday;
	}

	public String getoOrderdate() {
		return oOrderdate;
	}

	public void setoOrderdate(String oOrderdate) {
		this.oOrderdate = oOrderdate;
	}

	public String getoOrderstatus() {
		return oOrderstatus;
	}

	public void setoOrderstatus(String oOrderstatus) {
		this.oOrderstatus = oOrderstatus;
	}

	@Override
	public String toString() {
		return "MyOrder [oId=" + oId + ", fosterUserName=" + fosterUserName
				+ ", petName=" + petName + ", oFosterstyle=" + oFosterstyle
				+ ", oFosterplaceName=" + oFosterplaceName + ", oFosterday="
				+ oFosterday + ", oOrderdate=" + oOrderdate + ", oOrderstatus="
				+ oOrderstatus + "]";
	}
    
}
