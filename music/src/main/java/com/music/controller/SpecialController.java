package com.music.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.music.entity.Singer;
import com.music.entity.Song;
import com.music.entity.Special;
import com.music.service.SingerService;
import com.music.service.SongService;
import com.music.service.SpecialService;
@Controller
public class SpecialController {
	@Autowired
	private SpecialService specialService;
	
	@Autowired
	private SongService songService;
	
	@Autowired
	private SingerService singerService;
	
	@RequestMapping("/specialPage")//专辑页面
	public ModelAndView specialPage(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		Integer specialId = Integer.parseInt(request.getParameter("specialId"));
		Special special = specialService.selectByPrimaryKey1(specialId);//需要连表查
		List<Song> songList = songService.findBySpecialId(specialId);
		Singer singer = singerService.selectByPrimaryKey(special.getSingerId());
		request.getSession().setAttribute("songList", songList);
		request.getSession().setAttribute("singer", singer);
		mv.addObject("special", special);
		mv.setViewName("/WEB-INF/jsp/special.jsp");
		return mv;
		
	}
}
