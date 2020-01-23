package com.house.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.house.entity.HouseKeeper;
import com.house.entity.HouseType;
import com.house.entity.Housing;
import com.house.entity.Manager;
import com.house.entity.User;
import com.house.service.HouseKeeperService;
import com.house.service.HouseTypeService;
import com.house.service.HousingService;
import com.house.service.ManagerService;
import com.house.service.UserService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.org.apache.xpath.internal.operations.Mult;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HouseKeeperService houseKeeperService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private HouseTypeService houseTypeService;
	
	@Autowired
	private HousingService housingService;
	
	@RequestMapping("/loginPage")
	public String loginPage(){
		return "/WEB-INF/jsp/login.jsp";
	}
	
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		
		List<HouseType> htList = houseTypeService.listByAll();
		request.getSession().setAttribute("htList", htList);
		
		List<Housing> housingList = housingService.listByState();
		request.getSession().setAttribute("housingList", housingList);
		
		
		mv.setViewName("/WEB-INF/jsp/index.jsp");
		return mv;
	}
	
	@RequestMapping("/userExit")
	public String userExit(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:index.fw";
	}
	
	@RequestMapping("/houseKeeperExit")
	public String houseKeeperExit(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:loginPage.fw";
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpSession session,String userAccount,
			String userPassword,String identity,String valicode){
		ModelAndView mv = new ModelAndView();
		String valicodeNum = (String) session.getAttribute("valicodeNum");
		if((!"".equals(userAccount) && userAccount != null) || (!"".equals(userPassword)&& userPassword != null)){
			if(valicodeNum.equals(valicode)){
				if("普通用户".equals(identity)){
					User user = userService.selectByAccount(userAccount);
					if(null != user && userAccount.equals(user.getUserAccount())
							&& userPassword.equals(user.getUserPassword())){
						
						request.getSession().setAttribute("userAccount", user);
						request.getSession().setAttribute("identity", identity);
						
						mv.setViewName("redirect:index.fw");
						return mv;
					}
				}else if("房管员".equals(identity)){
					HouseKeeper houseKeeper = houseKeeperService.selectByAccount(userAccount);
					if(null != houseKeeper && userAccount.equals(houseKeeper.getHousekeeperAccount())
							&& userPassword.equals(houseKeeper.getHousekeeperPassword())){
						
						request.getSession().setAttribute("houseKeeperAccount", houseKeeper);
						request.getSession().setAttribute("identity", identity);
						
						mv.setViewName("redirect:hkIndex.fw");
						return mv;
					}
				}else if("管理员".equals(identity)){
					Manager manager = managerService.selectByAccount(userAccount);
					if(null != manager && userAccount.equals(manager.getManagerAccount())
							&& userPassword.equals(manager.getManagerPassword())){
						
						request.getSession().setAttribute("managerAccount", manager);
						request.getSession().setAttribute("identity", identity);
						
						mv.setViewName("redirect:managerIndex.fw");
						return mv;
					}
				}
				mv.addObject("msg", "账号或密码错误");
				mv.setViewName("/WEB-INF/jsp/login.jsp");
			}else{
				mv.addObject("msg", "验证码错误");
				mv.setViewName("/WEB-INF/jsp/login.jsp");
			}
		}else{
			mv.addObject("msg", "账号或密码不能为空");
			mv.setViewName("/WEB-INF/jsp/login.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/valicode")
	public void valicode(HttpServletRequest request,HttpServletResponse response) throws IOException{
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
		OutputStream os = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(image);
	}
	
	@RequestMapping("/userRegisterPage")
	public String userRegisterPage(){
		return "/WEB-INF/jsp/userRegister.jsp";
	}
	
	@RequestMapping("/houseKeeperRegisterPage")
	public String houseKeeperRegisterPage(){
		return "/WEB-INF/jsp/houseKeeperRegister.jsp";
	}
	
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(HttpServletRequest request,User user,String againPassword,MultipartFile avatar){
		ModelAndView mv = new ModelAndView();
		String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(user.getUserAccount());
		boolean res = matcher.matches();
		if(user.getUserAccount().length() > 0){
			if(res == true){
				if(user.getUserAccount().length()<=16&&user.getUserAccount().length()>=2){
					if(null != userService.selectByAccount(user.getUserAccount())){
						mv.addObject("msg", "账户名已存在");
						mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
						return mv;
					}else{
						if(user.getUserPassword().length() > 0){
							if(user.getUserPassword().length()>=6 && user.getUserPassword().length()<=16){
								if(againPassword.equals(user.getUserPassword())){
									str  =  "^[(\\u4e00-\\u9fa5)]+$";
									pattern = Pattern.compile(str);
									matcher = pattern.matcher(user.getUserName());
									res = matcher.matches();
									
									if(user.getUserName().length() > 0){
										if(res == true){
											if(user.getUserName().length()>=2 && user.getUserName().length()<=4){
													str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
													pattern = Pattern.compile(str);
													matcher = pattern.matcher(user.getUserTelnumber());
													res = matcher.matches();
													if(user.getUserTelnumber().length() > 0){
														if(res == true){
															String fileName = "";
															if(!avatar.isEmpty()){
																String path = request.getServletContext().getRealPath("img/avatar");
																fileName = avatar.getOriginalFilename();
																int index = fileName.lastIndexOf(".");
																String ext = fileName.substring(index+1);
																if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
																	File file = new File(path,fileName);
																	try {
																		avatar.transferTo(file);
																		user.setUserAvatar("img/avatar/"+fileName);
																		userService.insertSelective(user);
																		mv.setViewName("redirect:loginPage.fw");
																	} catch (
																			IllegalStateException
																			| IOException e) {
																		// TODO Auto-generated catch block
																		System.out.println(e.getMessage());
																	}
																	return mv;
																}else{
																	mv.addObject("msg", "上传的图片只支持jpg,png,gif格式");
																	mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
																	return mv;
																}
															}
															if(fileName == ""){
																mv.addObject("msg", "用户头像不能为空");
																mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
																return mv;
															}
															return mv;
														}else{
															mv.addObject("msg", "联系电话只能是长度11位且格式正确的电话号码");
															mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
															return mv;
														}
													}else{
														mv.addObject("msg", "联系电话不能为空");
														mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
														return mv;
													}
												}else{
												mv.addObject("msg", "用户名长度只能是2-4位");
												mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
												return mv;
											}
										}else{
											mv.addObject("msg", "用户名只能是中文汉字");
											mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
											return mv;
										}
									}else{
										mv.addObject("msg", "用户名不能为空");
										mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
										return mv;
									}
									
									
								}else{
									mv.addObject("msg", "两次密码不一致");
									mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
									return mv;
								}
							}else{
								mv.addObject("msg", "密码长度只能是6-16位");
								mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
								return mv;
							}
						}else{
							mv.addObject("msg", "密码不能为空");
							mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
							return mv;
						}
					}
				}else{
					mv.addObject("msg", "账户名长度只能是2-16个字符");
					mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
					return mv;
				}
			}else{
				mv.addObject("msg", "格式错误，只能是字母，数字，中文");
				mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
				return mv;
			}
		}else{
			mv.addObject("msg", "账户名不能为空");
			mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
			return mv;
		}
	}
	
	@RequestMapping("/houseKeeperRegister")
	public ModelAndView houseKeeperRegister(HttpServletRequest request,HouseKeeper houseKeeper,String againPassword,MultipartFile avatar){
		ModelAndView mv = new ModelAndView();
		String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(houseKeeper.getHousekeeperAccount());
		boolean res = matcher.matches();
		if(houseKeeper.getHousekeeperAccount().length() > 0){
			if(res == true){
				if(houseKeeper.getHousekeeperAccount().length()<=16&&houseKeeper.getHousekeeperAccount().length()>=2){
					if(null != houseKeeperService.selectByAccount(houseKeeper.getHousekeeperAccount())){
						mv.addObject("msg", "账户名已存在");
						mv.setViewName("/WEB-INF/jsp/userRegister.jsp");
						return mv;
					}else{
						if(houseKeeper.getHousekeeperPassword().length() > 0){
							if(houseKeeper.getHousekeeperPassword().length()>=6 && houseKeeper.getHousekeeperPassword().length()<=16){
								if(againPassword.equals(houseKeeper.getHousekeeperPassword())){
									str  =  "^[(\\u4e00-\\u9fa5)]+$";
									pattern = Pattern.compile(str);
									matcher = pattern.matcher(houseKeeper.getHousekeeperName());
									res = matcher.matches();
									
									if(houseKeeper.getHousekeeperName().length() > 0){
										if(res == true){
											if(houseKeeper.getHousekeeperName().length()>=2 && houseKeeper.getHousekeeperName().length()<=4){
													str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
													pattern = Pattern.compile(str);
													matcher = pattern.matcher(houseKeeper.getHousekeeperTelnumber());
													res = matcher.matches();
													if(houseKeeper.getHousekeeperTelnumber().length() > 0){
														if(res == true){
															if(null != houseKeeper.getHousekeeperAddress() &&
																	!"".equals(houseKeeper.getHousekeeperAddress())){
																str = "^[(\\u4e00-\\u9fa5)]+$";
																pattern = Pattern.compile(str);
																matcher = pattern.matcher(houseKeeper.getHousekeeperAddress());
																res = matcher.matches();
																if(res == true){
																	String fileName = "";
																	if(!avatar.isEmpty()){
																		String path = request.getServletContext().getRealPath("img/avatar");
																		fileName = avatar.getOriginalFilename();
																		int index = fileName.lastIndexOf(".");
																		String ext = fileName.substring(index+1);
																		if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
																			File file = new File(path,fileName);
																			try {
																				avatar.transferTo(file);
																				houseKeeper.setHousekeeperAvatar("img/avatar/"+fileName);
																				houseKeeperService.insertSelective(houseKeeper);
																				mv.setViewName("redirect:loginPage.fw");
																			} catch (
																					IllegalStateException
																					| IOException e) {
																				// TODO Auto-generated catch block
																				System.out.println(e.getMessage());
																			}
																			return mv;
																		}else{
																			mv.addObject("msg", "上传的图片只支持jpg,png,gif格式");
																			mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
																			return mv;
																		}
																	}
																	if(fileName == ""){
																		mv.addObject("msg", "用户头像不能为空");
																		mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
																		return mv;
																	}
																	return mv;
																}else{
																	mv.addObject("msg", "联系地址只能是中文汉字");
																	mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
																	return mv;
																}
															}else{
																mv.addObject("msg", "联系地址不能为空");
																mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
																return mv;
															}
														}else{
															mv.addObject("msg", "联系电话只能是长度11位且格式正确的电话号码");
															mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
															return mv;
														}
													}else{
														mv.addObject("msg", "联系电话不能为空");
														mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
														return mv;
													}
												}else{
												mv.addObject("msg", "用户名长度只能是2-4位");
												mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
												return mv;
											}
										}else{
											mv.addObject("msg", "用户名只能是中文汉字");
											mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
											return mv;
										}
									}else{
										mv.addObject("msg", "用户名不能为空");
										mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
										return mv;
									}
									
									
								}else{
									mv.addObject("msg", "两次密码不一致");
									mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
									return mv;
								}
							}else{
								mv.addObject("msg", "密码长度只能是6-16位");
								mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
								return mv;
							}
						}else{
							mv.addObject("msg", "密码不能为空");
							mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
							return mv;
						}
					}
				}else{
					mv.addObject("msg", "账户名长度只能是2-16个字符");
					mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
					return mv;
				}
			}else{
				mv.addObject("msg", "格式错误，只能是字母，数字，中文");
				mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
				return mv;
			}
		}else{
			mv.addObject("msg", "账户名不能为空");
			mv.setViewName("/WEB-INF/jsp/houseKeeperRegister.jsp");
			return mv;
		}
	}
	
	
	@RequestMapping(value="/checkUserAccount",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkUserAccount(String userAccount){
		String str = "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(userAccount);
		boolean res = matcher.matches();
		
		if(!"".equals(userAccount)){
			if(res == true){
				if(userAccount.length()<=16&&userAccount.length()>=2){
					if(null != userService.selectByAccount(userAccount)){
						return "账户名已存在";
					}else{
						return "";
					}
				}else{
					return "账户名长度只能是2-16个字符";
				}
			}else{
				return "格式错误，只能是字母，数字，中文";
			}
		}else{
			return "账户名不能为空";
		}
	}
	
	@RequestMapping(value="/checkHkAccount",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkHkAccount(String userAccount){
		String str = "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(userAccount);
		boolean res = matcher.matches();
		
		if(!"".equals(userAccount)){
			if(res == true){
				if(userAccount.length()<=16&&userAccount.length()>=2){
					if(null != houseKeeperService.selectByAccount(userAccount)){
						return "账户名已存在";
					}else{
						return "";
					}
				}else{
					return "账户名长度只能是2-16个字符";
				}
			}else{
				return "格式错误，只能是字母，数字，中文";
			}
		}else{
			return "账户名不能为空";
		}
	}
	
	@RequestMapping(value="/checkPassword",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkPassword(String userPassword){
		if(!"".equals(userPassword)){
			if(userPassword.length()>=6 && userPassword.length()<=16){
				return "";
			}else{
				return "密码长度只能是6-16位";
			}
		}else{
			return "密码不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkAgainPassword",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAgainPassword(String againPassword,String userPassword){
		
		if(againPassword.equals(userPassword)){
			return "";
		}else{
			return "两次密码不一致";
		}
		
	}
	
	@RequestMapping(value="/checkUserName",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkUserName(String userName){
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(userName);
		boolean res = matcher.matches();
		
		if(!"".equals(userName)){
			if(res == true){
				if(userName.length()>=2 && userName.length()<=4){
					return "";
				}else{
					return "姓名长度只能是2-4位";
				}
			}else{
				return "姓名只能是中文汉字";
			}
		}else{
			return "姓名不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkContactWay",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkContactWay(String userTelnumber){
		String str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(userTelnumber);
		boolean res = matcher.matches();
		if(!"".equals(userTelnumber)){
			if(res == true){
				return "";
			}
			else{
				return "只能是长度11位且格式正确的电话号码";
			}
		}else{
			return "联系电话不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkAddress",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAddress(String address){
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(address);
		boolean res = matcher.matches();
		if(!"".equals(address)){
			if(res == true){
				return "";
			}else{
				return "联系地址只能是中文汉字";
			}
		}else{
			return "联系地址不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkAvatar",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAvatar(String avatar){
		int index = avatar.lastIndexOf(".");
		String ext = avatar.substring(index+1);
		if(!"".equals(avatar)){
			if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
				return "";
			}else{
				return "只支持jpg,png,gif格式的图片";
			}
		}else{
			return "用户头像不能为空";
		}
		
	}
	
	
	
}
