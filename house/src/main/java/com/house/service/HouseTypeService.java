package com.house.service;

import java.util.List;

import com.house.entity.HouseType;

public interface HouseTypeService {
	int deleteByPrimaryKey(Integer housetypeId);

    int insert(HouseType record);

    int insertSelective(HouseType record);

    HouseType selectByPrimaryKey(Integer housetypeId);

    int updateByPrimaryKeySelective(HouseType record);

    int updateByPrimaryKey(HouseType record);

    /**
     * 
     * 查询出所有的房源类型数据
     */
	List<HouseType> listByAll();

    /**
     * 
     * 根据房源类型id查询出对应的房源类型数据
     */
	HouseType selectByHouseTypeName(String houseType);
}
