package qqmail.dao;

import java.util.List;

import qqmail.entry.GroupNameInfo;
import qqmail.entry.LinkManInfo;
import qqmail.entry.Linkman;
import qqmail.entry.Linkmangroup;

//对于通讯录的操作
public interface ILinkManDao {
    //根据id得到所有联系人的基本信息
	public List<LinkManInfo> readAllLinkManByUserId(int userId);
	
	//根据一个组名查到一个组的全部联系人
	public List<LinkManInfo> readAllLinkManByGroupName(String groupName,int userId);
	
	//根据用户id查找到对应的全部组名，以及组里面联系人的数量
	public List<GroupNameInfo> readAllGroupByUserId(int userId);
	
	//为联系人更改组名
	public void updataGroupName(int userId,String account,int GroupId);
	
	//创建一个组名，并且返回其id值
	public void saveGroupName(Linkmangroup group);
	
	//根据组名在通讯录组表里面查找组名，找到就返回id
	public Linkmangroup returnaGroupIdByName(String linkmanName);
	
	//根据用户名和账号删除通讯录里面的联系人
	public void deleteByAccount(String account,int userId);
	
	
	
	//刘波
	
	
	
	//通过用户id查询得到该用户所有的联系人信息；
	public List<Linkman> selectByUid(int user_id);
	
	//通过用户id查询得到该用户所有的通讯组id；
	public List<Integer> selectGid(int user_id);
	
	//通过用户id和组id查询得到改用户所有的联系人信息；
	public List<Linkman> selectByUidAndGid(int user_id,int group_id);
	
	//插入联系人
	public void insert(Linkman linkman);
	
	//通过联系人id和组id查询得到改用户所有的联系人信息；
	public List<Linkman> selectByLidAndGid(int linkman_id,int group_id);
}
