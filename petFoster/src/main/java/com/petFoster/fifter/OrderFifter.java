package com.petFoster.fifter;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.petFoster.domain.Order;
import com.petFoster.service.OrderService;

public class OrderFifter implements HandlerInterceptor{
	
	@Autowired
	private OrderService orderService;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		List<Order> orderList = orderService.listByAll();
		Date now = new Date();
		for(Order o : orderList){
			Long day = o.getoFosterday()+7L;
			Long startDate = o.getoOrderdate().getTime() + day * 1000 * 60 * 60 * 24L;
			if(startDate <= now.getTime() && "待确认".equals(o.getoOrderstatus())){
				o.setoOrderstatus("已确认");
				orderService.updateByPrimaryKeySelective(o);
			}
			Long date = o.getoOrderdate().getTime() + 1000 * 60 * 60 * 24L;
			if(date <= now.getTime() && "正在预约".equals(o.getoOrderstatus())){
				o.setoOrderstatus("拒单");
				orderService.updateByPrimaryKeySelective(o);
			}
			
		}

		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
