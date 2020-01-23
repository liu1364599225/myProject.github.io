package com.petFoster.domain;

public class FosterFamily {
    private Long fId;

    private String fAccountname;

    private String fPassword;

    private String fAdoptername;

    private String fAdoptersex;

    private String fFosterexperience;

    private String fContactway;

    private String fAddress;

    private String fFamilyphoto;

    private String fRequeststatus;

    private String fTyperange;

    private String fFeedbackinformation;

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getfAccountname() {
        return fAccountname;
    }

    public void setfAccountname(String fAccountname) {
        this.fAccountname = fAccountname == null ? null : fAccountname.trim();
    }

    public String getfPassword() {
        return fPassword;
    }

    public void setfPassword(String fPassword) {
        this.fPassword = fPassword == null ? null : fPassword.trim();
    }

    public String getfAdoptername() {
        return fAdoptername;
    }

    public void setfAdoptername(String fAdoptername) {
        this.fAdoptername = fAdoptername == null ? null : fAdoptername.trim();
    }

    public String getfAdoptersex() {
        return fAdoptersex;
    }

    public void setfAdoptersex(String fAdoptersex) {
        this.fAdoptersex = fAdoptersex == null ? null : fAdoptersex.trim();
    }

    public String getfFosterexperience() {
        return fFosterexperience;
    }

    public void setfFosterexperience(String fFosterexperience) {
        this.fFosterexperience = fFosterexperience == null ? null : fFosterexperience.trim();
    }

    public String getfContactway() {
        return fContactway;
    }

    public void setfContactway(String fContactway) {
        this.fContactway = fContactway == null ? null : fContactway.trim();
    }

    public String getfAddress() {
        return fAddress;
    }

    public void setfAddress(String fAddress) {
        this.fAddress = fAddress == null ? null : fAddress.trim();
    }

    public String getfFamilyphoto() {
        return fFamilyphoto;
    }

    public void setfFamilyphoto(String fFamilyphoto) {
        this.fFamilyphoto = fFamilyphoto == null ? null : fFamilyphoto.trim();
    }

    public String getfRequeststatus() {
        return fRequeststatus;
    }

    public void setfRequeststatus(String fRequeststatus) {
        this.fRequeststatus = fRequeststatus == null ? null : fRequeststatus.trim();
    }

    public String getfTyperange() {
        return fTyperange;
    }

    public void setfTyperange(String fTyperange) {
        this.fTyperange = fTyperange == null ? null : fTyperange.trim();
    }

    public String getfFeedbackinformation() {
        return fFeedbackinformation;
    }

    public void setfFeedbackinformation(String fFeedbackinformation) {
        this.fFeedbackinformation = fFeedbackinformation == null ? null : fFeedbackinformation.trim();
    }

	@Override
	public String toString() {
		return "FosterFamily [fId=" + fId + ", fAccountname=" + fAccountname
				+ ", fPassword=" + fPassword + ", fAdoptername=" + fAdoptername
				+ ", fAdoptersex=" + fAdoptersex + ", fFosterexperience="
				+ fFosterexperience + ", fContactway=" + fContactway
				+ ", fAddress=" + fAddress + ", fFamilyphoto=" + fFamilyphoto
				+ ", fRequeststatus=" + fRequeststatus + ", fTyperange="
				+ fTyperange + ", fFeedbackinformation=" + fFeedbackinformation
				+ "]";
	}
    
    
}