package qqmail.controller;
//和用户相关的controller在这里配置
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import code.IndustrySMS;
import qqmail.entry.User;
import qqmail.service.IUserService;

@Controller
public class UserController {
	@Autowired
    private IUserService service;
    
    @RequestMapping("/login.do")
    /**
     * 这个方法用于跳转到login.jsp页面
     * @return  一个字符串的路径
     */
    public String toLoginPage(){
    	return "/WEB-INF/jsp/login.jsp";
    }
    
    @RequestMapping("/register.do")
    /**
     * 这个方法用于跳转到register.jsp页面
     * @return  一个字符串的路径
     */
    public String toRegisterPage(){
    	return "/WEB-INF/jsp/register.jsp";
    }
    
    @RequestMapping("/fpassword.do")
    /**
     * 这个方法用于跳转到fpassword.jsp页面
     * @return  一个字符串的路径
     */
    public String toFpasswordPage(){
    	return "/WEB-INF/jsp/fpassword.jsp";
    }
    
    /**
     * 检查传递过来的account和password是否存在于数据库中，密码是否正确
     */
    @RequestMapping(value="/checkLogin.do",produces="text/html;charset=utf-8")
    @ResponseBody
    public Object checkLogin(HttpServletRequest request,String account,String password,HttpServletResponse response) throws ServletException, IOException{
    	User user = service.proving(account, password);
    	if(user == null){
    		//用户为空说明没有查询到该信息，可能是用户名和密码不正确
    		return "账号或者密码不正确!!!";
    	}else{
    		request.getSession().setAttribute("user", user);
    		return "";
    	}
    }
    
    /**
     * 发送验证码
     */
    @RequestMapping("/sendCode.do")
    @ResponseBody
    public Object sendCode(String tel){
    	int code = IndustrySMS.execute(tel);//获得验证码
    	return code+"";//将验证码发送给
    }
    
    /**
     * 注册页面跳到邮箱首页
     * @return
     */
    @RequestMapping("/registerUser.do")
    public String register(String account,String nickname,String password,String phonenum,HttpServletRequest request){
    	User user = new User(nickname,account+"@qq.com",password,phonenum);
    	service.createUser(user);
    	request.getSession().setAttribute("user", user);
    	return "/jsp/mail.jsp";
    }
    
    /**
     * 忘记密码后修改密码
     * @param account 账号
     * @param password 新密码
     * @param request  一个request请求
     * @return
     */
    @RequestMapping("/fpasswordUser.do")
    public String fpasswordUser(String account,String password,HttpServletRequest request){
    	String[] ps = password.split(",");
    	System.out.println("account:"+account+",password:"+ps[0]);
    	service.updatePass(account, ps[0]);
    	User user = service.readUserByAccount(account);
    	request.getSession().setAttribute("user", user);
    	return "/jsp/mail.jsp";
    }
}
