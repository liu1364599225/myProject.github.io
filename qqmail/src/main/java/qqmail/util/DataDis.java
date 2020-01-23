package qqmail.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import qqmail.entry.MailPro;
import qqmail.service.IInboxService;
public class DataDis {
	public List getNum(List<MailPro> list2){
		List list1 = new ArrayList();
		List<MailPro> list = list2;//根据状态lnbox为true，send_mail_id查询
		List<MailPro> today = new ArrayList<MailPro>();  //本日
		List<MailPro> one = new ArrayList<MailPro>();   //周一
		List<MailPro> two = new ArrayList<MailPro>();   //周二
		List<MailPro> three = new ArrayList<MailPro>(); //周三
		List<MailPro> four = new ArrayList<MailPro>(); //周四
		List<MailPro> five = new ArrayList<MailPro>(); //周五
		List<MailPro> six = new ArrayList<MailPro>();  //周六
		List<MailPro> seven = new ArrayList<MailPro>(); //周日
		List<MailPro> more = new ArrayList<MailPro>();  //更早
		DateUtil da = new DateUtil();
		System.out.println(list.size()+"daxiao");
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
		list1.add(list.size());
		list1.add(today.size());
		list1.add(one.size());
		list1.add(two.size());
		list1.add(three.size());
		list1.add(four.size());
		list1.add(five.size());
		list1.add(six.size());
		list1.add(seven.size());
		list1.add(more.size());
		return list1;
	}
	
}
