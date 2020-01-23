package com.house.entity;

public class HkReservationRecord {
	
	private Housing housing;

	private User user;
	
	private String lookHouseTime;
	
	private String recordTime;
	
	private String reservationrecordState;
	
	private Integer reservationrecordId;

	public Housing getHousing() {
		return housing;
	}

	public void setHousing(Housing housing) {
		this.housing = housing;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLookHouseTime() {
		return lookHouseTime;
	}

	public void setLookHouseTime(String lookHouseTime) {
		this.lookHouseTime = lookHouseTime;
	}

	public String getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}

	public String getReservationrecordState() {
		return reservationrecordState;
	}

	public void setReservationrecordState(String reservationrecordState) {
		this.reservationrecordState = reservationrecordState;
	}

	public Integer getReservationrecordId() {
		return reservationrecordId;
	}

	public void setReservationrecordId(Integer reservationrecordId) {
		this.reservationrecordId = reservationrecordId;
	}

	@Override
	public String toString() {
		return "HkReservationRecord [housing=" + housing + ", user=" + user
				+ ", lookHouseTime=" + lookHouseTime + ", recordTime="
				+ recordTime + ", reservationrecordState="
				+ reservationrecordState + ", reservationrecordId="
				+ reservationrecordId + "]";
	}
	
	
}
