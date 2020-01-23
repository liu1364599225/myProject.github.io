package qqmail.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import qqmail.entry.GroupList;
import qqmail.entry.Linkman;
import qqmail.entry.Linkmangroup;
import qqmail.entry.Mail;
import qqmail.entry.Notepaper;
import qqmail.entry.Now_linkman;
import qqmail.entry.Status;
import qqmail.entry.User;
import qqmail.service.ILinkManService;
import qqmail.service.ILinkmangroupService;
import qqmail.service.IMailService;
import qqmail.service.INotepaperService;
import qqmail.service.INow_linkmanService;
import qqmail.service.IStatusService;
import qqmail.service.IUserService;
import sun.misc.BASE64Decoder;

@Controller
public class WriterController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IMailService mailService;
	
	@Autowired
	private ILinkManService linkmanService;
	
	@Autowired
	private ILinkmangroupService linkmangroupService;
	
	@Autowired
	private INow_linkmanService now_linkmanService;
	
	@Autowired 
	private IStatusService statusService;
	
	@Autowired
	private INotepaperService notepaperService;
	
	//跳到主页面
	@RequestMapping("/mailPage.do")
	public String mailPage(HttpServletRequest request){
		User user = userService.selectById(1);
		request.getSession().setAttribute("user", user);
		return "/jsp/mail.jsp";
	}
	
	//将数据传到写信jsp页面并显示
	@RequestMapping("/writerLettersPage.do")
	public ModelAndView writerLettersPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Integer> gids = linkmanService.selectGid(user.getUser_id());
		List<GroupList> groupList = new ArrayList<GroupList>();
		for(int gid : gids){
			GroupList groups = new GroupList();
			groups.setLinkman_group(linkmangroupService.selectByGid(gid));
			List<Linkman> lms = linkmanService.selectByUidAndGid(user.getUser_id(), gid);
			List<User> users = new ArrayList<User>();
			for(Linkman l : lms){
				User u = userService.selectById(l.getLinkman_id());
				users.add(u);
			}
			groups.setUser(users);
			groupList.add(groups);
		}
		List<Now_linkman> nlList = now_linkmanService.selectTopFive(user.getUser_id());
		List<User> nlinkmanList = new ArrayList<User>();
		for(Now_linkman nlinkman : nlList){
			User u = userService.selectById(nlinkman.getLinkman_id());
			nlinkmanList.add(u);
		}
		
		List<Notepaper> noteList = notepaperService.listByAll();
		int count = noteList.size();	//数据库数据总条数
		int pageSize = 7;				//页面显示数据条数
		int pageNum = 1;				//当前是第几页
		int pageCount = count%pageSize == 0?count/pageSize:count/pageSize+1;	//总页数
		List<Notepaper> pageList = notepaperService.listByOnePage((pageNum-1)*pageSize, pageSize);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("pageList", pageList);
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("nlinkmanList", nlinkmanList);
		session.setAttribute("groupList", groupList);
		mv.setViewName("/WEB-INF/jsp/writer/writerLetters.jsp");
		return mv;
	}
	
	//通过ajax根据jsp页面传出的页码值查出信纸下一页的数据
	@RequestMapping(value="/nextlistOnePageData.do")
	@ResponseBody
	public Object nextlistOnePageData(String pageNum,HttpServletRequest request){
		HttpSession session = request.getSession();
		int pageSize = (Integer) session.getAttribute("pageSize");
		int start = (Integer.parseInt(pageNum))*pageSize;
		List<Notepaper> pageList = notepaperService.listByOnePage(start, pageSize);
		return pageList;
	}
	
	//通过ajax根据jsp页面传出的页码值查出信纸上一页的数据
	@RequestMapping(value="/lastlistOnePageData.do")
	@ResponseBody
	public Object lastlistOnePageData(String pageNum,HttpServletRequest request){
		HttpSession session = request.getSession();
		int pageSize = (Integer) session.getAttribute("pageSize");
		int num = Integer.parseInt(pageNum);
		int start = (num - 2)*pageSize;
		List<Notepaper> pageList = notepaperService.listByOnePage(start, pageSize);
		return pageList;
	}
	
	
	//ajax判断收件人邮箱号是否存在
	@RequestMapping(value="/checkAddresseeMN.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAddresseeMN(String inputVal){
		String[] str = inputVal.split(";");
		for(int i = 0;i < str.length;i++){
			if(!"".equals(str[i])){
				int startIndex = str[i].indexOf("<");
				int endIndex = str[i].indexOf(">");
				String subStr = str[i].substring(startIndex+1,endIndex);
				User user = userService.selectByUser_account(subStr);
				if(null == user){
					return subStr;
				}
			}
		}
		return "";
	}

	//处理发送邮件功能和校验
	@RequestMapping("/sendMail.do")
	public ModelAndView sendMail(Mail mail,String mailNumber,String notepaperId,String style,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		session.setAttribute("style", style);
		if(!"".equals(notepaperId) && null != notepaperId){
			mail.setNotepaper_id(Integer.parseInt(notepaperId));
		}
		if(!("".equals(mailNumber)) && null != mailNumber){
			Status status = new Status();
			status.setInbox("true");
			status.setAsend("true");
			statusService.insertReturnId(status);
			mail.setStatus_id(status.getMail_status_id());
			mail.setSend_mail_id(u.getUser_id());
			String[] mailMNs = mailNumber.split(";");
			for(int i = 0;i < mailMNs.length;i++){
				if(!"".equals(mailMNs[i])){
					int startIndex =mailMNs[i].indexOf("<");
					int endIndex = mailMNs[i].indexOf(">");
					String subStr = mailMNs[i].substring(startIndex+1,endIndex);
					User user = userService.selectByUser_account(subStr);
					//如果对应邮箱号的用户存在就生成对应的邮件表数据
					if(null != user){
						mail.setAccept_mail_id(user.getUser_id());
						if(null == mail.getMotive() || "".equals(mail.getMotive())){
							mail.setMotive("(无主题)");
						}
						mailService.insert(mail);
						//显示当前用户下所有的联系人
						List<Now_linkman> nlList = now_linkmanService.listByUidAll(u.getUser_id());
						Now_linkman now_linkman = new Now_linkman();
						now_linkman.setUser_id(u.getUser_id());
						now_linkman.setLinkman_id(user.getUser_id());
						
						for(Now_linkman n : nlList){
							if(user.getUser_id() == n.getLinkman_id()){
								now_linkmanService.deleteByLid(n.getLinkman_id());
								break;
							}
						}

						//如果联系人超过或等于五个则删除日期靠后的数据
						nlList = now_linkmanService.listByUidAll(u.getUser_id());
						while(nlList.size() >= 5){
							Now_linkman nl = nlList.get(nlList.size() - 1);
							now_linkmanService.delete(nl.getId());
							nlList = now_linkmanService.listByUidAll(u.getUser_id());
						}
						
						//如果数据小于5个，则直接插入数据
						if(nlList.size() < 5){
							now_linkmanService.insert(now_linkman);
						}
						mv.setViewName("redirect:/sendSuccessPage.do");
					}
				}
			}
		}else{
			mv.addObject("message1", "收件人地址不能为空");
			mv.setViewName("/WEB-INF/jsp/writer/writerLetters.jsp");
		}
		
		
		return mv;
	}
	
	//清空当前用户的最近联系人
	@RequestMapping("/deleteNowlinkman.do")
	public ModelAndView deleteNowlinkman(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		now_linkmanService.deleteByUid(user.getUser_id());
		mv.setViewName("redirect:/writerLettersPage.do");
		return mv;
	}
	
	//清空新窗口写信页面中当前用户的最近联系人
	@RequestMapping("/deleteNewNowlinkman.do")
	public ModelAndView deleteNewNowlinkman(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		now_linkmanService.deleteByUid(user.getUser_id());
		mv.setViewName("redirect:/newWriterLettersPage.do");
		return mv;
	}
	
	//存草稿箱
	@RequestMapping(value="/saveDraft.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object saveDraft(Mail mail,String mailNumber,String notepaperId,HttpServletRequest request){
		User u = (User) request.getSession().getAttribute("user");
		mail.setSend_mail_id(u.getUser_id());
		Status status = new Status();
		status.setDraft("true");
		statusService.insertReturnId(status);
		mail.setStatus_id(status.getMail_status_id());
		if(!"".equals(notepaperId) && null != notepaperId){
			mail.setNotepaper_id(Integer.parseInt(notepaperId));
		}
		if(null == mail.getMotive() && "".equals(mail.getMotive())){
			mail.setMotive("(无主题)");
		}
		mailService.insert(mail);
		
		return "邮件成功保存到草稿箱";
	}
	
	//新增信纸功能
	@RequestMapping("/fileUp.do")
	public ModelAndView fileUp(MultipartFile newNotepaperImg,String style,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		if(!newNotepaperImg.isEmpty()){
			String path = request.getServletContext().getRealPath("/img/notepaperImg");
			String fileName = newNotepaperImg.getOriginalFilename();
			int index = fileName.lastIndexOf(".");
			String ext = fileName.substring(index+1);
			if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
				File file = new File(path,fileName);
				Notepaper notepaper = new Notepaper();
					try {
						newNotepaperImg.transferTo(file);
						notepaper.setNotepaper_img("/img/notepaperImg/"+fileName);
						notepaperService.insert(notepaper);
						session.setAttribute("successMessage", "信纸新增成功");
						session.removeAttribute("fileMessage1");
						session.removeAttribute("fileMessage2");
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
			}else{
				session.removeAttribute("successMessage");
				session.setAttribute("fileMessage1", "图片格式不正确");
				session.setAttribute("fileMessage2", "");
			}
		}
		if("old".equals(style)){
			mv.setViewName("redirect:/redirectToWriterLettersPage.do");
		}else if("new".equals(style)){
			mv.setViewName("redirect:/redirectToNewWriterLettersPage.do");
		}
		return mv;
	}
	
	//上传完信纸重定向回写信页面并传递提示信息
	@RequestMapping("/redirectToWriterLettersPage.do")
	public ModelAndView redirectToWriteLettersPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Integer> gids = linkmanService.selectGid(user.getUser_id());
		List<GroupList> groupList = new ArrayList<GroupList>();
		for(int gid : gids){
			GroupList groups = new GroupList();
			groups.setLinkman_group(linkmangroupService.selectByGid(gid));
			List<Linkman> lms = linkmanService.selectByUidAndGid(user.getUser_id(), gid);
			List<User> users = new ArrayList<User>();
			for(Linkman l : lms){
				User u = userService.selectById(l.getLinkman_id());
				users.add(u);
			}
			groups.setUser(users);
			groupList.add(groups);
		}
		List<Now_linkman> nlList = now_linkmanService.selectTopFive(user.getUser_id());
		List<User> nlinkmanList = new ArrayList<User>();
		for(Now_linkman nlinkman : nlList){
			User u = userService.selectById(nlinkman.getLinkman_id());
			nlinkmanList.add(u);
		}
		
		List<Notepaper> noteList = notepaperService.listByAll();
		int count = noteList.size();	//数据库数据总条数
		int pageSize = 7;				//页面显示数据条数
		int pageNum = 1;				//当前是第几页
		int pageCount = count%pageSize == 0?count/pageSize:count/pageSize+1;	//总页数
		List<Notepaper> pageList = notepaperService.listByOnePage((pageNum-1)*pageSize, pageSize);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("pageList", pageList);
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("nlinkmanList", nlinkmanList);
		session.setAttribute("groupList", groupList);
		
		String success = (String) session.getAttribute("successMessage");
		String message1 = (String) session.getAttribute("fileMessage1");
		String message2 = (String) session.getAttribute("fileMessage2");
		mv.addObject("success", success);
		mv.addObject("message1", message1);
		mv.addObject("message2", message2);
		mv.setViewName("/WEB-INF/jsp/writer/writerLetters.jsp");
		return mv;
	}
	
	//上传完信纸重定向回新窗口写信页面并传递提示信息
	@RequestMapping("/redirectToNewWriterLettersPage.do")
	public ModelAndView redirectToNewWriteLettersPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Integer> gids = linkmanService.selectGid(user.getUser_id());
		List<GroupList> groupList = new ArrayList<GroupList>();
		for(int gid : gids){
			GroupList groups = new GroupList();
			groups.setLinkman_group(linkmangroupService.selectByGid(gid));
			List<Linkman> lms = linkmanService.selectByUidAndGid(user.getUser_id(), gid);
			List<User> users = new ArrayList<User>();
			for(Linkman l : lms){
				User u = userService.selectById(l.getLinkman_id());
				users.add(u);
			}
			groups.setUser(users);
			groupList.add(groups);
		}
		List<Now_linkman> nlList = now_linkmanService.selectTopFive(user.getUser_id());
		List<User> nlinkmanList = new ArrayList<User>();
		for(Now_linkman nlinkman : nlList){
			User u = userService.selectById(nlinkman.getLinkman_id());
			nlinkmanList.add(u);
		}
		
		List<Notepaper> noteList = notepaperService.listByAll();
		int count = noteList.size();	//数据库数据总条数
		int pageSize = 7;				//页面显示数据条数
		int pageNum = 1;				//当前是第几页
		int pageCount = count%pageSize == 0?count/pageSize:count/pageSize+1;	//总页数
		List<Notepaper> pageList = notepaperService.listByOnePage((pageNum-1)*pageSize, pageSize);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("pageList", pageList);
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("nlinkmanList", nlinkmanList);
		session.setAttribute("groupList", groupList);
		
		String success = (String) session.getAttribute("successMessage");
		String message1 = (String) session.getAttribute("fileMessage1");
		String message2 = (String) session.getAttribute("fileMessage2");
		mv.addObject("success", success);
		mv.addObject("message1", message1);
		mv.addObject("message2", message2);
		mv.setViewName("/WEB-INF/jsp/writer/newWriterLetters.jsp");
		return mv;
	}
	
	//搜索框模糊查询功能
	@RequestMapping(value="/selectLike.do")
	@ResponseBody
	public Object selectLike(String inputVal,HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<User> userList = userService.likeSelect(user.getUser_id(), inputVal);
		return userList;
	}
	
	
	//跳转到普通邮件发送成功页面
	@RequestMapping("/sendSuccessPage.do")
	public ModelAndView sendSuccessPage(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/jsp/writer/sendSuccess.jsp");
		return mv;
	}
	
	//跳到新窗口写普通邮件jsp页面
	@RequestMapping("/newWriterLettersPage.do")
	public String newWriterLettersPage(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Integer> gids = linkmanService.selectGid(user.getUser_id());
		List<GroupList> groupList = new ArrayList<GroupList>();
		for(int gid : gids){
			GroupList groups = new GroupList();
			groups.setLinkman_group(linkmangroupService.selectByGid(gid));
			List<Linkman> lms = linkmanService.selectByUidAndGid(user.getUser_id(), gid);
			List<User> users = new ArrayList<User>();
			for(Linkman l : lms){
				User u = userService.selectById(l.getLinkman_id());
				users.add(u);
			}
			groups.setUser(users);
			groupList.add(groups);
		}
		List<Now_linkman> nlList = now_linkmanService.selectTopFive(user.getUser_id());
		List<User> nlinkmanList = new ArrayList<User>();
		for(Now_linkman nlinkman : nlList){
			User u = userService.selectById(nlinkman.getLinkman_id());
			nlinkmanList.add(u);
		}
	
		List<Notepaper> noteList = notepaperService.listByAll();
		int count = noteList.size();	//数据库数据总条数
		int pageSize = 7;				//页面显示数据条数
		int pageNum = 1;				//当前是第几页
		int pageCount = count%pageSize == 0?count/pageSize:count/pageSize+1;	//总页数
		List<Notepaper> pageList = notepaperService.listByOnePage((pageNum-1)*pageSize, pageSize);
		session.setAttribute("pageCount", pageCount);
		session.setAttribute("pageNum", pageNum);
		session.setAttribute("pageList", pageList);
		session.setAttribute("pageSize", pageSize);
		session.setAttribute("nlinkmanList", nlinkmanList);
		session.setAttribute("groupList", groupList);
		return "/WEB-INF/jsp/writer/newWriterLetters.jsp";
	}
	
	//跳转到预览普通邮件页面
	@RequestMapping("/previewWLPage.do")
	public ModelAndView previewWLPage(Mail mail,String notepaperId,String mailNumber){
		ModelAndView mv = new ModelAndView();
		if(!"".equals(notepaperId) && null != notepaperId){
			Notepaper notepaper = notepaperService.selectById(Integer.parseInt(notepaperId));
			mv.addObject("notepaper", notepaper);
		}
		mv.addObject("mail", mail);
		mv.addObject("mailNumber", mailNumber);
		mv.setViewName("/WEB-INF/jsp/writer/previewWL.jsp");
		return mv;
	}
	

	//将数据传到写群邮件jsp页面并显示
	@RequestMapping("/groupMailPage.do")
	public ModelAndView groupMailPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Integer> gidList = linkmanService.selectGid(user.getUser_id());
		List<Linkmangroup> lmgList = new ArrayList<Linkmangroup>();
		for(Integer i : gidList){
			Linkmangroup lmg = linkmangroupService.selectByGid(i);
			lmgList.add(lmg);
		}
		session.setAttribute("lmgList", lmgList);
		mv.setViewName("/WEB-INF/jsp/writer/groupMail.jsp");
		return mv;
	}
	
	//处理发送群邮件功能
	@RequestMapping("/sendGroupMail.do")
	public ModelAndView sendGroupMail(Mail mail,String mailNumber,String style,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		session.setAttribute("style", style);
		
		Status status = new Status();
		status.setGroup_mail("true");
		
		statusService.insertReturnId(status);
		
		mail.setSend_mail_id(user.getUser_id());
		mail.setStatus_id(status.getMail_status_id());
		if(null == mail.getMotive() || "".equals(mail.getMotive())){
			mail.setMotive("(无主题)");
		}
		//查询出通讯组名对应的当前用户的组id
		int gid = linkmangroupService.selectGidByUid(user.getUser_id(), mailNumber);
		List<Linkman> linkmanList = linkmanService.selectByUidAndGid(user.getUser_id(), gid);
		for(Linkman lm : linkmanList){
			mail.setAccept_mail_id(lm.getLinkman_id());
			mailService.insert(mail);
		}
		session.setAttribute("groupName", mailNumber);
		mv.setViewName("redirect:/sendGroupSuccessPage.do");
		return mv;
	}
	
	//跳到群邮件发送成功提示页面
	@RequestMapping("/sendGroupSuccessPage.do")
	public ModelAndView sendGroupSuccessPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String groupName = (String) session.getAttribute("groupName");
		mv.addObject("groupName", groupName);
		mv.setViewName("/WEB-INF/jsp/writer/sendGroupSuccess.jsp");
		return mv;
	}
	
	//跳到新窗口写群邮件jsp页面
	@RequestMapping("/newGroupMailPage.do")
	public String newGroupMailPage(){
		return "/WEB-INF/jsp/writer/newGroupMail.jsp";
	}
	
	//跳转到写明信片页面
	@RequestMapping("/postcardPage.do")
	public ModelAndView postcardPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Integer> gids = linkmanService.selectGid(user.getUser_id());
		List<GroupList> groupList = new ArrayList<GroupList>();
		for(int gid : gids){
			GroupList groups = new GroupList();
			groups.setLinkman_group(linkmangroupService.selectByGid(gid));
			List<Linkman> lms = linkmanService.selectByUidAndGid(user.getUser_id(), gid);
			List<User> users = new ArrayList<User>();
			for(Linkman l : lms){
				User u = userService.selectById(l.getLinkman_id());
				users.add(u);
			}
			groups.setUser(users);
			groupList.add(groups);
		}
		List<Now_linkman> nlList = now_linkmanService.selectTopFive(user.getUser_id());
		List<User> nlinkmanList = new ArrayList<User>();
		for(Now_linkman nlinkman : nlList){
			User u = userService.selectById(nlinkman.getLinkman_id());
			nlinkmanList.add(u);
		}
		
		//显示通讯组
		List<Integer> gidList = linkmanService.selectGid(user.getUser_id());
		List<Linkmangroup> lmgList = new ArrayList<Linkmangroup>();
		for(Integer i : gidList){
			Linkmangroup lmg = linkmangroupService.selectByGid(i);
			lmgList.add(lmg);
		}
		
		session.setAttribute("nlinkmanList", nlinkmanList);
		session.setAttribute("groupList", groupList);
		session.setAttribute("lmgList", lmgList);
		
		mv.setViewName("/WEB-INF/jsp/writer/postcard.jsp");
		return mv;
	}
	
	
	//通过ajax将画出来的图片上传到本地服务器
	@RequestMapping(value="/imgUp.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object imgUp(String imageDataUrl,HttpServletRequest request){
		BASE64Decoder decoder = new BASE64Decoder();    
		byte[] b;
		try {
			b = decoder.decodeBuffer(imageDataUrl);    
			ByteArrayInputStream bais = new ByteArrayInputStream(b);
			BufferedImage bi1 = ImageIO.read(bais);
			Date now = new Date();
			String path = request.getServletContext().getRealPath("/img/postcardImg");
			File w2 = new File(path+"/test"+now.getTime()+".png");
			ImageIO.write(bi1, "png", w2);
			return "/qqmail/img/postcardImg/"+w2.getName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return "";
	}
	
	//处理群发明信片邮件功能和校验
	@RequestMapping("/sendPostcardGroupMail.do")
	public ModelAndView sendPostcardGroupMail(Mail mail,String mailNumber,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		Status status = new Status();
		status.setGroup_mail("true");
		
		statusService.insertReturnId(status);
		
		mail.setSend_mail_id(user.getUser_id());
		mail.setStatus_id(status.getMail_status_id());
		if(null == mail.getMotive() || "".equals(mail.getMotive())){
			mail.setMotive(user.getNickname()+"寄来的明信片");
		}
		//查询出通讯组名对应的当前用户的组id
		int gid = linkmangroupService.selectGidByUid(user.getUser_id(), mailNumber);
		List<Linkman> linkmanList = linkmanService.selectByUidAndGid(user.getUser_id(), gid);
		for(Linkman lm : linkmanList){
			mail.setAccept_mail_id(lm.getLinkman_id());
			mailService.insert(mail);
		}
		session.setAttribute("groupName", mailNumber);
		mv.setViewName("redirect:/sendPostcardGroupSuccessPage.do");
		return mv;
	}
	
	//跳到群发明信片发送成功提示页面
	@RequestMapping("/sendPostcardGroupSuccessPage.do")
	public ModelAndView sendPostcardGroupSuccessPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String groupName = (String) session.getAttribute("groupName");
		mv.addObject("groupName", groupName);
		mv.setViewName("/WEB-INF/jsp/writer/sendPostcardGroupSuccessPage.jsp");
		return mv;
	}
	
	//处理发送明信片邮件功能和校验
	@RequestMapping("/sendPostcardMail.do")
	public ModelAndView sendPostcardMail(Mail mail,String mailNumber,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		if(!("".equals(mailNumber)) && null != mailNumber){
			Status status = new Status();
			status.setInbox("true");
			status.setAsend("true");
			statusService.insertReturnId(status);
			mail.setStatus_id(status.getMail_status_id());
			mail.setSend_mail_id(u.getUser_id());
			String[] mailMNs = mailNumber.split(";");
			for(int i = 0;i < mailMNs.length;i++){
				if(!"".equals(mailMNs[i])){
					int startIndex =mailMNs[i].indexOf("<");
					int endIndex = mailMNs[i].indexOf(">");
					String subStr = mailMNs[i].substring(startIndex+1,endIndex);
					User user = userService.selectByUser_account(subStr);
					//如果对应邮箱号的用户存在就生成对应的邮件表数据
					if(null != user){
						mail.setAccept_mail_id(user.getUser_id());
						mail.setMotive(u.getNickname()+"寄来的明信片");
						mailService.insert(mail);
						//显示当前用户下所有的联系人
						List<Now_linkman> nlList = now_linkmanService.listByUidAll(u.getUser_id());
						Now_linkman now_linkman = new Now_linkman();
						now_linkman.setUser_id(u.getUser_id());
						now_linkman.setLinkman_id(user.getUser_id());
						
						for(Now_linkman n : nlList){
							if(user.getUser_id() == n.getLinkman_id()){
								now_linkmanService.deleteByLid(n.getLinkman_id());
								break;
							}
						}

						//如果联系人超过或等于五个则删除日期靠后的数据
						nlList = now_linkmanService.listByUidAll(u.getUser_id());
						while(nlList.size() >= 5){
							Now_linkman nl = nlList.get(nlList.size() - 1);
							now_linkmanService.delete(nl.getId());
							nlList = now_linkmanService.listByUidAll(u.getUser_id());
						}
						
						//如果数据小于5个，则直接插入数据
						if(nlList.size() < 5){
							now_linkmanService.insert(now_linkman);
						}
						mv.setViewName("redirect:/sendPostcardSuccess.do");
					}
				}
			}
		}else{
			mv.addObject("message1", "收件人地址不能为空");
			mv.setViewName("/WEB-INF/jsp/writer/postcard.jsp");
		}
		
		return mv;
	}
	
	
	//跳到发送明信片成功页面
	@RequestMapping("/sendPostcardSuccess.do")
	public String sendPostcardSuccess(){
		return "/WEB-INF/jsp/writer/sendPostcardSuccess.jsp";
	}
	
	//清空当前用户的最近联系人
	@RequestMapping("/deletePostCardNowlinkman.do")
	public ModelAndView deletePostCardNowlinkman(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		now_linkmanService.deleteByUid(user.getUser_id());
		mv.setViewName("redirect:/postcardPage.do");
		return mv;
	}
	
	//跳到邮箱首页jsp页面
	@RequestMapping("/rightPage.do")
	public String rightPage(){
		return "/jsp/right.jsp";
	}
	
	
	
	//跳到添加联系人jsp页面
	@RequestMapping("/addLinkManPage.do")
	public ModelAndView addLinkManPage(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<Linkmangroup> groupList = linkmangroupService.selectGroupByUid(user.getUser_id());
		mv.addObject("groupList", groupList);
		mv.setViewName("/WEB-INF/jsp/writer/addLinkMan.jsp");
		return mv;
	}
	
	//ajax检查邮箱号是否存在
	@RequestMapping(value="/checkAddresseeMN1.do",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAddresseeMN1(String userAccount){
		User user = userService.selectByUser_account(userAccount);
		if(null == user){
			return "该邮箱地址不存在";
		}
		return "";
	}
	
	//添加联系人功能
	@RequestMapping("/saveLinkMan.do")
	public ModelAndView saveLinkMan(Linkman linkman,String user_account,String nickname,String hiredate,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		User u = userService.selectByUser_account(user_account);
		if(null != u){
			linkman.setLinkman_id(u.getUser_id());
			List<Linkman> linkList = linkmanService.selectByLidAndGid(linkman.getLinkman_id(), linkman.getGroup_id());
			if(linkList.size() != 0){
				mv.setViewName("/addLinkManPage.do");
				mv.addObject("prompt", "此通讯录已有该联系人");
				return mv;
			}
		}
		linkman.setUser_id(user.getUser_id());
		Date birthday = new Date();
		if(!"".equals(hiredate) && null != hiredate){
			try {
				birthday = new SimpleDateFormat("yyyy-MM-dd").parse(hiredate);
				linkman.setBirthday(birthday);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		}
		linkmanService.insert(linkman);
		mv.setViewName("/toLinkManPage.do");
		return mv;
	}
	
}
