package com.music.entity;

public class Songtype {
    private Integer songtypeId;

    private String songtypeName;

    private String songtypeRsrv1;

    private String songtypeRsrv2;

    public Integer getSongtypeId() {
        return songtypeId;
    }

    public void setSongtypeId(Integer songtypeId) {
        this.songtypeId = songtypeId;
    }

    public String getSongtypeName() {
        return songtypeName;
    }

    public void setSongtypeName(String songtypeName) {
        this.songtypeName = songtypeName == null ? null : songtypeName.trim();
    }

    public String getSongtypeRsrv1() {
        return songtypeRsrv1;
    }

    public void setSongtypeRsrv1(String songtypeRsrv1) {
        this.songtypeRsrv1 = songtypeRsrv1 == null ? null : songtypeRsrv1.trim();
    }

    public String getSongtypeRsrv2() {
        return songtypeRsrv2;
    }

    public void setSongtypeRsrv2(String songtypeRsrv2) {
        this.songtypeRsrv2 = songtypeRsrv2 == null ? null : songtypeRsrv2.trim();
    }
}