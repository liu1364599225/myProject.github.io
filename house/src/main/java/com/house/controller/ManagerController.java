package com.house.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.house.entity.Comment;
import com.house.entity.HouseKeeper;
import com.house.entity.HouseMating;
import com.house.entity.Housing;
import com.house.entity.Manager;
import com.house.entity.ReservationRecord;
import com.house.entity.User;
import com.house.service.HouseKeeperService;
import com.house.service.HouseMatingService;
import com.house.service.HousingService;
import com.house.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private HousingService housingService;
	
	@Autowired
	private HouseMatingService houseMatingService;
	
	@Autowired
	private HouseKeeperService houseKeeperService;
	
	@Autowired
	private ManagerService managerService;
	
	@RequestMapping("/managerIndex")
	public ModelAndView managerIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		Manager manager = (Manager) session.getAttribute("managerAccount");
		List<Housing> housingList= housingService.listByStateCheck();
		session.setAttribute("housingList", housingList);
		mv.setViewName("/WEB-INF/jsp/managerIndex.jsp");
		return mv;
	}
	
	@RequestMapping("/housingCheckPage")
	public ModelAndView housingCheckPage(HttpServletRequest request,HttpSession session,Integer housingId){
		ModelAndView mv = new ModelAndView();
		Housing housing = housingService.selectByPrimaryKey(housingId);
		HouseMating houseMating = houseMatingService.selectByHousingId(housing.getHousingId());
		HouseKeeper houseKeeper = houseKeeperService.selectByPrimaryKey(housing.getHousekeeperId());
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String str = sf.format(housing.getHousingCreatetime());
		
		mv.addObject("housingCreateTime", str);
		request.getSession().setAttribute("housing", housing);
		request.getSession().setAttribute("houseMating", houseMating);
		request.getSession().setAttribute("houseKeeper", houseKeeper);
		mv.setViewName("/WEB-INF/jsp/housingCheck.jsp");
		return mv;
	}
	
	@RequestMapping("/passCheckHousing")
	public ModelAndView passCheckHousing(HttpServletRequest request,Integer housingId){
		ModelAndView mv = new ModelAndView();
		Housing housing = new Housing();
		housing.setHousingId(housingId);
		housing.setHousingCheckstate("2");
		housingService.updateByPrimaryKeySelective(housing);
		mv.setViewName("redirect:managerIndex.fw");
		return mv;
	}
	
	@RequestMapping("/noPassCheckHousing")
	public ModelAndView noPassCheckHousing(HttpServletRequest request,Integer housingId){
		ModelAndView mv = new ModelAndView();
		Housing housing = new Housing();
		housing.setHousingId(housingId);
		housing.setHousingCheckstate("1");
		housingService.updateByPrimaryKeySelective(housing);
		mv.setViewName("redirect:managerIndex.fw");
		return mv;
	}
	
	@RequestMapping("/managerExit")
	public String managerExit(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:loginPage.fw";
	}
}
