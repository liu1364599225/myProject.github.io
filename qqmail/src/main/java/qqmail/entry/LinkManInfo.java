package qqmail.entry;
//在通讯录页面要用到的联系人信息
public class LinkManInfo {
    private int id;//联系人id
    private String name;//联系人名字
    private String account;//联系人账号
    private String tel;//联系人电话
    private String groupName;//联系人所在的组名
    
    //开始我是没有写无参构造，mybaits接收的时候报错
    public LinkManInfo(){
    	
    }
    
	public LinkManInfo(int id, String name, String account, String tel,
			String groupName) {
		this.id = id;
		this.name = name;
		this.account = account;
		this.tel = tel;
		this.groupName = groupName;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	@Override
	public String toString() {
		return "LinkManInfo [id=" + id + ", name=" + name + ", account="
				+ account + ", tel=" + tel + ", groupName=" + groupName + "]";
	}
	
}
