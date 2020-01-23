package com.petFoster.service;

import java.util.List;

import com.petFoster.domain.Order;

public interface OrderService {
	int deleteByPrimaryKey(Long oId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long oId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> listByOneRequestStatus(String requestStatus,String oFosterstyle,Long oFosterplaceid);
    
    List<Order> listBy1RequestStatus(String requestStatus);
    
    List<Order> listByRequestStatus(String requestStatus1,String requestStatus2,String requestStatus3);
    
    List<Order> listByAll();
    
    List<Long> listByRefuse(Long uId);
    
    List<Order> listByfuId(Long fuId);
    
    List<Order> listByoFosterplaceid(Long oFosterplaceid,String oFosterstyle);
    
    List<Order> listBypId(Long pId);
    
    void deleteByfosterPlaceIdAndfosterStyle(Long placeId,String style);
}
