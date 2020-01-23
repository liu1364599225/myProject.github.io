package com.petFoster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.HospitalMapper;
import com.petFoster.domain.Hospital;
import com.petFoster.service.HospitalService;

public class HospitalServiceImpl implements HospitalService{
	@Autowired
	private HospitalMapper HospitalMapper;

	public int deleteByPrimaryKey(Long hId) {
		// TODO Auto-generated method stub
		return HospitalMapper.deleteByPrimaryKey(hId);
	}

	public int insert(Hospital record) {
		// TODO Auto-generated method stub
		return HospitalMapper.insert(record);
	}

	public int insertSelective(Hospital record) {
		// TODO Auto-generated method stub
		return HospitalMapper.insertSelective(record);
	}

	public Hospital selectByPrimaryKey(Long hId) {
		// TODO Auto-generated method stub
		return HospitalMapper.selectByPrimaryKey(hId);
	}

	public int updateByPrimaryKeySelective(Hospital record) {
		// TODO Auto-generated method stub
		return HospitalMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Hospital record) {
		// TODO Auto-generated method stub
		return HospitalMapper.updateByPrimaryKey(record);
	}

	public List<Hospital> listByAll() {
		// TODO Auto-generated method stub
		return HospitalMapper.listByAll();
	}

}
