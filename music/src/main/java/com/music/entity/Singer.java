package com.music.entity;

public class Singer {
    private Integer singerId;

    private String singerName;

    private String singerPicture;

    private String singerAddress;

    private String singerRsrv1;

    private String singerRsrv2;

    private String singerSketch;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    public String getSingerPicture() {
        return singerPicture;
    }

    public void setSingerPicture(String singerPicture) {
        this.singerPicture = singerPicture == null ? null : singerPicture.trim();
    }

    public String getSingerAddress() {
        return singerAddress;
    }

    public void setSingerAddress(String singerAddress) {
        this.singerAddress = singerAddress == null ? null : singerAddress.trim();
    }

    public String getSingerRsrv1() {
        return singerRsrv1;
    }

    public void setSingerRsrv1(String singerRsrv1) {
        this.singerRsrv1 = singerRsrv1 == null ? null : singerRsrv1.trim();
    }

    public String getSingerRsrv2() {
        return singerRsrv2;
    }

    public void setSingerRsrv2(String singerRsrv2) {
        this.singerRsrv2 = singerRsrv2 == null ? null : singerRsrv2.trim();
    }

    public String getSingerSketch() {
        return singerSketch;
    }

    public void setSingerSketch(String singerSketch) {
        this.singerSketch = singerSketch == null ? null : singerSketch.trim();
    }
}