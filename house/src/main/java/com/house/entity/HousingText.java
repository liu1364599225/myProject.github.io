package com.house.entity;

public class HousingText {
	
	private Integer housetypeId;
	
	private String housePrice1;
	
	private String housePrice2;
	
	private String roomType;

	public Integer getHousetypeId() {
		return housetypeId;
	}

	public void setHousetypeId(Integer housetypeId) {
		this.housetypeId = housetypeId;
	}

	public String getHousePrice1() {
		return housePrice1;
	}

	public void setHousePrice1(String housePrice1) {
		this.housePrice1 = housePrice1;
	}

	public String getHousePrice2() {
		return housePrice2;
	}

	public void setHousePrice2(String housePrice2) {
		this.housePrice2 = housePrice2;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "HousingText [housetypeId=" + housetypeId + ", housePrice1="
				+ housePrice1 + ", housePrice2=" + housePrice2 + ", roomType="
				+ roomType + "]";
	}
	
	
}
