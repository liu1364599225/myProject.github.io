package com.house.entity;

public class User {
    private Integer userId;

    private String userAccount;

    private String userPassword;

    private String userName;

    private String userAvatar;

    private String userSex;

    private String userTelnumber;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserTelnumber() {
        return userTelnumber;
    }

    public void setUserTelnumber(String userTelnumber) {
        this.userTelnumber = userTelnumber == null ? null : userTelnumber.trim();
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userAccount=" + userAccount
				+ ", userPassword=" + userPassword + ", userName=" + userName
				+ ", userAvatar=" + userAvatar + ", userSex=" + userSex
				+ ", userTelnumber=" + userTelnumber + "]";
	}
}