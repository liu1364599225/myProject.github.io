package com.house.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.house.entity.Comment;
import com.house.entity.HouseKeeper;
import com.house.entity.HouseMating;
import com.house.entity.HouseType;
import com.house.entity.Housing;
import com.house.entity.HousingText;
import com.house.entity.ReservationRecord;
import com.house.entity.User;
import com.house.entity.UserReservationRecord;
import com.house.service.CommentService;
import com.house.service.HouseKeeperService;
import com.house.service.HouseMatingService;
import com.house.service.HouseTypeService;
import com.house.service.HousingService;
import com.house.service.ReservationRecordService;
import com.house.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private HouseTypeService houseTypeService;
	
	@Autowired
	private HousingService housingService;
	
	@Autowired
	private HouseMatingService houseMatingService;
	
	@Autowired
	private HouseKeeperService houseKeeperService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ReservationRecordService reservationRecordService;
	
	//筛选功能
	@RequestMapping(value="/selectByType")
	@ResponseBody
	public Object selectByType(HttpServletRequest request,
			String housePrice,String roomType,String houseType){
		HousingText housingText = new HousingText();
		List<Housing> hList = null;
		if(!"全部".equals(houseType)){
			HouseType ht = houseTypeService.selectByHouseTypeName(houseType);
			housingText.setHousetypeId(ht.getHousetypeId());
			
			if(!"全部".equals(roomType)){
				housingText.setRoomType(roomType);
				
				if(!"全部".equals(housePrice)){
					if("500元以下".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndlessPrice(housingText);
					}else if("4000元以上".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndThanPrice(housingText);
					}else{
						String[] s = housePrice.split("元");
						String[] price = s[0].split("-");
						housingText.setHousePrice1(price[0]);
						housingText.setHousePrice2(price[1]);
						hList = housingService.listByStateAndHT(housingText);
					}
				}else{
					hList = housingService.listByStateAndHT(housingText);
				}
			}else{
				
				if(!"全部".equals(housePrice)){
					if("500元以下".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndlessPrice(housingText);
					}else if("4000元以上".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndThanPrice(housingText);
					}else{
						String[] s = housePrice.split("元");
						String[] price = s[0].split("-");
						housingText.setHousePrice1(price[0]);
						housingText.setHousePrice2(price[1]);
						hList = housingService.listByStateAndHT(housingText);
					}
				}else{
					hList = housingService.listByStateAndHT(housingText);
				}
			}
		}else{
			if(!"全部".equals(roomType)){
				housingText.setRoomType(roomType);
				
				if(!"全部".equals(housePrice)){
					if("500元以下".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndlessPrice(housingText);
					}else if("4000元以上".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndThanPrice(housingText);
					}else{
						String[] s = housePrice.split("元");
						String[] price = s[0].split("-");
						housingText.setHousePrice1(price[0]);
						housingText.setHousePrice2(price[1]);
						hList = housingService.listByStateAndHT(housingText);
					}
				}else{
					hList = housingService.listByStateAndHT(housingText);
				}
			}else{
				if(!"全部".equals(housePrice)){
					if("500元以下".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndlessPrice(housingText);
					}else if("4000元以上".equals(housePrice)){
						String[] s = housePrice.split("元");
						housingText.setHousePrice1(s[0]);
						hList = housingService.listByStateAndThanPrice(housingText);
					}else{
						String[] s = housePrice.split("元");
						String[] price = s[0].split("-");
						housingText.setHousePrice1(price[0]);
						housingText.setHousePrice2(price[1]);
						hList = housingService.listByStateAndHT(housingText);
					}
				}else{
					hList = housingService.listByStateAndHT(housingText);
				}
			}
		}
		
		return hList;
	}
	
	
	//搜索功能
	@RequestMapping(value="/search")
	@ResponseBody
	public Object search(HttpServletRequest request,String searchText){
		List<Housing> hList = housingService.searchByTitleAndAddress(searchText);
		return hList;
	}
	
	@RequestMapping("/housingPage")
	public ModelAndView housingPage(HttpServletRequest request,HttpSession session,Integer housingId){
		ModelAndView mv = new ModelAndView();
		Housing housing = housingService.selectByPrimaryKey(housingId);
		HouseMating houseMating = houseMatingService.selectByHousingId(housing.getHousingId());
		HouseKeeper houseKeeper = houseKeeperService.selectByPrimaryKey(housing.getHousekeeperId());
		
		List<Comment> commentList = commentService.selectByHousingId(housingId);
		List<Comment> cList = new ArrayList<Comment>();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String str = sf.format(housing.getHousingCreatetime());
		
		for(Comment c : commentList){
			User user = userService.selectByPrimaryKey(c.getUserId());
			c.setUser(user);
			c.setCommentTime(sf.format(c.getCommentCreatetime()));
			cList.add(c);
		}
		
		if(null != session.getAttribute("userAccount")){
			User user = (User) session.getAttribute("userAccount");
			ReservationRecord reservationRecord = reservationRecordService.selectByOrderState(user.getUserId(),housing.getHousingId());
			if(null != reservationRecord){
				mv.addObject("ordering", reservationRecord.getReservationrecordState());
			}
		}

		mv.addObject("commentList", cList);
		mv.addObject("housingCreateTime", str);
		request.getSession().setAttribute("housing", housing);
		request.getSession().setAttribute("houseMating", houseMating);
		request.getSession().setAttribute("houseKeeper", houseKeeper);
		mv.setViewName("/WEB-INF/jsp/housing.jsp");
		return mv;
	}
	
	@RequestMapping("/commitComment")
	public ModelAndView commitComment(HttpServletRequest request,String commentText,Integer userId){
		ModelAndView mv = new ModelAndView();
		Comment comment = new Comment();
		comment.setCommentText(commentText);
		comment.setUserId(userId);
		Housing housing = (Housing) request.getSession().getAttribute("housing");
		comment.setHousingId(housing.getHousingId());
		comment.setCommentCreatetime(new Date());
		commentService.insertSelective(comment);
		mv.addObject("housingId", housing.getHousingId());
		mv.setViewName("redirect:housingPage.fw");
		return mv;
	}
	
	//预约看房功能
	@RequestMapping("/orderHousing")
	public ModelAndView orderHousing(HttpServletRequest request,String lookingTime,Integer userId){
		ModelAndView mv = new ModelAndView();
		Housing housing = (Housing) request.getSession().getAttribute("housing");
		HouseKeeper houseKeeper = (HouseKeeper) request.getSession().getAttribute("houseKeeper");
		
		ReservationRecord reservationRecord = new ReservationRecord();
		reservationRecord.setHousekeeperId(houseKeeper.getHousekeeperId());
		reservationRecord.setReservationrecordCreatetime(new Date());
		reservationRecord.setReservationrecordState("正在预约");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
		try {
			Date lookingDate = sf.parse(lookingTime);
			reservationRecord.setReservationrecordLookingtime(lookingDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		ReservationRecord rRecord = reservationRecordService.selectByUserIdAndHousingId(userId,housing.getHousingId());
		if(null != rRecord){
			reservationRecord.setReservationrecordId(rRecord.getReservationrecordId());
			reservationRecordService.updateByPrimaryKeySelective(reservationRecord);
		}else{
			reservationRecord.setHousingId(housing.getHousingId());
			reservationRecord.setUserId(userId);
			reservationRecordService.insertSelective(reservationRecord);
		}
		
		mv.addObject("housingId", housing.getHousingId());
		mv.setViewName("redirect:housingPage.fw");
		return mv;
	}
	
	@RequestMapping("/userInformationPage")
	public String userInformationPage(){
		return "/WEB-INF/jsp/userInformation.jsp";
	}
	
	@RequestMapping(value="/updateUserInformation",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object updateUserInformation(HttpServletRequest request,HttpSession session,User user){
		User userLogin = (User) session.getAttribute("userAccount");
		
		if(null != user.getUserPassword()){
			if(user.getUserPassword().length() > 0){
				if(user.getUserPassword().length()>=6 && user.getUserPassword().length()<=16){
					
				}else{
					return "密码长度只能是6-16位";
				}
			}else{
				return "密码不能为空";
			}
		}
		
		if(null != user.getUserName()){
			if(! "".equals(user.getUserName())){
				String str  =  "^[(\\u4e00-\\u9fa5)]+$";
				Pattern pattern = Pattern.compile(str);
				Matcher matcher = pattern.matcher(user.getUserName());
				boolean res = matcher.matches();
				
				if(res == true){
					if(user.getUserName().length()>=2 && user.getUserName().length()<=4){
						
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
		
		if(null != user.getUserTelnumber()){
			if(!"".equals(user.getUserTelnumber())){
				String str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
				Pattern pattern = Pattern.compile(str);
				Matcher matcher = pattern.matcher(user.getUserTelnumber());
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
		
		user.setUserId(userLogin.getUserId());
		userService.updateByPrimaryKeySelective(user);
		User userAccount = userService.selectByPrimaryKey(userLogin.getUserId());
		session.setAttribute("userAccount", userAccount);
		return "";
	}
	
	@RequestMapping("/updateUserAvatar")
	@ResponseBody
	public ModelAndView updateUserAvatar(HttpServletRequest request,HttpSession session,MultipartFile userAvatar){
		ModelAndView mv = new ModelAndView();
		User userAccount = (User) session.getAttribute("userAccount");
		User user = new User();
		String fileName = "";
		if(!userAvatar.isEmpty()){
			String path = request.getServletContext().getRealPath("img/avatar");
			fileName = userAvatar.getOriginalFilename();
			int index = fileName.lastIndexOf(".");
			String ext = fileName.substring(index+1);
			if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif")){
				File file = new File(path,fileName);
				try {
					userAvatar.transferTo(file);
					user.setUserId(userAccount.getUserId());
					user.setUserAvatar("img/avatar/"+fileName);
					userService.updateByPrimaryKeySelective(user);
					user = userService.selectByPrimaryKey(user.getUserId());
					session.setAttribute("userAccount", user);
				}catch (IllegalStateException
						| IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			}
		}
		
		mv.setViewName("redirect:userInformationPage.fw");
		return mv;
	}
	
	@RequestMapping("/userOrderRecords")
	public ModelAndView userOrderRecords(HttpSession session){
		ModelAndView mv = new ModelAndView();
		User user = (User) session.getAttribute("userAccount");
		List<ReservationRecord> recordList= reservationRecordService.selectByUserId(user.getUserId());
		List<UserReservationRecord> uRecordList = new ArrayList<UserReservationRecord>();
		
		for(ReservationRecord r : recordList){
			UserReservationRecord userRecord = new UserReservationRecord();
			userRecord.setReservationrecordId(r.getReservationrecordId());
			
			Housing housing = housingService.selectByPrimaryKey(r.getHousingId());
			userRecord.setHousing(housing);
			
			HouseKeeper houseKeeper = houseKeeperService.selectByPrimaryKey(r.getHousekeeperId());
			userRecord.setHousekeeperName(houseKeeper.getHousekeeperName());
			
			SimpleDateFormat sf1 = new SimpleDateFormat("yyyy年MM月dd日");
			String lookHouseTime = sf1.format(r.getReservationrecordLookingtime());
			userRecord.setLookHouseTime(lookHouseTime);
			
			SimpleDateFormat sf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
			String createTime = sf2.format(r.getReservationrecordCreatetime());
			userRecord.setRecordTime(createTime);

			userRecord.setReservationrecordState(r.getReservationrecordState());
			
			uRecordList.add(userRecord);
		}
		
		mv.addObject("uRecordList", uRecordList);
		mv.setViewName("/WEB-INF/jsp/userOrderRecords.jsp");
		return mv;
	}
	
	@RequestMapping("/cancelOrder")
	public ModelAndView cancelOrder(Integer reservationrecordId){
		ModelAndView mv = new ModelAndView();
		ReservationRecord record = new ReservationRecord();
		record.setReservationrecordId(reservationrecordId);
		record.setReservationrecordState("已取消");
		reservationRecordService.updateByPrimaryKeySelective(record);
		mv.setViewName("redirect:userOrderRecords.fw");
		return mv;
	}
}
