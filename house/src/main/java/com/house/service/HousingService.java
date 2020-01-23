package com.house.service;

import java.util.List;

import com.house.entity.Housing;
import com.house.entity.HousingText;

public interface HousingService {
	int deleteByPrimaryKey(Integer housingId);

    int insert(Housing record);

    int insertSelective(Housing record);

    Housing selectByPrimaryKey(Integer housingId);

    int updateByPrimaryKeySelective(Housing record);

    int updateByPrimaryKey(Housing record);

    
    /**
     * 查出审核通过，未租出的所有房源信息，按发布时间逆序排序
     */
	List<Housing> listByState();

    /**
     * 查出审核通过，未租出的，对应的房源价格区间，房源类型，房源户型的所有房源信息，按发布时间逆序排序
     */
	List<Housing> listByStateAndHT(HousingText housingText);

    /**
     * 查出审核通过，未租出的，大于对应的房源价格，房源类型，房源户型的所有房源信息，按发布时间逆序排序
     */
	List<Housing> listByStateAndThanPrice(HousingText housingText);


    /**
     * 查出审核通过，未租出的，小于对应的房源价格，房源类型，房源户型的所有房源信息，按发布时间逆序排序
     */
	List<Housing> listByStateAndlessPrice(HousingText housingText);


    /**
     * 根据搜索内容模糊搜索标题、地址相关的所有房源信息，按发布时间逆序排序
     */
	List<Housing> searchByTitleAndAddress(String searchText);

	
    /**
     * 根据房管员id查询出该房管员所有房源信息，按发布时间逆序排序
     */
	List<Housing> selectByHousekeeperId(Integer housekeeperId);

    /**
     * 查出所有待审核的房源信息，按发布时间逆序排序
     */
	List<Housing> listByStateCheck();
}
