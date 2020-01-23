package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.house.dao.ReservationRecordMapper;
import com.house.entity.ReservationRecord;
import com.house.service.ReservationRecordService;

public class ReservationRecordServiceImpl implements ReservationRecordService{
	
	@Autowired
	private ReservationRecordMapper reservationRecordMapper;

	@Override
	public int deleteByPrimaryKey(Integer reservationrecordId) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.deleteByPrimaryKey(reservationrecordId);
	}

	@Override
	public int insert(ReservationRecord record) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(ReservationRecord record) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.insertSelective(record);
	}

	@Override
	public ReservationRecord selectByPrimaryKey(Integer reservationrecordId) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.selectByPrimaryKey(reservationrecordId);
	}

	@Override
	public int updateByPrimaryKeySelective(ReservationRecord record) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ReservationRecord record) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.updateByPrimaryKey(record);
	}

	@Override
	public ReservationRecord selectByOrderState(Integer userId,
			Integer housingId) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.selectByOrderState(userId, housingId);
	}

	@Override
	public ReservationRecord selectByUserIdAndHousingId(Integer userId,
			Integer housingId) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.selectByUserIdAndHousingId(userId, housingId);
	}

	@Override
	public List<ReservationRecord> selectByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.selectByUserId(userId);
	}

	@Override
	public List<ReservationRecord> listByAll() {
		// TODO Auto-generated method stub
		return reservationRecordMapper.listByAll();
	}

	@Override
	public List<ReservationRecord> selectByLookTime() {
		// TODO Auto-generated method stub
		return reservationRecordMapper.selectByLookTime();
	}

	@Override
	public List<ReservationRecord> selectByHkId(Integer housekeeperId) {
		// TODO Auto-generated method stub
		return reservationRecordMapper.selectByHkId(housekeeperId);
	}

}
