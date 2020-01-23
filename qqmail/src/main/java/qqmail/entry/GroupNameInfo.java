package qqmail.entry;

public class GroupNameInfo {
    private int num;//每个分组的联系人数量
    private String groupName;//分组名
    
    public GroupNameInfo(){
    	
    }

	public GroupNameInfo(int num, String groupName) {
		super();
		this.num = num;
		this.groupName = groupName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "GroupNameInfo [num=" + num + ", groupName=" + groupName + "]";
	}
}
