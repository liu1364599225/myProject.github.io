package qqmail.entry;
//用户表
public class User {
    private int user_id;//用户id
    private String nickname;//用户名字
    private String user_account;//用户的账号
    private String user_password;//用户的密码
    private String user_tel;//用户的电话
    
    public User(){
    	
    }
    
	public User(String nickname, String user_account, String user_password,
			String user_tel) {
		super();
		this.nickname = nickname;
		this.user_account = user_account;
		this.user_password = user_password;
		this.user_tel = user_tel;
	}



	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", nickname=" + nickname
				+ ", user_account=" + user_account + ", user_password="
				+ user_password + ", user_tel=" + user_tel + "]";
	}
}
