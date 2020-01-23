package com.music.entity;

import java.util.Date;

public class UsersAndComments {
	private Integer commentsId;

    private Date commentsTime;
    
    private String stringTime;

    private String commentsContent;

    private String usersName;
    
    private String usersAvatar;

    private Integer songId;

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

	public String getCommentsContent() {
		return commentsContent;
	}

	public void setCommentsContent(String commentsContent) {
		this.commentsContent = commentsContent;
	}

	public String getUsersName() {
		return usersName;
	}

	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}

	public String getUsersAvatar() {
		return usersAvatar;
	}

	public void setUsersAvatar(String usersAvatar) {
		this.usersAvatar = usersAvatar;
	}

	public Integer getSongId() {
		return songId;
	}

	public void setSongId(Integer songId) {
		this.songId = songId;
	}
	
	public String getStringTime() {
		return stringTime;
	}

	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}

	@Override
	public String toString() {
		return "UsersAndComments [commentsId=" + commentsId + ", commentsTime="
				+ commentsTime + ", commentsContent=" + commentsContent
				+ ", usersName=" + usersName + ", usersAvatar=" + usersAvatar
				+ ", songId=" + songId + "]";
	}
    
    
}
