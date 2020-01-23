package com.house.entity;

import java.util.Date;

public class Housing {
    private Integer housingId;

    private String housingTitle;

    private String housingAbout;

    private String housingImage;

    private String housingAddress;

    private String housingDetailsaddress;

    private String housingPrice;

    private String housingArea;

    private String housingHousetype;

    private String housingFloor;

    private Date housingCreatetime;

    private String housingCheckstate;

    private String housingLeasestate;

    private Integer housetypeId;

    private Integer housekeeperId;

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

    public String getHousingTitle() {
        return housingTitle;
    }

    public void setHousingTitle(String housingTitle) {
        this.housingTitle = housingTitle == null ? null : housingTitle.trim();
    }

    public String getHousingAbout() {
        return housingAbout;
    }

    public void setHousingAbout(String housingAbout) {
        this.housingAbout = housingAbout == null ? null : housingAbout.trim();
    }

    public String getHousingImage() {
        return housingImage;
    }

    public void setHousingImage(String housingImage) {
        this.housingImage = housingImage == null ? null : housingImage.trim();
    }

    public String getHousingAddress() {
        return housingAddress;
    }

    public void setHousingAddress(String housingAddress) {
        this.housingAddress = housingAddress == null ? null : housingAddress.trim();
    }

    public String getHousingDetailsaddress() {
        return housingDetailsaddress;
    }

    public void setHousingDetailsaddress(String housingDetailsaddress) {
        this.housingDetailsaddress = housingDetailsaddress == null ? null : housingDetailsaddress.trim();
    }

    public String getHousingPrice() {
        return housingPrice;
    }

    public void setHousingPrice(String housingPrice) {
        this.housingPrice = housingPrice == null ? null : housingPrice.trim();
    }

    public String getHousingArea() {
        return housingArea;
    }

    public void setHousingArea(String housingArea) {
        this.housingArea = housingArea == null ? null : housingArea.trim();
    }

    public String getHousingHousetype() {
        return housingHousetype;
    }

    public void setHousingHousetype(String housingHousetype) {
        this.housingHousetype = housingHousetype == null ? null : housingHousetype.trim();
    }

    public String getHousingFloor() {
        return housingFloor;
    }

    public void setHousingFloor(String housingFloor) {
        this.housingFloor = housingFloor == null ? null : housingFloor.trim();
    }

    public Date getHousingCreatetime() {
        return housingCreatetime;
    }

    public void setHousingCreatetime(Date housingCreatetime) {
        this.housingCreatetime = housingCreatetime;
    }

    public String getHousingCheckstate() {
        return housingCheckstate;
    }

    public void setHousingCheckstate(String housingCheckstate) {
        this.housingCheckstate = housingCheckstate == null ? null : housingCheckstate.trim();
    }

    public String getHousingLeasestate() {
        return housingLeasestate;
    }

    public void setHousingLeasestate(String housingLeasestate) {
        this.housingLeasestate = housingLeasestate == null ? null : housingLeasestate.trim();
    }

    public Integer getHousetypeId() {
        return housetypeId;
    }

    public void setHousetypeId(Integer housetypeId) {
        this.housetypeId = housetypeId;
    }

    public Integer getHousekeeperId() {
        return housekeeperId;
    }

    public void setHousekeeperId(Integer housekeeperId) {
        this.housekeeperId = housekeeperId;
    }

	@Override
	public String toString() {
		return "Housing [housingId=" + housingId + ", housingTitle="
				+ housingTitle + ", housingAbout=" + housingAbout
				+ ", housingImage=" + housingImage + ", housingAddress="
				+ housingAddress + ", housingDetailsaddress="
				+ housingDetailsaddress + ", housingPrice=" + housingPrice
				+ ", housingArea=" + housingArea + ", housingHousetype="
				+ housingHousetype + ", housingFloor=" + housingFloor
				+ ", housingCreatetime=" + housingCreatetime
				+ ", housingCheckstate=" + housingCheckstate
				+ ", housingLeasestate=" + housingLeasestate + ", housetypeId="
				+ housetypeId + ", housekeeperId=" + housekeeperId + "]";
	}
}