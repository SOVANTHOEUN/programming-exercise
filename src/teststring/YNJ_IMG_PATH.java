package teststring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class YNJ_IMG_PATH {
	private static Date today = new Date();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String urlStr		= "http://dev.yaimg.yanolja.com/resize/place/v4/2017/07/09/05/596142178a5fd0.90968864.jpg";
		String split1[]		= urlStr.split("//");
		String splitStr1	= split1[1];
		String split2[]		= splitStr1.split("/");
		String splitStr2	= split2[split2.length - 1];
		
		System.out.println("splitStr:: "+splitStr2);
		
		/*String split2[]		 = splitDot[splitDot.length-1];
		UUID uuid			 = UUID.randomUUID();
		String randomTimeStr = uuid.toString() + (new SimpleDateFormat("yyyyMMddHHmmss")).format(today);
		String imgName		 = randomTimeStr +"."+ imgExten;
		System.out.println("randomTimeStr:: "+randomTimeStr);
		System.out.println("imgName:: "+imgName);
		System.out.println("imgName:: "+urlStr.split("//")[1].toString().split("/")[8].toString());*/

	}

}
