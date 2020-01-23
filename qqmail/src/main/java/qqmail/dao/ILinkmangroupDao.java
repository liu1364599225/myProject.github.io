package qqmail.dao;


import java.util.List;

import qqmail.entry.Linkmangroup;

public interface ILinkmangroupDao {
	
	//通过组id查出对应的数据
	public Linkmangroup selectByGid(int gid);
	
	//通过用户id查联系人表中的所有的组id，然后再查询出组名对应的当前用户下的组id；
	public Integer selectGidByUid(int user_id,String group_name);
	
	//通过用户id查该用户的所有组信息
	public List<Linkmangroup> selectGroupByUid(int user_id);
}
