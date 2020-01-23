package com.music.entity;

import java.util.Date;

public class Viprecords {
    private Integer viprecordsId;

    private Date viprecordsCreatetime;

    private String viprecordsDuration;

    private Integer userId;

    private String viprecordsRsrv1;

    private String viprecordsRsrv2;

    public Integer getViprecordsId() {
        return viprecordsId;
    }

    public void setViprecordsId(Integer viprecordsId) {
        this.viprecordsId = viprecordsId;
    }

    public Date getViprecordsCreatetime() {
        return viprecordsCreatetime;
    }

    public void setViprecordsCreatetime(Date viprecordsCreatetime) {
        this.viprecordsCreatetime = viprecordsCreatetime;
    }

    public String getViprecordsDuration() {
        return viprecordsDuration;
    }

    public void setViprecordsDuration(String viprecordsDuration) {
        this.viprecordsDuration = viprecordsDuration == null ? null : viprecordsDuration.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getViprecordsRsrv1() {
        return viprecordsRsrv1;
    }

    public void setViprecordsRsrv1(String viprecordsRsrv1) {
        this.viprecordsRsrv1 = viprecordsRsrv1 == null ? null : viprecordsRsrv1.trim();
    }

    public String getViprecordsRsrv2() {
        return viprecordsRsrv2;
    }

    public void setViprecordsRsrv2(String viprecordsRsrv2) {
        this.viprecordsRsrv2 = viprecordsRsrv2 == null ? null : viprecordsRsrv2.trim();
    }
}