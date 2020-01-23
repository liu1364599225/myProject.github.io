package com.petFoster.domain;

public class Manager {
    private Long mId;

    private String mAccountname;

    private String mPassword;

    private String mManagername;

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmAccountname() {
        return mAccountname;
    }

    public void setmAccountname(String mAccountname) {
        this.mAccountname = mAccountname == null ? null : mAccountname.trim();
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword == null ? null : mPassword.trim();
    }

    public String getmManagername() {
        return mManagername;
    }

    public void setmManagername(String mManagername) {
        this.mManagername = mManagername == null ? null : mManagername.trim();
    }
}