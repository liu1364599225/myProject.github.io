package com.house.dao;

import com.house.entity.HouseKeeper;

public interface HouseKeeperMapper {
    int deleteByPrimaryKey(Integer housekeeperId);

    int insert(HouseKeeper record);

    int insertSelective(HouseKeeper record);

    HouseKeeper selectByPrimaryKey(Integer housekeeperId);

    int updateByPrimaryKeySelective(HouseKeeper record);

    int updateByPrimaryKey(HouseKeeper record);
    
    
    
    HouseKeeper selectByAccount(String houseKeeperAccount);
}