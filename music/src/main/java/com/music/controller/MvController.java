package com.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.music.entity.Singer;
import com.music.service.MvService;
import com.music.service.SingerService;
import com.music.service.impl.SingerServiceImpl;

@Controller
public class MvController {
	@Autowired
	private MvService mvService;
	
	@Autowired
	private SingerService singerService;
	
	@RequestMapping("/mvList")
	public ModelAndView mvList(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("mvList", mvService.selectAll());
		mv.setViewName("/WEB-INF/jsp/mvList.jsp");
		return mv;
	}
	
	@RequestMapping("/mv")
	public ModelAndView mv(String mvId){
		System.out.println(mvId);
		ModelAndView mv = new ModelAndView();		
		mv.addObject("mv",mvService.selectByPrimaryKey(Integer.valueOf(mvId)));
		mv.setViewName("/WEB-INF/jsp/mvPlay.jsp");
		return mv;
	}
}
