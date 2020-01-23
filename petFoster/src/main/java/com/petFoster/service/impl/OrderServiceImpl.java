package com.petFoster.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.petFoster.dao.OrderMapper;
import com.petFoster.domain.Order;
import com.petFoster.service.OrderService;

public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper OrderMapper;
	
	public int deleteByPrimaryKey(Long oId) {
		// TODO Auto-generated method stub
		return OrderMapper.deleteByPrimaryKey(oId);
	}

	public int insert(Order record) {
		// TODO Auto-generated method stub
		return OrderMapper.insert(record);
	}

	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return OrderMapper.insertSelective(record);
	}

	public Order selectByPrimaryKey(Long oId) {
		// TODO Auto-generated method stub
		return OrderMapper.selectByPrimaryKey(oId);
	}

	public int updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return OrderMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Order record) {
		// TODO Auto-generated method stub
		return OrderMapper.updateByPrimaryKey(record);
	}

	public List<Order> listByAll() {
		// TODO Auto-generated method stub
		return OrderMapper.listByAll();
	}

	public List<Order> listByRequestStatus(String requestStatus1,String requestStatus2,String requestStatus3) {
		// TODO Auto-generated method stub
		return OrderMapper.listByRequestStatus(requestStatus1,requestStatus2,requestStatus3);
	}

	public List<Order> listByfuId(Long fuId) {
		// TODO Auto-generated method stub
		return OrderMapper.listByfuId(fuId);
	}

	public List<Order> listBypId(Long pId) {
		// TODO Auto-generated method stub
		return OrderMapper.listBypId(pId);
	}

	public void deleteByfosterPlaceIdAndfosterStyle(Long placeId, String style) {
		// TODO Auto-generated method stub
		OrderMapper.deleteByfosterPlaceIdAndfosterStyle(placeId, style);
	}

	public List<Long> listByRefuse(Long uId) {
		// TODO Auto-generated method stub
		return OrderMapper.listByRefuse(uId);
	}

	public List<Order> listByoFosterplaceid(Long oFosterplaceid,
			String oFosterstyle) {
		// TODO Auto-generated method stub
		return OrderMapper.listByoFosterplaceid(oFosterplaceid, oFosterstyle);
	}

	public List<Order> listByOneRequestStatus(String requestStatus,String oFosterstyle,Long oFosterplaceid) {
		// TODO Auto-generated method stub
		return OrderMapper.listByOneRequestStatus(requestStatus,oFosterstyle,oFosterplaceid);
	}

	public List<Order> listBy1RequestStatus(String requestStatus) {
		// TODO Auto-generated method stub
		return OrderMapper.listBy1RequestStatus(requestStatus);
	}

}
