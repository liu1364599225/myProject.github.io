package com.house.entity;

public class HouseKeeper {
    private Integer housekeeperId;

    private String housekeeperAccount;

    private String housekeeperPassword;

    private String housekeeperName;

    private String housekeeperAvatar;

    private String housekeeperSex;

    private String housekeeperTelnumber;

    private String housekeeperAddress;

    public Integer getHousekeeperId() {
        return housekeeperId;
    }

    public void setHousekeeperId(Integer housekeeperId) {
        this.housekeeperId = housekeeperId;
    }

    public String getHousekeeperAccount() {
        return housekeeperAccount;
    }

    public void setHousekeeperAccount(String housekeeperAccount) {
        this.housekeeperAccount = housekeeperAccount == null ? null : housekeeperAccount.trim();
    }

    public String getHousekeeperPassword() {
        return housekeeperPassword;
    }

    public void setHousekeeperPassword(String housekeeperPassword) {
        this.housekeeperPassword = housekeeperPassword == null ? null : housekeeperPassword.trim();
    }

    public String getHousekeeperName() {
        return housekeeperName;
    }

    public void setHousekeeperName(String housekeeperName) {
        this.housekeeperName = housekeeperName == null ? null : housekeeperName.trim();
    }

    public String getHousekeeperAvatar() {
        return housekeeperAvatar;
    }

    public void setHousekeeperAvatar(String housekeeperAvatar) {
        this.housekeeperAvatar = housekeeperAvatar == null ? null : housekeeperAvatar.trim();
    }

    public String getHousekeeperSex() {
        return housekeeperSex;
    }

    public void setHousekeeperSex(String housekeeperSex) {
        this.housekeeperSex = housekeeperSex == null ? null : housekeeperSex.trim();
    }

    public String getHousekeeperTelnumber() {
        return housekeeperTelnumber;
    }

    public void setHousekeeperTelnumber(String housekeeperTelnumber) {
        this.housekeeperTelnumber = housekeeperTelnumber == null ? null : housekeeperTelnumber.trim();
    }

    public String getHousekeeperAddress() {
        return housekeeperAddress;
    }

    public void setHousekeeperAddress(String housekeeperAddress) {
        this.housekeeperAddress = housekeeperAddress == null ? null : housekeeperAddress.trim();
    }

	@Override
	public String toString() {
		return "HouseKeeper [housekeeperId=" + housekeeperId
				+ ", housekeeperAccount=" + housekeeperAccount
				+ ", housekeeperPassword=" + housekeeperPassword
				+ ", housekeeperName=" + housekeeperName
				+ ", housekeeperAvatar=" + housekeeperAvatar
				+ ", housekeeperSex=" + housekeeperSex
				+ ", housekeeperTelnumber=" + housekeeperTelnumber
				+ ", housekeeperAddress=" + housekeeperAddress + "]";
	}
    
    
}