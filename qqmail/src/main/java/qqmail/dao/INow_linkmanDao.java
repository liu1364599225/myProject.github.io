package qqmail.dao;

import java.util.List;

import qqmail.entry.Now_linkman;

public interface INow_linkmanDao {
	
	//查询当前用户最近联系人中的日期最近的前五条数据
	public List<Now_linkman> selectTopFive(int user_id);
	
	//查询当前用户最近联系人中的日期最近的前五条数据中指定联系人id的数据
	public List<Now_linkman> selectTopFive1(int user_id,int linkman_id);
	
	//查询当前用户最近联系人所有数据
	public List<Now_linkman> listByUidAll(int user_id);
	
	
	//删除数据
	public void delete(int id);
	
	//删除该联系人的所有联系人数据
	public void deleteByLid(int linkman_id);
	
	//删除该用户的所有联系人数据
	public void deleteByUid(int user_id);
	
	//插入数据
	public void insert(Now_linkman now_linkman);
}
