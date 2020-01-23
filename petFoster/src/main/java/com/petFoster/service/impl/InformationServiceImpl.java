package com.petFoster.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.InformationMapper;
import com.petFoster.domain.Information;
import com.petFoster.service.InformationService;

public class InformationServiceImpl implements InformationService{
	@Autowired
	private InformationMapper InformationMapper;
	
	public int deleteByPrimaryKey(Long iId) {
		// TODO Auto-generated method stub
		return InformationMapper.deleteByPrimaryKey(iId);
	}

	public int insert(Information record) {
		// TODO Auto-generated method stub
		return InformationMapper.insert(record);
	}

	public int insertSelective(Information record) {
		// TODO Auto-generated method stub
		return InformationMapper.insertSelective(record);
	}

	public Information selectByPrimaryKey(Long iId) {
		// TODO Auto-generated method stub
		return InformationMapper.selectByPrimaryKey(iId);
	}

	public int updateByPrimaryKeySelective(Information record) {
		// TODO Auto-generated method stub
		return InformationMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Information record) {
		// TODO Auto-generated method stub
		return InformationMapper.updateByPrimaryKey(record);
	}

	public Information selectByFosterplaceidAndFosterstyle(Long fId,
			String string) {
		// TODO Auto-generated method stub
		return InformationMapper.selectByFosterplaceidAndFosterstyle(fId, string);
	}

	public void deleteByFosterplaceidAndFosterStyle(Long psId,
			String fosterStyle) {
		// TODO Auto-generated method stub
		InformationMapper.deleteByFosterplaceidAndFosterStyle(psId, fosterStyle);
	}

}
