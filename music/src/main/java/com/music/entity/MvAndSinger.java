package com.music.entity;

public class MvAndSinger {
    private Integer mvId;

    private String mvName;

    private String mvPriture;

    private String mvMvfile;

    private Singer singer;

    private String mvRsrv1;

    private String mvRsrv2;

    public Integer getMvId() {
        return mvId;
    }

    public void setMvId(Integer mvId) {
        this.mvId = mvId;
    }

    public String getMvName() {
        return mvName;
    }

    public void setMvName(String mvName) {
        this.mvName = mvName == null ? null : mvName.trim();
    }

    public String getMvPriture() {
        return mvPriture;
    }

    public void setMvPriture(String mvPriture) {
        this.mvPriture = mvPriture == null ? null : mvPriture.trim();
    }

    public String getMvMvfile() {
        return mvMvfile;
    }

    public void setMvMvfile(String mvMvfile) {
        this.mvMvfile = mvMvfile == null ? null : mvMvfile.trim();
    }

  

    public Singer getSinger() {
		return singer;
	}

	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public String getMvRsrv1() {
        return mvRsrv1;
    }

    public void setMvRsrv1(String mvRsrv1) {
        this.mvRsrv1 = mvRsrv1 == null ? null : mvRsrv1.trim();
    }

    public String getMvRsrv2() {
        return mvRsrv2;
    }

    public void setMvRsrv2(String mvRsrv2) {
        this.mvRsrv2 = mvRsrv2 == null ? null : mvRsrv2.trim();
    }
}