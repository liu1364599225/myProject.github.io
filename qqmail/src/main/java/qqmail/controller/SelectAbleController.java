package qqmail.controller;
//这个controller是用作对日历的操作
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import qqmail.entry.Event;
import qqmail.entry.User;
import qqmail.service.IEventService;

@Controller
public class SelectAbleController {
	 @Autowired
	 private IEventService service;
	
	 @RequestMapping("/toSelectablePage.do")
     public String toSelectablePage(){
    	 return "/WEB-INF/jsp/selectable.jsp";
     }
	 
	 //创建一个event
	 @RequestMapping(value="/createEvent.do")
	 @ResponseBody
	 public Object createEvent(String title,String start,String end,HttpServletRequest request,HttpServletResponse response) throws ParseException, UnsupportedEncodingException{
		 User user = (User) request.getSession().getAttribute("user");
		 int master = user.getUser_id();
		 //int master = 1;
		 Date stime = new SimpleDateFormat("yyyy-MM-dd").parse(start);
		 Date etime = new SimpleDateFormat("yyyy-MM-dd").parse(end);
		 Event event = new Event(title,stime,etime,master);
		 service.createEvent(event);
		 return event.getEid();
	 }
	 
	 /**
	  * 根据master用户id去查看该用户所有event通过ajax返回
	  * @return
	  * @throws ParseException
	  */
	 @RequestMapping("/readAllEventByMaster.do")
	 @ResponseBody//一定要加这个注解，说明是ajax请求
	 public Object readAllEventByMaster(HttpServletRequest request) throws ParseException{
		 User user = (User) request.getSession().getAttribute("user");
		 int master = user.getUser_id();
		 //int master = 1;//测试用
		 List<Event> list = service.readAllByMaster(master);
		 return list;
	 }
	 
	 /**
	  * 根据ajax返回的一个id来删除event
	  * @return
	  */
	 @RequestMapping("/deleteEventById.do")
	 @ResponseBody//一定要加这个注解，说明是ajax请求
	 public Object deleteEventById(String id){
		 service.deleteEvent(Integer.parseInt(id));
		 return null;
	 }
	 
	 /**
	  * 根据ajax返回的title和id来修改event
	 * @throws UnsupportedEncodingException 
	  */
	 @RequestMapping("/updateEventById.do")
	 @ResponseBody//一定要加这个注解，说明是ajax请求
	 public Object updateEventById(String id,String title,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		 //request.setCharacterEncoding("UTF-8");
		 System.out.println(title);
		 Event event = new Event();
		 event.setTitle(title);
		 event.setEid(Integer.parseInt(id));
		 service.updateEvent(event);
		 return null;
	 }
}
