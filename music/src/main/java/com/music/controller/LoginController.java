package com.music.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.music.entity.Users;
import com.music.service.CommentsService;
import com.music.service.UsersService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller
public class LoginController {
	@Autowired
	private UsersService userService;
	
	@RequestMapping("/exit.lw")
	public String exit(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		String url = request.getHeader("Referer");
		return "redirect:"+url;
	}
	
	@RequestMapping("/loginPage")
	public String loginPage(HttpServletRequest request){
		String url = request.getHeader("Referer");
		request.getSession().setAttribute("lastUrl", url);
		return "/WEB-INF/jsp/login.jsp";
	}
	/**
	 * 随机生成验证码
	 * @param response
	 * @param request
	 * @return 验证码
	 * @throws IOException 
	 */
	@RequestMapping("/valiCode")
	public void valicode(HttpServletRequest request,HttpServletResponse response){
		Random ran = new Random();
		BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
		g.fillRect(0, 0, 100, 40);
		g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
		g.setFont(new Font("",Font.BOLD,30));
		
		g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
		String number = "";
		String str = Integer.toString(ran.nextInt(10));
		g.drawString(str, 10, 30);
		number = number+str;
		
		g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
		str = Integer.toString(ran.nextInt(10));
		g.drawString(str, 35, 30);
		number = number+str;
		
		g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
		str = Integer.toString(ran.nextInt(10));
		g.drawString(str, 60, 30);
		number = number+str;
		
		g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
		str = Integer.toString(ran.nextInt(10));
		g.drawString(str, 85, 30);
		number = number+str;
		HttpSession session = request.getSession();
		session.setAttribute("valicodeNum",number);
		
		for(int i = 0;i < 10;i++){
			g.setColor(new Color(ran.nextInt(255),ran.nextInt(255),ran.nextInt(255)));
			g.drawLine(ran.nextInt(100), ran.nextInt(30), ran.nextInt(10), ran.nextInt(100));
		}
		OutputStream os;
		try {
			os = response.getOutputStream();
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
			encoder.encode(image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		String username =(String)request.getParameter("username");
		String password =(String)request.getParameter("password");
		String valicode =(String)request.getParameter("code");
		HttpSession session =request.getSession();
		String code = (String)session.getAttribute("valicodeNum");
		if(valicode.equals(code)){//校验验证码
			Users user = userService.selectByUsernameAndPassword(username, password);
			if(user != null){//判断用户是否存在
				//进入首页
				session.setAttribute("user", user);
				//登录成功跳回登录前的页面请求地址
				String lastUrl = (String)session.getAttribute("lastUrl");
				mv.setViewName("redirect:"+lastUrl);
			}else{//重新返回登录界面
				mv.addObject("str", "用户不存在！");
				mv.setViewName("/WEB-INF/jsp/login.jsp");
			}
		}else{//验证码错误，请重新输入
			mv.addObject("str", "验证码错误！");
			mv.setViewName("/WEB-INF/jsp/login.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView register(MultipartFile avatar,HttpServletRequest request,HttpServletResponse response){//注册
		ModelAndView mv = new ModelAndView();
		String username =(String)request.getParameter("username");
		String password =(String)request.getParameter("password");
		String realname =(String)request.getParameter("realname");
		String gender =(String)request.getParameter("gender");
		String valicode =(String)request.getParameter("code");
		HttpSession session =request.getSession();
		String code = (String)session.getAttribute("valicodeNum");
		if(valicode.equals(code)){//校验验证码
			Users user1 =userService.selectByUsername(username);//检验用户名是否重复
			if(user1 != null){
				mv.addObject("str", "已存在该用户！");
				mv.setViewName("/WEB-INF/jsp/login.jsp");
				return mv;
			}
			
			//头像上传
			try {
				String fileName = "";
				if(!avatar.isEmpty()){
					String path = request.getServletContext().getRealPath("/images/users");
					fileName = avatar.getOriginalFilename();
					int index = fileName.lastIndexOf(".");
					String ext = fileName.substring(index+1);
					if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
						File file = new File(path,fileName);
						avatar.transferTo(file);
						Users user =new Users();
						user.setUsersAccount(username);
						user.setUsersPassword(password);
						user.setUsersName(realname);
						user.setUsersSex(gender);
						user.setUsersAvatar("images/users/"+fileName);
						userService.insertSelective(user);
						Users newUser = userService.selectByUsernameAndPassword(username, password);
						session.setAttribute("user", newUser);
						mv.setViewName("redirect:/indexPage.lw");
					}else{

						mv.addObject("str", "图片格式只能为jpg,png,gif！");
						mv.setViewName("/WEB-INF/jsp/login.jsp");
					}
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}else{//验证码错误，请重新输入
			mv.addObject("str", "验证码错误！");
			mv.setViewName("/WEB-INF/jsp/login.jsp");
		}
		return mv;
	}
}
