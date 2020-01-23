package com.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.music.entity.Special;
import com.music.service.SpecialService;

@Controller
public class IndexController {
	@Autowired
	private SpecialService specialService;
	
	@RequestMapping("/indexPage")
	public ModelAndView indexPage(){
		ModelAndView mv = new ModelAndView();
		List<Special> speList = specialService.selectSpecialAll();
		mv.addObject("speList", speList);
		mv.setViewName("/WEB-INF/jsp/index.jsp");
		return mv;
		
	}
}
