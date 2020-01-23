package com.petFoster.dao;

import java.util.List;

import com.petFoster.domain.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Long mId);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Long mId);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    
    List<Manager> listByAll();
    
    Manager listByAccount(String accountName);
}