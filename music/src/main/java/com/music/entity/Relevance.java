package com.music.entity;

public class Relevance {
    private Integer relevanceId;

    private Integer songId;

    private Integer songlistId;

    private String relevanceRsrv1;

    private String relevanceRsrv2;

    public Integer getRelevanceId() {
        return relevanceId;
    }

    public void setRelevanceId(Integer relevanceId) {
        this.relevanceId = relevanceId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSonglistId() {
        return songlistId;
    }

    public void setSonglistId(Integer songlistId) {
        this.songlistId = songlistId;
    }

    public String getRelevanceRsrv1() {
        return relevanceRsrv1;
    }

    public void setRelevanceRsrv1(String relevanceRsrv1) {
        this.relevanceRsrv1 = relevanceRsrv1 == null ? null : relevanceRsrv1.trim();
    }

    public String getRelevanceRsrv2() {
        return relevanceRsrv2;
    }

    public void setRelevanceRsrv2(String relevanceRsrv2) {
        this.relevanceRsrv2 = relevanceRsrv2 == null ? null : relevanceRsrv2.trim();
    }

	@Override
	public String toString() {
		return "Relevance [relevanceId=" + relevanceId + ", songId=" + songId
				+ ", songlistId=" + songlistId + ", relevanceRsrv1="
				+ relevanceRsrv1 + ", relevanceRsrv2=" + relevanceRsrv2 + "]";
	}
    
    
}