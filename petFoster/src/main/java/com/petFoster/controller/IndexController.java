package com.petFoster.controller;

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

import com.petFoster.domain.FosterFamily;
import com.petFoster.domain.FosterUser;
import com.petFoster.domain.Information;
import com.petFoster.domain.Order;
import com.petFoster.domain.Pet;
import com.petFoster.domain.PetShop;
import com.petFoster.service.FosterFamilyService;
import com.petFoster.service.FosterUserService;
import com.petFoster.service.InformationService;
import com.petFoster.service.ManagerService;
import com.petFoster.service.OrderService;
import com.petFoster.service.PetService;
import com.petFoster.service.PetShopService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@Controller
public class IndexController {
	@Autowired
	private PetService petService;
	
	@Autowired
	private FosterUserService fosterUserService;
	
	@Autowired
	private FosterFamilyService fosterFamilyService;
	
	@Autowired
	private PetShopService petShopService;
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private InformationService informationService;
	
	
	@RequestMapping("/loginPage.pet")
	public String loginPage(){
		return "/WEB-INF/jsp/login.jsp";
	}
	
	@RequestMapping("/login.pet")
	public ModelAndView login(String accountName,String password,String identity,
			String valicode,HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String valicodeNum = (String) session.getAttribute("valicodeNum");
		if(accountName != ""){
			if(password != ""){
				if(valicode.equals(valicodeNum)){
					if(identity.equals("寄养用户")){
						if(null != fosterUserService.listByAccount(accountName) && password.equals(fosterUserService.listByAccount(accountName).getFuPassword())){
							if(fosterUserService.listByAccount(accountName).getFuRequeststatus().equals("已通过")){
								mv.addObject("msg", "");
								mv.addObject("fosterUser",fosterUserService.listByAccount(accountName));
								mv.addObject("ffList",fosterFamilyService.listByRequestStatus("已通过"));
								mv.addObject("psList",petShopService.listByRequestStatus("已通过"));
								FosterUser user = fosterUserService.listByAccount(accountName);
								List<Long> idList = orderService.listByRefuse(user.getFuId());
								System.out.println(idList.size());
								if(idList.size() != 0){
									String msg = "您的宠物:";
									for(Long id : idList){
										Pet pet = petService.selectByPrimaryKey(id);
										msg += pet.getpPetname()+",";
									}
									msg += "有被寄养地取消了预约的订单";
									mv.addObject("msg", msg);
								}
								mv.setViewName("/WEB-INF/jsp/fuIndex.jsp");
								return mv;
							}else{
								mv.addObject("msg", "该账户还在等待管理员审核，请耐心等待");
								mv.setViewName("/WEB-INF/jsp/login.jsp");
								return mv;
							}
						}else{
							mv.addObject("msg", "账户名或密码错误");
							mv.setViewName("/WEB-INF/jsp/login.jsp");
							return mv;
						}
					}else if(identity.equals("寄养家庭")){
						if(null != fosterFamilyService.listByAccount(accountName) && password.equals(fosterFamilyService.listByAccount(accountName).getfPassword())){
							if(fosterFamilyService.listByAccount(accountName).getfRequeststatus().equals("已通过")){
								FosterFamily family = fosterFamilyService.listByAccount(accountName);
								if(null != family.getfFeedbackinformation() && "" != family.getfFeedbackinformation()){
									if(family.getfFeedbackinformation().split("#").length > 1){
										String systemInformation = family.getfFeedbackinformation().split("#")[1];
										mv.addObject("systemInformation",systemInformation);
									}
								}
								Information information = informationService.selectByFosterplaceidAndFosterstyle(family.getfId(), "寄养家庭");
								mv.addObject("information", information);
								mv.addObject("msg", "");
								mv.addObject("oFosterstyle","寄养家庭");
								mv.addObject("fosterFamily", family);
								List<Order> idList = orderService.listByOneRequestStatus("正在预约","寄养家庭",family.getfId());
								if(idList.size() != 0){
									int times = 0;
									for(Order order : idList){
										++ times;
									}
									String msg = "您有"+times+"笔新的预约订单";
									mv.addObject("msg", msg);
								}
								mv.setViewName("/WEB-INF/jsp/ffInformation.jsp");
								return mv;
							}else{
								mv.addObject("msg", "该账户还在等待管理员审核，请耐心等待");
								mv.setViewName("/WEB-INF/jsp/login.jsp");
								return mv;
							}
						}else{
							mv.addObject("msg", "账户名或密码错误或注册申请未通过");
							mv.setViewName("/WEB-INF/jsp/login.jsp");
							return mv;
						}
					}else if(identity.equals("宠物店")){
						if(null != petShopService.listByAccount(accountName) && password.equals(petShopService.listByAccount(accountName).getPsPassword())){
							if(petShopService.listByAccount(accountName).getPsRequeststatus().equals("已通过")){
								PetShop petShop = petShopService.listByAccount(accountName);
								if(null != petShop.getPsFeedbackinformation() && "" != petShop.getPsFeedbackinformation()){
									if(petShop.getPsFeedbackinformation().split("#").length > 1){
										String systemInformation = petShop.getPsFeedbackinformation().split("#")[1];
										mv.addObject("systemInformation",systemInformation);
									}
								}
								Information information = informationService.selectByFosterplaceidAndFosterstyle(petShop.getPsId(), "宠物店");
								mv.addObject("information",information);
								mv.addObject("msg", "");
								mv.addObject("oFosterstyle","宠物店");
								mv.addObject("petShop", petShop);
								List<Order> idList = orderService.listByOneRequestStatus("正在预约","宠物店",petShop.getPsId());
								if(idList.size() != 0){
									int times = 0;
									for(Order order : idList){
										++ times;
									}
									String msg = "您有"+times+"笔新的预约订单";
									mv.addObject("msg", msg);
								}
								mv.setViewName("/WEB-INF/jsp/psInformation.jsp");
								return mv;
							}else{
								mv.addObject("msg", "该账户还在等待管理员审核，请耐心等待");
								mv.setViewName("/WEB-INF/jsp/login.jsp");
								return mv;
							}
						}else{
							mv.addObject("msg", "账户名或密码错误或注册申请未通过");
							mv.setViewName("/WEB-INF/jsp/login.jsp");
							return mv;
						}
					}else if(identity.equals("管理员")){
						if(null != managerService.listByAccount(accountName) && password.equals(managerService.listByAccount(accountName).getmPassword())){
							mv.addObject("msg", "");
							mv.addObject("ffList",fosterFamilyService.listByRequestStatus("待审核"));
							mv.addObject("psList",petShopService.listByRequestStatus("待审核"));
							mv.addObject("accountName", accountName);
							List<Order> idList = orderService.listBy1RequestStatus("已挂起");
							if(idList.size() != 0){
								int times = 0;
								for(Order order : idList){
									++ times;
								}
								String msg = "有"+times+"笔挂起的订单待处理";
								mv.addObject("msg", msg);
							}
							mv.setViewName("/WEB-INF/jsp/manager.jsp");
							return mv;
						}else{
							mv.addObject("msg", "账户名或密码错误");
							mv.setViewName("/WEB-INF/jsp/login.jsp");
							return mv;
						}
					}
				}else{
					mv.addObject("msg", "验证码错误");
					mv.setViewName("/WEB-INF/jsp/login.jsp");
					return mv;
				}
			}else{
				mv.addObject("msg", "密码不能为空");
				mv.setViewName("/WEB-INF/jsp/login.jsp");
				return mv;
			}
		}else{
			mv.addObject("msg", "账户名不能为空");
			mv.setViewName("/WEB-INF/jsp/login.jsp");
			return mv;
		}
		return mv;
	}
	
	@RequestMapping("/valicode.pet")
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
	
	
//寄养用户注册
	
	@RequestMapping("/fuRegisterPage.pet")
	public String fuRegisterPage(){
		return "/WEB-INF/jsp/fuRegister.jsp";
	}
	
	@RequestMapping(value="/fuRegister.pet",produces="text/html;charset=utf-8")
	public ModelAndView fuRegister(FosterUser user,String againPassword,Pet pet){
		ModelAndView mv = new ModelAndView();
		String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(user.getFuAccountname());
		boolean res = matcher.matches();
		if(user.getFuAccountname() != ""){
			if(res == true){
				if(user.getFuAccountname().length()<=16&&user.getFuAccountname().length()>=2){
					if(null != fosterUserService.listByAccount(user.getFuAccountname())){
						mv.addObject("msg", "账户名已存在");
						mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
						return mv;
					}else{
						if(user.getFuPassword() != ""){
							if(user.getFuPassword().length()>=6 && user.getFuPassword().length()<=16){
								if(againPassword.equals(user.getFuPassword())){
									str  =  "^[(\\u4e00-\\u9fa5)]+$";
									pattern = Pattern.compile(str);
									matcher = pattern.matcher(user.getFuFosterusername());
									res = matcher.matches();
									
									if(user.getFuFosterusername() != ""){
										if(res == true){
											if(user.getFuFosterusername().length()>=2 && user.getFuFosterusername().length()<=4){
												str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
												pattern = Pattern.compile(str);
												matcher = pattern.matcher(user.getFuContactway());
												res = matcher.matches();
												if(user.getFuContactway() != ""){
													if(res == true){
														if(user.getFuAddress() != ""){
															str  =  "^[(\\u4e00-\\u9fa5)]+$";
															pattern = Pattern.compile(str);
															matcher = pattern.matcher(pet.getpPetname());
															res = matcher.matches();
															
															if(pet.getpPetname() != ""){
																if(res == true){
																	if(pet.getpPetname().length()>=2 && pet.getpPetname().length()<=4){
																		user.setFuRequeststatus("已通过");
																		fosterUserService.insertSelective(user);
																		pet.setFuId(user.getFuId());
																		petService.insertSelective(pet);
																		mv.setViewName("/WEB-INF/jsp/prompt1.jsp");
																		return mv;
																	}else{
																		mv.addObject("msg", "宠物昵称长度只能是2-4位");
																		mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
																		return mv;
																	}
																}else{
																	mv.addObject("msg", "宠物昵称只能是中文汉字");
																	mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
																	return mv;
																}
															}else{
																mv.addObject("msg", "宠物昵称不能为空");
																mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
																return mv;
															}
														}else{
															mv.addObject("msg", "联系地址不能为空");
															mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
															return mv;
														}
													}
													else{
														mv.addObject("msg", "联系方式只能是长度11位且格式正确的电话号码");
														mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
														return mv;
													}
												}else{
													mv.addObject("msg", "联系方式不能为空");
													mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
													return mv;
												}
											}else{
												mv.addObject("msg", "姓名长度只能是2-4位");
												mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
												return mv;
											}
										}else{
											mv.addObject("msg", "姓名只能是中文汉字");
											mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
											return mv;
										}
									}else{
										mv.addObject("msg", "姓名不能为空");
										mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
										return mv;
									}
								}else{
									mv.addObject("msg", "两次密码不一致");
									mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
									return mv;
								}
							}else{
								mv.addObject("msg", "密码长度只能是6-16位");
								mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
								return mv;
							}
						}else{
							mv.addObject("msg", "密码不能为空");
							mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
							return mv;
						}
					}
				}else{
					mv.addObject("msg", "账户名长度只能是2-16个字符");
					mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
					return mv;
				}
			}else{
				mv.addObject("msg", "账户名格式错误，只能是字母，数字，中文");
				mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
				return mv;
			}
		}else{
			mv.addObject("msg", "账户名不能为空");
			mv.setViewName("/WEB-INF/jsp/fuRegister.jsp");
			return mv;
		}
	}
	
	@RequestMapping(value="/checkAccountName.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAccountName(String accountName){
		String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(accountName);
		boolean res = matcher.matches();
		
		if(accountName != ""){
			if(res == true){
				if(accountName.length()<=16&&accountName.length()>=2){
					if(null != fosterUserService.listByAccount(accountName)){
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
	
	@RequestMapping(value="/checkPassword.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkPassword(String password){
		if(password != ""){
			if(password.length()>=6 && password.length()<=16){
				return "";
			}else{
				return "密码长度只能是6-16位";
			}
		}else{
			return "密码不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkAgainPassword.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAgainPassword(String againPassword,String password){
		
		if(againPassword.equals(password)){
			return "";
		}else{
			return "两次密码不一致";
		}
		
	}
	
	@RequestMapping(value="/checkUserName.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkUserName(String userName){
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(userName);
		boolean res = matcher.matches();
		
		if(userName != ""){
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
	
	@RequestMapping(value="/checkContactWay.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkContactWay(String contactWay){
		String str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(contactWay);
		boolean res = matcher.matches();
		if(contactWay != ""){
			if(res == true){
				return "";
			}
			else{
				return "只能是长度11位且格式正确的电话号码";
			}
		}else{
			return "联系方式不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkAddress.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAddress(String address){
		if(address != ""){
			return "";
		}else{
			return "联系地址不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkPetName.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkPetName(String petName){
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(petName);
		boolean res = matcher.matches();
		
		if(petName != ""){
			if(res == true){
				if(petName.length()>=2 && petName.length()<=4){
					return "";
				}else{
					return "宠物昵称长度只能是2-4位";
				}
			}else{
				return "宠物昵称只能是中文汉字";
			}
		}else{
			return "宠物昵称不能为空";
		}
	}
	
	
	
//寄养家庭注册
	
	@RequestMapping("/ffRegisterPage.pet")
	public String ffRegisterPage(){
		return "/WEB-INF/jsp/ffRegister.jsp";
	}
	
	@RequestMapping(value="/ffRegister.pet",produces="text/html;charset=utf-8")
	public ModelAndView ffRegister(FosterFamily family,Information information,String againPassword,MultipartFile familyPhoto,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(family.getfAccountname());
		boolean res = matcher.matches();
		if(family.getfAccountname().length() > 0){
			if(res == true){
				if(family.getfAccountname().length()<=16&&family.getfAccountname().length()>=2){
					if(null != fosterFamilyService.listByAccount(family.getfAccountname())){
						mv.addObject("msg", "账户名已存在");
						mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
						return mv;
					}else{
						if(family.getfPassword().length() > 0){
							if(family.getfPassword().length()>=6 && family.getfPassword().length()<=16){
								if(againPassword.equals(family.getfPassword())){
									str  =  "^[(\\u4e00-\\u9fa5)]+$";
									pattern = Pattern.compile(str);
									matcher = pattern.matcher(family.getfAdoptername());
									res = matcher.matches();
									
									if(family.getfAdoptername().length() > 0){
										if(res == true){
											if(family.getfAdoptername().length()>=2 && family.getfAdoptername().length()<=4){
												if(family.getfFosterexperience().length() < 100){
													str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
													pattern = Pattern.compile(str);
													matcher = pattern.matcher(family.getfContactway());
													res = matcher.matches();
													if(family.getfContactway().length() > 0){
														if(res == true){
															if(family.getfAddress().length() > 0){
																String fileName = "";
																if(!familyPhoto.isEmpty()){
																	String path = request.getServletContext().getRealPath("/familyImg");
																	fileName = familyPhoto.getOriginalFilename();
																	int index = fileName.lastIndexOf(".");
																	String ext = fileName.substring(index+1);
																	if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
																		File file = new File(path,fileName);
																		familyPhoto.transferTo(file);
																		mv.addObject("path",path+"/"+fileName);
																		if(family.getfTyperange() != null && family.getfTyperange().length() > 0){
																			family.setfFamilyphoto("/familyImg/"+fileName);
																			family.setfRequeststatus("待审核");
																			fosterFamilyService.insertSelective(family);
																			information.setiFosterplaceid(family.getfId());
																			String iNeedtoknow = "1、寄养入住时间：14:00；2、寄养结束时间：次日14:00；3、切勿隐瞒宠物的性格和生活习惯；4、准时接送宠物入住和回家";
																			information.setiNeedtoknow(iNeedtoknow);
																			information.setiFosterstyle("寄养家庭");
																			String iCshotline = "400-8700-815";
																			information.setiCshotline(iCshotline);
																			System.out.println(information);
																			informationService.insertSelective(information);
																			mv.setViewName("/WEB-INF/jsp/prompt.jsp");
																			return mv;
																		}else{
																			mv.addObject("msg", "宠物类型范围不能为空");
																			mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
																			return mv;
																		}
																	}else{
																		mv.addObject("msg", "上传的图片只支持jpg,png,gif格式");
																		mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
																		return mv;
																	}
																}
																if(fileName == ""){
																	mv.addObject("msg", "家庭图片不能为空");
																	mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
																	return mv;
																}
																return mv;
																
															}else{
																mv.addObject("msg", "联系地址不能为空");
																mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
																return mv;
															}
														}else{
															mv.addObject("msg", "只能是长度11位且格式正确的电话号码");
															mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
															return mv;
														}
													}else{
														mv.addObject("msg", "联系方式不能为空");
														mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
														return mv;
													}
												}else{
													mv.addObject("msg", "字数不能超过100字");
													mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
													return mv;
												}
											}else{
												mv.addObject("msg", "姓名长度只能是2-4位");
												mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
												return mv;
											}
										}else{
											mv.addObject("msg", "姓名只能是中文汉字");
											mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
											return mv;
										}
									}else{
										mv.addObject("msg", "姓名不能为空");
										mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
										return mv;
									}
								}else{
									mv.addObject("msg", "两次密码不一致");
									mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
									return mv;
								}
							}else{
								mv.addObject("msg", "密码长度只能是6-16位");
								mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
								return mv;
							}
						}else{
							mv.addObject("msg", "密码不能为空");
							mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
							return mv;
						}
					}
				}else{
					mv.addObject("msg", "账户名长度只能是2-16个字符");
					mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
					return mv;
				}
			}else{
				mv.addObject("msg", "账户名格式错误，只能是字母，数字，中文");
				mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
				return mv;
			}
		}else{
			mv.addObject("msg", "账户名不能为空");
			mv.setViewName("/WEB-INF/jsp/ffRegister.jsp");
			return mv;
		}
		
	}
	
	@RequestMapping(value="/checkAccountName1.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAccountName1(String accountName){
		String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(accountName);
		boolean res = matcher.matches();
		
		if(accountName != ""){
			if(res == true){
				if(accountName.length()<=16&&accountName.length()>=2){
					if(null != fosterFamilyService.listByAccount(accountName)){
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
	
	@RequestMapping(value="/checkPassword1.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkPassword1(String password){
		if(password != ""){
			if(password.length()>=6 && password.length()<=16){
				return "";
			}else{
				return "密码长度只能是6-16位";
			}
		}else{
			return "密码不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkAgainPassword1.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAgainPassword1(String againPassword,String password){
		
		if(againPassword.equals(password)){
			return "";
		}else{
			return "两次密码不一致";
		}
		
	}
	
	@RequestMapping(value="/checkFosterName.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFosterName(String fosterName){
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(fosterName);
		boolean res = matcher.matches();
		
		if(fosterName != ""){
			if(res == true){
				if(fosterName.length()>=2 && fosterName.length()<=4){
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
	
	
	@RequestMapping(value="/checkfosterExperience.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkfosterExperience(String fosterExperience){
		if(fosterExperience != ""){
			if(fosterExperience.length() < 100){
				return "";
			}else{
				return "字数不能超过100字";
			}
		}else{
			return "";
		}
	}
	
	
	@RequestMapping(value="/checkContactWay1.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkContactWay1(String contactWay){
		String str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(contactWay);
		boolean res = matcher.matches();
		if(contactWay != ""){
			if(res == true){
				return "";
			}
			else{
				return "只能是长度11位且格式正确的电话号码";
			}
		}else{
			return "联系方式不能为空";
		}
		
	}
	
	@RequestMapping(value="/checkAddress1.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkAddress1(String address){
		if(address != ""){
			return "";
		}else{
			return "联系地址不能为空";
		}
		
	}
	
	
	@RequestMapping(value="/checkFosterFamilyPhoto.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFosterFamilyPhoto(String fosterFamilyPhoto){
		int index = fosterFamilyPhoto.lastIndexOf(".");
		String ext = fosterFamilyPhoto.substring(index+1);
		if(fosterFamilyPhoto != ""){
			if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
				return "";
			}else{
				return "只支持jpg,png,gif格式的图片";
			}
		}else{
			return "家庭图片不能为空";
		}
		
	}
	
	
//宠物店注册
	
		@RequestMapping("/psRegisterPage.pet")
		public String psRegisterPage(){
			return "/WEB-INF/jsp/psRegister.jsp";
		}
		
		
		@RequestMapping(value="/psRegister.pet",produces="text/html;charset=utf-8")
		public ModelAndView psRegister(PetShop petShop,Information information,String againPassword,MultipartFile petShopPhoto,HttpServletRequest request) throws IllegalStateException, IOException{
			ModelAndView mv = new ModelAndView();
			String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
			Pattern pattern = Pattern.compile(str);
			Matcher matcher = pattern.matcher(petShop.getPsAccountname());
			boolean res = matcher.matches();
			if(petShop.getPsAccountname().length() > 0){
				if(res == true){
					if(petShop.getPsAccountname().length()<=16&&petShop.getPsAccountname().length()>=2){
						if(null != petShopService.listByAccount(petShop.getPsAccountname())){
							mv.addObject("msg", "账户名已存在");
							mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
							return mv;
						}else{
							if(petShop.getPsPassword().length() > 0){
								if(petShop.getPsPassword().length()>=6 && petShop.getPsPassword().length()<=16){
									if(againPassword.equals(petShop.getPsPassword())){
										str  =  "^[(\\u4e00-\\u9fa5)]+$";
										pattern = Pattern.compile(str);
										matcher = pattern.matcher(petShop.getPsPetshopname());
										res = matcher.matches();
										
										if(petShop.getPsPetshopname().length() > 0){
											if(res == true){
												if(petShop.getPsPetshopname().length()>=2 && petShop.getPsPetshopname().length()<=10){
														str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
														pattern = Pattern.compile(str);
														matcher = pattern.matcher(petShop.getPsContactway());
														res = matcher.matches();
														if(petShop.getPsContactway().length() > 0){
															if(res == true){
																if(petShop.getPsAddress().length() > 0){
																	String fileName = "";
																	if(!petShopPhoto.isEmpty()){
																		String path = request.getServletContext().getRealPath("/petShopImg");
																		fileName = petShopPhoto.getOriginalFilename();
																		int index = fileName.lastIndexOf(".");
																		String ext = fileName.substring(index+1);
																		if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
																			File file = new File(path,fileName);
																			petShopPhoto.transferTo(file);
																			mv.addObject("path",path+"/"+fileName);
																			if(petShop.getPsTyperange() != null && petShop.getPsTyperange().length() > 0){
																				petShop.setPsPetshopphoto("/petShopImg/"+fileName);
																				petShop.setPsRequeststatus("待审核");
																				petShopService.insertSelective(petShop);
																				information.setiFosterplaceid(petShop.getPsId());
																				String iNeedtoknow = "1、寄养入住时间：14:00；2、寄养结束时间：次日14:00；3、切勿隐瞒宠物的性格和生活习惯；4、准时接送宠物入住和回家";
																				information.setiNeedtoknow(iNeedtoknow);
																				information.setiFosterstyle("宠物店");
																				String iCshotline = "400-8700-815";
																				information.setiCshotline(iCshotline);
																				informationService.insertSelective(information);
																				mv.setViewName("/WEB-INF/jsp/prompt.jsp");
																				return mv;
																			}else{
																				mv.addObject("msg", "宠物类型范围不能为空");
																				mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
																				return mv;
																			}
																		}else{
																			mv.addObject("msg", "上传的图片只支持jpg,png,gif格式");
																			mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
																			return mv;
																		}
																	}
																	if(fileName == ""){
																		mv.addObject("msg", "宠物店图片不能为空");
																		mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
																		return mv;
																	}
																	return mv;
																	
																}else{
																	mv.addObject("msg", "联系地址不能为空");
																	mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
																	return mv;
																}
															}else{
																mv.addObject("msg", "联系方式只能是长度11位且格式正确的电话号码");
																mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
																return mv;
															}
														}else{
															mv.addObject("msg", "联系方式不能为空");
															mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
															return mv;
														}
													}else{
													mv.addObject("msg", "宠物店名长度只能是2-10位");
													mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
													return mv;
												}
											}else{
												mv.addObject("msg", "宠物店名只能是中文汉字");
												mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
												return mv;
											}
										}else{
											mv.addObject("msg", "宠物店名不能为空");
											mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
											return mv;
										}
										
										
									}else{
										mv.addObject("msg", "两次密码不一致");
										mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
										return mv;
									}
								}else{
									mv.addObject("msg", "密码长度只能是6-16位");
									mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
									return mv;
								}
							}else{
								mv.addObject("msg", "密码不能为空");
								mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
								return mv;
							}
						}
					}else{
						mv.addObject("msg", "账户名长度只能是2-16个字符");
						mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
						return mv;
					}
				}else{
					mv.addObject("msg", "格式错误，只能是字母，数字，中文");
					mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
					return mv;
				}
			}else{
				mv.addObject("msg", "账户名不能为空");
				mv.setViewName("/WEB-INF/jsp/psRegister.jsp");
				return mv;
			}
		}
		
		
		@RequestMapping(value="/checkAccountName2.pet",produces="text/html;charset=utf-8")
		@ResponseBody
		public Object checkAccountName2(String accountName){
			String str  =  "^[a-zA-Z0-9\u4e00-\u9fa5]+$";
			Pattern pattern = Pattern.compile(str);
			Matcher matcher = pattern.matcher(accountName);
			boolean res = matcher.matches();
			
			if(accountName != ""){
				if(res == true){
					if(accountName.length()<=16&&accountName.length()>=2){
						if(null != petShopService.listByAccount(accountName)){
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
		
		@RequestMapping(value="/checkPassword2.pet",produces="text/html;charset=utf-8")
		@ResponseBody
		public Object checkPassword2(String password){
			if(password != ""){
				if(password.length()>=6 && password.length()<=16){
					return "";
				}else{
					return "密码长度只能是6-16位";
				}
			}else{
				return "密码不能为空";
			}
			
		}
		
		@RequestMapping(value="/checkAgainPassword2.pet",produces="text/html;charset=utf-8")
		@ResponseBody
		public Object checkAgainPassword2(String againPassword,String password){
			
			if(againPassword.equals(password)){
				return "";
			}else{
				return "两次密码不一致";
			}
			
		}
		
		@RequestMapping(value="/checkPetshopName.pet",produces="text/html;charset=utf-8")
		@ResponseBody
		public Object checkPetshopName(String petshopName){
			String str  =  "^[(\\u4e00-\\u9fa5)]+$";
			Pattern pattern = Pattern.compile(str);
			Matcher matcher = pattern.matcher(petshopName);
			boolean res = matcher.matches();
			
			if(petshopName != ""){
				if(res == true){
					if(petshopName.length()>=2 && petshopName.length()<=10){
						return "";
					}else{
						return "宠物店名长度只能是2-10位";
					}
				}else{
					return "宠物店名只能是中文汉字";
				}
			}else{
				return "宠物店名不能为空";
			}
			
		}
		
		
		@RequestMapping(value="/checkContactWay2.pet",produces="text/html;charset=utf-8")
		@ResponseBody
		public Object checkContactWay2(String contactWay){
			String str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
			Pattern pattern = Pattern.compile(str);
			Matcher matcher = pattern.matcher(contactWay);
			boolean res = matcher.matches();
			if(contactWay != ""){
				if(res == true){
					return "";
				}
				else{
					return "只能是长度11位且格式正确的电话号码";
				}
			}else{
				return "联系方式不能为空";
			}
			
		}
		
		@RequestMapping(value="/checkAddress2.pet",produces="text/html;charset=utf-8")
		@ResponseBody
		public Object checkAddress2(String address){
			if(address != ""){
				return "";
			}else{
				return "联系地址不能为空";
			}
			
		}
		
		
		@RequestMapping(value="/checkPetShopPhoto.pet",produces="text/html;charset=utf-8")
		@ResponseBody
		public Object checkPetShopPhoto(String petShopPhoto){
			int index = petShopPhoto.lastIndexOf(".");
			String ext = petShopPhoto.substring(index+1);
			if(petShopPhoto != ""){
				if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
					return "";
				}else{
					return "只支持jpg,png,gif格式的图片";
				}
			}else{
				return "宠物店图片不能为空";
			}
			
		}
		
}
