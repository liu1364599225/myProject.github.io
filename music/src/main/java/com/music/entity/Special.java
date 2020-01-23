package com.music.entity;

public class Special {
    private Integer specialId;

    private String specialName;

    private String specialPricture;

    private Integer singerId;

    private String specialRsrv1;

    private String specialRsrv2;

    private String specialSketch;
    
    private	String singerName;

    public Integer getSpecialId() {
        return specialId;
    }

    public void setSpecialId(Integer specialId) {
        this.specialId = specialId;
    }

    public String getSpecialName() {
        return specialName;
    }

    public void setSpecialName(String specialName) {
        this.specialName = specialName == null ? null : specialName.trim();
    }

    public String getSpecialPricture() {
        return specialPricture;
    }

    public void setSpecialPricture(String specialPricture) {
        this.specialPricture = specialPricture == null ? null : specialPricture.trim();
    }

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSpecialRsrv1() {
        return specialRsrv1;
    }

    public void setSpecialRsrv1(String specialRsrv1) {
        this.specialRsrv1 = specialRsrv1 == null ? null : specialRsrv1.trim();
    }

    public String getSpecialRsrv2() {
        return specialRsrv2;
    }

    public void setSpecialRsrv2(String specialRsrv2) {
        this.specialRsrv2 = specialRsrv2 == null ? null : specialRsrv2.trim();
    }

    public String getSpecialSketch() {
        return specialSketch;
    }

    public void setSpecialSketch(String specialSketch) {
        this.specialSketch = specialSketch == null ? null : specialSketch.trim();
    }

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	@Override
	public String toString() {
		return "Special [specialId=" + specialId + ", specialName="
				+ specialName + ", specialPricture=" + specialPricture
				+ ", singerId=" + singerId + ", specialRsrv1=" + specialRsrv1
				+ ", specialRsrv2=" + specialRsrv2 + ", specialSketch="
				+ specialSketch + ", singerName=" + singerName + "]";
	}
    
    
}