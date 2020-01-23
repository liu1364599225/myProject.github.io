package qqmail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import qqmail.entry.GroupNameInfo;
import qqmail.entry.LinkManInfo;
import qqmail.entry.Linkmangroup;
import qqmail.entry.User;
import qqmail.service.ILinkManService;

@Controller
public class LinkManController {
	@Autowired
    private ILinkManService service;
	/**
	 * 跳转到通讯录联系人界面
	 * @return
	 */
	@RequestMapping("/toLinkManPage.do")
	public ModelAndView toLinkManPage(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		int userId = user.getUser_id();
		//int userId = 1;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/jsp/linkman.jsp");
		List<LinkManInfo> list = service.readAllLinkManByUserId(userId);
		List<GroupNameInfo> listGroup = service.readAllGroupByUserId(userId);
		//System.out.println(listGroup.toString());
		mv.addObject("list", list);
		mv.addObject("listGroup", listGroup);
		return mv;
	}
	
	@RequestMapping("/readAllByGroupName.do")
	@ResponseBody
	public Object readAllByGroupName(String groupName,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");
		int userId = user.getUser_id();
		//int userId = 1;
		List<LinkManInfo> list;
		if("全部".equals(groupName)){
			list = service.readAllLinkManByUserId(userId);
		}else{
			groupName = groupName.substring(0, groupName.indexOf("("));
			list = service.readAllLinkManByGroupName(groupName, userId);
		}
		return list;
	}
	
	@RequestMapping("/updateGroupInfo.do")
	@ResponseBody
	public Object updateGroupInfo(String groupName,String info,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		Linkmangroup group = service.returnaGroupIdByName(groupName);//根据组名查找该名字是否存在
		if(group == null){
			//这就是说明组名在通讯录组表中不存在就创建一个
			group = new Linkmangroup();
			group.setGroup_name(groupName);
			service.saveGroupName(group);//创建一个新的分组并且返回一个groupId
		}
		User user = (User) request.getSession().getAttribute("user");//得到开始从登录注册忘记密码进入页面时的user
	    int userId = user.getUser_id();
		//int userId = 1;
		String[] infos = info.split("&");//加入新分组的各个账号用&分隔符分开
		for(int i=0;i<infos.length;i++){//用循环的方式来改变每个联系人的分组
			service.updataGroupName(userId, infos[i], group.getGroup_id());
		}
        return 111;//这里返回的是一个无意义的数字只是要这个进入ajax的success方法
	}
	
	/**
	 * 从联系人表中删除一条数据
	 * @param account  返回的联系人账号字符串    联系人一&联系人二     的格式
	 */
	@RequestMapping("/deleteLinkMan.do")
	@ResponseBody
	public Object deleteLinkMan(String account,HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("user");//得到开始从登录注册忘记密码进入页面时的user
		int userId = user.getUser_id();//拿到该用户的id  
		String[] accounts = account.split("&");
		for(int i=0;i<accounts.length;i++){
			service.deleteByAccount(accounts[i],userId);//删除数据
		}
		return 111;//这里返回的是一个无意义的数字只是要这个进入ajax的success方法
	}
}
