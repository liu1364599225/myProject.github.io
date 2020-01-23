package qqmail.entry;

import java.util.Date;
//联系人表，这是向联系人里面增加新人的时候用的
public class Linkman {
    private int linkman_id;//联系人id
    private int user_id;//拥有该通讯录的用户id
    private String address;//地址
    private Date birthday;//生日
    private String job;//工作
    private int group_id;//所属组的id
    
	public int getLinkman_id() {
		return linkman_id;
	}
	public void setLinkman_id(int linkman_id) {
		this.linkman_id = linkman_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	
	@Override
	public String toString() {
		return "Linkman [linkman_id=" + linkman_id + ", user_id=" + user_id
				+ ", address=" + address + ", birthday=" + birthday + ", job="
				+ job + ", group_id=" + group_id + "]";
	}
}
