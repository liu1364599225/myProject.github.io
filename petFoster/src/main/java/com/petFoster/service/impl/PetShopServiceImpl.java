package com.petFoster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.PetShopMapper;
import com.petFoster.domain.PetShop;
import com.petFoster.service.PetShopService;

public class PetShopServiceImpl implements PetShopService{
	@Autowired
	private PetShopMapper PetShopMapper;
	
	public int deleteByPrimaryKey(Long psId) {
		// TODO Auto-generated method stub
		return PetShopMapper.deleteByPrimaryKey(psId);
	}

	public int insert(PetShop record) {
		// TODO Auto-generated method stub
		return PetShopMapper.insert(record);
	}

	public int insertSelective(PetShop record) {
		// TODO Auto-generated method stub
		return PetShopMapper.insertSelective(record);
	}

	public PetShop selectByPrimaryKey(Long psId) {
		// TODO Auto-generated method stub
		return PetShopMapper.selectByPrimaryKey(psId);
	}

	public int updateByPrimaryKeySelective(PetShop record) {
		// TODO Auto-generated method stub
		return PetShopMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(PetShop record) {
		// TODO Auto-generated method stub
		return PetShopMapper.updateByPrimaryKey(record);
	}

	public List<PetShop> listByAll() {
		// TODO Auto-generated method stub
		return PetShopMapper.listByAll();
	}

	public PetShop listByAccount(String accountName) {
		// TODO Auto-generated method stub
		return PetShopMapper.listByAccount(accountName);
	}

	public List<PetShop> listByRequestStatus(String requestStatus) {
		// TODO Auto-generated method stub
		return PetShopMapper.listByRequestStatus(requestStatus);
	}

}
