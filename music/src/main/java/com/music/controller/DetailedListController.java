package com.music.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.music.entity.Songlist;
import com.music.entity.SonglistAndSong;
import com.music.entity.Users;
import com.music.service.SonglistService;

@Controller
public class DetailedListController {
	@Autowired
	private SonglistService songlistService;
	
	@RequestMapping("/detailedList")
	public ModelAndView songList(String songlistId,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		SonglistAndSong songListAndSong =songlistService.selectById(Integer.valueOf(songlistId));
		mv.addObject("songListAndSong", songListAndSong);
		request.getSession().setAttribute("songList", songListAndSong.getSongList());
		mv.setViewName("/WEB-INF/jsp/detailedList.jsp");
		return mv;
	}
	
	@RequestMapping(value="/detailed",produces="text/html;charset=utf-8")
	public ModelAndView detailed(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		if(null == user){
			mv.setViewName("redirect:/loginPage.lw");
			return mv;
		}
		List<Songlist>  myMusicList = songlistService.listAllByUserId(user.getUsersId());
		mv.addObject("myMusicList", myMusicList);
		mv.setViewName("/WEB-INF/jsp/detailed.jsp");
		return mv;
	}
	
	@RequestMapping(value="/createDetailed",produces="text/html;charset=utf-8")
	public ModelAndView createDetailed(String songlistName,String userId,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("redirect:detailed.lw");
		Songlist songlist = new Songlist();
		songlist.setSonglistName(songlistName);
		songlist.setUserId(Integer.valueOf(userId));
		songlistService.insert(songlist);
		return mv;
	}
}
