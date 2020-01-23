package qqmail.entry;
//联系人组表
public class Linkmangroup {
    private int group_id;//组的id
    private String group_name;//组的名字
    
    
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	
	
	@Override
	public String toString() {
		return "Linkman_group [group_id=" + group_id + ", group_name="
				+ group_name + "]";
	}
}
