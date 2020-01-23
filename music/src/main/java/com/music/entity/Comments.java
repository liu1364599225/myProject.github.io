package com.music.entity;

import java.util.Date;

public class Comments {
    private Integer commentsId;

    private Date commentsTime;

    private Integer userId;

    private Integer songId;

    private String commentsRsrv1;

    private String commentsRsrv2;

    private String commentsContent;

    public Integer getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Integer commentsId) {
        this.commentsId = commentsId;
    }

    public Date getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(Date commentsTime) {
        this.commentsTime = commentsTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getCommentsRsrv1() {
        return commentsRsrv1;
    }

    public void setCommentsRsrv1(String commentsRsrv1) {
        this.commentsRsrv1 = commentsRsrv1 == null ? null : commentsRsrv1.trim();
    }

    public String getCommentsRsrv2() {
        return commentsRsrv2;
    }

    public void setCommentsRsrv2(String commentsRsrv2) {
        this.commentsRsrv2 = commentsRsrv2 == null ? null : commentsRsrv2.trim();
    }

    public String getCommentsContent() {
        return commentsContent;
    }

    public void setCommentsContent(String commentsContent) {
        this.commentsContent = commentsContent == null ? null : commentsContent.trim();
    }

	@Override
	public String toString() {
		return "Comments [commentsId=" + commentsId + ", commentsTime="
				+ commentsTime + ", userId=" + userId + ", songId=" + songId
				+ ", commentsRsrv1=" + commentsRsrv1 + ", commentsRsrv2="
				+ commentsRsrv2 + ", commentsContent=" + commentsContent + "]";
	}
    
    
}