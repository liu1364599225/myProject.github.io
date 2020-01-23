package com.house.entity;

public class HouseType {
    private Integer housetypeId;

    private String housetypeName;

    public Integer getHousetypeId() {
        return housetypeId;
    }

    public void setHousetypeId(Integer housetypeId) {
        this.housetypeId = housetypeId;
    }

    public String getHousetypeName() {
        return housetypeName;
    }

    public void setHousetypeName(String housetypeName) {
        this.housetypeName = housetypeName == null ? null : housetypeName.trim();
    }

	@Override
	public String toString() {
		return "HouseType [housetypeId=" + housetypeId + ", housetypeName="
				+ housetypeName + "]";
	}
}