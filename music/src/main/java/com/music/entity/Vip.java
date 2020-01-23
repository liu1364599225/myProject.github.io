package com.music.entity;

import java.util.Date;

public class Vip {
    private Integer vipId;

    private Date vipCreatetime;

    private Date vipExpirationtime;

    private Integer userId;

    private String vipRsrv1;

    private String vipRsrv2;

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public Date getVipCreatetime() {
        return vipCreatetime;
    }

    public void setVipCreatetime(Date vipCreatetime) {
        this.vipCreatetime = vipCreatetime;
    }

    public Date getVipExpirationtime() {
        return vipExpirationtime;
    }

    public void setVipExpirationtime(Date vipExpirationtime) {
        this.vipExpirationtime = vipExpirationtime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getVipRsrv1() {
        return vipRsrv1;
    }

    public void setVipRsrv1(String vipRsrv1) {
        this.vipRsrv1 = vipRsrv1 == null ? null : vipRsrv1.trim();
    }

    public String getVipRsrv2() {
        return vipRsrv2;
    }

    public void setVipRsrv2(String vipRsrv2) {
        this.vipRsrv2 = vipRsrv2 == null ? null : vipRsrv2.trim();
    }
}