package com.music.entity;

public class Users {
    private Integer usersId;

    private String usersAccount;

    private String usersPassword;

    private String usersName;

    private String usersSex;

    private String usersAvatar;

    private Integer usersType;

    private String usersRsrv1;

    private String usersRsrv2;

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getUsersAccount() {
        return usersAccount;
    }

    public void setUsersAccount(String usersAccount) {
        this.usersAccount = usersAccount == null ? null : usersAccount.trim();
    }

    public String getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(String usersPassword) {
        this.usersPassword = usersPassword == null ? null : usersPassword.trim();
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName == null ? null : usersName.trim();
    }

    public String getUsersSex() {
        return usersSex;
    }

    public void setUsersSex(String usersSex) {
        this.usersSex = usersSex == null ? null : usersSex.trim();
    }

    public String getUsersAvatar() {
        return usersAvatar;
    }

    public void setUsersAvatar(String usersAvatar) {
        this.usersAvatar = usersAvatar == null ? null : usersAvatar.trim();
    }

    public Integer getUsersType() {
        return usersType;
    }

    public void setUsersType(Integer usersType) {
        this.usersType = usersType;
    }

    public String getUsersRsrv1() {
        return usersRsrv1;
    }

    public void setUsersRsrv1(String usersRsrv1) {
        this.usersRsrv1 = usersRsrv1 == null ? null : usersRsrv1.trim();
    }

    public String getUsersRsrv2() {
        return usersRsrv2;
    }

    public void setUsersRsrv2(String usersRsrv2) {
        this.usersRsrv2 = usersRsrv2 == null ? null : usersRsrv2.trim();
    }

	@Override
	public String toString() {
		return "Users [usersId=" + usersId + ", usersAccount=" + usersAccount
				+ ", usersPassword=" + usersPassword + ", usersName="
				+ usersName + ", usersSex=" + usersSex + ", usersAvatar="
				+ usersAvatar + ", usersType=" + usersType + ", usersRsrv1="
				+ usersRsrv1 + ", usersRsrv2=" + usersRsrv2 + "]";
	}
    
    
}