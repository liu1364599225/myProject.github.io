package code;

import java.net.URLEncoder;
import java.util.Random;

import code.common.Config;
import code.common.HttpUtil;


/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	
	//获取验证码
	public static int getCode(){
		Random rand = new Random();
//		1000-9999
		int code = rand.nextInt(9000)+1000;//0-8999
		return code;
	}
	
	/**
	 * 验证码通知短信
	 */
	public static int execute(String to)
	{
		int code = getCode();
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode("【mail工作室】您的验证码为"+code+"，请于5分钟内正确输入，如非本人操作，请忽略此短信。", "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println(code);
	    return code;
	}
}
