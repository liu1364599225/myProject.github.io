package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.IUserDao;
import qqmail.entry.User;
import qqmail.service.IUserService;

public class UserServiceImpl implements IUserService{
	@Autowired
    private IUserDao dao;
    
    public void setDao(IUserDao dao) {
		this.dao = dao;
	}

	//检查用户是否完成登录验证
	public User proving(String account, String password) {
		return dao.proving(account, password);
	}

	//用户忘记密码时，修改密码
	public void updatePass(String account, String newPassword) {
		dao.updatePass(account, newPassword);
	}

	//注册新用户
	public void createUser(User user) {
		dao.createUser(user);
	}

	public User readUserByAccount(String account) {
		return dao.readUserByAccount(account);
	}

	public User selectById(int user_id) {
		// TODO Auto-generated method stub
		return dao.selectById(user_id);
	}

	public User selectByUser_account(String user_account) {
		// TODO Auto-generated method stub
		return dao.selectByUser_account(user_account);
	}

	public List<User> likeSelect(int user_id, String data) {
		// TODO Auto-generated method stub
		return dao.likeSelect(user_id, data);
	}
}
