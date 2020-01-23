package qqmail.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.ILinkmangroupDao;
import qqmail.entry.Linkmangroup;
import qqmail.service.ILinkmangroupService;

public class LinkmangroupServiceImpl implements ILinkmangroupService{
	@Autowired
	private ILinkmangroupDao dao;
	
	public void setDao(ILinkmangroupDao dao) {
		this.dao = dao;
	}

	public Linkmangroup selectByGid(int gid) {
		// TODO Auto-generated method stub
		return dao.selectByGid(gid);
	}



	public Integer selectGidByUid(int user_id, String group_name) {
		// TODO Auto-generated method stub
		return dao.selectGidByUid(user_id, group_name);
	}

	public List<Linkmangroup> selectGroupByUid(int user_id) {
		// TODO Auto-generated method stub
		return dao.selectGroupByUid(user_id);
	}

}
