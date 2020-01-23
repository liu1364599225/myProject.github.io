package qqmail.entry;

import java.util.Date;

//最近联系人表
public class Now_linkman {
    private int id;//现有联系人表id
    private int user_id;//拥有这个联系表人的id
    private int linkman_id;//被联系人的id
    private Date link_time;//联系时间
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getLinkman_id() {
		return linkman_id;
	}
	public void setLinkman_id(int linkman_id) {
		this.linkman_id = linkman_id;
	}
	
	public Date getLink_time() {
		return link_time;
	}
	public void setLink_time(Date link_time) {
		this.link_time = link_time;
	}
	
	@Override
	public String toString() {
		return "Now_linkman [id=" + id + ", user_id=" + user_id
				+ ", linkman_id=" + linkman_id + ", link_time=" + link_time
				+ "]";
	}

	
}
