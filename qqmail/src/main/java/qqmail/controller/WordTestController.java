package qqmail.controller;
//这个controller用于对在线文档的操作
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import qqmail.entry.MyFile;
import qqmail.entry.User;
import qqmail.service.IFileService;
import wordtojsp.ToWord;


@Controller
public class WordTestController {
	@Autowired
	private IFileService service;
	
	/**
	 * 上传文件，文件上传成功以后给它返回一个页面
	 * @param inputfile 返回的一个文件对象
	 * @param request 
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/uploadFile.do")
	public String uploadFile(MultipartFile inputfile,HttpServletRequest request) throws IllegalStateException, IOException{
		if(!inputfile.isEmpty()){//先判断其是否为空，预防出现空指针
			String path = request.getServletContext().getRealPath("/file");//定义上传到服务器的路径
			String fileName = inputfile.getOriginalFilename();//得到上传文件的名字
			File file = new File(path+"/fileword",fileName);
			inputfile.transferTo(file);
			String sourcePath = path+"/fileword/"+fileName;//文档的路径
			String picturesPath = path+"/fileimg/";//图片存放的路径
			//fileName为一个文件名加一个后缀
			String time = ""+new Date().getTime();
			String targetPath = path+"/filejsp/"+time+".jsp";
			ToWord.wordToHtml(sourcePath, picturesPath, targetPath);//调用外部的方法将其转化为jsp
			//转化完成后将路径存入数据库
			String fjsp = "file/filejsp/"+time+".jsp";
			User user = (User) request.getSession().getAttribute("user");//拿到用户的user对象
			int userId = user.getUser_id();
			MyFile f = new MyFile(fileName.substring(0, fileName.indexOf(".")),fjsp,new Date(),userId);
			service.createFile(f);
			return fjsp;//这里返回的是文档转成jsp的路径
		}
		return null;
	}
	
	/**
	 * 这个方法用于得到该用户的所有file并且将其返回出去
	 * @param request
	 * @return  返回一个ModelAndView对象
	 */
	@RequestMapping("/readAllFileByUser.do")
	public ModelAndView readAllFileByUser(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		User user = (User) request.getSession().getAttribute("user");
		int userId = user.getUser_id();
		List<MyFile> list = service.readAllFileById(userId);
		mv.addObject("list", list);
		mv.setViewName("/WEB-INF/jsp/wordtest.jsp");
	    return mv;	
	}
	
	//从页面删除一个文件信息
	@RequestMapping("/deleteById.do")
	public void deleteById(String id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		service.deleteByFileId(Integer.parseInt(id));//先从数据库中删除信息
		request.getRequestDispatcher("/readAllFileByUser.do").forward(request, response);
	}
}
