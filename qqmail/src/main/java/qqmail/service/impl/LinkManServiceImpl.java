package qqmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.dao.ILinkManDao;
import qqmail.entry.GroupNameInfo;
import qqmail.entry.LinkManInfo;
import qqmail.entry.Linkman;
import qqmail.entry.Linkmangroup;
import qqmail.service.ILinkManService;

public class LinkManServiceImpl implements ILinkManService{
	@Autowired
	private ILinkManDao dao;
	
	public List<LinkManInfo> readAllLinkManByUserId(int userId) {
		return dao.readAllLinkManByUserId(userId);
	}

	public List<LinkManInfo> readAllLinkManByGroupName(String groupName,
			int userId) {
		return dao.readAllLinkManByGroupName(groupName, userId);
	}

	public List<GroupNameInfo> readAllGroupByUserId(int userId) {
		return dao.readAllGroupByUserId(userId);
	}

	public void updataGroupName(int userId, String account, int GroupId) {
		dao.updataGroupName(userId, account, GroupId);
	}

	public void saveGroupName(Linkmangroup group) {
		dao.saveGroupName(group);
	}

	public Linkmangroup returnaGroupIdByName(String linkmanName) {
		return dao.returnaGroupIdByName(linkmanName);
	}

	public void deleteByAccount(String account, int userId) {
		dao.deleteByAccount(account, userId);
	}

	public List<Linkman> selectByUid(int user_id) {
		// TODO Auto-generated method stub
		return dao.selectByUid(user_id);
	}

	public List<Integer> selectGid(int user_id) {
		// TODO Auto-generated method stub
		return dao.selectGid(user_id);
	}

	public List<Linkman> selectByUidAndGid(int user_id, int group_id) {
		// TODO Auto-generated method stub
		return dao.selectByUidAndGid(user_id, group_id);
	}

	public void insert(Linkman linkman) {
		// TODO Auto-generated method stub
		dao.insert(linkman);
	}

	public List<Linkman> selectByLidAndGid(int linkman_id, int group_id) {
		// TODO Auto-generated method stub
		return dao.selectByLidAndGid(linkman_id, group_id);
	}

}
