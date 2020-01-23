package com.house.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.house.entity.HkReservationRecord;
import com.house.entity.HouseKeeper;
import com.house.entity.HouseMating;
import com.house.entity.HouseType;
import com.house.entity.Housing;
import com.house.entity.ReservationRecord;
import com.house.entity.User;
import com.house.entity.UserReservationRecord;
import com.house.service.HouseKeeperService;
import com.house.service.HouseMatingService;
import com.house.service.HouseTypeService;
import com.house.service.HousingService;
import com.house.service.ReservationRecordService;
import com.house.service.UserService;

@Controller
public class HkController {

	@Autowired
	private HouseKeeperService houseKeeperService;
	
	@Autowired
	private UserService	userService;
	
	@Autowired
	private HousingService	housingService;
	
	@Autowired
	private ReservationRecordService reservationRecordService;
	
	@Autowired
	private HouseMatingService houseMatingService;
	
	@Autowired
	private HouseTypeService houseTypeService;
	
	@RequestMapping("/hkIndex")
	public ModelAndView hkIndex(HttpSession session){
		ModelAndView mv = new ModelAndView();
		HouseKeeper houseKeeper = (HouseKeeper) session.getAttribute("houseKeeperAccount");
		List<Housing> housingList= housingService.selectByHousekeeperId(houseKeeper.getHousekeeperId());
		session.setAttribute("hHList", housingList);
		mv.setViewName("/WEB-INF/jsp/hkIndex.jsp");
		return mv;
	}
	
	@RequestMapping("/houseKeeperInformationPage")
	public String userInformationPage(){
		return "/WEB-INF/jsp/houseKeeperInformation.jsp";
	}
	
	@RequestMapping(value="/updateHouseKeeperInformation",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object updatehouseKeeperInformation(HttpServletRequest request,HttpSession session,HouseKeeper houseKeeper){
		HouseKeeper houseKeeperLogin = (HouseKeeper) session.getAttribute("houseKeeperAccount");
		
		if(null != houseKeeper.getHousekeeperPassword()){
			if(houseKeeper.getHousekeeperPassword().length() > 0){
				if(houseKeeper.getHousekeeperPassword().length()>=6 && houseKeeper.getHousekeeperPassword().length()<=16){
					
				}else{
					return "密码长度只能是6-16位";
				}
			}else{
				return "密码不能为空";
			}
		}
		
		if(null != houseKeeper.getHousekeeperName()){
			if(! "".equals(houseKeeper.getHousekeeperName())){
				String str  =  "^[(\\u4e00-\\u9fa5)]+$";
				Pattern pattern = Pattern.compile(str);
				Matcher matcher = pattern.matcher(houseKeeper.getHousekeeperName());
				boolean res = matcher.matches();
				
				if(res == true){
					if(houseKeeper.getHousekeeperName().length()>=2 && houseKeeper.getHousekeeperName().length()<=4){
						
					}else{
						return "用户名长度只能是2-4位";
					}
				}else{
					return "用户名只能是中文汉字";
				}
			}else{
				return "用户名不能为空";
			}
		}
		
		if(null != houseKeeper.getHousekeeperTelnumber()){
			if(!"".equals(houseKeeper.getHousekeeperTelnumber())){
				String str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
				Pattern pattern = Pattern.compile(str);
				Matcher matcher = pattern.matcher(houseKeeper.getHousekeeperTelnumber());
				boolean res = matcher.matches();
				
				if(res == true){
					
				}
				else{
					return "只能是长度11位且格式正确的电话号码";
				}
			}else{
				return "联系电话不能为空";
			}
		}
		
		if(null != houseKeeper.getHousekeeperAddress()){
			if(!"".equals(houseKeeper.getHousekeeperAddress())){
				String str  =  "^[(\\u4e00-\\u9fa5)]+$";
				Pattern pattern = Pattern.compile(str);
				Matcher matcher = pattern.matcher(houseKeeper.getHousekeeperAddress());
				boolean res = matcher.matches();
				
				if(res == true){
					
				}else{
					return "联系地址只能是中文汉字";
				}
			}else{
				return "联系地址不能为空";
			}
		}
		
		houseKeeper.setHousekeeperId(houseKeeperLogin.getHousekeeperId());
		houseKeeperService.updateByPrimaryKeySelective(houseKeeper);
		HouseKeeper houseKeeperAccount = houseKeeperService.selectByPrimaryKey(houseKeeperLogin.getHousekeeperId());
		session.setAttribute("houseKeeperAccount", houseKeeperAccount);
		return "";
	}
	
	@RequestMapping("/updateHouseKeeperAvatar")
	@ResponseBody
	public ModelAndView updateHouseKeeperAvatar(HttpServletRequest request,HttpSession session,MultipartFile housekeeperAvatar){
		ModelAndView mv = new ModelAndView();
		HouseKeeper houseKeeperAccount = (HouseKeeper) session.getAttribute("houseKeeperAccount");
		HouseKeeper houseKeeper = new HouseKeeper();
		String fileName = "";
		if(!housekeeperAvatar.isEmpty()){
			String path = request.getServletContext().getRealPath("img/avatar");
			fileName = housekeeperAvatar.getOriginalFilename();
			int index = fileName.lastIndexOf(".");
			String ext = fileName.substring(index+1);
			if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
				File file = new File(path,fileName);
				try {
					housekeeperAvatar.transferTo(file);
					houseKeeper.setHousekeeperId(houseKeeperAccount.getHousekeeperId());
					houseKeeper.setHousekeeperAvatar("img/avatar/"+fileName);
					houseKeeperService.updateByPrimaryKeySelective(houseKeeper);
					houseKeeper = houseKeeperService.selectByPrimaryKey(houseKeeperAccount.getHousekeeperId());
					session.setAttribute("houseKeeperAccount", houseKeeper);
				}catch (IllegalStateException
						| IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
		}
		
		mv.setViewName("redirect:houseKeeperInformationPage.fw");
		return mv;
	}
	

	
	@RequestMapping("/hkOrderRecords")
	public ModelAndView hkOrderRecords(HttpSession session){
		ModelAndView mv = new ModelAndView();
		HouseKeeper houseKeeper = (HouseKeeper) session.getAttribute("houseKeeperAccount");
		List<ReservationRecord> recordList= reservationRecordService.selectByHkId(houseKeeper.getHousekeeperId());
		List<HkReservationRecord> hRecordList = new ArrayList<HkReservationRecord>();
		
		for(ReservationRecord r : recordList){
			HkReservationRecord hkRecord = new HkReservationRecord();
			hkRecord.setReservationrecordId(r.getReservationrecordId());
			
			Housing housing = housingService.selectByPrimaryKey(r.getHousingId());
			hkRecord.setHousing(housing);
			
			User user = userService.selectByPrimaryKey(r.getUserId());
			hkRecord.setUser(user);
			
			SimpleDateFormat sf1 = new SimpleDateFormat("yyyy年MM月dd日");
			String lookHouseTime = sf1.format(r.getReservationrecordLookingtime());
			hkRecord.setLookHouseTime(lookHouseTime);
			
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			String createTime = sf2.format(r.getReservationrecordCreatetime());
			hkRecord.setRecordTime(createTime);

			hkRecord.setReservationrecordState(r.getReservationrecordState());
			hRecordList.add(hkRecord);
		}
		
		mv.addObject("hRecordList", hRecordList);
		mv.setViewName("/WEB-INF/jsp/hkOrderRecords.jsp");
		return mv;
	}
	
	@RequestMapping("/acceptOrder")
	public ModelAndView acceptOrder(Integer reservationrecordId){
		ModelAndView mv = new ModelAndView();
		ReservationRecord record = new ReservationRecord();
		record.setReservationrecordId(reservationrecordId);
		record.setReservationrecordState("预约成功");
		reservationRecordService.updateByPrimaryKeySelective(record);
		mv.setViewName("redirect:hkOrderRecords.fw");
		return mv;
	}
	
	@RequestMapping("/refuseOrder")
	public ModelAndView refuseOrder(Integer reservationrecordId){
		ModelAndView mv = new ModelAndView();
		ReservationRecord record = new ReservationRecord();
		record.setReservationrecordId(reservationrecordId);
		record.setReservationrecordState("预约失败");
		reservationRecordService.updateByPrimaryKeySelective(record);
		mv.setViewName("redirect:hkOrderRecords.fw");
		return mv;
	}
	
	@RequestMapping("/publishHousingPage")
	public String publishHousingPage(){
		return "/WEB-INF/jsp/publishHousing.jsp";
	}
	
	@RequestMapping("/publishHousing")
	public ModelAndView publishHousing(HttpServletRequest request,HttpSession session,
			Housing housing,HouseMating houseMating,
			HouseType houseType,@RequestParam MultipartFile[] fileselect){
		ModelAndView mv = new ModelAndView();
		String str = "^[0-9]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(housing.getHousingPrice());
		boolean res = matcher.matches();
		if(!"".equals(housing.getHousingTitle()) && null != housing.getHousingTitle()){

			if(!"".equals(housing.getHousingPrice()) && null != housing.getHousingPrice()){
				if(res == true){
					
					if(!"".equals(housing.getHousingArea()) && null != housing.getHousingArea()){
						matcher = pattern.matcher(housing.getHousingArea());
						res = matcher.matches();
						if(res == true){
							
							if(!"".equals(housing.getHousingAddress()) && null != housing.getHousingAddress()){
								if(!"".equals(housing.getHousingDetailsaddress()) && null != housing.getHousingDetailsaddress()){
									if(!"".equals(housing.getHousingAbout()) && null != housing.getHousingAbout()){
										String housingImage = "";
										for(MultipartFile file : fileselect){
											if(!file.isEmpty()){
									            String filename = file.getOriginalFilename();
									            String path = request.getServletContext().getRealPath("img/housing");
									            int index = filename.lastIndexOf(".");
												String ext = filename.substring(index+1);
												if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
													File fileImg = new File(path,filename);
													try {
														file.transferTo(fileImg);
														housingImage += "img/housing/"+filename+";";
														
													} catch (
															IllegalStateException
															| IOException e) {
														// TODO Auto-generated catch block
														System.out.println(e.getMessage());
													}
												}else{
													mv.addObject("msg", "上传的图片只支持jpg,png,gif格式");
													mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
													return mv;
												}
											}
										}
										if(!"".equals(housingImage)){
											housingImage = housingImage.substring(0, housingImage.lastIndexOf(';'));
										}
										housing.setHousingImage(housingImage);
										
										housing.setHousingCheckstate("0");
										housing.setHousingLeasestate("0");
										
										String[] ht = housing.getHousingHousetype().split(",");
										String type = "";
										for(int i = 0;i < ht.length;i++){
											type += ht[i];
										}
										housing.setHousingHousetype(type);
										
										HouseKeeper houseKeeper = (HouseKeeper) session.getAttribute("houseKeeperAccount");
										housing.setHousekeeperId(houseKeeper.getHousekeeperId());
										
										HouseType hType = houseTypeService.selectByHouseTypeName(houseType.getHousetypeName());
										housing.setHousetypeId(hType.getHousetypeId());
										housing.setHousingCreatetime(new Date());
										housingService.insertSelective(housing);
										
										houseMating.setHousingId(housing.getHousingId());
										houseMatingService.insertSelective(houseMating);
										
										mv.setViewName("redirect:hkIndex.fw");
									}else{
										mv.addObject("msg", "房源简介不能为空");
										mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
									}
								}else{
									mv.addObject("msg", "房源详细地址不能为空");
									mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
								}
							}else{
								mv.addObject("msg", "房源地址不能为空");
								mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
							}
						}else{
							mv.addObject("msg", "房源面积只能是数字格式");
							mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
						}
					}else{
						mv.addObject("msg", "房源面积不能为空");
						mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
					}
					
				}else{
					mv.addObject("msg", "房源价格只能是数字格式");
					mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
				}
			}else{
				mv.addObject("msg", "房源价格不能为空");
				mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
			}
		}else{
			mv.addObject("msg", "房源标题不能为空");
			mv.setViewName("/WEB-INF/jsp/publishHousing.jsp");
		}
		return mv;
	}
	
	@RequestMapping(value="/checkPriceAndArea",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkPriceAndArea(String number){
		if(!"".equals(number)){
			String str = "^[0-9]+$";
			Pattern pattern = Pattern.compile(str);
			Matcher matcher = pattern.matcher(number);
			boolean res = matcher.matches();
			if(res == true){
				return "";
			}else{
				return "只能输入数字";
			}
		}else{
			return "内容不能为空";
		}
	}

	//下架房源
	@RequestMapping("/undercarriage")
	public ModelAndView undercarriage(HttpServletRequest request,Integer housingId){
		ModelAndView mv = new ModelAndView();
		Housing housing = new Housing();
		housing.setHousingId(housingId);
		housing.setHousingLeasestate("1");
		housingService.updateByPrimaryKeySelective(housing);
		mv.setViewName("redirect:hkIndex.fw");
		return mv;
	}

	//上架房源
	@RequestMapping("/grounding")
	public ModelAndView grounding(HttpServletRequest request,Integer housingId){
		ModelAndView mv = new ModelAndView();
		Housing housing = new Housing();
		housing.setHousingId(housingId);
		housing.setHousingLeasestate("0");
		housingService.updateByPrimaryKeySelective(housing);
		mv.setViewName("redirect:hkIndex.fw");
		return mv;
	}
	
	@RequestMapping("/updateHousingPage")
	public ModelAndView updateHousingPage(HttpServletRequest request,Integer housingId){
		ModelAndView mv = new ModelAndView();
		Housing housing = housingService.selectByPrimaryKey(housingId);
		HouseType houseType = houseTypeService.selectByPrimaryKey(housing.getHousetypeId());
		HouseMating houseMating = houseMatingService.selectByHousingId(housing.getHousingId());
		mv.addObject("housing", housing);
		mv.addObject("houseType", houseType);
		mv.addObject("houseMating", houseMating);
		mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
		return mv;
	}
	
	@RequestMapping("/updateHousing")
	public ModelAndView updateHousing(HttpServletRequest request,HttpSession session,
			Housing housing,HouseMating houseMating,
			HouseType houseType,@RequestParam MultipartFile[] fileselect){
		ModelAndView mv = new ModelAndView();
		String str = "^[0-9]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(housing.getHousingPrice());
		boolean res = matcher.matches();
		if(!"".equals(housing.getHousingTitle()) && null != housing.getHousingTitle()){

			if(!"".equals(housing.getHousingPrice()) && null != housing.getHousingPrice()){
				if(res == true){
					
					if(!"".equals(housing.getHousingArea()) && null != housing.getHousingArea()){
						matcher = pattern.matcher(housing.getHousingArea());
						res = matcher.matches();
						if(res == true){
							
							if(!"".equals(housing.getHousingAddress()) && null != housing.getHousingAddress()){
								if(!"".equals(housing.getHousingDetailsaddress()) && null != housing.getHousingDetailsaddress()){
									if(!"".equals(housing.getHousingAbout()) && null != housing.getHousingAbout()){
										String housingImage = "";
										for(MultipartFile file : fileselect){
											if(!file.isEmpty()){
									            String filename = file.getOriginalFilename();
									            String path = request.getServletContext().getRealPath("img/housing");
									            int index = filename.lastIndexOf(".");
												String ext = filename.substring(index+1);
												if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
													File fileImg = new File(path,filename);
													try {
														file.transferTo(fileImg);
														housingImage += "img/housing/"+filename+";";
														
													} catch (
															IllegalStateException
															| IOException e) {
														// TODO Auto-generated catch block
														System.out.println(e.getMessage());
													}
												}else{
													mv.addObject("msg", "上传的图片只支持jpg,png,gif格式");
													mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
													return mv;
												}
											}
										}
										if(!"".equals(housingImage)){
											housingImage = housingImage.substring(0, housingImage.lastIndexOf(';'));
										}
										housing.setHousingImage(housingImage);
										
										housing.setHousingCheckstate("0");
										housing.setHousingLeasestate("0");
										
										String[] ht = housing.getHousingHousetype().split(",");
										String type = "";
										for(int i = 0;i < ht.length;i++){
											type += ht[i];
										}
										housing.setHousingHousetype(type);
										
										HouseKeeper houseKeeper = (HouseKeeper) session.getAttribute("houseKeeperAccount");
										housing.setHousekeeperId(houseKeeper.getHousekeeperId());
										
										HouseType hType = houseTypeService.selectByHouseTypeName(houseType.getHousetypeName());
										housing.setHousetypeId(hType.getHousetypeId());
										housing.setHousingCreatetime(new Date());
										housingService.updateByPrimaryKeySelective(housing);
										
										houseMating.setHousingId(housing.getHousingId());
										houseMatingService.updateByHousingId(houseMating);
										
										mv.setViewName("redirect:hkIndex.fw");
									}else{
										mv.addObject("msg", "房源简介不能为空");
										mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
									}
								}else{
									mv.addObject("msg", "房源详细地址不能为空");
									mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
								}
							}else{
								mv.addObject("msg", "房源地址不能为空");
								mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
							}
						}else{
							mv.addObject("msg", "房源面积只能是数字格式");
							mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
						}
					}else{
						mv.addObject("msg", "房源面积不能为空");
						mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
					}
					
				}else{
					mv.addObject("msg", "房源价格只能是数字格式");
					mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
				}
			}else{
				mv.addObject("msg", "房源价格不能为空");
				mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
			}
		}else{
			mv.addObject("msg", "房源标题不能为空");
			mv.setViewName("/WEB-INF/jsp/updateHousing.jsp");
		}
		return mv;
	}
}
