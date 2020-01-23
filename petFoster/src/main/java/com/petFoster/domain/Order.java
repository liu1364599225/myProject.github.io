package com.petFoster.domain;

import java.util.Date;

public class Order {
    private Long oId;

    private Long uId;

    private Long pId;

    private String oFosterstyle;

    private Long oFosterplaceid;

    private Long oFosterday;

    private Date oOrderdate;

    private String oOrderstatus;

    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public Long getuId() {
        return uId;
    }

    public void setuId(Long uId) {
        this.uId = uId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getoFosterstyle() {
        return oFosterstyle;
    }

    public void setoFosterstyle(String oFosterstyle) {
        this.oFosterstyle = oFosterstyle == null ? null : oFosterstyle.trim();
    }

    public Long getoFosterplaceid() {
        return oFosterplaceid;
    }

    public void setoFosterplaceid(Long oFosterplaceid) {
        this.oFosterplaceid = oFosterplaceid;
    }

    public Long getoFosterday() {
        return oFosterday;
    }

    public void setoFosterday(Long oFosterday) {
        this.oFosterday = oFosterday;
    }

    public Date getoOrderdate() {
        return oOrderdate;
    }

    public void setoOrderdate(Date oOrderdate) {
        this.oOrderdate = oOrderdate;
    }

    public String getoOrderstatus() {
        return oOrderstatus;
    }

    public void setoOrderstatus(String oOrderstatus) {
        this.oOrderstatus = oOrderstatus == null ? null : oOrderstatus.trim();
    }

	@Override
	public String toString() {
		return "Order [oId=" + oId + ", uId=" + uId + ", pId=" + pId
				+ ", oFosterstyle=" + oFosterstyle + ", oFosterplaceid="
				+ oFosterplaceid + ", oFosterday=" + oFosterday
				+ ", oOrderdate=" + oOrderdate + ", oOrderstatus="
				+ oOrderstatus + "]";
	}
    
    
}