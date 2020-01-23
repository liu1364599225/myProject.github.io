package com.petFoster.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.petFoster.domain.FosterFamily;
import com.petFoster.domain.FosterUser;
import com.petFoster.domain.Hospital;
import com.petFoster.domain.Information;
import com.petFoster.domain.MyOrder;
import com.petFoster.domain.Order;
import com.petFoster.domain.Pet;
import com.petFoster.domain.PetShop;
import com.petFoster.service.FosterFamilyService;
import com.petFoster.service.FosterUserService;
import com.petFoster.service.HospitalService;
import com.petFoster.service.InformationService;
import com.petFoster.service.ManagerService;
import com.petFoster.service.OrderService;
import com.petFoster.service.PetService;
import com.petFoster.service.PetShopService;

@Controller
public class InformationController {

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
	private HospitalService hospitalService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private InformationService informationService;
	
	@RequestMapping("/addHospital.pet")
	public ModelAndView addHospital(String accountName,MultipartFile hospitalPhoto,
			Hospital hospital,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		if(!hospitalPhoto.isEmpty()){
			String path = request.getServletContext().getRealPath("/hospitalImg");
			String fileName = hospitalPhoto.getOriginalFilename();
			File file = new File(path,fileName);
			hospitalPhoto.transferTo(file);
			mv.addObject("path",path+"/"+fileName);
			hospital.sethHospitalphoto("/hospitalImg/"+fileName);
		}
		hospitalService.insertSelective(hospital);
		mv.addObject("accountName", accountName);
		mv.setViewName("/hospitalUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/addHospitalPage.pet")
	public ModelAndView addHospitalPage(String accountName){
		ModelAndView mv = new ModelAndView();
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/addhospitalPage.jsp");
		return mv;
	}
	
	@RequestMapping("/deleteHospital.pet")
	public ModelAndView deleteHospital(String accountName,Long hId){
		ModelAndView mv = new ModelAndView();
		hospitalService.deleteByPrimaryKey(hId);
		mv.addObject("accountName", accountName);
		mv.setViewName("/hospitalUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/updateHospital.pet")
	public ModelAndView updateHospital(Hospital hospital,MultipartFile hospitalPhoto,
				String accountName,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		if(!hospitalPhoto.isEmpty()){
			String path = request.getServletContext().getRealPath("/hospitalImg");
			String fileName = hospitalPhoto.getOriginalFilename();
			File file = new File(path,fileName);
			hospitalPhoto.transferTo(file);
			mv.addObject("path",path+"/"+fileName);
			hospital.sethHospitalphoto("/hospitalImg/"+fileName);
		}
		hospitalService.updateByPrimaryKeySelective(hospital);
		mv.addObject("accountName", accountName);
		mv.setViewName("/hospitalUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/hospitalUpdatePage.pet")
	public ModelAndView hospitalUpdatePage(String accountName,Long hId){
		ModelAndView mv = new ModelAndView();
		Hospital hospital = hospitalService.selectByPrimaryKey(hId);
		mv.addObject("accountName", accountName);
		mv.addObject("hospital", hospital);
		mv.addObject("hId", hId);
		mv.setViewName("/WEB-INF/jsp/hospitalUpdatePage.jsp");
		return mv;
	}
	
	@RequestMapping("/hospitalUpdate.pet")
	public ModelAndView hospitalUpdate(String accountName){
		ModelAndView mv = new ModelAndView();
		List<Hospital> hospitalList = hospitalService.listByAll();
		mv.addObject("hospitalList", hospitalList);
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/hospitalUpdate.jsp");
		return mv;
	}
	
	@RequestMapping("/PsfeedbackInformation.pet")
	public ModelAndView PsfeedbackInformation(String accountName,Long psId,String systemInformation){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = petShopService.selectByPrimaryKey(psId);
		if(null != petShop.getPsFeedbackinformation() && "" != petShop.getPsFeedbackinformation()){
			if(petShop.getPsFeedbackinformation().split("#").length > 0){
				String userInformation = petShop.getPsFeedbackinformation().split("#")[0];
				petShop.setPsFeedbackinformation(userInformation+"#"+systemInformation);
			}else{
				petShop.setPsFeedbackinformation("#"+systemInformation);
			}
		}else{
			petShop.setPsFeedbackinformation("#"+systemInformation);
		}
		petShopService.updateByPrimaryKeySelective(petShop);
		mv.addObject("accountName", accountName);
		mv.addObject("psId", psId);
		mv.setViewName("/psUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/PsfeedbackInformationPage.pet")
	public ModelAndView PsfeedbackInformationPage(String accountName,Long psId){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = petShopService.selectByPrimaryKey(psId);
		if(null != petShop.getPsFeedbackinformation() && "" != petShop.getPsFeedbackinformation()){
			if(petShop.getPsFeedbackinformation().split("#").length > 0){
				String fuInformation = petShop.getPsFeedbackinformation().split("#")[0];
				mv.addObject("fuInformation",fuInformation);
			}
		}
		mv.addObject("accountName", accountName);
		mv.addObject("psId", psId);
		mv.setViewName("/WEB-INF/jsp/feedbackInformation2.jsp");
		return mv;
	}
	
	@RequestMapping("/FffeedbackInformation.pet")
	public ModelAndView FffeedbackInformation(String accountName,Long fId,String systemInformation){
		ModelAndView mv = new ModelAndView();
		FosterFamily family = fosterFamilyService.selectByPrimaryKey(fId);
		if(null != family.getfFeedbackinformation() && "" != family.getfFeedbackinformation()){
			if(family.getfFeedbackinformation().split("#").length > 0){
				String userInformation = family.getfFeedbackinformation().split("#")[0];
				family.setfFeedbackinformation(userInformation+"#"+systemInformation);
			}else{
				family.setfFeedbackinformation("#"+systemInformation);
			}
		}else{
			family.setfFeedbackinformation("#"+systemInformation);
		}
		fosterFamilyService.updateByPrimaryKeySelective(family);
		mv.addObject("accountName", accountName);
		mv.addObject("fId", fId);
		mv.setViewName("/ffUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/FffeedbackInformationPage.pet")
	public ModelAndView feedbackInformationPage1(String accountName,Long fId){
		ModelAndView mv = new ModelAndView();
		FosterFamily family = fosterFamilyService.selectByPrimaryKey(fId);
		if(null != family.getfFeedbackinformation() && "" != family.getfFeedbackinformation()){
			if(family.getfFeedbackinformation().split("#").length > 0){
				String fuInformation = family.getfFeedbackinformation().split("#")[0];
				mv.addObject("fuInformation",fuInformation);
			}
		}
		mv.addObject("accountName", accountName);
		mv.addObject("fId", fId);
		mv.setViewName("/WEB-INF/jsp/feedbackInformation1.jsp");
		return mv;
	}
	
	@RequestMapping("/updatePs.pet")
	public ModelAndView updatePs(PetShop petShop,Information information,MultipartFile petShopPhoto,
				String accountName,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		if(!petShopPhoto.isEmpty()){
			String path = request.getServletContext().getRealPath("/petShopImg");
			String fileName = petShopPhoto.getOriginalFilename();
			File file = new File(path,fileName);
			petShopPhoto.transferTo(file);
			mv.addObject("path",path+"/"+fileName);
			petShop.setPsPetshopphoto("/petShopImg/"+fileName);
		}
		petShopService.updateByPrimaryKeySelective(petShop);
		informationService.updateByPrimaryKeySelective(information);
		mv.addObject("accountName", accountName);
		mv.setViewName("/psUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/psUpdatePage.pet")
	public ModelAndView psUpdatePage(String accountName,Long psId){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = petShopService.selectByPrimaryKey(psId);
		Information information = informationService.selectByFosterplaceidAndFosterstyle(psId,"宠物店");
		mv.addObject("accountName", accountName);
		mv.addObject("petShop", petShop);
		mv.addObject("information",information);
		mv.addObject("psId", psId);
		mv.setViewName("/WEB-INF/jsp/psUpdatePage.jsp");
		return mv;
	}
	
	
	@RequestMapping("/psUpdate.pet")
	public ModelAndView psUpdate(String accountName){
		ModelAndView mv = new ModelAndView();
		List<PetShop> psList = petShopService.listByAll();
		for(PetShop petShop : psList){
			if(null != petShop.getPsFeedbackinformation() && "" != petShop.getPsFeedbackinformation()){
				if(petShop.getPsFeedbackinformation().split("#").length > 0){
					String fuInformation = petShop.getPsFeedbackinformation().split("#")[0];
					petShop.setPsFeedbackinformation(fuInformation);
				}
			}
		}
		mv.addObject("psList", psList);
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/psUpdate.jsp");
		return mv;
	}
	
	
	@RequestMapping("/updateFf.pet")
	public ModelAndView updateFf(FosterFamily family,Information information,MultipartFile familyPhoto,
				String accountName,HttpServletRequest request) throws IllegalStateException, IOException{
		ModelAndView mv = new ModelAndView();
		if(!familyPhoto.isEmpty()){
			String path = request.getServletContext().getRealPath("/familyImg");
			String fileName = familyPhoto.getOriginalFilename();
			File file = new File(path,fileName);
			familyPhoto.transferTo(file);
			mv.addObject("path",path+"/"+fileName);
			family.setfFamilyphoto("/familyImg/"+fileName);
		}
		fosterFamilyService.updateByPrimaryKeySelective(family);
		informationService.updateByPrimaryKeySelective(information);
		mv.addObject("accountName", accountName);
		mv.setViewName("/ffUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/ffUpdatePage.pet")
	public ModelAndView ffUpdatePage(String accountName,Long ffId){
		ModelAndView mv = new ModelAndView();
		FosterFamily family = fosterFamilyService.selectByPrimaryKey(ffId);
		Information information = informationService.selectByFosterplaceidAndFosterstyle(ffId, "寄养家庭");
		mv.addObject("accountName", accountName);
		mv.addObject("information",information);
		mv.addObject("family", family);
		mv.addObject("ffId", ffId);
		mv.setViewName("/WEB-INF/jsp/ffUpdatePage.jsp");
		return mv;
	}
	
	@RequestMapping("/ffUpdate.pet")
	public ModelAndView ffUpdatePage(String accountName){
		ModelAndView mv = new ModelAndView();
		List<FosterFamily> ffList = fosterFamilyService.listByAll();
		for(FosterFamily family : ffList){
			if(null != family.getfFeedbackinformation() && "" != family.getfFeedbackinformation()){
				if(family.getfFeedbackinformation().split("#").length > 0){
					String fuInformation = family.getfFeedbackinformation().split("#")[0];
					family.setfFeedbackinformation(fuInformation);
				}
			}
		}
		mv.addObject("ffList", ffList);
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/ffUpdate.jsp");
		return mv;
	}
	
	@RequestMapping("/coordinate.pet")
	public ModelAndView coordinate(Long oId,String accountName){
		ModelAndView mv = new ModelAndView();
		Order order = new Order();
		Order o = orderService.selectByPrimaryKey(oId);
		order.setoId(oId);
		order.setoOrderstatus("已确认");
		
		orderService.updateByPrimaryKeySelective(order);
		mv.addObject("accountName",accountName);
		mv.setViewName("/orderInformationPage.pet");
		return mv;
	}
	
	@RequestMapping("/orderInformationPage.pet")
	public ModelAndView orderInformationPage(String accountName){
		ModelAndView mv = new ModelAndView();
		List<Order> orderList = orderService.listBy1RequestStatus("已挂起");
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			FosterUser user = fosterUserService.selectByPrimaryKey(order.getuId());
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭")){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店")){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		mv.addObject("myOrderList", myOrderList);
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/orderInformation.jsp");
		return mv;
	}
	
	@RequestMapping("/feedbackInformation.pet")
	public ModelAndView feedbackInformation(String accountName,Long fuId,String systemInformation){
		ModelAndView mv = new ModelAndView();
		FosterUser fosterUser = fosterUserService.selectByPrimaryKey(fuId);
		if(null != fosterUser.getFuFeedbackinformation() && "" != fosterUser.getFuFeedbackinformation()){
			if(fosterUser.getFuFeedbackinformation().split("#").length > 0){
				String userInformation = fosterUser.getFuFeedbackinformation().split("#")[0];
				fosterUser.setFuFeedbackinformation(userInformation+"#"+systemInformation);
			}else{
				fosterUser.setFuFeedbackinformation("#"+systemInformation);
			}
		}else{
			fosterUser.setFuFeedbackinformation("#"+systemInformation);
		}
		fosterUserService.updateByPrimaryKeySelective(fosterUser);
		mv.addObject("accountName", accountName);
		mv.addObject("fuId", fuId);
		mv.setViewName("/fuUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/feedbackInformationPage.pet")
	public ModelAndView feedbackInformationPage(String accountName,Long fuId){
		ModelAndView mv = new ModelAndView();
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		if(null != user.getFuFeedbackinformation() && "" != user.getFuFeedbackinformation()){
			if(user.getFuFeedbackinformation().split("#").length > 0){
				String fuInformation = user.getFuFeedbackinformation().split("#")[0];
				mv.addObject("fuInformation",fuInformation);
			}
		}
		mv.addObject("accountName", accountName);
		mv.addObject("fuId", fuId);
		mv.setViewName("/WEB-INF/jsp/feedbackInformation.jsp");
		return mv;
	}
	
	@RequestMapping("/addPet.pet")
	public ModelAndView addPet(String accountName,Long fuId,Pet pet){
		ModelAndView mv = new ModelAndView();
		petService.insertSelective(pet);
		mv.addObject("accountName", accountName);
		mv.addObject("fuId", fuId);
		mv.setViewName("/fuUpdatePage.pet");
		return mv;
	}
	
	@RequestMapping("/addPetPage.pet")
	public ModelAndView addUpdatePage(String accountName,Long fuId){
		ModelAndView mv = new ModelAndView();
		mv.addObject("accountName", accountName);
		mv.addObject("fuId", fuId);
		mv.setViewName("/WEB-INF/jsp/addPetPage.jsp");
		return mv;
	}
	
	@RequestMapping("/petDelete.pet")
	public ModelAndView petDelete(Pet pet,String accountName,Long fuId){
		ModelAndView mv = new ModelAndView();
		if(orderService.listBypId(pet.getpId()).size() == 0){
			petService.deleteByPrimaryKey(pet.getpId());
			mv.addObject("accountName", accountName);
			mv.addObject("fuId", fuId);
			mv.setViewName("/fuUpdatePage.pet");
		}else{
			mv.addObject("msg", "有订单信息中存在该宠物的信息，无法删除");
			mv.addObject("accountName", accountName);
			mv.addObject("fuId", fuId);
			mv.setViewName("/fuUpdatePage.pet");
		}
		
		return mv;
	}
	
	@RequestMapping("/updatePet.pet")
	public ModelAndView updatePet(Pet pet,String accountName,Long fuId){
		ModelAndView mv = new ModelAndView();
		petService.updateByPrimaryKeySelective(pet);
		mv.addObject("accountName", accountName);
		mv.addObject("fuId", fuId);
		mv.setViewName("/fuUpdatePage.pet");
		return mv;
	}
	
	@RequestMapping("/petUpdate.pet")
	public ModelAndView petUpdate(String accountName,Long pId,Long fuId){
		ModelAndView mv = new ModelAndView();
		Pet pet = petService.selectByPrimaryKey(pId);
		mv.addObject("accountName", accountName);
		mv.addObject("pet",pet);
		mv.addObject("fuId",fuId);
		mv.setViewName("/WEB-INF/jsp/petUpdatePage.jsp");
		return mv;
	}
	
	@RequestMapping("/updateFu.pet")
	public ModelAndView updateFu(FosterUser user,String accountName){
		ModelAndView mv = new ModelAndView();
		fosterUserService.updateByPrimaryKeySelective(user);
		mv.addObject("accountName", accountName);
		mv.setViewName("/fuUpdate.pet");
		return mv;
	}
	
	@RequestMapping("/fuUpdatePage.pet")
	public ModelAndView fuUpdatePage(String accountName,Long fuId){
		ModelAndView mv = new ModelAndView();
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<Pet> petList = petService.selectByfuId(fuId);
		mv.addObject("accountName", accountName);
		mv.addObject("user", user);
		mv.addObject("petList", petList);
		mv.addObject("fuId", fuId);
		mv.setViewName("/WEB-INF/jsp/fuUpdatePage.jsp");
		return mv;
	}
	
	@RequestMapping("/psDetails.pet")
	public ModelAndView psDetails(Long psId,String accountName){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = petShopService.selectByPrimaryKey(psId);
		Information information = informationService.selectByFosterplaceidAndFosterstyle(psId,"宠物店");
		mv.addObject("accountName", accountName);
		mv.addObject("petShop",petShop);
		mv.addObject("information", information);
		mv.setViewName("/WEB-INF/jsp/psDetails.jsp");
		return mv;
	}
	
	@RequestMapping("/ffDetails.pet")
	public ModelAndView ffDetails(Long fId,String accountName){
		ModelAndView mv = new ModelAndView();
		FosterFamily family = fosterFamilyService.selectByPrimaryKey(fId);
		Information information = informationService.selectByFosterplaceidAndFosterstyle(fId,"寄养家庭");
		mv.addObject("accountName", accountName);
		mv.addObject("family",family);
		mv.addObject("information", information);
		mv.setViewName("/WEB-INF/jsp/ffDetails.jsp");
		return mv;
	}
	
	@RequestMapping("/manager.pet")
	public ModelAndView manager(String accountName){
		ModelAndView mv = new ModelAndView();
		mv.addObject("ffList",fosterFamilyService.listByRequestStatus("待审核"));
		mv.addObject("psList",petShopService.listByRequestStatus("待审核"));
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/manager.jsp");
		return mv;
	}
	
	@RequestMapping("/fuUpdate.pet")
	public ModelAndView fuUpdate(String accountName){
		ModelAndView mv = new ModelAndView();
		List<FosterUser> userList = fosterUserService.listByAll();
		for(FosterUser user : userList){
			if(null != user.getFuFeedbackinformation() && "" != user.getFuFeedbackinformation()){
				if(user.getFuFeedbackinformation().split("#").length > 0){
					String fuInformation = user.getFuFeedbackinformation().split("#")[0];
					user.setFuFeedbackinformation(fuInformation);
				}
			}
		}
		mv.addObject("accountName", accountName);
		mv.addObject("userList",userList);
		mv.setViewName("/WEB-INF/jsp/fuUpdate.jsp");
		return mv;
	}
	
	@RequestMapping("/noPassPetShop.pet")
	public ModelAndView noPassPetShop(Long psId,String accountName){
		ModelAndView mv = new ModelAndView();
		petShopService.deleteByPrimaryKey(psId);
		informationService.deleteByFosterplaceidAndFosterStyle(psId,"宠物店");
		mv.addObject("ffList",fosterFamilyService.listByRequestStatus("待审核"));
		mv.addObject("psList",petShopService.listByRequestStatus("待审核"));
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/manager.jsp");
		return mv;
	}
	
	@RequestMapping("/passPetShop.pet")
	public ModelAndView passPetShop(Long psId,String accountName){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = new PetShop();
		petShop.setPsId(psId);
		petShop.setPsRequeststatus("已通过");
		petShopService.updateByPrimaryKeySelective(petShop);
		mv.addObject("ffList",fosterFamilyService.listByRequestStatus("待审核"));
		mv.addObject("psList",petShopService.listByRequestStatus("待审核"));
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/manager.jsp");
		return mv;
	}
	
	@RequestMapping("/noPassFamily.pet")
	public ModelAndView noPassFamily(Long fId,String accountName){
		ModelAndView mv = new ModelAndView();
		fosterFamilyService.deleteByPrimaryKey(fId);
		informationService.deleteByFosterplaceidAndFosterStyle(fId,"寄养家庭");
		mv.addObject("ffList",fosterFamilyService.listByRequestStatus("待审核"));
		mv.addObject("psList",petShopService.listByRequestStatus("待审核"));
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/manager.jsp");
		return mv;
	}
	
	@RequestMapping("/passFamily.pet")
	public ModelAndView passFamily(Long fId,String accountName){
		ModelAndView mv = new ModelAndView();
		FosterFamily fosterFamily = new FosterFamily();
		fosterFamily.setfId(fId);
		fosterFamily.setfRequeststatus("已通过");
		fosterFamilyService.updateByPrimaryKeySelective(fosterFamily);
		mv.addObject("ffList",fosterFamilyService.listByRequestStatus("待审核"));
		mv.addObject("psList",petShopService.listByRequestStatus("待审核"));
		mv.addObject("accountName", accountName);
		mv.setViewName("/WEB-INF/jsp/manager.jsp");
		return mv;
	}
	
	
	@RequestMapping("/deleteOrder.pet")
	public ModelAndView deleteOrder(Long oId,Long fuId){
		ModelAndView mv = new ModelAndView();
		orderService.deleteByPrimaryKey(oId);
		mv.addObject("fuId",fuId);
		mv.setViewName("/fuOrderPage.pet");
		return mv;
	}
	
	@RequestMapping("/cancellationOrder.pet")
	public ModelAndView cancellationOrder(Long oId,Long fuId){
		ModelAndView mv = new ModelAndView();
		Order order = new Order();
		order.setoId(oId);
		Date now = new Date();
		Order o = orderService.selectByPrimaryKey(oId);
		int day = now.getDate() - 1;
		now.setDate(day);
		if(o.getoOrderdate().getTime() < now.getTime()){
			mv.addObject("msg", "订单生成时间超过一天，无法取消");
		}else{
			order.setoOrderstatus("已取消");
			orderService.updateByPrimaryKeySelective(order);
		}
		mv.addObject("fuId",fuId);
		mv.setViewName("/fuOrderPage.pet");
		return mv;
	}
	
	@RequestMapping("/confirmationOrder.pet")
	public ModelAndView confirmationOrder(Long oId,Long fuId){
		ModelAndView mv = new ModelAndView();
		Order order = new Order();
		order.setoId(oId);
		order.setoOrderstatus("已确认");
		orderService.updateByPrimaryKeySelective(order);
		mv.addObject("fuId",fuId);
		mv.setViewName("/fuOrderPage.pet");
		return mv;
	}
	
	@RequestMapping("/hangOrder.pet")
	public ModelAndView hangOrder(Long oId,Long fuId){
		ModelAndView mv = new ModelAndView();
		Order order = new Order();
		order.setoId(oId);
		order.setoOrderstatus("已挂起");
		orderService.updateByPrimaryKeySelective(order);
		mv.addObject("fuId",fuId);
		mv.setViewName("/fuOrderPage.pet");
		return mv;
	}
	
	@RequestMapping(value="/listAllOrder.pet")
	@ResponseBody
	public Object listAllOrder(Long fuId){
		List<Order> orderList = orderService.listByfuId(fuId);
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	@RequestMapping(value="/listOneYearOrder.pet")
	@ResponseBody
	public Object listOneYearOrder(Long fuId){
		List<Order> uOrderList = orderService.listByfuId(fuId);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int year = now.getYear() - 1;
		now.setYear(year);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	@RequestMapping(value="/listThreeMonthOrder.pet")
	@ResponseBody
	public Object listThreeMonthOrder(Long fuId){
		List<Order> uOrderList = orderService.listByfuId(fuId);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int month = now.getMonth()-3;
		now.setMonth(month);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	@RequestMapping(value="/listOneMonthOrder.pet")
	@ResponseBody
	public Object listOneMonthOrder(Long fuId){
		List<Order> uOrderList = orderService.listByfuId(fuId);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int month = now.getMonth()-1;
		now.setMonth(month);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	
	@RequestMapping("/fuOrderPage.pet")
	public ModelAndView fuOrderPage(Long fuId){
		ModelAndView mv = new ModelAndView();
		List<Order> uOrderList = orderService.listByfuId(fuId);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int month = now.getMonth()-1;
		now.setMonth(month);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		mv.addObject("fuId", fuId);
		mv.addObject("accountName",user.getFuAccountname());
		mv.addObject("myOrderList", myOrderList);
		mv.setViewName("/WEB-INF/jsp/fuOrder.jsp");
		return mv;
	}
	
	@RequestMapping("/startFoster.pet")
	public ModelAndView startFoster(String accountName,Long fId,Long pId,Long fosterDay,String style){
		ModelAndView mv = new ModelAndView();
		FosterUser user = fosterUserService.listByAccount(accountName);
		List<Pet> petList = petService.selectByfuId(user.getFuId());
		List<Pet> petList1 = new ArrayList<Pet>();
		if(pId == null){
			mv.addObject("msg", "请选择您要寄养的宠物");
			List<Order> orderList = orderService.listByRequestStatus("待确认","正在预约","已挂起");
			for(Pet pet : petList){
				int times = 0;
				for(Order order : orderList){
					if(order.getpId().equals(pet.getpId())){
						++times;
						break;
					}
				}
				if(times == 0){
					petList1.add(pet);
				}
			}
			
			if(petList1.size() == 0){
				mv.addObject("msg", "您的所有宠物都已在寄养状态，无宠物可供寄养");
			}
			mv.addObject("accountName", user.getFuAccountname());
			mv.addObject("style", style);
			mv.addObject("petList", petList1);
			mv.addObject("fuId",user.getFuId());
			mv.addObject("fId",fId);
			mv.setViewName("/WEB-INF/jsp/fosterPage.jsp");
		}else{
			List<Order> orderList = orderService.listByRequestStatus("待确认","正在预约","已挂起");
			int times = 0;
			for(Order order : orderList){
				if(order.getpId().equals(pId)){
					++times;
					break;
				}
			}
			if(times == 0){
				if(style.equals("寄养家庭")){
					FosterFamily family = fosterFamilyService.selectByPrimaryKey(fId);
					Pet pet = petService.selectByPrimaryKey(pId);
					if(null != family.getfTyperange() && "" != family.getfTyperange()){
						if(family.getfTyperange().split(",").length > 1){
							for(int i = 0;i < family.getfTyperange().split(",").length;i++){
								if(pet.getpType().equals(family.getfTyperange().split(",")[i])){
									Order order = new Order();
									order.setuId(user.getFuId());
									order.setpId(pId);
									order.setoFosterstyle(style);
									order.setoFosterplaceid(fId);
									order.setoFosterday(fosterDay);
									order.setoOrderstatus("正在预约");
									orderService.insertSelective(order);
									mv.addObject("prompt", "宠物开始预约成功");
									mv.setViewName("/fuIndex.pet");
									return mv;
								}
							}
						}else{
							if(pet.getpType().equals(family.getfTyperange())){
								Order order = new Order();
								order.setuId(user.getFuId());
								order.setpId(pId);
								order.setoFosterstyle(style);
								order.setoFosterplaceid(fId);
								order.setoFosterday(fosterDay);
								order.setoOrderstatus("正在预约");
								orderService.insertSelective(order);
								mv.addObject("prompt", "宠物开始预约成功");
								mv.setViewName("/fuIndex.pet");
								return mv;
							}
						}

						
						for(Pet pet1 : petList){
							times = 0;
							for(Order order : orderList){
								if(order.getpId().equals(pet1.getpId())){
									++times;
									break;
								}
							}
							if(times == 0){
								petList1.add(pet1);
							}
						}
						
						if(petList1.size() == 0){
							mv.addObject("msg", "您的所有宠物都已在寄养状态，无宠物可供寄养");
						}
						
						mv.addObject("msg", "此寄养地不支持该宠物类型");
						mv.addObject("style", style);
						mv.addObject("accountName", user.getFuAccountname());
						mv.addObject("petList", petList1);
						mv.addObject("fuId",user.getFuId());
						mv.addObject("fId",fId);
						mv.setViewName("/WEB-INF/jsp/fosterPage.jsp");
						return mv;
					}
				}else if(style.equals("宠物店")){
					PetShop petShop = petShopService.selectByPrimaryKey(fId);
					Pet pet = petService.selectByPrimaryKey(pId);
					if(null != petShop.getPsTyperange() && "" != petShop.getPsTyperange()){
						if(petShop.getPsTyperange().split(",").length > 1){
							for(int i = 0;i < petShop.getPsTyperange().split(",").length;i++){
								if(pet.getpType().equals(petShop.getPsTyperange().split(",")[i])){
									Order order = new Order();
									order.setuId(user.getFuId());
									order.setpId(pId);
									order.setoFosterstyle(style);
									order.setoFosterplaceid(fId);
									order.setoFosterday(fosterDay);
									order.setoOrderstatus("正在预约");
									orderService.insertSelective(order);
									mv.addObject("prompt", "宠物开始预约成功");
									mv.setViewName("/fuIndex.pet");
									return mv;
								}
							}
						}else{
							if(pet.getpType().equals(petShop.getPsTyperange())){
								Order order = new Order();
								order.setuId(user.getFuId());
								order.setpId(pId);
								order.setoFosterstyle(style);
								order.setoFosterplaceid(fId);
								order.setoFosterday(fosterDay);
								order.setoOrderstatus("正在预约");
								orderService.insertSelective(order);
								mv.addObject("prompt", "宠物开始预约成功");
								mv.setViewName("/fuIndex.pet");
								return mv;
							}
						}

						
						for(Pet pet1 : petList){
							times = 0;
							for(Order order : orderList){
								if(order.getpId().equals(pet1.getpId())){
									++times;
									break;
								}
							}
							if(times == 0){
								petList1.add(pet1);
							}
						}
						
						if(petList1.size() == 0){
							mv.addObject("msg", "您的所有宠物都已在寄养状态，无宠物可供寄养");
						}
						
						mv.addObject("msg", "此寄养地不支持该宠物类型");
						mv.addObject("style", style);
						mv.addObject("accountName", user.getFuAccountname());
						mv.addObject("petList", petList1);
						mv.addObject("fuId",user.getFuId());
						mv.addObject("fId",fId);
						mv.setViewName("/WEB-INF/jsp/fosterPage.jsp");
						return mv;
					}
				}
			}else{
				mv.setViewName("/fuIndex.pet");
			}
		}
		return mv;
	}
	
	
	@RequestMapping("/fosterPage.pet")
	public ModelAndView fosterPage(Long fuId,Long fId,String style){
		ModelAndView mv = new ModelAndView();
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<Pet> petList = petService.selectByfuId(fuId);
		List<Pet> petList1 = new ArrayList<Pet>();
		List<Order> orderList = orderService.listByRequestStatus("待确认","正在预约","已挂起");
		System.out.println(orderList);
		for(Pet pet : petList){
			int times = 0;
			for(Order order : orderList){
				if(order.getpId().equals(pet.getpId())){
					++times;
					break;
				}
			}
			if(times == 0){
				petList1.add(pet);
			}
		}
		
		if(petList1.size() == 0){
			mv.addObject("msg", "您的所有宠物都已在寄养状态，无宠物可供寄养");
		}
		mv.addObject("accountName", user.getFuAccountname());
		mv.addObject("petList", petList1);
		System.out.println(petList1);
		mv.addObject("fuId",fuId);
		mv.addObject("fId",fId);
		mv.addObject("style",style);
		mv.setViewName("/WEB-INF/jsp/fosterPage.jsp");
		return mv;
	}
	
	@RequestMapping("/fuFfDetails.pet")
	public ModelAndView fuFfDetails(Long fuId,Long fId,String style){
		ModelAndView mv = new ModelAndView();
		FosterFamily family = fosterFamilyService.selectByPrimaryKey(fId);
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		Information information = informationService.selectByFosterplaceidAndFosterstyle(fId,style);
		mv.addObject("accountName", user.getFuAccountname());
		mv.addObject("family",family);
		mv.addObject("information", information);
		mv.addObject("fosterUser", user);
		mv.setViewName("/WEB-INF/jsp/fuFfDetails.jsp");
		return mv;
	}
	
	@RequestMapping("/fuPsDetails.pet")
	public ModelAndView fuPsDetails(Long fuId,Long fId,String style){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = petShopService.selectByPrimaryKey(fId);
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		Information information = informationService.selectByFosterplaceidAndFosterstyle(fId,style);
		mv.addObject("accountName", user.getFuAccountname());
		mv.addObject("petShop",petShop);
		mv.addObject("information", information);
		mv.addObject("fosterUser", user);
		mv.setViewName("/WEB-INF/jsp/fuPsDetails.jsp");
		return mv;
	}
	
	@RequestMapping("/hospitalDetailsPage.pet")
	public ModelAndView hospitalDetailsPage(String accountName,Long hId){
		ModelAndView mv = new ModelAndView();
		Hospital hospital = hospitalService.selectByPrimaryKey(hId);
		mv.addObject("accountName", accountName);
		mv.addObject("hospital",hospital);
		mv.setViewName("/WEB-INF/jsp/hospitalDetails.jsp");
		return mv;
	}
	
	@RequestMapping("/hospital.pet")
	public ModelAndView hospital(String accountName){
		ModelAndView mv = new ModelAndView();
		List<Hospital> hospitalList = hospitalService.listByAll();
		mv.addObject("hospitalList",hospitalList);
		mv.addObject("accountName",accountName);
		mv.setViewName("/WEB-INF/jsp/hospital.jsp");
		return mv;
	}
	
	@RequestMapping("/deleteffAccount.pet")
	public ModelAndView deleteffAccount(Long fId){
		ModelAndView mv = new ModelAndView();
		fosterFamilyService.deleteByPrimaryKey(fId);
		orderService.deleteByfosterPlaceIdAndfosterStyle(fId, "寄养家庭");
		informationService.deleteByFosterplaceidAndFosterStyle(fId, "寄养家庭");
		mv.addObject("msg", "注销成功");
		mv.setViewName("/loginPage.pet");
		return mv;
	}
	
	@RequestMapping("/deletepsAccount.pet")
	public ModelAndView deletepsAccount(Long psId){
		ModelAndView mv = new ModelAndView();
		petShopService.deleteByPrimaryKey(psId);
		orderService.deleteByfosterPlaceIdAndfosterStyle(psId, "宠物店");
		informationService.deleteByFosterplaceidAndFosterStyle(psId, "宠物店");
		mv.addObject("msg", "注销成功");
		mv.setViewName("/loginPage.pet");
		return mv;
	}
	
	@RequestMapping("/fuIndexPage.pet")
	public String fuIndexPage(){
		return "/WEB-INF/jsp/fuIndex.jsp";
	}
	
	@RequestMapping("/fuIndex.pet")
	public ModelAndView fuIndex(String accountName){
		ModelAndView mv = new ModelAndView();
		mv.addObject("fosterUser",fosterUserService.listByAccount(accountName));
		mv.addObject("ffList",fosterFamilyService.listByRequestStatus("已通过"));
		mv.addObject("psList",petShopService.listByRequestStatus("已通过"));
		mv.setViewName("/WEB-INF/jsp/fuIndex.jsp");
		return mv;
	}
	
	@RequestMapping("/fuAddPet.pet")
	public ModelAndView fuAddPet(Long fuId,Pet pet,String accountName){
		ModelAndView mv = new ModelAndView();
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(pet.getpPetname());
		boolean res = matcher.matches();
		if("" != pet.getpPetname() && null != pet.getpPetname()){
			if(res == true){
				if(pet.getpPetname().length()>=2 && pet.getpPetname().length()<=4){
					if(0 == petService.listByPetNameAndFuId(fuId,pet.getpPetname()).size()){
						petService.insertSelective(pet);
						mv.addObject("msg", "");
						mv.setViewName("/updateFuPage.pet");
					}else{
						mv.addObject("msg", "宠物名已存在");
						mv.setViewName("/WEB-INF/jsp/fuAddPetPage.jsp");
					}
				}else{
					mv.addObject("msg", "宠物昵称长度只能是2-4位");
					mv.setViewName("/WEB-INF/jsp/fuAddPetPage.jsp");
				}
			}else{
				mv.addObject("msg", "宠物昵称只能是中文汉字");
				mv.setViewName("/WEB-INF/jsp/fuAddPetPage.jsp");
			}
		}else{
			mv.addObject("msg", "宠物昵称不能为空");
			mv.setViewName("/WEB-INF/jsp/fuAddPetPage.jsp");
		}
		mv.addObject("fuId", fuId);
		mv.addObject("accountName", accountName);
		return mv;
	}
	
	@RequestMapping(value="/checkFuPetName1.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFuPetName1(String petName,Long fuId){
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(petName);
		boolean res = matcher.matches();
		if(petName != ""){
			if(res == true){
				if(petName.length()>=2 && petName.length()<=4){
					if(0 < petService.listByPetNameAndFuId(fuId, petName).size()){
						return "宠物名已存在";
					}else{
						return "";
					}
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
	
	@RequestMapping("/fuAddPetPage.pet")
	public ModelAndView fuAddPetPage(String accountName,Long fuId){
		ModelAndView mv = new ModelAndView();
		mv.addObject("accountName", accountName);
		mv.addObject("fuId",fuId);
		mv.setViewName("/WEB-INF/jsp/fuAddPetPage.jsp");
		return mv;
	}
	
	@RequestMapping("/deletePet.pet")
	public ModelAndView deletePet(Long fuId,Long pId){
		ModelAndView mv = new ModelAndView();
		if(orderService.listBypId(pId).size() == 0){
			petService.deleteByPrimaryKey(pId);
			mv.addObject("fuId", fuId);
			mv.setViewName("/updateFuPage.pet");
		}else{
			mv.addObject("msg", "有订单信息中存在该宠物的信息，无法删除");
			mv.addObject("fuId", fuId);
			mv.setViewName("/updateFuPage.pet");
		}
		return mv;
	}
	
	@RequestMapping("/updatePetInformation.pet")
	public ModelAndView updatePetInformation(Pet pet,String accountName,Long fuId){
		ModelAndView mv = new ModelAndView();
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(pet.getpPetname());
		boolean res = matcher.matches();
		Pet pet1 = petService.selectByPrimaryKey(pet.getpId());
		if("" != pet.getpPetname() && null != pet.getpPetname()){
			if(!(pet1.getpPetname().equals(pet.getpPetname()))){
				if(res == true){
					if(pet.getpPetname().length()>=2 && pet.getpPetname().length()<=4){
						if(0 == petService.listByPetNameAndFuId(fuId,pet.getpPetname()).size()){
							petService.updateByPrimaryKeySelective(pet);
							mv.addObject("msg", "");
							mv.setViewName("/updateFuPage.pet");
						}else{
							mv.addObject("msg", "宠物名已存在");
							mv.setViewName("/WEB-INF/jsp/updatePetPage.jsp");
						}
					}else{
						mv.addObject("msg", "宠物昵称长度只能是2-4位");
						mv.setViewName("/WEB-INF/jsp/updatePetPage.jsp");
					}
				}else{
					mv.addObject("msg", "宠物昵称只能是中文汉字");
					mv.setViewName("/WEB-INF/jsp/updatePetPage.jsp");
				}
			}else{
				petService.updateByPrimaryKeySelective(pet);
				mv.addObject("msg", "");
				mv.setViewName("/updateFuPage.pet");
			}
		}else{
			mv.addObject("msg", "宠物昵称不能为空");
			mv.setViewName("/WEB-INF/jsp/updatePetPage.jsp");
		}
		mv.addObject("fuId", fuId);
		mv.addObject("accountName", accountName);
		mv.addObject("pet",pet);
		return mv;
	}
	
	
	@RequestMapping(value="/checkFuPetName.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFuPetName(String petName,Long fuId,Long pId){
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(petName);
		boolean res = matcher.matches();
		Pet pet = petService.selectByPrimaryKey(pId);
		if(petName != ""){
			if(!(petName.equals(pet.getpPetname()))){
				if(res == true){
					if(petName.length()>=2 && petName.length()<=4){
						if(0 < petService.listByPetNameAndFuId(fuId, petName).size()){
							return "宠物名已存在";
						}else{
							return "";
						}
					}else{
						return "宠物昵称长度只能是2-4位";
					}
				}else{
					return "宠物昵称只能是中文汉字";
				}
			}else{
				return "";
			}
		}else{
			return "宠物昵称不能为空";
		}
	}
	
	
	
	@RequestMapping("/updatePetPage.pet")
	public ModelAndView updatePetPage(String accountName,Long pId,Long fuId){
		ModelAndView mv = new ModelAndView();
		Pet pet = petService.selectByPrimaryKey(pId);
		mv.addObject("accountName", accountName);
		mv.addObject("pet",pet);
		mv.addObject("fuId",fuId);
		mv.setViewName("/WEB-INF/jsp/updatePetPage.jsp");
		return mv;
	}
	
	@RequestMapping(value="/updateFuInformation.pet",produces="text/html;charset=utf-8")
	public ModelAndView updateFuInformation(FosterUser user,String againPassword){
		ModelAndView mv = new ModelAndView();
		String str  =  "^[(\\u4e00-\\u9fa5)]+$";
		Pattern pattern = Pattern.compile(str);
		Matcher matcher = pattern.matcher(user.getFuFosterusername());
		boolean res = matcher.matches();
		if(user.getFuFosterusername() != ""){
			if(res == true){
				if(user.getFuFosterusername().length()>=2 && user.getFuFosterusername().length()<=4){
					if(user.getFuPassword() != ""){
						if(user.getFuPassword().length()>=6 && user.getFuPassword().length()<=16){
							if(againPassword.equals(user.getFuPassword())){
								str  =  "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
								pattern = Pattern.compile(str);
								matcher = pattern.matcher(user.getFuContactway());
								res = matcher.matches();
								if(user.getFuContactway() != ""){
									if(res == true){
										if(user.getFuAddress() != ""){
											fosterUserService.updateByPrimaryKeySelective(user);
											mv.setViewName("/fuInformation.pet");
										}else{
											mv.addObject("msg", "联系地址不能为空");
											mv.setViewName("/updateFuPage.pet");
											return mv;
										}
									}else{
										mv.addObject("msg", "联系方式只能是长度11位且格式正确的电话号码");
										mv.setViewName("/updateFuPage.pet");
										return mv;
									}
								}else{
									mv.addObject("msg", "联系方式不能为空");
									mv.setViewName("/updateFuPage.pet");
									return mv;
								}
							}else{
								mv.addObject("msg", "两次密码不一致");
								mv.setViewName("/updateFuPage.pet");
								return mv;
							}
						}else{
							mv.addObject("msg", "密码长度只能是6-16位");
							mv.setViewName("/updateFuPage.pet");
							return mv;
						}
					}else{
						mv.addObject("msg", "密码不能为空");
						mv.setViewName("/updateFuPage.pet");
						return mv;
					}
				}else{
					mv.addObject("msg", "姓名长度只能是2-4位");
					mv.setViewName("/updateFuPage.pet");
					return mv;
				}
			}else{
				mv.addObject("msg", "姓名只能是中文汉字");
				mv.setViewName("/updateFuPage.pet");
				return mv;
			}
		}else{
			mv.addObject("msg", "姓名不能为空");
			mv.setViewName("/updateFuPage.pet");
			return mv;
		}
		mv.addObject("fuId", user.getFuId());
		return mv;
	}
	
	
	@RequestMapping(value="/checkFuUserName.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFuUserName(String userName){
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
	
	
	@RequestMapping(value="/checkFuPassword.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFuPassword(String password){
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
	
	@RequestMapping(value="/checkFuAgainPassword.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFuAgainPassword(String againPassword,String password){
		
		if(againPassword.equals(password)){
			return "";
		}else{
			return "两次密码不一致";
		}
		
	}
	
	
	@RequestMapping(value="/checkFuContactWay.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFuContactWay(String contactWay){
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
	
	@RequestMapping(value="/checkFuAddress.pet",produces="text/html;charset=utf-8")
	@ResponseBody
	public Object checkFuAddress(String address){
		if(address != ""){
			return "";
		}else{
			return "联系地址不能为空";
		}
		
	}
	
	
	
	@RequestMapping("/updateFuPage.pet")
	public ModelAndView updateFuPage(Long fuId){
		ModelAndView mv = new ModelAndView();
		FosterUser user = fosterUserService.selectByPrimaryKey(fuId);
		List<Pet> petList = petService.selectByfuId(fuId);
		if(0 < user.getFuAddress().split(" ").length){
			String[] str = user.getFuAddress().split(" ");
			String address = "";
			for(int i=0;i < str.length;i++){
				address += user.getFuAddress().split(" ")[i]+"/";
			}
			int index = address.lastIndexOf("/");
			String ext = address.substring(0,index);
			mv.addObject("address", ext);
		}
		mv.addObject("user", user);
		mv.addObject("petList", petList);
		mv.addObject("fuId", fuId);
		mv.setViewName("/WEB-INF/jsp/updateFuPage.jsp");
		return mv;
	}
	
	
	
	@RequestMapping("/feedbackinformation.pet")
	public ModelAndView feedbackinformation(String userInformation,Long fuId){
		ModelAndView mv = new ModelAndView();
		FosterUser fosterUser = fosterUserService.selectByPrimaryKey(fuId);
		if(null != fosterUser.getFuFeedbackinformation() && "" != fosterUser.getFuFeedbackinformation()){
			if(fosterUser.getFuFeedbackinformation().split("#").length > 1){
				String systemInformation = fosterUser.getFuFeedbackinformation().split("#")[1];
				fosterUser.setFuFeedbackinformation(userInformation+"#"+systemInformation);
			}else{
				fosterUser.setFuFeedbackinformation(userInformation+"#");
			}
		}else{
			fosterUser.setFuFeedbackinformation(userInformation+"#");
		}
		fosterUserService.updateByPrimaryKeySelective(fosterUser);
		mv.addObject("msg","提交成功");
		mv.setViewName("/fuInformation.pet?fuId"+fuId);
		return mv;
	}
	
	
	@RequestMapping("/fuInformation.pet")
	public ModelAndView fuInformation(Long fuId){
		ModelAndView mv = new ModelAndView();
		FosterUser fosterUser = fosterUserService.selectByPrimaryKey(fuId);
		List<Pet> petList = petService.selectByfuId(fuId);
		if(fosterUser.getFuFeedbackinformation() != null){
			if(fosterUser.getFuFeedbackinformation().split("#").length > 1){
				String systemInformation = fosterUser.getFuFeedbackinformation().split("#")[1];
				mv.addObject("systemInformation",systemInformation);
			}
		}
		mv.addObject("fosterUser",fosterUser);
		mv.addObject("petList",petList);
		mv.setViewName("/WEB-INF/jsp/fuInformation.jsp");
		return mv;
	}
	
	@RequestMapping("/feedbackinformation1.pet")
	public ModelAndView feedbackinformation1(String ffInformation,Long fId,String oFosterstyle){
		ModelAndView mv = new ModelAndView();
		FosterFamily fosterFamily = fosterFamilyService.selectByPrimaryKey(fId);
		if(null != fosterFamily.getfFeedbackinformation() && "" != fosterFamily.getfFeedbackinformation()){
			if(fosterFamily.getfFeedbackinformation().split("#").length > 1){
				String systemInformation = fosterFamily.getfFeedbackinformation().split("#")[1];
				fosterFamily.setfFeedbackinformation(ffInformation+"#"+systemInformation);
			}else{
				fosterFamily.setfFeedbackinformation(ffInformation+"#");
			}
		}else{
			fosterFamily.setfFeedbackinformation(ffInformation+"#");
		}
		
		fosterFamilyService.updateByPrimaryKeySelective(fosterFamily);
		mv.addObject("msg","提交成功");
		mv.addObject("oFosterstyle", oFosterstyle);
		mv.addObject("oFosterplaceid",fId);
		mv.setViewName("/ffInformation.pet?oFosterplaceid="+fId);
		return mv;
	}
	
	
	@RequestMapping("/ffInformation.pet")
	public ModelAndView ffInformation(Long oFosterplaceid,String oFosterstyle){
		ModelAndView mv = new ModelAndView();
		FosterFamily fosterFamily = fosterFamilyService.selectByPrimaryKey(oFosterplaceid);
		if(null != fosterFamily.getfFeedbackinformation() && "" != fosterFamily.getfFeedbackinformation()){
			if(fosterFamily.getfFeedbackinformation().split("#").length > 1){
				String systemInformation = fosterFamily.getfFeedbackinformation().split("#")[1];
				mv.addObject("systemInformation",systemInformation);
			}
		}
		Information information = informationService.selectByFosterplaceidAndFosterstyle(oFosterplaceid, oFosterstyle);
		mv.addObject("fosterFamily",fosterFamily);
		mv.addObject("oFosterstyle", oFosterstyle);
		mv.addObject("information", information);
		mv.setViewName("/WEB-INF/jsp/ffInformation.jsp");
		return mv;
	}
	
	@RequestMapping("/feedbackinformation2.pet")
	public ModelAndView feedbackinformation2(String psInformation,Long psId,String oFosterstyle){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = petShopService.selectByPrimaryKey(psId);
		if(null != petShop.getPsFeedbackinformation() && "" != petShop.getPsFeedbackinformation()){
			if(petShop.getPsFeedbackinformation().split("#").length > 1){
				String systemInformation = petShop.getPsFeedbackinformation().split("#")[1];
				petShop.setPsFeedbackinformation(psInformation+"#"+systemInformation);
			}else{
				petShop.setPsFeedbackinformation(psInformation+"#");
			}
		}else{
			petShop.setPsFeedbackinformation(psInformation+"#");
		}
		
		petShopService.updateByPrimaryKeySelective(petShop);
		mv.addObject("msg","提交成功");
		mv.addObject("oFosterstyle", oFosterstyle);
		mv.setViewName("/psInformation.pet?oFosterplaceid="+psId);
		return mv;
	}
	
	@RequestMapping(value="/listPsAndffAllOrder.pet")
	@ResponseBody
	public Object listPsAndffAllOrder(Long oFosterplaceid,String oFosterstyle){
		List<Order> orderList = orderService.listByoFosterplaceid(oFosterplaceid, oFosterstyle);
		
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			FosterUser user = fosterUserService.selectByPrimaryKey(order.getuId());
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	@RequestMapping(value="/listPsAndffOneYearOrder.pet")
	@ResponseBody
	public Object listPsAndffOneYearOrder(Long oFosterplaceid,String oFosterstyle){
		List<Order> uOrderList = orderService.listByoFosterplaceid(oFosterplaceid, oFosterstyle);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int year = now.getYear()-1;
		now.setYear(year);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			FosterUser user = fosterUserService.selectByPrimaryKey(order.getuId());
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	@RequestMapping(value="/listPsAndffThreeMonthOrder.pet")
	@ResponseBody
	public Object listPsAndffThreeMonthOrder(Long oFosterplaceid,String oFosterstyle){
		List<Order> uOrderList = orderService.listByoFosterplaceid(oFosterplaceid, oFosterstyle);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int month = now.getMonth()-3;
		now.setMonth(month);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			FosterUser user = fosterUserService.selectByPrimaryKey(order.getuId());
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	@RequestMapping(value="/listPsAndffOneMonthOrder.pet")
	@ResponseBody
	public Object listPsAndffOneMonthOrder(Long oFosterplaceid,String oFosterstyle){
		List<Order> uOrderList = orderService.listByoFosterplaceid(oFosterplaceid, oFosterstyle);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int month = now.getMonth()-1;
		now.setMonth(month);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			FosterUser user = fosterUserService.selectByPrimaryKey(order.getuId());
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭") && null != fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid())){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店") && null != petShopService.selectByPrimaryKey(order.getoFosterplaceid())){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		return myOrderList;
	}
	
	
	@RequestMapping("/refuseOrder.pet")
	public ModelAndView refuseOrder(Long oId,Long oFosterplaceid){
		ModelAndView mv = new ModelAndView();
		Order order = new Order();
		Order o = orderService.selectByPrimaryKey(oId);
		order.setoId(oId);
		order.setoOrderstatus("拒单");
		orderService.updateByPrimaryKeySelective(order);
		mv.addObject("oFosterplaceid",oFosterplaceid);
		mv.setViewName("/psAndffOrderPage.pet?oFosterstyle="+o.getoFosterstyle());
		return mv;
	}
	
	@RequestMapping("/agreeOrder.pet")
	public ModelAndView agreeOrder(Long oId,Long oFosterplaceid){
		ModelAndView mv = new ModelAndView();
		Order order = new Order();
		Order o = orderService.selectByPrimaryKey(oId);
		order.setoId(oId);
		order.setoOrderstatus("待确认");
		orderService.updateByPrimaryKeySelective(order);
		mv.addObject("oFosterplaceid",oFosterplaceid);
		mv.setViewName("/psAndffOrderPage.pet?oFosterstyle="+o.getoFosterstyle());
		return mv;
	}
	
	@RequestMapping("/hangpsAndffOrder.pet")
	public ModelAndView hangpsAndffOrder(Long oId,Long oFosterplaceid){
		ModelAndView mv = new ModelAndView();
		Order order = new Order();
		Order o = orderService.selectByPrimaryKey(oId);
		order.setoId(oId);
		order.setoOrderstatus("已挂起");
		orderService.updateByPrimaryKeySelective(order);
		mv.addObject("oFosterplaceid",oFosterplaceid);
		mv.setViewName("/psAndffOrderPage.pet?oFosterstyle="+o.getoFosterstyle());
		return mv;
	}
	
	@RequestMapping("/psAndffOrderPage.pet")
	public ModelAndView psAndffOrderPage(Long oFosterplaceid,String oFosterstyle){
		ModelAndView mv = new ModelAndView();
		System.out.println(oFosterstyle);
		List<Order> uOrderList = orderService.listByoFosterplaceid(oFosterplaceid, oFosterstyle);
		List<Order> orderList = new ArrayList<Order>();
		Date now = new Date();
		int month = now.getMonth()-1;
		now.setMonth(month);
		for(Order o : uOrderList){
			if(now.getTime() <= o.getoOrderdate().getTime()){
				orderList.add(o);
			}
		}
		
		List<MyOrder> myOrderList = new ArrayList<MyOrder>();
		for(Order order : orderList){
			MyOrder myOrder = new MyOrder();
			FosterUser user = fosterUserService.selectByPrimaryKey(order.getuId());
			Pet pet = petService.selectByPrimaryKey(order.getpId());
			myOrder.setoId(order.getoId());
			myOrder.setFosterUserName(user.getFuFosterusername());
			myOrder.setPetName(pet.getpPetname());
			if(order.getoFosterstyle().equals("寄养家庭")){
				FosterFamily family = fosterFamilyService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(family.getfAdoptername());
			}else if(order.getoFosterstyle().equals("宠物店")){
				PetShop petShop = petShopService.selectByPrimaryKey(order.getoFosterplaceid());
				myOrder.setoFosterplaceName(petShop.getPsPetshopname());
			}
			myOrder.setoFosterstyle(order.getoFosterstyle());
			myOrder.setoFosterday(order.getoFosterday());
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			myOrder.setoOrderdate(f.format(order.getoOrderdate()));
			myOrder.setoOrderstatus(order.getoOrderstatus());
			myOrderList.add(myOrder);
		}
		if("寄养家庭".equals(oFosterstyle)){
			FosterFamily ff = fosterFamilyService.selectByPrimaryKey(oFosterplaceid);
			mv.addObject("accountName",ff.getfAccountname());
		}else if("宠物店".equals(oFosterstyle)){
			PetShop ps = petShopService.selectByPrimaryKey(oFosterplaceid);
			mv.addObject("accountName",ps.getPsAccountname());
		}
		mv.addObject("oFosterplaceid", oFosterplaceid);
		mv.addObject("oFosterstyle",oFosterstyle);
		mv.addObject("myOrderList", myOrderList);
		mv.setViewName("/WEB-INF/jsp/psAndffOrder.jsp");
		return mv;
	}
	
	@RequestMapping("/psInformation.pet")
	public ModelAndView psInformation(Long oFosterplaceid,String oFosterstyle){
		ModelAndView mv = new ModelAndView();
		PetShop petShop = petShopService.selectByPrimaryKey(oFosterplaceid);
		if(null != petShop.getPsFeedbackinformation() && "" != petShop.getPsFeedbackinformation()){
			if(petShop.getPsFeedbackinformation().split("#").length > 1){
				String systemInformation = petShop.getPsFeedbackinformation().split("#")[1];
				mv.addObject("systemInformation",systemInformation);
			}
		}
		Information information = informationService.selectByFosterplaceidAndFosterstyle(oFosterplaceid, oFosterstyle);
		mv.addObject("petShop",petShop);
		mv.addObject("oFosterstyle", oFosterstyle);
		mv.addObject("information", information);
		System.out.println(information);
		mv.setViewName("/WEB-INF/jsp/psInformation.jsp");
		return mv;
	}
}
