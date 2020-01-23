package qqmail.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.fabric.xmlrpc.base.Data;

import qqmail.entry.MailPro;
import qqmail.entry.Status;
import qqmail.entry.User;
import qqmail.service.IDeleteService;
import qqmail.service.IInboxService;
import qqmail.util.DataDis;
import qqmail.util.DateUtil;
@Controller
public class MailDeleteController {
	@Autowired
	private IDeleteService service; 
	
	@RequestMapping("/readAll_Delete.do")
	public ModelAndView readAll_Delete(int pageNum,HttpSession session){
		ModelAndView mv = new ModelAndView();
		//-------------------跳转页面----------------------------------
		User u = (User) session.getAttribute("user");
		int user = u.getUser_id();
		List<MailPro> list8 = service.readAll_Delete_Count("true",user);//根据状态lnbox为true，send_mail_id查询
		List<MailPro> list = new ArrayList<MailPro>();
		int pageSize = 3;//页面大小(所放数据个数)
		int count = list8.size();//mail表中对应条件的数据总条数
		int start = (pageNum)*pageSize;//页面开始数据数值
		int pageCount = count%pageSize==0?count/pageSize:count/pageSize+1;//总页数
		if(pageNum < pageCount){
			mv.addObject("pageNum", pageNum+1);//向jsp传当前下一页的页面页数
			mv.addObject("start", start);
			mv.addObject("now_page", pageNum+1);
			mv.addObject("all_page", pageCount);
			list = service.readAll_Delete("true",user,start,start+pageSize);//根据状态lnbox为true，send_mail_id查询
		}else{
			mv.addObject("pageNum", 0);
			mv.addObject("now_page", 0);
			mv.addObject("all_page", 0);
			mv.addObject("msg2", "block");
			mv.addObject("msg1", "没有数据了");
			mv.addObject("msg3", "none;");
		}
		
		
		List<MailPro> today = new ArrayList<MailPro>();  //本日
		List<MailPro> one = new ArrayList<MailPro>();   //周一
		List<MailPro> two = new ArrayList<MailPro>();   //周二
		List<MailPro> three = new ArrayList<MailPro>(); //周三
		List<MailPro> four = new ArrayList<MailPro>(); //周四
		List<MailPro> five = new ArrayList<MailPro>(); //周五
		List<MailPro> six = new ArrayList<MailPro>();  //周六
		List<MailPro> seven = new ArrayList<MailPro>(); //周日
		List<MailPro> more = new ArrayList<MailPro>();  //更早
		//判断日期是否为本日、本周、本月的工具类
		DateUtil da = new DateUtil();
		for(int i = 0 ; i < list.size() ; i++){
			//----------------获取数据库中对应的时间，并且按年月日星期-------------------------------------------------------------
			//拿到数据库对应的时间
			Date data = list.get(i).getSend_time();
			//根据日期拿星期
			SimpleDateFormat sdf1 = new SimpleDateFormat("E");  
			String we = sdf1.format(data);
			int week = 0;
			if(we.equals("星期一")){
				week = 1;
			}else if(we.equals("星期二")){
				week = 2;
			}else if(we.equals("星期三")){
				week = 3;
			}else if(we.equals("星期四")){
				week = 4;
			}else if(we.equals("星期五")){
				week = 5;
			}else if(we.equals("星期六")){
				week = 6;
			}else if(we.equals("星期日")){
				week = 7;
			}
			
			System.out.println(week);
			//根据日期拿年
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
			String year = sdf2.format(data);
			//根据年拿月份
			SimpleDateFormat sdf3 = new SimpleDateFormat("MM");
			String mouth = sdf3.format(data);
			//根据年拿日
			SimpleDateFormat sdf4 = new SimpleDateFormat("dd");
			String day = sdf4.format(data);
			//日期转字符串
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = sdf.format(data);
			list.get(i).setDate(dateString);
			
			
			//----------------------设定页面点击小图标颜色---------------------------------------------
		    if(list.get(i).getAfind().equals("true")){   //改变邮箱颜色
		    	list.get(i).setAfind("darkkhaki;");
		    }else{
		    	list.get(i).setAfind("#E2A214;");
		    }
		    if(list.get(i).getBit_mail().equals("true")){  //改变星星颜色
		    	list.get(i).setBit_mail("#FAD04D;");
		    }else{
		    	list.get(i).setBit_mail("black;");
		    }
		    
		  //----------------------按时间分组-----------------------------------------------------
			long time = data.getTime();
			boolean istoday = da.isToday(time);//判断是否为本日
			boolean isweek = da.isThisWeek(time);//判断是否为本周
			boolean ismouth = da.isThisMonth(time);//判断是否为本月
			if(istoday){
				today.add(list.get(i));
			}else if(isweek){
				switch (week) {
				case 1:	one.add(list.get(i)); break;
				case 2: two.add(list.get(i)); break;
				case 3: three.add(list.get(i)); break;
				case 4: four.add(list.get(i)); break;
				case 5: five.add(list.get(i)); break;
				case 6: six.add(list.get(i)); break;
				case 7: seven.add(list.get(i)); break;
				}
			}else{
				more.add(list.get(i));
			}
		    
		    
		}
		//---------------------显示邮件时间端配置------------------------------------
		
		if(today.size() > 0){
			mv.addObject("head1", "display: block;");
			mv.addObject("today1", today.size());
		} if(one.size() > 0){
			mv.addObject("head2", "星display: block;");
			mv.addObject("one1", one.size());
		} if(two.size() > 0){
			mv.addObject("head3", "display: block;");
			mv.addObject("two1", two.size());
		} if(three.size() > 0){
			mv.addObject("head4", "display: block;");
			mv.addObject("three1", three.size());
		} if(four.size() > 0){
			mv.addObject("head5", "display: block;");
			mv.addObject("four1", four.size());
		} if(five.size() > 0){
			mv.addObject("head6", "display: block;");
			mv.addObject("five1", five.size());
		} if(six.size() > 0){
			mv.addObject("head7", "display: block;");
			mv.addObject("six1", six.size());
		} if(seven.size() > 0){
			mv.addObject("head8", "display: block;");
			mv.addObject("seven1", seven.size());
		} if(more.size() > 0){
			mv.addObject("head9", "display: block;");
			mv.addObject("more1", more.size());
		}
		mv.addObject("today", today);
		mv.addObject("one", one);
		mv.addObject("two", two);
		mv.addObject("three", three);
		mv.addObject("four", four);
		mv.addObject("five", five);
		mv.addObject("six", six);
		mv.addObject("seven", seven);
		mv.addObject("more", more);
		mv.addObject("list_size", list8.size());
		List<MailPro> list5 =  service.readAll_DeletePro("true", user);
		mv.addObject("noread_list_size", list5.size());
		System.out.println(list+"状态");
		mv.setViewName("/WEB-INF/jsp/delete.jsp");
		
		return mv;
	}
	
	
	//-------------------跳转二级页面-------------------------------
	@RequestMapping("/second6.do")
	@ResponseBody
	public ModelAndView second6(int time1,int sendId){
		ModelAndView mv = new ModelAndView();
		System.out.println(time1+"&"+sendId);
		//List<MailPro> list8 = service.readAll_Inbox_Count("true",1115241874);//查询到所以的数据
		MailPro mailPro = service.readAll_Delete_ById("true",sendId, time1);//查看对应邮件
		Date data = mailPro.getSend_time();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(data);
		mailPro.setDate(dateStr);
		mv.addObject("mailPro", mailPro);
		System.out.println("mailPro"+mailPro);
		
		mv.setViewName("/WEB-INF/jsp/second.jsp");
		return mv;
	}
	
	
	//--------------------------举报------------------------------------------
	@RequestMapping("/report6.do") //加入垃圾箱
	@ResponseBody
	public Object report6(int time,int id,HttpSession session){
		Status status = service.readBySendId(id,time);
		service.updateReport("true", status.getMail_status_id());//加入垃圾箱
		DataDis di = new DataDis();
		User u = (User) session.getAttribute("user");
		int user = u.getUser_id(); 
		List<MailPro> list1 = service.readAll_Delete("true",user,0,3);//根据状态lnbox为true，send_mail_id查询
		List list = di.getNum(list1);
		List<MailPro> list5 =  service.readAll_DeletePro("true", user);
		List<MailPro> list6 = service.readAll_Delete("true",user,0,3);
		list.add(list6.size());
		return list;
	}
	
	@RequestMapping("/delete7.do") //删除邮件状态
	@ResponseBody
	public Object delete7(int time,int id,HttpSession session){
		Status status = service.readBySendId(id,time);
		service.updateDeletes("true", status.getMail_status_id());
		DataDis di = new DataDis();
		User u = (User) session.getAttribute("user");
		int user = u.getUser_id(); 
		List<MailPro> list1 = service.readAll_Delete("true",user,0,3);//根据状态lnbox为true，send_mail_id查询
		List list = di.getNum(list1);
		List<MailPro> list5 =  service.readAll_DeletePro("true", user);
		List<MailPro> list6 = service.readAll_Delete("true",user,0,3);
		list.add(list6.size());
		return list;
	}
	
	@RequestMapping("/deleteTrue6.do")
	@ResponseBody
	public Object deleteTrue6(int time,int id,HttpSession session){ //彻底删除文件
		Status status = service.readBySendId(id,time);
		service.deleteTrue(status.getMail_status_id());
		User u = (User) session.getAttribute("user");
		int user = u.getUser_id(); 
		List<MailPro> list5 =  service.readAll_DeletePro("true", user);
		List<MailPro> list6 = service.readAll_Delete("true",user,0,3);
		List list = new ArrayList();
		list.add(list5.size());
		list.add(list6.size());
		return list;
	}
	
	@RequestMapping("/allReadFun6.do")
	@ResponseBody
	public Object allReadFun6(int time,int id,HttpSession session){ //更新为已读状态
		Status status = service.readBySendId(id,time);
		service.update("true","false",status.getMail_status_id());
		User u = (User) session.getAttribute("user");
		int user = u.getUser_id(); 
		List<MailPro> list5 =  service.readAll_DeletePro("true", user);
		List<MailPro> list6 = service.readAll_Delete("true",user,0,3);
		List list = new ArrayList();
		list.add(list5.size());
		list.add(list6.size());
		return list;
	}
	
	//-------------------------更新为未读状态--------------------------------------------------
	@RequestMapping("/noReadFun6.do")
	@ResponseBody
	public Object noReadFun6(int time,int id,HttpSession session){ //更新为已读状态
		Status status = service.readBySendId(id,time);
		service.update("false","true",status.getMail_status_id());
		User u = (User) session.getAttribute("user");
		int user = u.getUser_id(); 
		List<MailPro> list5 =  service.readAll_DeletePro("true", user);
		List<MailPro> list6 = service.readAll_Delete("true",user,0,3);
		List list = new ArrayList();
		list.add(list5.size());
		list.add(list6.size());
		return list;
	}
	
	//------------------（移动到）更新为已发送-------------------------------------
	
	@RequestMapping("/asend6.do")
	@ResponseBody
	public Object asend6(int time,int id,HttpSession session){ //更新为已读状态
		Status status = service.readBySendId(id,time);
		service.updateAsend("true", "false", status.getMail_status_id());
		DataDis di = new DataDis();
		User u = (User) session.getAttribute("user");
		int user = u.getUser_id(); 
		List<MailPro> list1 = service.readAll_Delete("true",user,0,3);//根据状态lnbox为true，send_mail_id查询
		List<MailPro> list6 = service.readAll_Delete("true",user,0,3);
		System.out.println(list1);
		List list = di.getNum(list1);
		List<MailPro> list5 =  service.readAll_DeletePro("true", user);
		list.add(list6.size());
		return list;
	}
	
	//-----------------------更新为收件箱---------------------------------------
		@RequestMapping("/inbox6.do")
		@ResponseBody
		public Object inbox6(int time,int id,HttpSession session){ //更新为已读状态
			Status status = service.readBySendId(id,time);
			service.updateInbox("true", status.getMail_status_id());
			DataDis di = new DataDis();
			User u = (User) session.getAttribute("user");
			int user = u.getUser_id();
			List<MailPro> list1 = service.readAll_Delete("true",user,0,3);//根据状态lnbox为true，send_mail_id查询
			List<MailPro> list6 = service.readAll_Delete("true",user,0,3);
			System.out.println(list1);
			List list = di.getNum(list1);
			List<MailPro> list5 =  service.readAll_DeletePro("true", user);
			list.add(list6.size());
			return list;
		}
}
