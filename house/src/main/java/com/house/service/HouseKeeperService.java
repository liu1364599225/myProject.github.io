package com.house.service;

import com.house.entity.HouseKeeper;

public interface HouseKeeperService {
	int deleteByPrimaryKey(Integer housekeeperId);

    int insert(HouseKeeper record);

    int insertSelective(HouseKeeper record);

    HouseKeeper selectByPrimaryKey(Integer housekeeperId);

    int updateByPrimaryKeySelective(HouseKeeper record);

    int updateByPrimaryKey(HouseKeeper record);
    

    /**
	 * 通过用户账号查询对应房管员信息
	 */
    HouseKeeper selectByAccount(String houseKeeperAccount);

}
