package com.house.entity;

import java.util.Date;

public class ReservationRecord {
    private Integer reservationrecordId;

    private String reservationrecordState;

    private Date reservationrecordLookingtime;

    private Date reservationrecordCreatetime;

    private Integer userId;

    private Integer housingId;

    private Integer housekeeperId;

    public Integer getReservationrecordId() {
        return reservationrecordId;
    }

    public void setReservationrecordId(Integer reservationrecordId) {
        this.reservationrecordId = reservationrecordId;
    }

    public String getReservationrecordState() {
        return reservationrecordState;
    }

    public void setReservationrecordState(String reservationrecordState) {
        this.reservationrecordState = reservationrecordState == null ? null : reservationrecordState.trim();
    }

    public Date getReservationrecordLookingtime() {
        return reservationrecordLookingtime;
    }

    public void setReservationrecordLookingtime(Date reservationrecordLookingtime) {
        this.reservationrecordLookingtime = reservationrecordLookingtime;
    }

    public Date getReservationrecordCreatetime() {
        return reservationrecordCreatetime;
    }

    public void setReservationrecordCreatetime(Date reservationrecordCreatetime) {
        this.reservationrecordCreatetime = reservationrecordCreatetime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

    public Integer getHousekeeperId() {
        return housekeeperId;
    }

    public void setHousekeeperId(Integer housekeeperId) {
        this.housekeeperId = housekeeperId;
    }

	@Override
	public String toString() {
		return "ReservationRecord [reservationrecordId=" + reservationrecordId
				+ ", reservationrecordState=" + reservationrecordState
				+ ", reservationrecordLookingtime="
				+ reservationrecordLookingtime
				+ ", reservationrecordCreatetime="
				+ reservationrecordCreatetime + ", userId=" + userId
				+ ", housingId=" + housingId + ", housekeeperId="
				+ housekeeperId + "]";
	}
    
    
}