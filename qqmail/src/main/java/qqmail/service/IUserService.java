package qqmail.service;

import java.util.List;

import qqmail.entry.User;

//用户表service
public interface IUserService {
	 //对登录时传递过来的账号和密码进行验证,如果存在返回对象，没有则为null
	public User proving(String account,String password);
	
	//用户忘记密码，修改密码
	public void updatePass(String account,String newPassword);
	
	//用户注册，创建新用户
	public void createUser(User user);
	
	//根据账号查找该User
	public User readUserByAccount(String account);
	
	
	//通过用户id，查询用户
	public User selectById(int user_id);
	
	//通过邮箱号，查询用户
	public User selectByUser_account(String user_account);
	
	//模糊查询
	public List<User> likeSelect(int user_id,String data);
}
