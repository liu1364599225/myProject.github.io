package com.house.dao;

import java.util.List;

import com.house.entity.HouseType;

public interface HouseTypeMapper {
    int deleteByPrimaryKey(Integer housetypeId);

    int insert(HouseType record);

    int insertSelective(HouseType record);

    HouseType selectByPrimaryKey(Integer housetypeId);

    int updateByPrimaryKeySelective(HouseType record);

    int updateByPrimaryKey(HouseType record);
    
    
    List<HouseType> listByAll();
    
	HouseType selectByHouseTypeName(String houseType);
}