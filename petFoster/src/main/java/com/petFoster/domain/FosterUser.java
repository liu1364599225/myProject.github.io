package com.petFoster.domain;

public class FosterUser {
    private Long fuId;

    private String fuAccountname;

    private String fuPassword;

    private String fuFosterusername;

    private String fuFosterusersex;

    private String fuContactway;

    private String fuAddress;

    private String fuRequeststatus;

    private String fuFeedbackinformation;

    public Long getFuId() {
        return fuId;
    }

    public void setFuId(Long fuId) {
        this.fuId = fuId;
    }

    public String getFuAccountname() {
        return fuAccountname;
    }

    public void setFuAccountname(String fuAccountname) {
        this.fuAccountname = fuAccountname == null ? null : fuAccountname.trim();
    }

    public String getFuPassword() {
        return fuPassword;
    }

    public void setFuPassword(String fuPassword) {
        this.fuPassword = fuPassword == null ? null : fuPassword.trim();
    }

    public String getFuFosterusername() {
        return fuFosterusername;
    }

    public void setFuFosterusername(String fuFosterusername) {
        this.fuFosterusername = fuFosterusername == null ? null : fuFosterusername.trim();
    }

    public String getFuFosterusersex() {
        return fuFosterusersex;
    }

    public void setFuFosterusersex(String fuFosterusersex) {
        this.fuFosterusersex = fuFosterusersex == null ? null : fuFosterusersex.trim();
    }

    public String getFuContactway() {
        return fuContactway;
    }

    public void setFuContactway(String fuContactway) {
        this.fuContactway = fuContactway == null ? null : fuContactway.trim();
    }

    public String getFuAddress() {
        return fuAddress;
    }

    public void setFuAddress(String fuAddress) {
        this.fuAddress = fuAddress == null ? null : fuAddress.trim();
    }

    public String getFuRequeststatus() {
        return fuRequeststatus;
    }

    public void setFuRequeststatus(String fuRequeststatus) {
        this.fuRequeststatus = fuRequeststatus == null ? null : fuRequeststatus.trim();
    }

    public String getFuFeedbackinformation() {
        return fuFeedbackinformation;
    }

    public void setFuFeedbackinformation(String fuFeedbackinformation) {
        this.fuFeedbackinformation = fuFeedbackinformation == null ? null : fuFeedbackinformation.trim();
    }

	@Override
	public String toString() {
		return "FosterUser [fuId=" + fuId + ", fuAccountname=" + fuAccountname
				+ ", fuPassword=" + fuPassword + ", fuFosterusername="
				+ fuFosterusername + ", fuFosterusersex=" + fuFosterusersex
				+ ", fuContactway=" + fuContactway + ", fuAddress=" + fuAddress
				+ ", fuRequeststatus=" + fuRequeststatus
				+ ", fuFeedbackinformation=" + fuFeedbackinformation + "]";
	}
    
    
}