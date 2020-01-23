package com.house.entity;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private String commentText;

    private Date commentCreatetime;

    private Integer userId;

    private Integer housingId;
    
    private User user;
    
    private String commentTime;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText == null ? null : commentText.trim();
    }

    public Date getCommentCreatetime() {
        return commentCreatetime;
    }

    public void setCommentCreatetime(Date commentCreatetime) {
        this.commentCreatetime = commentCreatetime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHousingId() {
        return housingId;
    }

    public void setHousingId(Integer housingId) {
        this.housingId = housingId;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentText="
				+ commentText + ", commentCreatetime=" + commentCreatetime
				+ ", userId=" + userId + ", housingId=" + housingId + ", user="
				+ user + ", commentTime=" + commentTime + "]";
	}
	
	
}