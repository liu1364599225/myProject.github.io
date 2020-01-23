package com.petFoster.domain;

import java.math.BigDecimal;

public class Information {
    private Long iId;

    private String iEnvironment;

    private BigDecimal iFostercare;

    private BigDecimal iPickupservice;

    private String iDescribe;

    private String iNeedtoknow;

    private String iCshotline;

    private String iFosterstyle;

    private Long iFosterplaceid;

    public Long getiId() {
        return iId;
    }

    public void setiId(Long iId) {
        this.iId = iId;
    }

    public String getiEnvironment() {
        return iEnvironment;
    }

    public void setiEnvironment(String iEnvironment) {
        this.iEnvironment = iEnvironment == null ? null : iEnvironment.trim();
    }

    public BigDecimal getiFostercare() {
        return iFostercare;
    }

    public void setiFostercare(BigDecimal iFostercare) {
        this.iFostercare = iFostercare;
    }

    public BigDecimal getiPickupservice() {
        return iPickupservice;
    }

    public void setiPickupservice(BigDecimal iPickupservice) {
        this.iPickupservice = iPickupservice;
    }

    public String getiDescribe() {
        return iDescribe;
    }

    public void setiDescribe(String iDescribe) {
        this.iDescribe = iDescribe == null ? null : iDescribe.trim();
    }

    public String getiNeedtoknow() {
        return iNeedtoknow;
    }

    public void setiNeedtoknow(String iNeedtoknow) {
        this.iNeedtoknow = iNeedtoknow == null ? null : iNeedtoknow.trim();
    }

    public String getiCshotline() {
        return iCshotline;
    }

    public void setiCshotline(String iCshotline) {
        this.iCshotline = iCshotline == null ? null : iCshotline.trim();
    }

    public String getiFosterstyle() {
        return iFosterstyle;
    }

    public void setiFosterstyle(String iFosterstyle) {
        this.iFosterstyle = iFosterstyle == null ? null : iFosterstyle.trim();
    }

    public Long getiFosterplaceid() {
        return iFosterplaceid;
    }

    public void setiFosterplaceid(Long iFosterplaceid) {
        this.iFosterplaceid = iFosterplaceid;
    }

	@Override
	public String toString() {
		return "Information [iId=" + iId + ", iEnvironment=" + iEnvironment
				+ ", iFostercare=" + iFostercare + ", iPickupservice="
				+ iPickupservice + ", iDescribe=" + iDescribe
				+ ", iNeedtoknow=" + iNeedtoknow + ", iCshotline=" + iCshotline
				+ ", iFosterstyle=" + iFosterstyle + ", iFosterplaceid="
				+ iFosterplaceid + "]";
	}
    
    
}