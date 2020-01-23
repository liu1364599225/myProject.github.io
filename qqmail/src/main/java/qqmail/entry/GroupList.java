package qqmail.entry;

import java.util.List;

public class GroupList {
	 private Linkmangroup linkman_group;//组信息
	 private List<User> user;//该组下的用户信息
	 
	public Linkmangroup getLinkman_group() {
		return linkman_group;
	}
	public void setLinkman_group(Linkmangroup linkman_group) {
		this.linkman_group = linkman_group;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "GroupList [linkman_group=" + linkman_group + ", user=" + user
				+ "]";
	}
	
}
