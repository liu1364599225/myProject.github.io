package com.music.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.music.entity.Comments;
import com.music.entity.Relevance;
import com.music.entity.Singer;
import com.music.entity.Song;
import com.music.entity.SongDetails;
import com.music.entity.Songlist;
import com.music.entity.Users;
import com.music.entity.UsersAndComments;
import com.music.service.CommentsService;
import com.music.service.RelevanceService;
import com.music.service.SingerService;
import com.music.service.SongService;
import com.music.service.SonglistService;

@Controller
public class songController {
	
	@Autowired
	private SingerService singerService;
	
	@Autowired
	private SongService	songService;
	
	@Autowired
	private SonglistService	songlistService;
	
	@Autowired
	private CommentsService commentsService;
	
	@Autowired
	private RelevanceService relevanceService;

	//显示歌手列表
	@RequestMapping("/singerPage")
	public ModelAndView singerPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		List<Singer> singerList = singerService.listByAll();
		mv.addObject("singerList", singerList);
		mv.setViewName("/WEB-INF/jsp/singerList.jsp");
		return mv;
	}
	
	//显示歌手简介及所有歌曲
	@RequestMapping("/songList")
	public ModelAndView songList(Integer singerId,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		Singer singer = singerService.selectByPrimaryKey(singerId);
		List<Song> songList = songService.selectBySingerId(singerId);
		Users user = (Users)session.getAttribute("user");
		if(null != user){
			List<Songlist> myMusicList = songlistService.listAllByUserId(user.getUsersId());
			session.setAttribute("myMusicList", myMusicList);
		}
		session.setAttribute("singer", singer);
		session.setAttribute("songList", songList);
		mv.setViewName("/WEB-INF/jsp/songList.jsp");
		return mv;
	}
	
	//判断用户是否登录和是否为vip
	@RequestMapping(value = "/isLoginAndVip",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object isLoginAndVip(HttpServletRequest request){
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		if(null == user){
			return "0";
		}
		if(null != user.getUsersType() && user.getUsersType().equals(0)){
			return "1";
		}
		return "";
	}
	
	//歌曲单曲下载
	@RequestMapping("/songDownload")
	public String songDownload(Integer songId,String songUrl,HttpServletRequest request,HttpServletResponse response){
		String referer = request.getHeader("Referer");
		if(referer != null && referer.startsWith("http://localhost:8888/music")){//防盗链：必须是项目名路径才能下载
			InputStream in = null;
			OutputStream out = null;
			try {
				String filePath = request.getServletContext().getRealPath(songUrl);
				String fileName = songUrl.substring(songUrl.lastIndexOf("/")+1);
				fileName = new String(fileName.getBytes("utf-8"),"ISO-8859-1");
				response.setHeader("content-disposition","attachment;filename="+fileName);
				in = new FileInputStream(filePath);
				out = response.getOutputStream();
				int len = 0;
				byte[] buf = new byte[1024];
				while((len = in.read(buf)) != -1){
					out.write(buf,0,len);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				try{
					if(out != null){
						out.close();
					}
					if(in != null){
						in.close();
					}
				} catch(IOException e){
					e.printStackTrace();
				}
			}
		}else{
			return "/WEB-INF/jsp/songList.jsp";
		}
		return null;
	}
	
	//根据对应歌曲id播放歌手对应单曲播放
	@RequestMapping("/songPlayPage")
	public ModelAndView songPlayPage(Integer songId){
		ModelAndView mv = new ModelAndView();
		Song song = songService.selectByPrimaryKey(songId);
		List<Song> songList = new ArrayList<Song>();
		songList.add(song);
		mv.addObject("songList", songList);
		mv.setViewName("/WEB-INF/jsp/songPlay.jsp");
		return mv;
	}
	
	//播放歌手所有歌曲,跳到播放界面
	@RequestMapping("/songAllPlayPage")
	public String songAllPlayPage(){
		return "/WEB-INF/jsp/songPlay.jsp";
	}
	
	//显示歌曲详情
	@RequestMapping("/songDetails")
	public ModelAndView songDetails(Integer songId,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		SongDetails songDetails = songService.selectDetails(songId);
		List<UsersAndComments> commentsList = commentsService.selectBySongId(songId);
		for(UsersAndComments uAc : commentsList){
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			uAc.setStringTime(sf.format(uAc.getCommentsTime()));
		}
		//读取歌词文件，传给页面显示
		String lyricsText = "";
		String path = request.getServletContext().getRealPath("");
		try {
			BufferedReader br = 
					new BufferedReader(
							new InputStreamReader(
									new FileInputStream(path+"/"+songDetails.getSongWordsfile()),"UTF-8"));
			while(true){
				//a.读取文件中一行数据
				String str = br.readLine();
				if(str == null){
					break;
				}
				String s = str.substring(str.lastIndexOf("]")+1);
				lyricsText = lyricsText + s+"\n";
			}
			//4.关闭资源
			br.close();
			mv.addObject("lyricsText", lyricsText);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("songDetails", songDetails);
		mv.addObject("commentsList", commentsList);
		mv.setViewName("/WEB-INF/jsp/songDetails.jsp");
		
		return mv;
	}
	
	//发表评论
	@RequestMapping("/commitComments")
	public ModelAndView commitComments(String commentsText,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		SongDetails songDetails = (SongDetails)session.getAttribute("songDetails");
		Users user = (Users)session.getAttribute("user");
		if(null == user){
			mv.setViewName("/songDetails.lw?songId="+songDetails.getSongId());
			return mv;
		}
		Comments comments = new Comments();
		comments.setCommentsContent(commentsText);
		comments.setCommentsTime(new Date());
		comments.setUserId(user.getUsersId());
		comments.setSongId(songDetails.getSongId());
		commentsService.insertSelective(comments);
		mv.setViewName("/songDetails.lw?songId="+comments.getSongId());
		return mv;
	}
	
	//添加歌曲到对应的歌单
	@RequestMapping("/addSongtoMyList")
	public String addSongtoMyList(Integer songId,Integer songlistId,Integer singerId){
		List<Relevance> relevanceList = relevanceService.listAllBySonglistId(songlistId);
		//遍历，如果歌单已存在该歌曲，则无需再插入
		for(Relevance r : relevanceList){
			if(r.getSongId().equals(songId)){
				return "redirect:/songList.lw?singerId="+singerId;
			}
		}
		Relevance relevance = new Relevance();
		relevance.setSongId(songId);
		relevance.setSonglistId(songlistId);
		relevanceService.insertSelective(relevance);
		return "redirect:/songList.lw?singerId="+singerId;
	}
}
