package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.INow_linkmanDao;
import qqmail.entry.Now_linkman;
import qqmail.service.INow_linkmanService;

public class Now_linkmanServiceImpl implements INow_linkmanService{
	@Autowired
	private INow_linkmanDao dao;
	
	public void setDao(INow_linkmanDao dao) {
		this.dao = dao;
	}
	
	public List<Now_linkman> selectTopFive(int user_id) {
		// TODO Auto-generated method stub
		return dao.selectTopFive(user_id);
	}
	
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}
	
	public void insert(Now_linkman now_linkman) {
		// TODO Auto-generated method stub
		dao.insert(now_linkman);
	}
	
	public List<Now_linkman> listByUidAll(int user_id) {
		// TODO Auto-generated method stub
		return dao.listByUidAll(user_id);
	}
	
	public List<Now_linkman> selectTopFive1(int user_id, int linkman_id) {
		// TODO Auto-generated method stub
		return dao.selectTopFive1(user_id,linkman_id);
	}
	
	public void deleteByLid(int linkman_id) {
		// TODO Auto-generated method stub
		dao.deleteByLid(linkman_id);
	}

	public void deleteByUid(int user_id) {
		// TODO Auto-generated method stub
		dao.deleteByUid(user_id);
	}

}
