package com.house.entity;

public class HouseMating {
    private Integer housematingId;

    private String housematingBed;

    private String housematingWasher;

    private String housematingAirconditioner;

    private String housematingBalcony;

    private String housematingRefrigerator;

    private String housematingToilet;

    private String housematingCookhouse;

    private String housematingTelevision;

    private String housematingWaterheater;

    private String housematingCloset;

    private String housematingWifi;

    private String housematingSofa;

    private Integer housingId;

    public Integer getHousematingId() {
        return housematingId;
    }

    public void setHousematingId(Integer housematingId) {
        this.housematingId = housematingId;
    }

    public String getHousematingBed() {
        return housematingBed;
    }

    public void setHousematingBed(String housematingBed) {
        this.housematingBed = housematingBed == null ? null : housematingBed.trim();
    }

    public String getHousematingWasher() {
        return housematingWasher;
    }

    public void setHousematingWasher(String housematingWasher) {
        this.housematingWasher = housematingWasher == null ? null : housematingWasher.trim();
    }

    public String getHousematingAirconditioner() {
        return housematingAirconditioner;
    }

    public void setHousematingAirconditioner(String housematingAirconditioner) {
        this.housematingAirconditioner = housematingAirconditioner == null ? null : housematingAirconditioner.trim();
    }

    public String getHousematingBalcony() {
        return housematingBalcony;
    }

    public void setHousematingBalcony(String housematingBalcony) {
        this.housematingBalcony = housematingBalcony == null ? null : housematingBalcony.trim();
    }

    public String getHousematingRefrigerator() {
        return housematingRefrigerator;
    }

    public void setHousematingRefrigerator(String housematingRefrigerator) {
        this.housematingRefrigerator = housematingRefrigerator == null ? null : housematingRefrigerator.trim();
    }

    public String getHousematingToilet() {
        return housematingToilet;
    }

    public void setHousematingToilet(String housematingToilet) {
        this.housematingToilet = housematingToilet == null ? null : housematingToilet.trim();
    }

    public String getHousematingCookhouse() {
        return housematingCookhouse;
    }

    public void setHousematingCookhouse(String housematingCookhouse) {
        this.housematingCookhouse = housematingCookhouse == null ? null : housematingCookhouse.trim();
    }

    public String getHousematingTelevision() {
        return housematingTelevision;
    }

    public void setHousematingTelevision(String housematingTelevision) {
        this.housematingTelevision = housematingTelevision == null ? null : housematingTelevision.trim();
    }

    public String getHousematingWaterheater() {
        return housematingWaterheater;
    }

    public void setHousematingWaterheater(String housematingWaterheater) {
        this.housematingWaterheater = housematingWaterheater == null ? null : housematingWaterheater.trim();
    }

    public String getHousematingCloset() {
        return housematingCloset;
    }

    public void setHousematingCloset(String housematingCloset) {
        this.housematingCloset = housematingCloset == null ? null : housematingCloset.trim();
    }

    public String getHousematingWifi() {
        return housematingWifi;
    }

    public void setHousematingWifi(String housematingWifi) {
        this.housematingWifi = housematingWifi == null ? null : housematingWifi.trim();
    }

    public String getHousematingSofa() {
        return housematingSofa;
    }

    public void setHousematingSofa(String housematingSofa) {
        this.housematingSofa = housematingSofa == null ? null : housematingSofa.trim();
    }

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

	@Override
	public String toString() {
		return "HouseMating [housematingId=" + housematingId
				+ ", housematingBed=" + housematingBed + ", housematingWasher="
				+ housematingWasher + ", housematingAirconditioner="
				+ housematingAirconditioner + ", housematingBalcony="
				+ housematingBalcony + ", housematingRefrigerator="
				+ housematingRefrigerator + ", housematingToilet="
				+ housematingToilet + ", housematingCookhouse="
				+ housematingCookhouse + ", housematingTelevision="
				+ housematingTelevision + ", housematingWaterheater="
				+ housematingWaterheater + ", housematingCloset="
				+ housematingCloset + ", housematingWifi=" + housematingWifi
				+ ", housematingSofa=" + housematingSofa + ", housingId="
				+ housingId + "]";
	}
}